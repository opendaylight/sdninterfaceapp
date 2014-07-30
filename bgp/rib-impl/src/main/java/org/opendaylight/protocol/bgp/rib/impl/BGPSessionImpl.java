/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.rib.impl;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import io.netty.channel.Channel;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.GuardedBy;

import org.opendaylight.protocol.bgp.parser.AsNumberUtil;
import org.opendaylight.protocol.bgp.parser.BGPError;
import org.opendaylight.protocol.bgp.parser.BGPSession;
import org.opendaylight.protocol.bgp.parser.BGPSessionListener;
import org.opendaylight.protocol.bgp.parser.BGPTerminationReason;
import org.opendaylight.protocol.bgp.parser.BgpTableTypeImpl;
import org.opendaylight.protocol.framework.AbstractProtocolSession;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.AsNumber;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Keepalive;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.KeepaliveBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.NotifyBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.bgp.parameters.CParameters;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.BgpTableType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.MultiprotocolCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.TablesKey;
import org.opendaylight.yangtools.yang.binding.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/////////////////////////////////////////ADDED FOR ODL_SDNi///////////////////////////////////
import java.io.Reader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/////////////////////////////////////////////////////////////////////////////////////////////////
@VisibleForTesting
public class BGPSessionImpl extends AbstractProtocolSession<Notification> implements BGPSession {

	private static final Logger LOG = LoggerFactory.getLogger(BGPSessionImpl.class);

	private static final Notification KEEP_ALIVE = new KeepaliveBuilder().build();

	/**
	 * Internal session state.
	 */
	public enum State {
		/**
		 * The session object is created by the negotiator in OpenConfirm state. While in this state, the session object
		 * is half-alive, e.g. the timers are running, but the session is not completely up, e.g. it has not been
		 * announced to the listener. If the session is torn down in this state, we do not inform the listener.
		 */
		OpenConfirm,
		/**
		 * The session has been completely established.
		 */
		Up,
		/**
		 * The session has been closed. It will not be resurrected.
		 */
		Idle,
	}

	/**
	 * System.nanoTime value about when was sent the last message Protected to be updated also in tests.
	 */
	@VisibleForTesting
	protected long lastMessageSentAt;

	/**
	 * System.nanoTime value about when was received the last message
	 */
	private long lastMessageReceivedAt;

	private final BGPSessionListener listener;

	/**
	 * Timer object grouping FSM Timers
	 */
	private final Timer stateTimer;

	private final BGPSynchronization sync;

	private int kaCounter = 0;

	private final Channel channel;
        public static final String admin = "admin";

	@GuardedBy("this")
	private State state = State.OpenConfirm;


	private final Set<BgpTableType> tableTypes;
	private final int holdTimerValue;
	private final int keepAlive;
	private final AsNumber asNumber;
	private final Ipv4Address bgpId;

	BGPSessionImpl(final Timer timer, final BGPSessionListener listener, final Channel channel, final Open remoteOpen, final int localHoldTimer) {
		this.listener = Preconditions.checkNotNull(listener);
		this.stateTimer = Preconditions.checkNotNull(timer);
		this.channel = Preconditions.checkNotNull(channel);
		this.holdTimerValue = (remoteOpen.getHoldTimer() < localHoldTimer) ? remoteOpen.getHoldTimer() : localHoldTimer;
		LOG.info("HoldTimer new value: {}", this.holdTimerValue);
		this.keepAlive = this.holdTimerValue / 3;
		this.asNumber = AsNumberUtil.advertizedAsNumber(remoteOpen);

		final Set<TablesKey> tts = Sets.newHashSet();
		final Set<BgpTableType> tats = Sets.newHashSet();
		if (remoteOpen.getBgpParameters() != null) {
			for (final BgpParameters param : remoteOpen.getBgpParameters()) {
				final CParameters cp = param.getCParameters();
				if (cp instanceof MultiprotocolCase) {
					final TablesKey tt = new TablesKey(((MultiprotocolCase) cp).getMultiprotocolCapability().getAfi(), ((MultiprotocolCase) cp).getMultiprotocolCapability().getSafi());
					LOG.trace("Added table type to sync {}", tt);
					tts.add(tt);
					tats.add(new BgpTableTypeImpl(tt.getAfi(), tt.getSafi()));
				}
			}
		}

		this.sync = new BGPSynchronization(this, this.listener, tts);
		this.tableTypes = tats;

		if (this.holdTimerValue != 0) {
			this.stateTimer.newTimeout(new TimerTask() {

				@Override
				public void run(final Timeout timeout) {
					handleHoldTimer();
				}
			}, this.holdTimerValue, TimeUnit.SECONDS);

			this.stateTimer.newTimeout(new TimerTask() {
				@Override
				public void run(final Timeout timeout) {
					handleKeepaliveTimer();
				}
			}, this.keepAlive, TimeUnit.SECONDS);
		}
		this.bgpId = remoteOpen.getBgpIdentifier();
	}
/////////////////////////////////////////////////////ADDED FOR ODL_SDNi////////////////////////////////
	private static String readAll(Reader rd) throws IOException {

		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) {
		InputStream is = null;
		JSONObject json = null;

		try {
			Authenticator.setDefault(new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(admin, admin
							.toCharArray());
				}
			});
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONObject(jsonText);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return json;
	}

        public static long ipToLong(String ipAddress1) {
		 
		String[] ipAddressInArray = ipAddress1.split("\\.");
	 
		long result = 0;
		try 
		{
		for (int i = 0; i < ipAddressInArray.length; i++) {
	 
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);
	 
		}
	 
		return result;
                }  
		
		catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} 
		
		
		catch(Exception e){
			e.printStackTrace();
	       }
		return result;
            }

