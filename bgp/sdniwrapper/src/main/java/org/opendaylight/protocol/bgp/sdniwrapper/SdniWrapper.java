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

import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.opendaylight.protocol.util.ByteArray;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.primitives.UnsignedBytes;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



public class SdniWrapper{
	
    private static final Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);
    private static final NetworkCapabilities networkData = new NetworkCapabilities();
    private final String CONTROLLER_URL = "http://localhost:8080/controller/nb/v2/sdni/default/topology";
	
    public String receiveMessage(){
    	String result = null;
    	//Receive all messages from all peer
    	//identify the peer
    	//read that message and unpack it
    	//readMessage();
    	//Store it in local memory or files
    	
    	return result;
    }
    
    public String sendMessage(){
    	String result = null;
    	
    	//Create the message from reading the rest apis of the local controller
    	//pack the message through byte buffer
    	//send that message to all the peers configured.
    	//createMessage();
    	
    	return result;
    }
    
    public String readMessage() {
    	String result = null;
    	
    	return result;
    }
    
	public ByteBuf getSDNIMessage(){
		byte[] defaultBytes = null;
		String topologyDetails = null;
		ByteBuf sdniBytes =  null;
		
		//Read the message/topology details from the controller's Rest API
		topologyDetails = callRestAPI(CONTROLLER_URL);
		LOG.info("Topology Details: "+topologyDetails);
		
		//Convert the message from string to byte array
		defaultBytes = topologyDetails.getBytes();
		sdniBytes  = Unpooled.copiedBuffer(defaultBytes);
		
		return sdniBytes;
	}
	
	@SuppressWarnings("unchecked")
	public String parseSDNIMessage(String sdnimsg){
		String resultData = sdnimsg;
		LOG.trace("SDNI update message : "+sdnimsg);
		JSONParser parser = new JSONParser();
		 
		try {
			
			Object obj = parser.parse(sdnimsg);
	 		JSONObject jsonObject = (JSONObject) obj;
	 		networkData.setLinks((List<String>) jsonObject.get("link"));
			networkData.setBandwidths((List<String>) jsonObject.get("bandwidth"));
			networkData.setLatencies((List<String>) jsonObject.get("latencies"));
			networkData.setMacAddressList((List<String>) jsonObject.get("macAddress"));
			networkData.setIpAddressList((List<String>) jsonObject.get("ipAddress"));
			networkData.setControllers((List<String>) jsonObject.get("controllers"));
			networkData.setNodes((List<String>) jsonObject.get("nodes"));
			networkData.setHosts((List<String>) jsonObject.get("hosts"));
	
		}catch(ParseException e){
			resultData = "ParseException";
			e.printStackTrace();
			return resultData;
		}
	    return resultData;
	}
	
	public String callRestAPI(String url){
		final String admin = "admin";
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(admin, admin.toCharArray());
            }
        });
		LOG.trace("before connecting to the controller for rest API");
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(url).build());
		String data = service.accept(MediaType.APPLICATION_JSON).get(String.class);
		LOG.trace("After connecting to the controller for rest API "+data);
		
		return data;
	}
	
	/*public List<Long> prepareListFromBytes(final byte[] bytes){
		final List<Long> sdniData = Lists.newArrayList();

		if (bytes.length == 0) {
			return Collections.emptyList();
	    }
	    
		int byteOffset = 0;
	    while (byteOffset < bytes.length) {
	        final int bitLength = UnsignedBytes.toInt(ByteArray.subByte(bytes, byteOffset, 1)[0]);
	        byteOffset += 1;
	        final int byteCount = (bitLength % Byte.SIZE != 0) ? (bitLength / Byte.SIZE) + 1 : bitLength / Byte.SIZE;
	        Long tmp = Long.parseLong(ByteArray.subByte(bytes, byteOffset, byteCount).toString());
	        sdniData.add(tmp);
	        byteOffset += byteCount;
	    }
	    return sdniData;
	}
	
	public static void printBytes(byte[] array, String name) {
	    for (int k = 0; k < array.length; k++) {
	        System.out.println(name + "[" + k + "] = " + "0x" + byteToHex(array[k]));
	    }
	    //BigInteger bigInteger1 = new BigInteger("123456789");
		//sdniData.add(1,1000000L);
	}
	
   static public String byteToHex(byte b) {
      // Returns hex String representation of byte b
      char hexDigit[] = {
         '0', '1', '2', '3', '4', '5', '6', '7',
         '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
      };
      char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
      return new String(array);
   }*/
   
//   /*
//	 * Need to pack the topology information of the local server i.e controller
//	 * based on the format given by BGPCEP
//	 * 
//	 */
//	public void packingMsg(){
//		
//	}
//	
//	/*
//	 * Packed Data needs to be sent across all the connected BGP servers 
//	 * Invoke ODL-BGP method for this call
//	 */
//	public void sendingMsg(){
//		
//	}
//	
//	/*
//	 * Received the packed data sent from other connected BGP servers
//	 * Invoke ODL-BGP method for this call
//	 */
//	public void receivingMsg(){
//		
//	}
//	
//	/*
//	 * Unpack the information received from other servers.
//	 * And save it in local files (controller_topology_data.conf, nlri_peer_toplogy_data_1.conf)
//	 */
//	public void unpackingMsg(){
//		
//	}
}

