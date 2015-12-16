/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;

import com.google.common.base.Optional;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.List;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.openflowplugin.openflow.md.core.session.OFSessionUtil;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeListBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeListKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortListBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParams;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParamsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.NodeConnectorStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsListener;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class OpendaylightSdniQosMsgServiceImpl implements
org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.
OpendaylightSdniQosMsgService, OpendaylightPortStatisticsListener {

	private final Logger logger = LoggerFactory.getLogger(OpendaylightSdniQosMsgServiceImpl.class);

	@Override
	public Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.
	sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> 
	getAllNodeConnectorsStatistics() {
		logger.info("SdniQoSReader - getNodeConnectorStatistics :  Start");

		org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput output = null;
		RpcResultBuilder rpcBuilder = null;

		org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006
		.GetAllNodeConnectorsStatisticsOutputBuilder builder = null; 
		NodeList nodeList = null;
		List<NodeList> outputNodesList = new ArrayList<NodeList>();

		try {

			final ReadOnlyTransaction readTx = OFSessionUtil.getSessionManager().getDataBroker().newReadOnlyTransaction();
			
			InstanceIdentifier<Nodes> NODES_IDENTIFIER = InstanceIdentifier.create(Nodes.class);
			Nodes nodes = getDataObject(readTx, NODES_IDENTIFIER);
			List<Node> nodesList = nodes.getNode();
			for ( Node node : nodesList )
			{
				try {
					nodeList = getAllPortStats(node, readTx);
				} catch (ReadFailedException | ExecutionException
						| InterruptedException e) {
					logger.error("Exception in getAllNodeConnectorsStatistics : "+e.getMessage());
				}

				outputNodesList.add(nodeList);
			}

			builder = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns
					.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutputBuilder();
			builder.setNodeList(outputNodesList);

			output = builder.build();

			rpcBuilder = RpcResultBuilder.success(output);

		} catch (Exception e) {
			logger.error("Exception in getAllNodeConnectorsStatistics : "+e.getMessage());
			rpcBuilder = RpcResultBuilder.failed();
		}
		return rpcBuilder.buildFuture();
	}



	private <T extends DataObject> T getDataObject(final ReadTransaction readOnlyTransaction,
			final InstanceIdentifier<T> identifier) {
		Optional<T> optionalData = null;
		try {
			optionalData = readOnlyTransaction.read(LogicalDatastoreType.OPERATIONAL, identifier).get();
			if (optionalData.isPresent()) {
				return optionalData.get();
			}
		} catch (Exception e) {
			logger.error("Exception while executing getDataObject: " + e.getMessage());
		}
		return null;
	}

	public void onNodeConnectorStatisticsUpdate(final NodeConnectorStatisticsUpdate notification) {
		// do nothing
	}

	public NodeList getAllPortStats(Node node, ReadOnlyTransaction readTx) 
			throws ExecutionException, InterruptedException, ReadFailedException {

		org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics
		.rev131214.flow.capable.node.connector.statistics.FlowCapableNodeConnectorStatistics flow = null; 

		final NodeKey nodeKey = node.getKey();
		logger.info("In getAllPortStats nodekey : " + node.getId().getValue() + " : " + node.getKey());


		List<NodeConnector> ncList = node.getNodeConnector();
		logger.info("In getAllPortStats ncList : "  + node.getId().getValue() + " : " + ncList);

		if ( ncList == null || ncList.isEmpty() )
		{
			return null;
		}

		logger.info("In getAllPortStats ncList size : "  + node.getId().getValue() + " : " +  ncList.size());

		List<PortList> portList = new ArrayList<PortList>();
		for (NodeConnector nc : ncList )
		{
			final InstanceIdentifier<NodeConnector> nodeConnectorII = InstanceIdentifier.create(Nodes.class)
					.child(Node.class, nodeKey).child(NodeConnector.class, nc.getKey());
			logger.info("In getAllPortStats nodeConnectorII : "  + node.getId().getValue() + " : " +  nodeConnectorII);

			final Optional<FlowCapableNodeConnectorStatisticsData> flowCapableNodeConnectorStatisticsDataOptional =
					readTx.read(LogicalDatastoreType.OPERATIONAL,
							nodeConnectorII.augmentation(FlowCapableNodeConnectorStatisticsData.class)).checkedGet();

			logger.info("In getAllPortStats flowCapableNodeConnectorStatisticsDataOptional : " 
					+ node.getId().getValue() + " : " + flowCapableNodeConnectorStatisticsDataOptional);

			if(flowCapableNodeConnectorStatisticsDataOptional.isPresent())
			{
				logger.info("In getAllPortStats: flow is present for "  + node.getId().getValue() + " : ncID : " + nc.getId().getValue());
				flow = flowCapableNodeConnectorStatisticsDataOptional.get().getFlowCapableNodeConnectorStatistics();

				List<PortParams> portparams = new ArrayList<PortParams>();
				PortListBuilder portListBuilder = new PortListBuilder();
				portListBuilder.setPortId(nc.getId().getValue());
				PortParamsBuilder portparamsBuilder = new PortParamsBuilder();
				portparamsBuilder.setBytes(flow.getBytes());
				portparamsBuilder.setCollisionCount(flow.getCollisionCount());
				portparamsBuilder.setDuration(flow.getDuration());
				portparamsBuilder.setPackets(flow.getPackets());
				portparamsBuilder.setReceiveCrcError(flow.getReceiveCrcError());
				portparamsBuilder.setReceiveDrops(flow.getReceiveDrops());
				portparamsBuilder.setReceiveErrors(flow.getReceiveErrors());
				portparamsBuilder.setReceiveFrameError(flow.getReceiveFrameError());
				portparamsBuilder.setReceiveOverRunError(flow.getReceiveOverRunError());
				portparamsBuilder.setTransmitDrops(flow.getTransmitDrops());
				portparamsBuilder.setTransmitErrors(flow.getTransmitErrors());
				portparams.add(portparamsBuilder.build());
				portListBuilder.setPortParams(portparams);
				portList.add(portListBuilder.build());
			}
		}

		NodeListBuilder nodeListBuilder = new NodeListBuilder();
		nodeListBuilder.setKey(new NodeListKey(node.getId().getValue()));
		nodeListBuilder.setNodeId(node.getId().getValue());
		nodeListBuilder.setPortList(portList);

		return nodeListBuilder.build();
	}
}

