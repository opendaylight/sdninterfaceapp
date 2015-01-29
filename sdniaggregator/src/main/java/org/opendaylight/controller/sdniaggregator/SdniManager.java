/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdniaggregator;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opendaylight.controller.clustering.services.IClusterGlobalServices;
import org.opendaylight.controller.connectionmanager.IConnectionManager;
import org.opendaylight.controller.hosttracker.IfIptoHost;
import org.opendaylight.controller.hosttracker.hostAware.HostNodeConnector;
import org.opendaylight.controller.sal.core.Bandwidth;
import org.opendaylight.controller.sal.core.Edge;
import org.opendaylight.controller.sal.core.Node;
import org.opendaylight.controller.sal.core.NodeConnector;
import org.opendaylight.controller.sal.core.Property;
import org.opendaylight.controller.sal.core.UpdateType;
import org.opendaylight.controller.sal.reader.NodeConnectorStatistics;
import org.opendaylight.controller.sal.topology.IListenTopoUpdates;
import org.opendaylight.controller.sal.topology.TopoEdgeUpdate;
import org.opendaylight.controller.sal.utils.ServiceHelper;
import org.opendaylight.controller.sal.utils.Status;
import org.opendaylight.controller.sal.utils.StatusCode;
import org.opendaylight.controller.switchmanager.ISwitchManager;
import org.opendaylight.controller.topologymanager.ITopologyManager;
import org.opendaylight.controller.statisticsmanager.IStatisticsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to retrieve various information about the topology to form
 * SDNi Network Capabilities Data.
 */
public class SdniManager {
    private static Logger log = LoggerFactory.getLogger(SdniManager.class);
    private NetworkCapabilities nwCapabilities = new NetworkCapabilities();
    private List<NetworkCapabilitiesQOS> list = new ArrayList();
    private static String loopbackAddress = InetAddress.getLoopbackAddress()
            .getHostAddress();
    private static final String SUCCESS = "success";
    private IListenTopoUpdates topoUpdates = null;

