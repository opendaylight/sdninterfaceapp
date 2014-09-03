/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.protocol.bgp.sdniwrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeSchedular extends TimerTask {

    private static Logger LOG = LoggerFactory.getLogger(TimeSchedular.class);
	private final CountDownLatch countDownLatch = new CountDownLatch(1);
	private MessageReceiver receiver = new MessageReceiver();
	private MessageSender sender = new MessageSender();
	private static List<String> ipAddress = new ArrayList<String>();
	private static String message;
	private SdniWrapper sdniwrapper = new SdniWrapper();

	public TimeSchedular(List<String> ipAddress, String message){
		this.ipAddress = ipAddress;
		this.message = message;
	}
	// Receiver thread
	Thread t1 = new Thread() {
		public void run() {
			try {

				countDownLatch.await();
				LOG.info("initiated Receiver server");
				receiver.messageReceiver();
	
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	};

	// Sender thread
	Thread t2 = new Thread() {

		public void run() {
			try {
				countDownLatch.await();
				LOG.info("ipaddress length: "+ipAddress.size());
				while(true){
					for(int i=0;i<ipAddress.size();i++){
						LOG.info("i value:"+i+" ip address list before sending msg: "+ipAddress.get(i));
						sender.messageSender(ipAddress.get(i), message);
					}
					t2.sleep(10000);
					sdniwrapper.printPeerInformation();
				}
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	};

	public void run() {

		countDownLatch.countDown();
		LOG.info("inside timeSchedular run() method");
		t1.start();
		t2.start();
	}

}
