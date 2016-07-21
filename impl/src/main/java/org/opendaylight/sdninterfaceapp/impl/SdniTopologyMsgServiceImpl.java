/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdninterfaceapp.impl;

import java.util.concurrent.Future;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.SocketException;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.OpendaylightSdniTopologyMsgService;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetAllPeerTopologyOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.Controllers;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.ControllersBuilder;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.Link;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.LinkBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetAllPeerTopologyOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetAllPeerTopologyOutput;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.LinkBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.Destination;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.DestinationBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.Source;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SourceBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TpId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.LinkId;


public class SdniTopologyMsgServiceImpl implements OpendaylightSdniTopologyMsgService {

private static final int CPUS = Runtime.getRuntime().availableProcessors();

    private static final Logger log = LoggerFactory.getLogger(SdniTopologyMsgServiceImpl.class);
    private DataBroker dataService = null;
    private static SdniTopologyMsgServiceImpl sdniTopologyMsgServiceImpl = new SdniTopologyMsgServiceImpl();
    OpendaylightSdniTopologyMsgService SdniTopologyMsgService = null;
    org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopologyBuilder networkTopologyBuilder = 
    		new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopologyBuilder();
    RpcResultBuilder rpcResultBuilder = null;

    
org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutputBuilder getTopologyOutputBuilder= new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutputBuilder();

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
                    log.debug("Settled on controller address {}", hostAddress);
                    return hostAddress;
                }
            }
        }
        log.error("Failed to find a suitable controller address");
        return null;
    }


    private SdniTopologyMsgServiceImpl(){

    }  


    public static SdniTopologyMsgServiceImpl getInstance() {
      return sdniTopologyMsgServiceImpl;
   }
    @Override
    public Future<RpcResult<GetTopologyOutput>> getTopology(){
	log.debug("SdniTopology Plugin Started");

	List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology> topoList = getAllTopologies();
     List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology> myTopoList = new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology>();

	if(topoList == null){
		return null;
	}
    for (org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology topo : topoList) {
    	org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyBuilder myTopo = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyBuilder();
   		          org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey  tkey = topo.getKey();
	
	
        myTopo.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyKey(topo.getTopologyId()));
        myTopo.setLink(getLinks(topo.getLink()));
        myTopo.setNode(getNodes(topo.getNode()));
        myTopo.setTopologyId(topo.getTopologyId());
        myTopo.setServerProvided(topo.isServerProvided());
	myTopo.setUnderlayTopology(getUnderlayTopos(topo.getUnderlayTopology()));

        myTopoList.add(myTopo.build());
   }
        
        networkTopologyBuilder.setTopology(myTopoList);
        networkTopologyBuilder.setControllerIp(findIpAddress());
	
        getTopologyOutputBuilder.setNetworkTopology(networkTopologyBuilder.build());
        log.info("------------getTopologyOutputBuilder----------------");
        rpcResultBuilder = RpcResultBuilder.success(getTopologyOutputBuilder.build());
        log.info("------------rpcResultBuilder----------------");
        return rpcResultBuilder.buildFuture();
 }

     
    private List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link> getLinks(List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link> mdsalLinkList) {

if(mdsalLinkList == null || mdsalLinkList.isEmpty()){
   return null;
}

List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link> result 
= new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link>();

for(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link l: mdsalLinkList) {
 org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.LinkBuilder myLink = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.LinkBuilder();

myLink.setDestination(l.getDestination());
myLink.setLinkId(l.getLinkId());
myLink.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.LinkKey(l.getLinkId()));
myLink.setSource(l.getSource());
myLink.setSupportingLink(l.getSupportingLink());
result.add(myLink.build());
}

return result;
    
}
  

private List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopology> getUnderlayTopos(List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.UnderlayTopology> mdsalUnderlayTopoList) {
if(mdsalUnderlayTopoList == null || mdsalUnderlayTopoList.isEmpty()){
   return null;
}
List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopology> result 
= new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopology>();

for(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.UnderlayTopology utp: mdsalUnderlayTopoList) {

org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopologyBuilder myUnderlayTopo = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopologyBuilder(); 

myUnderlayTopo.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopologyKey(utp.getTopologyRef()));
myUnderlayTopo.setTopologyRef(utp.getTopologyRef());


result.add(myUnderlayTopo.build());
}

