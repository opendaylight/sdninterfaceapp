/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
 * This SDNi Aggregetor is used to retrieve topology information to the SDNi Rest APIs.
 * 
 */
public class SdniManager{
    private static Logger log = LoggerFactory.getLogger(SdniManager.class);
    private NetworkCapabilities nwCapabilities = new NetworkCapabilities();
    /**
     * Finds IPv4 address of the local VM
     * TODO: This method is non-deterministic. There may be more than one IPv4 address. Cant say which
     * address will be returned. Read IP from a property file or enhance the code to make it deterministic.
     *
     * @return
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
     * Retrieve the links and bandwidths of the nodes using TopologyManager
     * i.e Edge properties
     * @param nwCapabilities
     * @param containerName
     * @return
     */
    private String accessTopologyManager(String containerName){
    	
    	log.debug("before topologymanager");
    	
    	ITopologyManager topologyManager = (ITopologyManager) ServiceHelper.getInstance(ITopologyManager.class, containerName, this);
    	if(topologyManager == null){
    		return null;
    	}
    	
	    Map<Edge, Set<Property>> topo = topologyManager.getEdges();
    	if (topo != null) {
    		for (Map.Entry<Edge, Set<Property>> entry : topo.entrySet()) {
    			log.debug("key(edge name):" +entry.getKey()+" --edge properties(set of property)-- "+entry.getValue());
            	this.nwCapabilities.addLink(entry.getKey().toString());
                EdgeProperties el = new EdgeProperties(entry.getKey(), entry.getValue());
                Set<Property> property  = el.getProperties();
                Iterator<Property> itr = property.iterator();
                
                while(itr.hasNext()){
                	String prop = itr.next().toString();
                	if(prop.contains("BandWidth")){
                		this.nwCapabilities.addBandwidth(prop.substring(prop.indexOf("[")+1 , prop.indexOf("]")));
                		log.debug("inside bandwidth:"+ prop.substring(prop.indexOf("[")+1 , prop.indexOf("]")));
                	}
                }
            }
           
        }
    	return "success";

    }
    
    /**
     * Retrieve Hosts and its IP addresses using HostTracker
     * Its retrieve only the active hosts.
     * @param containerName
     * @return
     */
    private String accessHostTracker(String containerName){
    	
    	log.info("inside hosttracker");
    	
    	IfIptoHost hostTracker = (IfIptoHost) ServiceHelper.getInstance(IfIptoHost.class, containerName, this);
    	if(hostTracker == null){
    		return null;
    	}
    	Set<HostNodeConnector> hostNodeConnectors = hostTracker.getAllHosts();
	    
	    if(hostNodeConnectors == null) {
	        return null;
	    }
	    
	    HostConfig hostconfig = new HostConfig();
	    for(HostNodeConnector hnc : hostNodeConnectors) {
	    	hostconfig = HostConfig.convert(hnc);
	    	this.nwCapabilities.addHost(hostconfig.getNodeConnectorId());
	    	this.nwCapabilities.addIpAddress(hostconfig.getNetworkAddress());
	    	log.debug("host networkaddress:"+hostconfig.getNetworkAddress());
	    	log.debug("host node connector id:"+hostconfig.getNodeConnectorId());
	    }
    	return "success";
    }
    
    /**
     * Retrieve the nodes and its mac address using SwitchManager
     * 
     * @param containerName
     * @return
     */
    private String accessSwitchManager(String containerName){
    	
    	log.debug("inside accessSwitchManager");
    	ISwitchManager switchManager = (ISwitchManager) ServiceHelper.getInstance(ISwitchManager.class, containerName,this);
    	if(switchManager == null){
    		return null;
    	}
    	Set<Node> nodes = switchManager.getNodes();
	    
	    for (Node node : nodes) {
	    	String nodeName = "";
	    	String macAddress = "";
	    	log.debug("nodes:"+node);
	    	nodeName = node.toString().replace("OF|", "");
	  
        	Map<String, Property> propMap = switchManager.getNodeProps(node);
            Object[] array = propMap.keySet().toArray();
            
            for (int i = 0; i < array.length; i++) {
            	String arrayElement = propMap.get(array[i]).toString();
            	if(arrayElement.contains("MacAddress")){
            		macAddress = arrayElement.substring(arrayElement.indexOf("[")+1,arrayElement.indexOf("]")); 
            	}
            log.debug("propMap info:"+arrayElement);
	        }
            this.nwCapabilities.addNode(nodeName);
	        this.nwCapabilities.addMacAddress(macAddress);
	     }
    	return "success";
    }
    
    
	public NetworkCapabilities getTopologyDetails(String containerName){
		
		//Retrieve Controller's IP address
		this.nwCapabilities.addController(findIpAddress());
		
		String result = "";
		//Retrieve Topology information
		result = accessTopologyManager(containerName);
		if(result == "" || result == null){
			return null;
		}
		//Retrieve Node information
		result = accessSwitchManager(containerName);
		if(result == null){
			return null;
		}
		//Retrieve Host information
		result = accessHostTracker(containerName);
		if(result == null){
			return null;
		}
		return this.nwCapabilities;

	}
   
}