    /**
     * Finds IPv4 address of the local VM TODO: This method is
     * non-deterministic. There may be more than one IPv4 address. Cant say
     * which address will be returned. Read IP from a property file or enhance
     * the code to make it deterministic.
     * @return String
     */
    private String findIpAddress() {
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            log.error("Failed to get list of interfaces", e1);
            return null;
        }
        while (e.hasMoreElements()) {

            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                log.debug("Trying address {}", i);
                if ((i instanceof Inet4Address) && (!i.isLoopbackAddress())) {
                    String hostAddress = i.getHostAddress();
                    log.debug("Settled on host address {}", hostAddress);
                    return hostAddress;
                }
            }
        }

        log.error("Failed to find a suitable host address");
        return null;
    }

    /**
     * Retrieve the links and bandwidths of the nodes using TopologyManager i.e
     * Edge properties
     * @param nwCapabilities
     * @param containerName
     * @return
     */
    private String accessTopologyManager(String containerName) {

        log.info("before topologymanager");

        ITopologyManager topologyManager = (ITopologyManager) ServiceHelper
                .getInstance(ITopologyManager.class, containerName, this);
        if (topologyManager == null) {
            return null;
        }

        Map<Edge, Set<Property>> topo = topologyManager.getEdges();
        if (topo != null) {
            for (Map.Entry<Edge, Set<Property>> entry : topo.entrySet()) {
                log.info("edge name :" + entry.getKey()+ " --edge properties-- "+ entry.getValue());
                this.nwCapabilities.addLink(entry.getKey().toString());
                EdgeProperties el = new EdgeProperties(entry.getKey(),
                        entry.getValue());
                Set<Property> property = el.getProperties();
                Iterator<Property> itr = property.iterator();

                while (itr.hasNext()) {
                    String prop = itr.next().toString();
                    if (prop.contains("BandWidth")) {
                        this.nwCapabilities.addBandwidth(prop.substring(
                                prop.indexOf('[') + 1, prop.indexOf(']')));
                        log.info("inside bandwidth:"+ prop.substring(prop.indexOf('[') + 1,prop.indexOf(']')));
                    }
                }
            }
	List<String> link = this.nwCapabilities.getLink();
	List<String> bandwidth = this.nwCapabilities.getBandwidth();
	if(bandwidth.isEmpty()){
		if(!(link.isEmpty())){
			for(String eachLink: link){
				this.nwCapabilities.addBandwidth("10Gbps");
			}
		}
	}

        }
        return SUCCESS;

    }

    /**
     * Retrieve Hosts and its IP addresses using HostTracker Its retrieve only
     * the active hosts.
     * @param containerName
     * @return
     */
    private String accessHostTracker(String containerName) {

       log.info("inside hosttracker");

        IfIptoHost hostTracker = (IfIptoHost) ServiceHelper.getInstance(
                IfIptoHost.class, containerName, this);
        if (hostTracker == null) {
            return null;
        }
        Set<HostNodeConnector> hostNodeConnectors = hostTracker.getAllHosts();

        if (hostNodeConnectors == null) {
            return null;
        }

        HostConfig hostconfig = new HostConfig();
        for (HostNodeConnector hnc : hostNodeConnectors) {
            log.info("host node" + hnc.getnodeconnectorNode() + "--host--"+ hnc.getnodeConnector());
            hostconfig = HostConfig.convert(hnc);
            this.nwCapabilities.addHost(hostconfig.getNodeConnectorId());
            this.nwCapabilities.addIpAddress(hostconfig.getNetworkAddress());
        }
        return SUCCESS;
    }

    /**
     * Retrieve the nodes and its mac address using SwitchManager
     * @param containerName
     * @return
     */
    private String accessSwitchManager(String containerName) {

        log.info("inside accessSwitchManager");
        ISwitchManager switchManager = (ISwitchManager) ServiceHelper
                .getInstance(ISwitchManager.class, containerName, this);
        if (switchManager == null) {
            return null;
        }
        Set<Node> nodes = switchManager.getNodes();

        for (Node node : nodes) {
            String nodeName = "";
            String macAddress = "";
            log.info("nodes:" + node);
            nodeName = node.toString().replace("OF|", "");

            Map<String, Property> propMap = switchManager.getNodeProps(node);
            Object[] array = propMap.keySet().toArray();

            for (int i = 0; i < array.length; i++) {
                String arrayElement = propMap.get(array[i]).toString();
                if (arrayElement.contains("MacAddress")) {
                    macAddress = arrayElement.substring(
                            arrayElement.indexOf('[') + 1,
                            arrayElement.indexOf(']'));
                }
                log.info("propMap info:" + arrayElement);
            }
            this.nwCapabilities.addNode(nodeName);
            this.nwCapabilities.addMacAddress(macAddress);
        }
        return SUCCESS;
    }
    
     /**
     * Retrieve the QOS parameters for node and port using StatisticsManager
     * @param containerName
     * @return
     */
    private String accessStatisticsManager(String containerName) {

        log.info("inside accessStatisticsManager");
        IStatisticsManager statisticsManager = (IStatisticsManager) ServiceHelper
                .getInstance(IStatisticsManager.class, containerName, this);
        if (statisticsManager == null) {
            return null;
        }

        ISwitchManager switchManager = (ISwitchManager) ServiceHelper
                .getInstance(ISwitchManager.class, containerName, this);
        if (switchManager == null) {
            return null;
        }

        List<PortStatistics> statistics = new ArrayList<PortStatistics>();
        for (Node node : switchManager.getNodes()) {
            List<NodeConnectorStatistics> stat = statisticsManager
                    .getNodeConnectorStatistics(node);
            PortStatistics portStat = new PortStatistics(node, stat);
            statistics.add(portStat);
        }
	
	NodeConnector nodeConnector;
	String port;
        long receivePackets;
        long transmitPackets;
        long receiveFrameError;
        long receiveOverRunError;
        long receiveCrcError;
        long collisionCount;

	for (PortStatistics ps : statistics) {
		Node node = ps.getNode();
		String nodeName = "";
            	nodeName = node.toString().replace("OF|", "");
		
		List<NodeConnectorStatistics>  nodeConnectorStats = ps.getPortStats();
		for(NodeConnectorStatistics nc : nodeConnectorStats ) {
			nodeConnector = nc.getNodeConnector();
			port = nodeConnector.getNodeConnectorIDString();
                	receivePackets = nc.getReceivePacketCount();
                	transmitPackets = nc.getTransmitPacketCount();
               		receiveFrameError = nc.getReceiveFrameErrorCount();
                	receiveOverRunError = nc.getReceiveOverRunErrorCount();
                	receiveCrcError = nc.getReceiveCRCErrorCount();
                	collisionCount = nc.getCollisionCount();
			
			NetworkCapabilitiesQOS ncq = new NetworkCapabilitiesQOS();

		        ncq.setNode(nodeName);
                	ncq.setPort(port);
                	ncq.setReceivePackets(receivePackets);
                	ncq.setTransmitPackets(transmitPackets);
               		ncq.setReceiveFrameError(receiveFrameError);
                	ncq.setReceiveOverRunError(receiveOverRunError);
                	ncq.setReceiveCrcError(receiveCrcError);
     			ncq.setCollisionCount(collisionCount);
                	list.add(ncq);    
            	}
	   }
         log.info("Inside Statistics manager - Node Connector Statistics List:" +list);
         return SUCCESS;
       }

    /**
     * Return the network capability data of SDNi
     * @param containerName
     * @return
     */
    public NetworkCapabilities getTopologyDetails(String containerName) {

        // Retrieve Controller's IP address
        this.nwCapabilities.addController(findIpAddress());
        String result = "";
	String result1 = "";
        String clustering = System.getProperty("supernodes", loopbackAddress);

        log.info("system property: " + clustering);
        if (clustering.equals("127.0.0.1")) {
            log.info("inside accessing individual manager");
            // Retrieve Topology information
            result = accessTopologyManager(containerName);
            if (result == "" || result == null) {
                return null;
            }
            // Retrieve Node information
            result = accessSwitchManager(containerName);
            if (result == null) {
                return null;
            }
            // Retrieve Host information
            result = accessHostTracker(containerName);
            if (result == null) {
                return null;
            }

	log.info("this.nwCapabilities"+this.nwCapabilities.getController());
        } else {
            log.info("inside accessing clustering and connection manager");
            result = getClusteredControllers(containerName);
        }
        return this.nwCapabilities;

    }
   
    public List<NetworkCapabilitiesQOS> getQOSDetails(String containerName) {

        // Retrieve Controller's IP address
        this.nwCapabilities.addController(findIpAddress());
        String result = "";
	String clustering = System.getProperty("supernodes", loopbackAddress);

        log.info("system property: " + clustering);
        if (clustering.equals("127.0.0.1")) {
            log.info("inside accessing individual manager");
  
            // Retrieve QOS information
            result = accessStatisticsManager(containerName);
            if (result == null) {
                return null;
            }

            log.info("this.nwCapabilities"+this.nwCapabilities.getController());
        } else {
            log.info("inside accessing clustering and connection manager");
            result = getClusteredControllersQOS(containerName);
        }
        return list;

    }
    /**
     * Returns list of clustered controllers. Highlights "this" controller and
     * if controller is coordinator
     * @return List<ClusterBean>
     */
	public String getClusteredControllersQOS(String containerName) {
        
        IClusterGlobalServices clusterServices = (IClusterGlobalServices) ServiceHelper
                .getGlobalInstance(IClusterGlobalServices.class, this);
        if (clusterServices == null) {
            return null;
        }
        IConnectionManager connectionManager = (IConnectionManager) ServiceHelper
                .getGlobalInstance(IConnectionManager.class, this);
        if (connectionManager == null) {
            return null;
        }
	IStatisticsManager statisticsManager = (IStatisticsManager) ServiceHelper
                .getInstance(IStatisticsManager.class, containerName, this);
        if (statisticsManager == null) {
            return null;
        }

        NodeConnector nodeConnector;
	String port;
        long receivePackets;
        long transmitPackets;
        long receiveFrameError;
        long receiveOverRunError;
        long receiveCrcError;
        long collisionCount;

        List<InetAddress> controllers = clusterServices.getClusteredControllers();
        for (InetAddress controller : controllers) {
            log.info("inside controller loop:" + controller.getHostAddress()+ " controller_ip:" + findIpAddress());
            if (controller.getHostAddress().toString().equals(findIpAddress())) {
                // get number of connected nodes
                Set<Node> connectedNodes = connectionManager.getNodes(controller);

                if (connectedNodes == null) {
                    return "not success";
                }
		List<PortStatistics> statistics = new ArrayList<PortStatistics>();
       		for (Node node : connectedNodes) {
            		List<NodeConnectorStatistics> stat = statisticsManager.getNodeConnectorStatistics(node);
            		PortStatistics portStat = new PortStatistics(node, stat);
            		statistics.add(portStat);
        	}
		for (PortStatistics ps : statistics) {
			Node node = ps.getNode();
			String nodeName = "";
            		nodeName = node.toString().replace("OF|", "");
		
			List<NodeConnectorStatistics>  nodeConnectorStats = ps.getPortStats();
			for(NodeConnectorStatistics nc : nodeConnectorStats ) {
				nodeConnector = nc.getNodeConnector();
				port = nodeConnector.getNodeConnectorIDString();
                		receivePackets = nc.getReceivePacketCount();
                		transmitPackets = nc.getTransmitPacketCount();
               			receiveFrameError = nc.getReceiveFrameErrorCount();
                		receiveOverRunError = nc.getReceiveOverRunErrorCount();
                		receiveCrcError = nc.getReceiveCRCErrorCount();
                		collisionCount = nc.getCollisionCount();
			
				NetworkCapabilitiesQOS ncq = new NetworkCapabilitiesQOS();

		      		ncq.setNode(nodeName);
                		ncq.setPort(port);
                		ncq.setReceivePackets(receivePackets);
                		ncq.setTransmitPackets(transmitPackets);
               			ncq.setReceiveFrameError(receiveFrameError);
                		ncq.setReceiveOverRunError(receiveOverRunError);
                		ncq.setReceiveCrcError(receiveCrcError);
     				ncq.setCollisionCount(collisionCount);
                		list.add(ncq);    
            		}
	   	}
	    }
        }
        return SUCCESS;
     }

     /**
     * Returns list of clustered controllers. Highlights "this" controller and
     * if controller is coordinator
     * @return List<ClusterBean>
     */
	public String getClusteredControllers(String containerName) {
        
        IClusterGlobalServices clusterServices = (IClusterGlobalServices) ServiceHelper
                .getGlobalInstance(IClusterGlobalServices.class, this);
        if (clusterServices == null) {
            return null;
        }
        IConnectionManager connectionManager = (IConnectionManager) ServiceHelper
                .getGlobalInstance(IConnectionManager.class, this);
        if (connectionManager == null) {
            return null;
        }
        ISwitchManager switchManager = (ISwitchManager) ServiceHelper
                .getInstance(ISwitchManager.class, containerName, this);
        if (switchManager == null) {
            return null;
        }
        ITopologyManager topologyManager = (ITopologyManager) ServiceHelper
                .getInstance(ITopologyManager.class, containerName, this);
        if (topologyManager == null) {
            return null;
        }

        IfIptoHost hostTracker = (IfIptoHost) ServiceHelper.getInstance(
                IfIptoHost.class, containerName, this);
        if (hostTracker == null) {
            return null;
        }
        Map<Edge, Set<Property>> topo = topologyManager.getEdges();
        List<String> macAddressList = new ArrayList<String>();
        
        List<InetAddress> controllers = clusterServices
                .getClusteredControllers();
        for (InetAddress controller : controllers) {
            log.info("inside controller loop:" + controller.getHostAddress()+ " controller_ip:" + findIpAddress());
            if (controller.getHostAddress().toString().equals(findIpAddress())) {
                // get number of connected nodes
                Set<Node> connectedNodes = connectionManager
                        .getNodes(controller);

                if (connectedNodes == null) {
                    return "not success";
                }
                for (Node node : connectedNodes) {
                    
                    // Start to switchmanager
                    String nodeName = "";
                    String macAddress = "";
                    nodeName = node.toString().replace("OF|", "");
                    
                    Map<String, Property> propMap = switchManager
                            .getNodeProps(node);
                    Object[] array = propMap.keySet().toArray();

                    for (int i = 0; i < array.length; i++) {
                        String arrayElement = propMap.get(array[i]).toString();
                        if (arrayElement.contains("MacAddress")) {
                            macAddress = arrayElement.substring(
                                    arrayElement.indexOf('[') + 1,
                                    arrayElement.indexOf(']'));
                        }
                    }
                    this.nwCapabilities.addNode(nodeName);
                    this.nwCapabilities.addMacAddress(macAddress);
                    macAddressList.add(macAddress);
                    // end to switchmanager

                    // start to topologymanager
                    if (topo != null) {
                        for (Map.Entry<Edge, Set<Property>> entry : topo
                                .entrySet()) {
                            String links = entry.getKey().toString();
                            links = links.substring(links.indexOf('>'));
                            log.info(" links :" + links);
                            if (links.contains(node.getNodeIDString())) {
                                this.nwCapabilities.addLink(entry.getKey()
                                        .toString());
                                EdgeProperties el = new EdgeProperties(
                                        entry.getKey(), entry.getValue());
                                Set<Property> property = el.getProperties();
                                Iterator<Property> itr = property.iterator();

                                while (itr.hasNext()) {
                                    String prop = itr.next().toString();
                                    if (prop.contains("BandWidth")) {
                                        this.nwCapabilities.addBandwidth(prop
                                                .substring(
                                                        prop.indexOf('[') + 1,
                                                        prop.indexOf(']')));
                                    }
                                }
                            }
                        }

                    } // end to topologymanager
                }  // accessHostTracker(containerName);

                Set<HostNodeConnector> hostNodeConnectors = hostTracker
                        .getAllHosts();
                if (hostNodeConnectors == null) {
                    return null;
                }

                HostConfig hostconfig = new HostConfig();
                for (HostNodeConnector hnc : hostNodeConnectors) {
                    String hostNodeConnector = hnc.getnodeconnectorNode()
                            .toString().replace("OF|00:00:", "");
                    if (macAddressList.contains(hostNodeConnector)) {
                        hostconfig = HostConfig.convert(hnc);
                        this.nwCapabilities.addHost(hostconfig
                                .getNodeConnectorId());
                        this.nwCapabilities.addIpAddress(hostconfig
                                .getNetworkAddress());
                    } else {
                        continue;
                    }
                }
            }
        }
        return SUCCESS;
    }

