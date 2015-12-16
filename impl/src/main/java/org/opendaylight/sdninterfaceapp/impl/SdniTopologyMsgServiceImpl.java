/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdninterfaceapp.impl;

import java.util.concurrent.Future;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
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
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;


public class SdniTopologyMsgServiceImpl implements OpendaylightSdniTopologyMsgService {

private static final int CPUS = Runtime.getRuntime().availableProcessors();

    private static final Logger log = LoggerFactory.getLogger(SdniTopologyMsgServiceImpl.class);
    private DataBroker dataService = null;
    OpendaylightSdniTopologyMsgService SdniTopologyMsgService = null;
    org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopologyBuilder networkTopologyBuilder = 
    		new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopologyBuilder();
    RpcResultBuilder rpcResultBuilder = null;

    
org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutputBuilder getTopologyOutputBuilder= new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutputBuilder();


    public SdniTopologyMsgServiceImpl(){

    }  

    @Override
    public Future<RpcResult<GetTopologyOutput>> getTopology(){
	log.debug("SdniTopology Plugin Started");

	List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology> topoList = getAllTopologies();
     List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology> myTopoList = new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology>();

	if(topoList == null){
                log.info("------------ mdsal topolist is null ---- returning null");
		return null;
	}
    for (org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology topo : topoList) {
    
        log.info("---------------mdsal topolist : {}", topo.toString());	org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyBuilder myTopo = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyBuilder();
   		          org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey  tkey = topo.getKey();
	
        log.info("------------mdsal topology Key : {}", tkey.toString());
	
        myTopo.setKey(new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyKey(topo.getTopologyId()));
        myTopo.setLink(getLinks(topo.getLink()));
        myTopo.setNode(getNodes(topo.getNode()));
        myTopo.setTopologyId(topo.getTopologyId());
        myTopo.setServerProvided(topo.isServerProvided());
	myTopo.setUnderlayTopology(getUnderlayTopos(topo.getUnderlayTopology()));

        myTopoList.add(myTopo.build());
   }
        
        networkTopologyBuilder.setTopology(myTopoList);
	
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
    
}
