/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl.sdniwrapper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SDNiServerListener extends TimerTask {
	private static final Logger log = LoggerFactory.getLogger(SDNiServerListener.class);
	private static final int ClientPort = 8115;

	private static SDNiServerListener serverListener;
	private static SdniMsgSynchronizer sdniMsgSync;
 
	
	SDNiServerListener()
	{
		sdniMsgSync = SdniMsgSynchronizer.getInstance();
	}

	public static SDNiServerListener getInstance()
	{
		if ( serverListener == null )
		{
			serverListener = new SDNiServerListener();
		}
		return serverListener;
	}
	
	public static void startListener() {
		 ExecutorService executor = null;

		 log.info("Listening on Port " + ClientPort);

		 try (ServerSocket serverSocket = new ServerSocket(ClientPort);) {

		  executor = Executors.newFixedThreadPool(sdniMsgSync.getPeerControllers().size());
		  log.info("Waiting for clients");
		  while (true) {
		   Socket clientSocket = serverSocket.accept();
		   Runnable worker = () -> {
		    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
		     log.info("Thread started with name:" + Thread.currentThread().getName());
		     String inputLine;
		     while ((inputLine = in .readLine()) != null) {
		      log.info("Received message from " + Thread.currentThread().getName() + " : " + inputLine);
		      sdniMsgSync.parseSDNIQoSMessage(inputLine);
		      sdniMsgSync.parseSDNITopoMessage(inputLine);
		     }
		    } catch (IOException e) {
		     log.error("I/O exception: " + e);
		    } catch (Exception ex) {
		     log.error("Exceprion in Thread Run. Exception : " + ex);
		    }
		   };
		   executor.execute(worker);
		  }
		 } catch (Exception e) {
		  log.error("Exception caught when trying to listen on port " + ClientPort + " or listening for a connection: " + e.getMessage());
		 }
		}
	
	@Override
	public void run() {
			startListener();

	}
}