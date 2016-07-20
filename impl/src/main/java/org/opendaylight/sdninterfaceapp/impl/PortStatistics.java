/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;
	
	
	
public class PortStatistics{


	private String receivePackets;
	private String transmitPackets;
	private String collisionCount;
	private String receiveFrameError;
	private String receiveOverRunError;
	private String receiveCrcError;
	private String nodeID;
	private String portID;
	private String portName;
	private String controller;


	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getReceivePackets() {
		return receivePackets;
	}

	public void setReceivePackets(String receivePackets) {
		this.receivePackets = receivePackets;
	}

	public String getTransmitPackets() {
		return transmitPackets;
	}

	public void setTransmitPackets(String transmitPackets) {
		this.transmitPackets = transmitPackets;
	}

	public String getCollisionCount() {
		return collisionCount;
	}

	public void setCollisionCount(String collisionCount) {
		this.collisionCount = collisionCount;
	}

	public String getReceiveFrameError() {
		return receiveFrameError;
	}

	public void setReceiveFrameError(String receiveFrameErrors) {
		this.receiveFrameError = receiveFrameErrors;
	}

	public String getReceiveOverRunError() {
		return receiveOverRunError;
	}

	public void setReceiveOverRunError(String receiveOverRunErrors) {
		this.receiveOverRunError = receiveOverRunErrors;
	}

	public String getReceiveCrcError() {
		return receiveCrcError;
	}

	public void setReceiveCrcError(String receiveCrcErrors) {
		this.receiveCrcError = receiveCrcErrors;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	
	public String getPortID() {
		return portID;
	}

	public void setPortID(String portID) {
		this.portID = portID;
	}
	
	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"controller\":\""+controller+"\"");
		sb.append(",\"nodeID\":\""+nodeID+"\"");
		sb.append(",\"portID\":\""+portID+"\"");
		sb.append(",\"collisionCount\":\""+collisionCount+"\"");
		sb.append(",\"receiveFrameError\":\""+receiveFrameError+"\"");
		sb.append(",\"receiveOverRunError\":\""+receiveOverRunError+"\"");
		sb.append(",\"receiveCrcError\":\""+receiveCrcError+"\"");
		sb.append(",\"receivePackets\":\""+receivePackets+"\"");
		sb.append(",\"transmitPackets\":\""+transmitPackets+"\"");
		sb.append(",\"portName\":\""+portName+"\"");
		sb.append("}");

		return sb.toString();
	}
}

