/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.sdniwrapper;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.net.Authenticator;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.PasswordAuthentication;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class SdniWrapper{
	
    private static Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);
    private static final NetworkCapabilities networkData = new NetworkCapabilities();
    private final String CONTROLLER_URL = "http://localhost:8080/controller/nb/v2/sdni/default/topology";
    private static final String CONFIGURATION_XML = "../configuration/initial/41-bgp-example.xml";
    public static Map peer_information  = new HashMap();
	
    public void activateSdniParser(){
    			LOG.info("inside activateSdni");
    			LOG.info("CONFIGURATION_XML"+CONFIGURATION_XML);
    			
    			//Create Message 
    			String message = "";
    			SdniWrapper sdniwrapper = new SdniWrapper();
    			message = sdniwrapper.getSDNIMessageInString();
    			
    			//Pack the Message
    			//ByteBuf byte_message = Unpooled.copiedBuffer(message.getBytes());
    		
    			//Get the Peer IP addresses from the configuration file
    			XmlParser parser = new XmlParser();
    			List<String> ip_address = parser.getPeerIP(CONFIGURATION_XML);
    			
    			//System.out.println("Message in Byte to send: "+byte_message);
    			LOG.info("Peer IP address: "+ip_address.get(0));
    			
    			//Trigger the message Sender and Receiver (socket code)
    			TimeSchedular socket = new TimeSchedular(ip_address, message);
    			socket.run();
    			//Send message to the configured Peer
    }
    
    /**
     * Finds IPv4 address of the local VM TODO: This method is
     * non-deterministic. There may be more than one IPv4 address. Cant say
     * which address will be returned. Read IP from a property file or enhance
     * the code to make it deterministic.
     * @return String
     */
    public String findIpAddress() {
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            LOG.info("Failed to get list of interfaces"+e1);
            return null;
        }
        while (e.hasMoreElements()) {

            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                if ((i instanceof Inet4Address) && (!i.isLoopbackAddress())) {
                    String hostAddress = i.getHostAddress();
                    return hostAddress;
                }
            }
        }

        LOG.info("Failed to find a suitable host address");
        return null;
    }

    public void printPeerInformation(){
        LOG.info("inside printPeerInformation");
    	Iterator<Map.Entry<Integer, Integer>> entries = peer_information.entrySet().iterator();
    	while (entries.hasNext()) {
    	    Map.Entry<Integer, Integer> entry = entries.next();
    	    LOG.info("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    	}
    	
    }
    public String getSDNIMessageInString(){
    	String topologyDetails = null;

		//Read the message/topology details from the controller's Rest API
		topologyDetails = callRestAPI(CONTROLLER_URL);
		
		LOG.info("inside getSDNIMessageInString: "+topologyDetails);
		return topologyDetails;
	}
    
	public ByteBuf getSDNIMessage(){
		byte[] defaultBytes = null;
		String topologyDetails = null;
		ByteBuf sdniBytes =  null;
		
		//Read the message/topology details from the controller's Rest API
		topologyDetails = callRestAPI(CONTROLLER_URL);
		
		//Convert the message from string to byte array
		defaultBytes = topologyDetails.getBytes();
		sdniBytes  = Unpooled.copiedBuffer(defaultBytes);
		
		return sdniBytes;
	}
	
	@SuppressWarnings("unchecked")
	public String parseSDNIMessage(String sdnimsg){
		String[] resultData = sdnimsg.split("--");
		
		for(int i = 0 ;i <= 2 ; i++){
		    LOG.info("resultData["+i+"]"+resultData[i]);
		}
		networkData.setTimeStamp(resultData[1]);
		JSONParser parser = new JSONParser();
		 
		try {
			String message = resultData[2].replace('"', '\"');
			LOG.info("my message: "+message);
			Object obj = parser.parse(message);
	 		JSONObject jsonObject = (JSONObject) obj;
	 		LOG.info("controller ip: "+jsonObject.get("controller"));
	 		networkData.setLinks((List<String>) jsonObject.get("link"));
			networkData.setBandwidths((List<String>) jsonObject.get("bandwidth"));
			networkData.setLatencies((List<String>) jsonObject.get("latency"));
			networkData.setMacAddressList((List<String>) jsonObject.get("macAddressList"));
			networkData.setIpAddressList((List<String>) jsonObject.get("ipAddressList"));
			networkData.setControllers((List<String>) jsonObject.get("controller"));
			networkData.setNodes((List<String>) jsonObject.get("node"));
			networkData.setHosts((List<String>) jsonObject.get("host"));
	
		}catch(ParseException e){
		    LOG.info("ParseException:"+e);
			return "ParseException";
		}
		peer_information.put(resultData[0], networkData);
		
	    return "success";
	}
	
	public String callRestAPI(String url){
		final String admin = "admin";
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(admin, admin.toCharArray());
            }
        });
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(url).build());
		String data = service.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		return data;
	}

}

