package org.opendaylight.sdninterfaceapp.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.sdninterfaceapp.impl.SdniTopologyMsgServiceImpl;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopologyBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.LinkBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.LinkKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.LinkId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.Destination;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.DestinationBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
import  org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TpId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.Source;
import  org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SourceBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SupportingLink;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SupportingLinkBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.link.attributes.SupportingLinkKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.node.attributes.SupportingNode;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.node.attributes.SupportingNodeBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.node.attributes.SupportingNodeKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.node.TerminationPoint;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.node.TerminationPointBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.node.TerminationPointKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.UnderlayTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.UnderlayTopologyBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.UnderlayTopologyKey;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

public class SdniTopologyMsgServiceImplTest  {
	SdniTopologyMsgServiceImpl serviceimpl = null;
	org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology mdsalNT;
	org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopologyBuilder nb= null;
	org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyBuilder topoBuilder;
	List<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology> listTopo;
	
	@Before
	public final void setUp() throws InterruptedException, ExecutionException
	{
		serviceimpl = new SdniTopologyMsgServiceImpl();
		InstanceIdentifier<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology> ntII
			 = InstanceIdentifier.builder(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology.class).build();
		final Logger log = LoggerFactory.getLogger(SdniTopologyMsgServiceImplTest.class);
		DataBroker  databroker= Mockito.mock(DataBroker.class);
		ReadOnlyTransaction ReadOnlyTrans=Mockito.mock(ReadOnlyTransaction.class);
		serviceimpl.setBroker(databroker);
		
		topoBuilder = new org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyBuilder();
		listTopo = new ArrayList<org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology>();
		Uri uri_tid_tb = new Uri("host:00:00:00:00:00:01");
		TopologyId tid_tb = new TopologyId(uri_tid_tb);
		TopologyKey tkey_tb = new TopologyKey(tid_tb);
		
		topoBuilder.setKey(tkey_tb);
		topoBuilder.setTopologyId(tid_tb);
	
		LinkBuilder linkBuilder = new LinkBuilder();
		Uri uri_lid_l = new Uri("host:00:00:00:00:00:06");
		LinkId lid_l = new LinkId(uri_lid_l);
		LinkKey lkey_l = new LinkKey(lid_l);
		
		DestinationBuilder destBuilder = new DestinationBuilder();
		Uri uri_dnid_l = new Uri("host:00:00:00:00:00:02");
		NodeId d_nid_l = new NodeId(uri_dnid_l);
		Uri uri_dtpid_l = new Uri("host:00:00:00:00:00:04");
		TpId d_tpid_l = new TpId(uri_dtpid_l);
		destBuilder.setDestNode(d_nid_l);
		destBuilder.setDestTp(d_tpid_l);
		
		SourceBuilder souBuilder = new SourceBuilder();
		Uri uri_snid_l = new Uri("host:00:00:00:00:00:03");
		NodeId s_nid_l = new NodeId(uri_snid_l);
		Uri uri_stpid_l = new Uri("host:00:00:00:00:00:05");
		TpId s_tpid_l = new TpId(uri_stpid_l);
		souBuilder.setSourceNode(s_nid_l);
		souBuilder.setSourceTp(s_tpid_l);
		
		SupportingLinkBuilder slBuilder = new SupportingLinkBuilder();
		Uri uri_slkey_l = new Uri("host:00:00:00:00:00:07");
		LinkId lid_slkey_l = new LinkId(uri_slkey_l);
		SupportingLinkKey slkey_l = new SupportingLinkKey(lid_slkey_l);
		slBuilder.setKey(slkey_l);
		slBuilder.setLinkRef(lid_slkey_l);
		List<SupportingLink> list_sl_l = new ArrayList<SupportingLink>();
		list_sl_l.add(slBuilder.build());
		
		
		linkBuilder.setKey(lkey_l);
		linkBuilder.setLinkId(lid_l);
		linkBuilder.setDestination(destBuilder.build());
		linkBuilder.setSource(souBuilder.build());
		linkBuilder.setSupportingLink(list_sl_l);
		
		List<Link> list_l = new ArrayList<Link>();
		list_l.add(linkBuilder.build());
		
		topoBuilder.setLink(list_l);
		
		NodeBuilder nodeBuilder = new NodeBuilder();
		Uri uri_nid_n = new Uri("openflow:8");
		NodeId nid_n = new NodeId(uri_nid_n);
		NodeKey nkey_n = new NodeKey(nid_n);
		
		SupportingNodeBuilder snBuilder = new SupportingNodeBuilder();
		Uri uri_nid_snb = new Uri("host:00:00:00:00:00:09");
		NodeId nid_snb = new NodeId(uri_nid_snb);
		Uri uri_tid_snb = new Uri("host:00:00:00:00:00:10");
		TopologyId tid_snb = new TopologyId(uri_tid_snb);
		SupportingNodeKey snkey_snb = new SupportingNodeKey(nid_snb,tid_snb);
		snBuilder.setKey(snkey_snb);
		snBuilder.setNodeRef(nid_snb);
		snBuilder.setTopologyRef(tid_snb);
		List<SupportingNode> list_sn = new ArrayList<SupportingNode>();
		list_sn.add(snBuilder.build());
		
		TerminationPointBuilder tpBuilder = new TerminationPointBuilder();
		Uri uri_tpid_tpb = new Uri("host:00:00:00:00:00:11");
		TpId tpid_tpb = new TpId(uri_tpid_tpb);
		TerminationPointKey tpkey_tpb = new TerminationPointKey(tpid_tpb);
		List<TpId> list_tpid_tpb = new ArrayList<TpId>();
		list_tpid_tpb.add(tpid_tpb);
		
		tpBuilder.setKey(tpkey_tpb);
		tpBuilder.setTpId(tpid_tpb);
		tpBuilder.setTpRef(list_tpid_tpb);
		
		List<TerminationPoint> list_tp = new ArrayList<TerminationPoint>();
		list_tp.add(tpBuilder.build());
		
		
		nodeBuilder.setKey(nkey_n);
		nodeBuilder.setNodeId(nid_n);
		nodeBuilder.setSupportingNode(list_sn);
		nodeBuilder.setTerminationPoint(list_tp);
		List<Node> list_n = new ArrayList<Node>();
		list_n.add(nodeBuilder.build());
		
		topoBuilder.setNode(list_n);
		
		
		UnderlayTopologyBuilder utBuilder = new UnderlayTopologyBuilder();
		Uri uri_tid_utb = new Uri("host:00:00:00:00:00:12");
		TopologyId tid_utb = new TopologyId(uri_tid_utb);
		UnderlayTopologyKey utk_utb = new UnderlayTopologyKey(tid_utb);
		utBuilder.setKey(utk_utb);
		utBuilder.setTopologyRef(tid_utb);
		
		List<UnderlayTopology> list_ut = new ArrayList<UnderlayTopology>();
		list_ut.add(utBuilder.build());
		
		topoBuilder.setUnderlayTopology(list_ut);
		topoBuilder.setServerProvided(true);
		
		listTopo.add(topoBuilder.build());
		nb = new NetworkTopologyBuilder();
		nb.setTopology(listTopo);
		mdsalNT = nb.build();
		Optional<NetworkTopology> optional=Optional.of(mdsalNT);
		CheckedFuture<Optional<NetworkTopology>, ReadFailedException> listenableFuture = Futures.immediateCheckedFuture(optional);
		
		//mockitos
		Mockito.when(databroker.newReadOnlyTransaction()).thenReturn(ReadOnlyTrans);
		Mockito.when(ReadOnlyTrans.read(LogicalDatastoreType.OPERATIONAL, ntII)).thenReturn(listenableFuture);
		
		ListenableFuture<Optional<NetworkTopology>> futureobject = ReadOnlyTrans.read(LogicalDatastoreType.OPERATIONAL, ntII); 		
		optional= futureobject.get();
		mdsalNT = (NetworkTopology) optional.get();
		listTopo= mdsalNT.getTopology();
	}
	
