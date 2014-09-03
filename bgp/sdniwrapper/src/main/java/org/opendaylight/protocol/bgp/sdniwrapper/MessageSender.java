/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.protocol.bgp.sdniwrapper;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageSender {
	
    private static Logger LOG = LoggerFactory.getLogger(MessageSender.class);
	SdniWrapper sdniwrapper = new SdniWrapper();
	
	public void messageSender(String ipaddress, String msg) {
		/** Define a host server */
		String host = "10.132.35.41";
		/** Define a port */
		int port = 19999;

		StringBuffer instr = new StringBuffer();
		String TimeStamp;
		LOG.info("SocketClient initialized");
			try {
				/** Obtain an address object of the server */
				InetAddress address = InetAddress.getByName(ipaddress);
				/** Establish a socket connetion */
				Socket connection = new Socket(address, port);
				/** Instantiate a BufferedOutputStream object */

				BufferedOutputStream bos = new BufferedOutputStream(
						connection.getOutputStream());

				/**
				 * Instantiate an OutputStreamWriter object with the optional
				 * character encoding.
				 */
				OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
				TimeStamp = new java.util.Date().toString();
				
				String process = sdniwrapper.findIpAddress() + "--" + TimeStamp + "--" + msg + (char) 13;

				/** Write across the socket connection and flush the buffer */
				osw.write(process);
				osw.flush();

				osw.close();
				bos.close();
				
			} catch (IOException f) {
			    LOG.info("IOException: " + f);
			} catch (Exception g) {
			    LOG.info("Exception: " + g);
			}
			/*
			 * finally{ try{ connection.close(); }catch(IOException e){ } }
			 */
		}
}