//////////////////////////////////////////////////////////////////////


	@Override
	public synchronized void close() {
		LOG.info("Closing session: {}", this);
		if (this.state != State.Idle) {
			this.sendMessage(new NotifyBuilder().setErrorCode(BGPError.CEASE.getCode()).build());
			this.channel.close();
			this.state = State.Idle;
		}
	}

	/**
	 * Handles incoming message based on their type.
	 *
	 * @param msg incoming message
	 */
	@Override
	public void handleMessage(final Notification msg) {
		// Update last reception time
		this.lastMessageReceivedAt = System.nanoTime();

		if (msg instanceof Open) {
			// Open messages should not be present here
			this.terminate(BGPError.FSM_ERROR);
		} else if (msg instanceof Notify) {
			// Notifications are handled internally
			LOG.info("Session closed because Notification message received: {} / {}", ((Notify) msg).getErrorCode(),
					((Notify) msg).getErrorSubcode());
			this.closeWithoutMessage();
			this.listener.onSessionTerminated(this,
					new BGPTerminationReason(BGPError.forValue(((Notify) msg).getErrorCode(), ((Notify) msg).getErrorSubcode())));
		} else if (msg instanceof Keepalive) {
			// Keepalives are handled internally
			LOG.debug("Received KeepAlive messsage.");
			this.kaCounter++;
			if (this.kaCounter >= 2) {
				this.sync.kaReceived();
			}
		} else {
			// All others are passed up
			this.listener.onMessage(this, msg);
			this.sync.updReceived((Update) msg);
		}
	}

	@Override
	public synchronized void endOfInput() {
		if (this.state == State.Up) {
			this.listener.onSessionDown(this, new IOException("End of input detected. Close the session."));
		}
	}

	void sendMessage(final Notification msg) {
		try {
			this.channel.writeAndFlush(msg);
			this.lastMessageSentAt = System.nanoTime();
			LOG.debug("Sent message: {}", msg);
		} catch (final Exception e) {
			LOG.warn("Message {} was not sent.", msg, e);
		}
	}

	private synchronized void closeWithoutMessage() {
		LOG.debug("Closing session: {}", this);
		this.channel.close();
		this.state = State.Idle;
	}

	/**
	 * Closes PCEP session from the parent with given reason. A message needs to be sent, but parent doesn't have to be
	 * modified, because he initiated the closing. (To prevent concurrent modification exception).
	 *
	 * @param closeObject
	 */
	private void terminate(final BGPError error) {
		this.sendMessage(new NotifyBuilder().setErrorCode(error.getCode()).setErrorSubcode(error.getSubcode()).build());
		this.closeWithoutMessage();

		this.listener.onSessionTerminated(this, new BGPTerminationReason(error));
	}

	/**
	 * If HoldTimer expires, the session ends. If a message (whichever) was received during this period, the HoldTimer
	 * will be rescheduled by HOLD_TIMER_VALUE + the time that has passed from the start of the HoldTimer to the time at
	 * which the message was received. If the session was closed by the time this method starts to execute (the session
	 * state will become IDLE), then rescheduling won't occur.
	 */
	private synchronized void handleHoldTimer() {
		if (this.state == State.Idle) {
			return;
		}

		final long ct = System.nanoTime();
		final long nextHold = this.lastMessageReceivedAt + TimeUnit.SECONDS.toNanos(this.holdTimerValue);

		if (ct >= nextHold) {
			LOG.debug("HoldTimer expired. " + new Date());
			this.terminate(BGPError.HOLD_TIMER_EXPIRED);
		} else {
			this.stateTimer.newTimeout(new TimerTask() {
				@Override
				public void run(final Timeout timeout) {
					handleHoldTimer();
				}
			}, nextHold - ct, TimeUnit.NANOSECONDS);
		}
	}

	/**
	 * If KeepAlive Timer expires, sends KeepAlive message. If a message (whichever) was send during this period, the
	 * KeepAlive Timer will be rescheduled by KEEP_ALIVE_TIMER_VALUE + the time that has passed from the start of the
	 * KeepAlive timer to the time at which the message was sent. If the session was closed by the time this method
	 * starts to execute (the session state will become IDLE), that rescheduling won't occur.
	 */
	private synchronized void handleKeepaliveTimer(){
		if (this.state == State.Idle) {
			return;
		}

		final long ct = System.nanoTime();
		long nextKeepalive = this.lastMessageSentAt + TimeUnit.SECONDS.toNanos(this.keepAlive);

		if (ct >= nextKeepalive) {
			this.sendMessage(KEEP_ALIVE);
			nextKeepalive = this.lastMessageSentAt + TimeUnit.SECONDS.toNanos(this.keepAlive);
/////////////////////////// /////////////ADDED FOR ODL-SDNi///////////////////////////////////////////////////////////////////
                        String newline = System.getProperty("line.separator");
                        try
                        {
                        JSONObject json = readJsonFromUrl("http://10.132.35.24:8080/controller/nb/v2/sdni/default/topology");
			System.out.println("From URL:"+json.toString());
			//System.out.println(json.get("link"));
			//FileWriter file = new FileWriter("C:\\Users\\679598\\Downloads\\test.json");
			FileWriter file = new FileWriter("/usr/local/etc/quagga/controller_putty.json");
			StringBuilder fileContent = new StringBuilder();
			StringBuilder fileContent1 = new StringBuilder();
			
			fileContent.append("controller ");
			String Controller = json.get("controller").toString()
					.replaceAll("\"", "").replace("[", "").replace("]", "");
			
			Long ipaddress = ipToLong(Controller);
			fileContent.append(ipaddress+ newline);
			
			fileContent.append("link ");
			String[] link = json.get("link").toString().replace("(", "").replace(")", "").replace("]", "")
					.replace("[", "").replace("\"", "").replace("->", "")
					.replace("@", "").replace("00:00:00:00:00:00:00:0", "")
					.replace(" ", "").split(",");
			String temp6 = "";
			for (int i = 0; i < link.length; i++) {
				temp6 = temp6
						+ link[i].replace("@OF|:::::::1->OF|", "").replace("OF|", "").replace("0"," ").replace("\",", "") + " " + " ";
				 //System.out.println(temp6);
			}
			String temp12="";
			//System.out.println("********");
			//System.out.println(temp6);
			//temp6="1231 1584 5248";
			String[] st1 = temp6.split(" ");
			//System.out.println("temp6: "+temp6);
			for(int i=0;i<st1.length;i++){
				char[] charArray = st1[i].toCharArray();
				for(int j=0;j<charArray.length;j++){
					if (j % 2 == 0) {
						temp12 = temp12 + charArray[j];
					}
				}
				temp12 = temp12 + " ";
			
			}
			//System.out.println("result: "+temp12);
			//String str = temp12;
			//System.out.println(temp12);
			List<String> lst =  Arrays.asList(temp12.split("  "));
	        List<String> modlst = new ArrayList<String>();
	        boolean flag = true;
	        for(int a=0;a<lst.size();a++){
	            if(a==0){
	                modlst.add(lst.get(a));
	            }
	            char[] lstchar = lst.get(a).toCharArray();
	            for(int b=0;b<modlst.size();b++){
	                char[] modlstchar = modlst.get(b).toCharArray();
	                //System.out.println(String.valueOf(modlstchar)+"---"+String.valueOf(lstchar));
	                if(String.valueOf(lstchar).equals(String.valueOf(modlstchar))){
	                    flag=false;
	                    break;
	                }else if((modlstchar[0]==lstchar[1]) && (modlstchar[1]==lstchar[0])){
	                    flag=false;
	                    break;
	                }else{
	                    continue;
	                }
	                
	            }
	            if(flag==true){
	                modlst.add(lst.get(a));
	            }
	            flag=true;
	        }
	        for(int k=0;k<modlst.size();k++){
	           //System.out.print(modlst.get(k)+"  ");
	        String s=modlst.get(k)+"  ";

			fileContent.append(s);
			
	        }
	        fileContent.append(newline);
				fileContent.append("nodes  ");
				String[] node = json.get("node").toString().replaceAll(":", "")
						.replace("[", "").replace("]", "").split(",");
				String temp = "";
				for (int i = 0; i < node.length; i++) {
					temp = temp
							+ node[i].replace("00:00:00:00:00:00:00:", "").replace(
									"\"", "") + " ";
					// System.out.println(node[i]);
				}
				// System.out.println(temp);
				//fileContent.append();
				
				fileContent.append(temp.replace("0", "") + newline);

			
				fileContent.append("host  ");
				String[] host = json.get("host").toString().replace("[", "")
						.replace("]", "").split(",");
				String temp4 = "";
				for (int i = 0; i < host.length; i++) {
					temp4 = temp4
							+ host[i].replace("00:00:00:00:00:00:00:", "").replace(
									"\"", "") + " ";
					// System.out.println(host[i]);
				}
				// System.out.println(temp4);
				fileContent.append(temp4.replace("0", "") + newline);
			
				fileContent.append("bandwidths ");
				String[] bandwidth = json.get("bandwidth").toString()
						.replace("Gbps", "").split(",");
				String tempo = "";
				for (int i = 0; i < bandwidth.length; i++) {
					tempo = tempo + bandwidth[i].replace("[", "").replace("]", "")
							+ " ";
					// System.out.println(bandwidth[i]);
				}
				// System.out.println(tempo);
				fileContent.append(tempo.replaceAll("\"", "") + newline);
				fileContent.append("latencies  ");
				String[] latency = json.get("latency").toString().replace("[", "")
						.replace("]", "").split(",");
				String temp5 = "";
				for (int i = 0; i < latency.length; i++) {
					temp5 = temp5 + latency[i].replace("", "").replace("\"", "")
							+ " ";
					// System.out.println(latency[i]);
				}
				// System.out.println(temp5);
				fileContent.append(temp5.replace("0", "") + newline);

				fileContent.append("macAddressList  ");
				String[] macAddressList = json.get("macAddressList").toString()
						.replace("[", "").replace("]", "").split(",");
				String temp1 = "";
				for (int i = 0; i < macAddressList.length; i++) {
					temp1 = temp1
							+ macAddressList[i].replace("00:00:00:00:00:", "")
									.replace("\"", "") + " ";
					// System.out.println(macAddressList[i]);
				}
				// System.out.println(temp1);
				fileContent.append(temp1.replace("0", "") + newline);

				
			fileContent.append("ipAddressList  ");
			String ipAddressList = (json.get("ipAddressList").toString()
					.replaceAll("\"", "").replace("[", "").replace("]", "") .replace("]", "")
					+ newline);       
			
			
			Long ipaddress2 = ipToLong(ipAddressList);
			fileContent.append(ipaddress2+ newline);
			
			//System.out.println(modifiedStr);;

			//System.out.println(fileContent1);
			
			System.out.println(fileContent);
			//System.out.println(fileContent1);
			
			file.write(fileContent.toString());
			
			file.flush();
			file.close();
                        }
                        catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			}catch (JSONException e){
			e.printStackTrace();
			} catch(Exception e){
			e.printStackTrace();
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        	}
		this.stateTimer.newTimeout(new TimerTask() {
			@Override
			public void run(final Timeout timeout) {
				handleKeepaliveTimer();
			}
		}, nextKeepalive - ct, TimeUnit.NANOSECONDS);
	}

	@Override
	public final String toString() {
		return addToStringAttributes(Objects.toStringHelper(this)).toString();
	}

	protected ToStringHelper addToStringAttributes(final ToStringHelper toStringHelper) {
		toStringHelper.add("channel", this.channel);
		toStringHelper.add("state", this.state);
		return toStringHelper;
	}

	@Override
	public Set<BgpTableType> getAdvertisedTableTypes() {
		return this.tableTypes;
	}

	@Override
	protected synchronized void sessionUp() {
		this.state = State.Up;
		this.listener.onSessionUp(this);
	}

	public synchronized State getState() {
		return this.state;
	}

	@Override
	public final Ipv4Address getBgpId() {
		return this.bgpId;
	}

	@Override
	public final AsNumber getAsNumber() {
		return this.asNumber;
	}
}
