/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.protocol.bgp.sdniwrapper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiver implements Runnable{
    
    private static Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	private Socket connection;
	private String TimeStamp;
	private SdniWrapper sdniwrapper = new SdniWrapper();
	
	public void messageReceiver(){
		int port = 19999;
		int count = 0;
		try {
			ServerSocket socket1 = new ServerSocket(port);
			LOG.info("Socket Server Initialized "+count);
			while (true) {
				Socket connection = socket1.accept();
				Runnable runnable = new MessageReceiver(connection, ++count);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	MessageReceiver(Socket s, int i) {
		this.connection = s;
	}

	public MessageReceiver() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		try {
			BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
			InputStreamReader isr = new InputStreamReader(is);
			int character;
			StringBuffer process = new StringBuffer();
			while ((character = isr.read()) != 13) {
				process.append((char) character);
			}
			LOG.info("Received Message:"+process);
			String result = "";
			if(process!=null || process.length()!=0){
				result = sdniwrapper.parseSDNIMessage(process.toString());
			}
			if(result!=""){
			    LOG.info("Received Message Processed Successfully!");
			}
			// Wait for 10 seconds
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			    LOG.info("Exception: "+e);
			}
			
			isr.close();
			is.close();
		} catch (Exception e) {
		    LOG.info("Exception:"+e);
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
			    LOG.info("IOException: "+e);
			}
		}
	}
}
