/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl.sdniwrapper;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SDNiClientCommunicator extends TimerTask{
	private static final Logger log = LoggerFactory.getLogger(SDNiClientCommunicator.class);
	
	private static final int ServerPort=8115;
	private static SDNiClientCommunicator clientCommunicator;
	private static SdniMsgSynchronizer sdniMsgSync;
	
	
	SDNiClientCommunicator()
	{
		sdniMsgSync = SdniMsgSynchronizer.getInstance();
	}

	public static SDNiClientCommunicator getInstance()
	{
		if ( clientCommunicator == null )
		{
			clientCommunicator = new SDNiClientCommunicator();
		}
		return clientCommunicator;
	}



	
	public static void sendMsg() {
		log.info("Starting sendMsg.........!");
		StringBuffer sdniMsg = new StringBuffer();
		
		//Get Topology and QoS messages
		sdniMsgSync.getSDNITopoMessage(sdniMsg);
		sdniMsgSync.getSDNIQoSMessage(sdniMsg);
		for ( String peerIP : sdniMsgSync.getPeerControllers())
		{
			try (Socket echoSocket = new Socket(peerIP, ServerPort);
					PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
					
					) {
				if (sdniMsg  != null) {
					out.println(sdniMsg.toString());
					log.info("Sending Message to Server : {}", peerIP);
				}
				
			}catch (Exception e) {
				log.error("Couldn't get I/O for the connection to : {}", e);
				
			} 
		}
		   
	  }
	
	@Override
	public void run() {
			sendMsg();
	}
	
}