return result;

}
  
private List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Node> getNodes(List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node> mdsalNodeList) {

if(mdsalNodeList == null || mdsalNodeList.isEmpty()){
   return null;
}


List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Node> result 
= new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Node>();

for(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node n: mdsalNodeList) {
org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.NodeBuilder myNode = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.NodeBuilder();

myNode.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.NodeKey(n.getNodeId()));
myNode.setNodeId(n.getNodeId());
myNode.setSupportingNode(n.getSupportingNode());

//Termination point list setting
List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPoint> myTpList 
= new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPoint>();
  for (org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.node.TerminationPoint mdsalNodeTp: n.getTerminationPoint()) {
org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPointBuilder myNodeTp= new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPointBuilder();

myNodeTp.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPointKey(mdsalNodeTp.getTpId()));
myNodeTp.setTpId(mdsalNodeTp.getTpId());
myNodeTp.setTpRef(mdsalNodeTp.getTpRef());

myTpList.add(myNodeTp.build());
}
myNode.setTerminationPoint(myTpList);
result.add(myNode.build());
}

return result;
}



    // Get all topologies in MD-SAL
    private List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology> getAllTopologies() {

        List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology> topo = 
        		new ArrayList<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology>();
        InstanceIdentifier<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology> ntII
                = InstanceIdentifier.builder(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology.class).build();
        ListenableFuture<Optional<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology>> lfONT;
        try (ReadOnlyTransaction rot = dataService.newReadOnlyTransaction()) {
            lfONT = rot.read(LogicalDatastoreType.OPERATIONAL, ntII);
            rot.close();
        }
        Optional<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology> oNT;
        try {
            oNT = lfONT.get();
        } catch (InterruptedException | ExecutionException ex) {
            log.warn(ex.getLocalizedMessage());
            return null;
        }
        if (oNT != null && oNT.isPresent()) {
            org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology networkTopo = oNT.get();
            topo = networkTopo.getTopology();
        }
        return topo;
    }


    public void setBroker(org.opendaylight.controller.md.sal.binding.api.DataBroker dataBroker)
    {
    	this.dataService = dataBroker;
    }
    
   
    @Override
    public Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.
	sdninterfaceapp.topology.msg.rev151006.GetAllPeerTopologyOutput>> getAllPeerTopology() {
   	 log.info("In getAllPeerTopology START");
       
   	
   	 GetAllPeerTopologyOutputBuilder outputBuilder = new GetAllPeerTopologyOutputBuilder();
   	 List<Controllers> controllers = new ArrayList<Controllers>();
   	 try {
               //String URL = "jdbc:sqlite:sdninterfaceapp:db";
               //Class.forName("org.sqlite.JDBC", true, Thread.currentThread().getContextClassLoader());
               //Connection conn = DriverManager.getConnection(URL); 
			
               SdniDataBase sdb = new SdniDataBase();
                //Connection conn = sdb.getConnection();

			Map<String, List<String>> topologyData=sdb.getAllPeerTopology();
log.info("after getAllPeerTopology of sdnjava"+ topologyData);
//logger.info(for(Map.Entry<String, ArrayList<Edge>> e : map.entrySet()){
  //for(Edge e1 : e.getValue())
    // System.out.println(e.getKey() + " = "+ e1.Out()););
			if ( topologyData != null && !topologyData.isEmpty() )
			{
				//get controller info
				Set<String> controllersList = topologyData.keySet();
				if ( controllersList != null && !controllersList.isEmpty() )
				{
					log.info("In getAllPeerTopology controllersList : {}", controllersList.size());
					for ( String controllerIp : controllersList )
			{
						ControllersBuilder crtlBuilder = new ControllersBuilder();
				//get link info
						List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.Link> linkList = new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.Link>();
				List<String> linkData=topologyData.get(controllerIp);
				if ( linkData != null && !linkData.isEmpty() )
				{
					log.info("In getAllPeerTopology linkData : {}", linkData.size());
					//Set<String> linksList = linkData.keySet();
					
						for ( String link : linkData )
						{
							String[] parts = link.split("->");
							String source = parts[0];
							String destination = parts[1];
							String sw = "openflow";
							String NODE1_ID;
							String TP1_ID;
							String NODE2_ID;
							String TP2_ID;
							
							if(source.contains(sw)){
                                                       TP1_ID = source;
                                                       //NODE1_ID = source;
							String[] sNodePort = source.split(":");
							NODE1_ID = sNodePort[0]+":"+sNodePort[1];
							//TP1_ID = sNodePort[2];		
							}
							else{
								//int len = source.length();
                               NODE1_ID = source;
                               TP1_ID = source;
							}
							if(destination.contains(sw)){
TP2_ID = destination;
//NODE2_ID = destination;
								String[] dNodePort = destination.split(":");
															NODE2_ID = dNodePort[0]+":"+dNodePort[1];
															
								}
								else{
								//int len1 = destination.length();
								                            //(jun15)NODE2_ID = source;
															//(jun15)TP2_ID = source;
                                                                      TP2_ID = destination;
                                                                      NODE2_ID = destination;
                                                                      
								}
							
							org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.LinkBuilder linkBuilder = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.getallpeertopology.output.controllers.LinkBuilder();
							DestinationBuilder destBuilder = new DestinationBuilder();
							//Uri uri_dnid_l = new Uri(NODE2_ID); 
									//NODE2_ID.toURI()Uri.parse();
							NodeId d_nid_l = new NodeId(NODE2_ID);
							//Uri uri_dtpid_l = new Uri(TP2_ID);
									//TP2_ID.toURI();
							TpId d_tpid_l = new TpId(TP2_ID);
							destBuilder.setDestNode(d_nid_l);
							destBuilder.setDestTp(d_tpid_l);
							linkBuilder.setDestination(destBuilder.build());
							
							SourceBuilder souBuilder = new SourceBuilder();
							//Uri uri_snid_l = new Uri(NODE1_ID);
							NodeId s_nid_l = new NodeId(NODE1_ID);
							//(jun15)Uri uri_stpid_l = new Uri(TP2_ID);
                              //                         Uri uri_stpid_l = new Uri(TP1_ID); 
							TpId s_tpid_l = new TpId(TP1_ID);
							souBuilder.setSourceNode(s_nid_l);
							souBuilder.setSourceTp(s_tpid_l);
							linkBuilder.setSource(souBuilder.build());
							
							
							//linkbuilder.setSource(new org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SourceBuilder().setSourceNode(NODE1_ID).setSourceTp(TP1_ID).build());
					        //linkbuilder.setDestination(new org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.DestinationBuilder().setDestNode(NODE2_ID).setDestTp(TP2_ID).build());
					        
							//linkbuilder.setDestination(destination);
							String Linkid;
							
							//linkbuilder.setKey();
                           //linkbuilder.setSource(source);
                           
                           
                           
                           /*if(source.contains(switch)){
                           	if(destination.contains(switch)){
                           		//when link is between two switches
                           		LinkId=source;
                           	}
                           	else{
                           		//when link is between switch(source) and host(destination)
                           		LinkId=source+"/"+destination;
                           	}
                           	
                           }
                           else
                           {//when link is between host(source) and switch(destination)
                           
                           		LinkId=source+"/"+destination;
                           	
                           }*/
                           if(source.contains(sw) && destination.contains(sw)){
                           	Linkid=source;
                           	}
                           else{
                           	Linkid=source+"/"+destination;
                           }
                           //Uri uri_lid_l = new Uri(Linkid);
                   		LinkId lid_l = new LinkId(Linkid);
                         linkBuilder.setLinkId(lid_l);
                           //List<SupportingLink> supportinglink= new ArrayList<SupportingLink>();
							//SupportingLinkBuilder supportinglinkbuilder = new SupportingLinkBuilder();
							
							
							//supportinglink.add(supportinglinkbuilder.build);
							
							//linkbuilder.setSupportingLink(supportinglink);
							linkList.add(linkBuilder.build());
						}
					  }	
					
				crtlBuilder.setControllerIp(controllerIp);
				crtlBuilder.setLink(linkList);
				controllers.add(crtlBuilder.build());
			}
				}
			  }		
	       }
	

	
   	 catch(Exception e) {
   		 log.error("Exception in getAllPeerTopology : {}",e.getMessage());
			//return RpcResultBuilder.failed().buildFuture();
   	 }
   	 outputBuilder.setControllers(controllers);
   	 return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
    }
}
