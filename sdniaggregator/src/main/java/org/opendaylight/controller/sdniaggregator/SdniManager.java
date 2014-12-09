/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdniaggregator;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opendaylight.controller.clustering.services.IClusterGlobalServices;
import org.opendaylight.controller.connectionmanager.IConnectionManager;
import org.opendaylight.controller.hosttracker.IfIptoHost;
import org.opendaylight.controller.hosttracker.hostAware.HostNodeConnector;
import org.opendaylight.controller.sal.core.Edge;
import org.opendaylight.controller.sal.core.Node;
import org.opendaylight.controller.sal.core.Property;
import org.opendaylight.controller.sal.utils.ServiceHelper;
import org.opendaylight.controller.switchmanager.ISwitchManager;
import org.opendaylight.controller.topologymanager.ITopologyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to retrieve various information about the topology to form
 * SDNi Network Capabilities Data.
 */
public class SdniManager {
    private static Logger log = LoggerFactory.getLogger(SdniManager.class);
    private NetworkCapabilities nwCapabilities = new NetworkCapabilities();
    private static String loopbackAddress = InetAddress.getLoopbackAddress()
            .getHostAddress();
    private static final String SUCCESS = "success";

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

        //log.debug("before topologymanager");

        ITopologyManager topologyManager = (ITopologyManager) ServiceHelper
                .getInstance(ITopologyManager.class, containerName, this);
        if (topologyManager == null) {
            return null;
        }

        Map<Edge, Set<Property>> topo = topologyManager.getEdges();
        if (topo != null) {
            for (Map.Entry<Edge, Set<Property>> entry : topo.entrySet()) {
                //log.info("edge name :" + entry.getKey()+ " --edge properties-- "+ entry.getValue());
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
                        //log.info("inside bandwidth:"+ prop.substring(prop.indexOf('[') + 1,prop.indexOf(']')));
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

       // log.info("inside hosttracker");

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
           // log.info("host node" + hnc.getnodeconnectorNode() + "--host--"+ hnc.getnodeConnector());
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

        //log.debug("inside accessSwitchManager");
        ISwitchManager switchManager = (ISwitchManager) ServiceHelper
                .getInstance(ISwitchManager.class, containerName, this);
        if (switchManager == null) {
            return null;
        }
        Set<Node> nodes = switchManager.getNodes();

        for (Node node : nodes) {
            String nodeName = "";
            String macAddress = "";
            //log.debug("nodes:" + node);
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
                //log.debug("propMap info:" + arrayElement);
            }
            this.nwCapabilities.addNode(nodeName);
            this.nwCapabilities.addMacAddress(macAddress);
        }
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

        String clustering = System.getProperty("supernodes", loopbackAddress);

        log.info("system property: " + clustering);
        if (clustering.equals("127.0.0.1")) {
            //log.info("inside accessing individual manager");
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
        } else {
            log.info("inside accessing clustering and connection manager");
            result = getClusteredControllers(containerName);
        }
        return this.nwCapabilities;

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

}