/**
     * Update the available bandwidth for all the links
     * @param containerName
     * @param bandwidth
     * @return
     */
    public Status updateBandwidth(String containerName, long bandwidth) {

       // log.debug("update topologymanager");

        //long bw_1 = Bandwidth.BW10Gbps, bw_2 = Bandwidth.BW100Mbps;
        long bwModified = bandwidth * Bandwidth.BW1Gbps;

        ITopologyManager topologyManager = (ITopologyManager) ServiceHelper
                .getInstance(ITopologyManager.class, containerName, this);
        if (topologyManager == null) {
            return new Status(StatusCode.INTERNALERROR,
                    "TopologyManager is null");
        }
        log.info("long value:" + bwModified);
        topoUpdates = (IListenTopoUpdates) ServiceHelper.getInstance(
                IListenTopoUpdates.class, containerName, this);
        if (topoUpdates == null) {
            return new Status(StatusCode.INTERNALERROR,
                    "IListenTopoUpdates is null");
        }
        List<TopoEdgeUpdate> topoedgeupdateList = new ArrayList<TopoEdgeUpdate>();
        Map<Edge, Set<Property>> topo = topologyManager.getEdges();
        if (topo != null) {
            for (Map.Entry<Edge, Set<Property>> entry : topo.entrySet()) {
                log.info("edge :" + entry.getKey()
                        + " --properties-- "
                        + entry.getValue());
                Edge e2 = (Edge) entry.getKey();

                Set<Property> props = new HashSet<Property>();
                props.add(new Bandwidth(bwModified));
                log.info("after updating bw to"+bwModified);
                TopoEdgeUpdate teu2 = new TopoEdgeUpdate(e2, props,
                        UpdateType.CHANGED);
                log.info("updatetype:" + teu2.getUpdateType());
                Set<Property> prop_update = teu2.getProperty();
                log.info("update property:" + prop_update.toArray());
                topoedgeupdateList.add(teu2);

            }
            //log.info("before calling edgeupdate");
            topoUpdates.edgeUpdate(topoedgeupdateList);
        }
        String msg = "Available bandwidth is updated";

        return new Status(StatusCode.SUCCESS, msg);
    }

    /**
     * Update the available bandwidth only for the given links
     * @param containerName
     * @param bandwidth
     * @return
     */
    public Status updateLinkBandwidth(String containerName, String bandwidth) {

        //log.debug("update topologymanager");

        try {
            /*File file = new File(FILE_BANDWIDTH);
            FileWriter fw = new FileWriter(file);
            fw.write(bandwidth);
            fw.close();*/

            HashMap<String, String> updatedLinkBw = new HashMap<String, String>();

            String[] linkpair = bandwidth.split("&");

            for (int i = 0; i < linkpair.length; i++) {
                String[] details = linkpair[i].split(",");
                //log.info(details[0] + "---" + details[1]);
                //log.info(details[0].substring(details[0].indexOf(':') + 1)+ "---"+ details[1].substring(details[1].indexOf(':') + 1));
                updatedLinkBw.put(
                        details[0].substring(details[0].indexOf(':') + 1),
                        details[1].substring(details[1].indexOf(':') + 1));
            }

            ITopologyManager topologyManager = (ITopologyManager) ServiceHelper
                    .getInstance(ITopologyManager.class, containerName, this);
            if (topologyManager == null) {
                return new Status(StatusCode.INTERNALERROR,
                        "TopologyManager is null");
            }

            topoUpdates = (IListenTopoUpdates) ServiceHelper.getInstance(
                    IListenTopoUpdates.class, containerName, this);
            if (topoUpdates == null) {
                return new Status(StatusCode.INTERNALERROR,
                        "IListenTopoUpdates is null");
            }
            List<TopoEdgeUpdate> topoedgeupdateList = new ArrayList<TopoEdgeUpdate>();
            Map<Edge, Set<Property>> topo = topologyManager.getEdges();
            if (topo != null) {
                for (Map.Entry<Edge, Set<Property>> entry : topo.entrySet()) {
                    log.info("key(edge name):" + entry.getKey()
                            + " --edge properties(set of property)-- "
                            + entry.getValue());

                    String linkname = entry.getKey().toString();
                   // log.info("linkname: " + linkname);
                    int breakpoint1 = linkname.indexOf("->");
                    String first1 = linkname.substring(0, breakpoint1);
                    String second1 = linkname.substring(breakpoint1);
                    String finalLink = first1.substring(
                            first1.lastIndexOf(':') + 1, breakpoint1)
                            + second1.substring(second1.lastIndexOf(':') + 1,
                                    second1.length() - 1);
                    String reverseLink = second1.substring(
                            second1.lastIndexOf(':') + 1, second1.length() - 1)
                            + first1.substring(first1.lastIndexOf(':') + 1,
                                    breakpoint1);
                    log.info("modified link: " + finalLink + " reverse link: "
                            + reverseLink);

                    if (updatedLinkBw.containsKey(finalLink)) {

                        Edge e2 = (Edge) entry.getKey();
                        Set<Property> props = new HashSet<Property>();
                        long bwModified = Long.parseLong(updatedLinkBw
                                .get(finalLink)) * Bandwidth.BW1Gbps;
                        props.add(new Bandwidth(bwModified));
                        log.info("after updating bw to " + bwModified);
                        TopoEdgeUpdate teu2 = new TopoEdgeUpdate(e2, props,
                                UpdateType.CHANGED);
                        topoedgeupdateList.add(teu2);
                    } else if (updatedLinkBw.containsKey(reverseLink)) {
                        Edge e2 = (Edge) entry.getKey();
                        Set<Property> props = new HashSet<Property>();
                        long bwModified = Long.parseLong(updatedLinkBw
                                .get(reverseLink)) * Bandwidth.BW1Gbps;
                        props.add(new Bandwidth(bwModified));
                        log.info("after updating bw to " + bwModified);
                        TopoEdgeUpdate teu2 = new TopoEdgeUpdate(e2, props,
                                UpdateType.CHANGED);
                        topoedgeupdateList.add(teu2);
                    }

                }
                //log.info("before calling edgeupdate");
                topoUpdates.edgeUpdate(topoedgeupdateList);
            }
        } catch (Exception e) {
            log.error("Not able to update Bandwidth, "+e);
           // e.printStackTrace();
        }
        String msg = "Available bandwidth is updated";

        return new Status(StatusCode.SUCCESS, msg);
    }



}
