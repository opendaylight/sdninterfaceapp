/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdniaggregator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class NetworkCapabilitiesQOS {
    @XmlElement
    private String node;
    @XmlElement
    private String port;
    @XmlElement
    private long receivePackets;
    @XmlElement
    private long transmitPackets;
    @XmlElement
    private long collisionCount;
    @XmlElement
    private long receiveFrameError;
    @XmlElement
    private long receiveOverRunError;
    @XmlElement
    private long receiveCrcError;
    
    public NetworkCapabilitiesQOS() {
    }
     
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
    
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public long getReceivePackets() {
        return receivePackets;
    }

    public void setReceivePackets(long receivePackets) {
        this.receivePackets = receivePackets;
    }
    
    public long getTransmitPackets() {
        return transmitPackets;
    }

    public void setTransmitPackets(long transmitPackets) {
        this.transmitPackets = transmitPackets;
    }
    

    public long getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(long latencies) {
        this.collisionCount = latencies;
    }

    public long getReceiveFrameError() {
        return receiveFrameError;
    }

    public void setReceiveFrameError(long receiveFrameErrors) {
        this.receiveFrameError = receiveFrameErrors;
    }

    public long getReceiveOverRunError() {
        return receiveOverRunError;
    }

    public void setReceiveOverRunError(long receiveOverRunErrors) {
        this.receiveOverRunError = receiveOverRunErrors;
    }

    public long getReceiveCrcError() {
        return receiveCrcError;
    }
    
    public void setReceiveCrcError(long receiveCrcErrors) {
        this.receiveCrcError = receiveCrcErrors;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("node ").append(node);
        sb.append(", port ").append(port);
        sb.append(", receivePackets ").append(receivePackets+ "");
        sb.append(", transmitPackets ").append(transmitPackets+ "");
        sb.append(", collisionCount ").append(collisionCount+ "");
        sb.append(", receiveFrameError ").append(receiveFrameError+ "");
        sb.append(", receiveOverRunError ").append(receiveOverRunError+ "");
        sb.append(", receiveCrcError ").append(receiveCrcError+ "");
       
        return sb.toString();
    }
}