	@Test
	public void testGetTopology() throws InterruptedException, ExecutionException
	{
		Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput>>  finalobject = serviceimpl.getTopology();
		
		RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput> 
		 rpcobject = finalobject.get();
		
		org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput outputobject = rpcobject.getResult();
		org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopology networkt = outputobject.getNetworkTopology();
		
		List< org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology> list_topo = networkt.getTopology();
		for( org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology topo : list_topo)
		{
			org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.TopologyKey key = topo.getKey();

			assertEquals("host:00:00:00:00:00:01",key.getTopologyId().getValue());
			TopologyId id = topo.getTopologyId();
			assertEquals("host:00:00:00:00:00:01",id.getValue());
			List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link> listl=topo.getLink();
			for(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link l : listl)
			{
				org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.LinkKey lkey = l.getKey();
				LinkId lid = l.getLinkId();
				Source s = l.getSource();
				Destination d= l.getDestination();
				assertEquals("host:00:00:00:00:00:06",lkey.getLinkId().getValue());
				assertEquals("host:00:00:00:00:00:06",lid.getValue());
				assertEquals("host:00:00:00:00:00:03",s.getSourceNode().getValue());
				assertEquals("host:00:00:00:00:00:05",s.getSourceTp().getValue());
				assertEquals("host:00:00:00:00:00:02",d.getDestNode().getValue());
				assertEquals("host:00:00:00:00:00:04",d.getDestTp().getValue());
				List<SupportingLink> lists = l.getSupportingLink(); 
				for(SupportingLink sl : lists)
				{
					SupportingLinkKey slkey = sl.getKey();
					LinkId lkid = sl.getLinkRef();
					assertEquals("host:00:00:00:00:00:07",slkey.getLinkRef().getValue());
					assertEquals("host:00:00:00:00:00:07",lkid.getValue());
				}	
			}
			List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Node> listn = topo.getNode(); 
			for(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Node n :listn)
			{
				org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.NodeKey nodek= n.getKey();
				NodeId nid = n.getNodeId();
				assertEquals("openflow:8",nodek.getNodeId().getValue());
				assertEquals("openflow:8",nid.getValue());
				List<SupportingNode> lsn=n.getSupportingNode();
				for(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.node.attributes.SupportingNode sn : lsn)
				{
					SupportingNodeKey snk = sn.getKey();
					NodeId snid = sn.getNodeRef();
					TopologyId stid = sn.getTopologyRef();
					assertEquals("host:00:00:00:00:00:09",snk.getNodeRef().getValue());
					assertEquals("host:00:00:00:00:00:10",snk.getTopologyRef().getValue());
					assertEquals("host:00:00:00:00:00:09",snid.getValue());
					assertEquals("host:00:00:00:00:00:10",stid.getValue());
				}
				List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPoint> ltp=n.getTerminationPoint();
				for(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPoint tp : ltp)
				{
					org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.node.TerminationPointKey ttpk = tp.getKey();
					TpId ttpid = tp.getTpId();
					 assertEquals("host:00:00:00:00:00:11",ttpk.getTpId().getValue());
					 assertEquals("host:00:00:00:00:00:11",ttpid.getValue());
					 List<TpId> ltpid = tp.getTpRef();
					 for(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TpId tpid :ltpid)
					 {
						 assertEquals("host:00:00:00:00:00:11",tpid.getValue());
					 }
				}	
			}

			List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopology> lu = topo.getUnderlayTopology();
			for(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopology u : lu)
			{
				org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.UnderlayTopologyKey uk = u.getKey();
				TopologyId uid = u.getTopologyRef();
				assertEquals("host:00:00:00:00:00:12",uk.getTopologyRef().getValue());
				assertEquals("host:00:00:00:00:00:12",uid.getValue());
				
			}

			assertEquals("true",topo.isServerProvided().toString());
		}	
	}		
}
