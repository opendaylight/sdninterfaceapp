/*
 * Copyright (c) 2015, 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdninterfaceapp.impl;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mockito.Mockito.*;
import java.util.concurrent.Future;
import org.junit.Test;
import org.mockito.Mockito;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.NodeList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.port.list.PortParams;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.GetAllNodeConnectorsStatisticsInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.flow.capable.node.connector.statistics.FlowCapableNodeConnectorStatisticsBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.CheckedFuture;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.openflowplugin.api.openflow.device.DeviceContext;
import org.opendaylight.openflowplugin.api.openflow.device.RequestContextStack;
import org.opendaylight.openflowplugin.api.openflow.md.core.session.SessionManager;
import org.opendaylight.openflowplugin.openflow.md.core.session.ConjunctSessionManager;
import org.opendaylight.openflowplugin.openflow.md.core.session.OFSessionUtil;
import org.opendaylight.openflowplugin.openflow.md.core.session.SessionManagerOFImpl;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.node.connector.statistics.Bytes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.node.connector.statistics.BytesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.node.connector.statistics.Packets;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.node.connector.statistics.PacketsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.NodeConnectorStatistics;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.duration.Duration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.statistics.types.rev130925.duration.DurationBuilder;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev130715.Counter32;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnectorBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.SdnControllersBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMapBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.SdnControllers;

public class OpendaylightSdniQosMsgServiceImplTest {
	private OpendaylightSdniQosMsgServiceImpl serviceImpl = OpendaylightSdniQosMsgServiceImpl.getInstance();;
	List<NodeConnectorStatisticsAndPortNumberMap> listOfMap;
	private final Logger logger = LoggerFactory.getLogger(OpendaylightSdniQosMsgServiceImpl.class);
	org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsDataBuilder flowcapabledata;

	@Test	
	public void testGetAllNodeConnectorsStatistics() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		try {

			mockClasses();
			Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.
			sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> finalObj = serviceImpl.getAllNodeConnectorsStatistics();
			RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.
			sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput> rpcObj=finalObj.get();
			org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput outputObj=rpcObj.getResult();
			
			

			List<NodeList> ndList=outputObj.getNodeList();

			
			for ( NodeList nList : ndList )
			{
				String nodeID = nList.getNodeId();
				assertEquals(nodeID, "openflow:1");
				List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.PortList> portlist =nList.getPortList();

				for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.PortList Plist : portlist )
				{
					String portID = Plist.getPortId();
					assertEquals(portID,"openflow:1");
					List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.port.list.PortParams> Pparamslist=Plist.getPortParams();
					for(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.port.list.PortParams Pparams :Pparamslist)
					{
						Bytes bytes=Pparams.getBytes();
						assertEquals(bytes.getReceived(),BigInteger.ONE);
						assertEquals(bytes.getTransmitted(),BigInteger.TEN);
						Duration duration=Pparams.getDuration();
						assertEquals(duration.getSecond().getValue(),new Long(21));
						assertEquals(duration.getNanosecond().getValue(),new Long(0001));
						BigInteger recErrors=Pparams.getReceiveErrors();
						assertEquals(recErrors,BigInteger.ONE);
						Packets packets=Pparams.getPackets();
						assertEquals(packets.getReceived(),BigInteger.ZERO);
						assertEquals(packets.getTransmitted(),BigInteger.ONE);
						BigInteger recCrcError=Pparams.getReceiveCrcError();
						assertEquals(recCrcError,BigInteger.ONE);
						BigInteger recDrops=Pparams.getReceiveDrops();
						assertEquals(recDrops,BigInteger.TEN);
						BigInteger transmitDrops=Pparams.getTransmitDrops();
						assertEquals(transmitDrops,BigInteger.ZERO);
						BigInteger recFrameError=Pparams.getReceiveFrameError();
						assertEquals(recFrameError,BigInteger.TEN);
						BigInteger recOverRunError=Pparams.getReceiveOverRunError();
						assertEquals(recOverRunError,BigInteger.ONE);
						BigInteger collisionCount=Pparams.getCollisionCount();
						assertEquals(collisionCount,BigInteger.ONE);
						BigInteger transmitError=Pparams.getTransmitErrors();
						assertEquals(transmitError,BigInteger.ZERO);
					}

				}
			}
		} 
		catch (InterruptedException | ExecutionException e) {

			System.out.println(e.getMessage());
		}
	}

	private void mockClasses() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException, ExecutionException

	{

	
			RpcProviderRegistry rpcRegisrty = Mockito.mock(RpcProviderRegistry.class);
			GetAllNodeConnectorsStatisticsInputBuilder input = new GetAllNodeConnectorsStatisticsInputBuilder() ;
			OpendaylightPortStatisticsService openPortStatsServiceTest=Mockito.mock(OpendaylightPortStatisticsService.class);
			Mockito.when(rpcRegisrty.getRpcService(OpendaylightPortStatisticsService.class)).thenReturn(openPortStatsServiceTest);

			RequestContextStack reqContextStack=Mockito.mock(RequestContextStack.class);
			DeviceContext deviceContext=Mockito.mock(DeviceContext.class);
			DataBroker  dataBroker= Mockito.mock(DataBroker.class);
			ReadOnlyTransaction readOnlyTrans=Mockito.mock(ReadOnlyTransaction.class);
			WriteTransaction writeTx = Mockito.mock(WriteTransaction.class);

			InstanceIdentifier<Nodes> NODES_IDENTIFIER = InstanceIdentifier.create(Nodes.class);
			input.setNode(new NodeRef(NODES_IDENTIFIER));
			OFSessionUtil.getSessionManager().setDataBroker(dataBroker);
			Mockito.when(dataBroker.newReadOnlyTransaction()).thenReturn(readOnlyTrans);
			Mockito.when(dataBroker.newWriteOnlyTransaction()).thenReturn(writeTx);
			
			Optional optionalData = Mockito.mock(Optional.class);
			CheckedFuture checkedFuture = Mockito.mock(CheckedFuture.class);
			FlowCapableNodeConnectorStatisticsData flowcapablenodeconnectorstatisticsdata=Mockito.mock(FlowCapableNodeConnectorStatisticsData.class);
			Mockito.when(readOnlyTrans.read(LogicalDatastoreType.OPERATIONAL, NODES_IDENTIFIER)).thenReturn(checkedFuture);
			Mockito.when(checkedFuture.get()).thenReturn(optionalData);
			Mockito.when(optionalData.isPresent()).thenReturn(true);

			List<Node> nodeList = new ArrayList<Node>();
			NodeBuilder nodes = new NodeBuilder();
			nodes.setId(new NodeId("openflow:1"));
			nodes. setKey(new NodeKey(new NodeId("openflow:1")));
			
             NodeConnectorBuilder ncBuilder = new NodeConnectorBuilder();
		     FlowCapableNodeConnectorBuilder fcncBuilder = new FlowCapableNodeConnectorBuilder();
		     NodeConnectorId Nid=new NodeConnectorId("openflow:1");
		     
		     ncBuilder.setKey(new NodeConnectorKey(Nid));
		     ncBuilder.setId(new NodeConnectorId("openflow:1"));
		     ncBuilder.addAugmentation(FlowCapableNodeConnector.class, fcncBuilder.build());
		     List<NodeConnector> nodecnList = new ArrayList<NodeConnector>();
		     nodecnList.add(ncBuilder.build());
			nodes.setNodeConnector(nodecnList);
			nodeList.add(nodes.build());
			
            

			NodesBuilder nodesB = new NodesBuilder();
			nodesB.setNode(nodeList);

			Mockito.when(optionalData.get()).thenReturn(nodesB.build());
			constructMapObject();
			final NodeKey nodeKey = nodes.getKey();
			try{
			
			for (NodeConnector nc : nodecnList ){
			final InstanceIdentifier<NodeConnector> nodeConnectorII = InstanceIdentifier.create(Nodes.class)
					.child(Node.class, nodeKey).child(NodeConnector.class, nc.getKey());

			
			org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData flowcapabled=flowcapabledata.build();
			Optional flowCapableNodeConnectorStatisticsDataOptional=optionalData.of(flowcapabled);
			
			CheckedFuture checkedFuture1 = Mockito.mock(CheckedFuture.class);
			
			Mockito.when(readOnlyTrans.read(LogicalDatastoreType.OPERATIONAL,nodeConnectorII.augmentation(FlowCapableNodeConnectorStatisticsData.class))).thenReturn(checkedFuture1);
			Mockito.when(checkedFuture1.checkedGet()).thenReturn(flowCapableNodeConnectorStatisticsDataOptional);
			}
		} catch (Exception e) {
			logger.error("Exception while executing getDataObject: " + e.getMessage());
		}
	}

	private void constructMapObject()
	{

		

		FlowCapableNodeConnectorStatisticsBuilder flowcapable=new FlowCapableNodeConnectorStatisticsBuilder();
		BytesBuilder bytesBuilder=new BytesBuilder();

		bytesBuilder.setReceived(BigInteger.ONE);
		bytesBuilder.setTransmitted(BigInteger.TEN);
		flowcapable.setBytes(bytesBuilder.build());
		flowcapable.setCollisionCount(BigInteger.ONE);
		DurationBuilder durationBuilder=new DurationBuilder();
		durationBuilder.setNanosecond(Counter32.getDefaultInstance("0001"));
		durationBuilder.setSecond(Counter32.getDefaultInstance("21"));
		flowcapable.setDuration(durationBuilder.build());
		PacketsBuilder packetsBuilder=new PacketsBuilder();
		packetsBuilder.setReceived(BigInteger.ZERO);
		packetsBuilder.setTransmitted(BigInteger.ONE);
		flowcapable.setPackets(packetsBuilder.build());
		flowcapable.setReceiveCrcError(BigInteger.ONE);
		flowcapable.setReceiveDrops(BigInteger.TEN);
		flowcapable.setReceiveErrors(BigInteger.ONE);
		flowcapable.setReceiveFrameError(BigInteger.TEN);
		flowcapable.setReceiveOverRunError(BigInteger.ONE);
		flowcapable.setTransmitDrops(BigInteger.ZERO);
		flowcapable.setTransmitErrors(BigInteger.ZERO);

		flowcapabledata=new org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsDataBuilder();
		flowcapabledata.setFlowCapableNodeConnectorStatistics(flowcapable.build());
		org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData flowcapabled=flowcapabledata.build();

		
	}

}
