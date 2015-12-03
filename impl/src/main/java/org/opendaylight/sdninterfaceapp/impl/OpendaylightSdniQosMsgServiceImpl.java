/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.lang.Exception;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.List;

import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.openflowplugin.api.openflow.device.DeviceContext;
import org.opendaylight.openflowplugin.api.openflow.device.RequestContextStack;
import org.opendaylight.openflowplugin.openflow.md.core.session.OFSessionUtil;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeContextRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.openflow.common.config.impl.rev140326.modules.module.configuration.openflow.provider.impl.RpcRegistryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.OpendaylightSdniQosMsgService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.GetAllNodeConnectorsStatisticsInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.NodeConnectorStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMapBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsService;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OpendaylightSdniQosMsgServiceImpl implements
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.
        OpendaylightSdniQosMsgService, OpendaylightPortStatisticsListener {

    private static OpendaylightSdniQosMsgServiceImpl qosDataServiceImpl = null;
    private static final InstanceIdentifier<NodeContextRef> NODES_IDENTIFIER = InstanceIdentifier.create(NodeContextRef.class);
    private final Logger logger = LoggerFactory.getLogger(OpendaylightSdniQosMsgServiceImpl.class);
    private org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsService opendaylightPortStatisticsService = null;
    private ProviderContext context = null;
    private org.opendaylight.controller.sal.binding.api.RpcProviderRegistry rpcProviderregistry = null;
    
    
    public void setRpcRegistry(org.opendaylight.controller.sal.binding.api.RpcProviderRegistry rpcProviderRegisrty)
    {
    	this.rpcProviderregistry = rpcProviderRegisrty;
    }
    
    @Override
    public Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.
    sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> 
    getAllNodeConnectorsStatistics() {
    	logger.info("SdniQoSReader - getNodeConnectorStatistics :  Start");

    	opendaylightPortStatisticsService = rpcProviderregistry.getRpcService(OpendaylightPortStatisticsService.class);

    	org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput output = null;
    	RpcResultBuilder rpcBuilder = null;
    	Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.
    	GetAllNodeConnectorsStatisticsOutput>> resultFuture = null;
    	RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.GetAllNodeConnectorsStatisticsOutput> rpcResultObj = null;
    	InstanceIdentifier<Node> ncInsId1 = null;
    	GetAllNodeConnectorsStatisticsInputBuilder input = null;
    	org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.GetAllNodeConnectorsStatisticsOutput result = null;
    	List<NodeConnectorStatisticsAndPortNumberMap> listNodeConnectorStatisticsAndPortNumberMap = null; 
    	org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006
    	.GetAllNodeConnectorsStatisticsOutputBuilder builder = null; 
    	org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006
    	.get.all.node.connectors.statistics.output.NodeQosBuilder nodeQosBuilder = null;

    	InstanceIdentifier<Nodes> NODES_IDENTIFIER = InstanceIdentifier.create(Nodes.class);
    	Nodes nodes = getDataObject(OFSessionUtil.getSessionManager().getDataBroker().newReadOnlyTransaction(), NODES_IDENTIFIER);

    	List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeQos> nodeQosList 
    	= new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeQos>();
    	
    	try {
    		List<Node> nodesList = nodes.getNode();
    		for ( Node node : nodesList )
    		{
    			ncInsId1 = InstanceIdentifier.builder(Nodes.class)
    					.child(Node.class, new NodeKey(node.getId())).build();

    			input = new GetAllNodeConnectorsStatisticsInputBuilder();
    			input.setNode(new NodeRef(ncInsId1));

    			resultFuture = opendaylightPortStatisticsService.getAllNodeConnectorsStatistics(input.build());

    			rpcResultObj = resultFuture.get();
    			result = rpcResultObj.getResult();
    			logger.info("Result in getAllNodeConnectorsStatistics : Node ID : " + node.getId() + " : " + result);

    			listNodeConnectorStatisticsAndPortNumberMap = result.getNodeConnectorStatisticsAndPortNumberMap();
    			logger.debug("Map Result obj in getAllNodeConnectorsStatistics : Node ID : " + node.getId() + " : " + listNodeConnectorStatisticsAndPortNumberMap);


    			nodeQosBuilder = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006
    					.get.all.node.connectors.statistics.output.NodeQosBuilder();

    			nodeQosBuilder.setNodeId(node.getId().getValue()); 
    			nodeQosBuilder.setNodeConnectorStatisticsAndPortNumberMap(listNodeConnectorStatisticsAndPortNumberMap);

    			nodeQosList.add(nodeQosBuilder.build());
    			logger.info("Returning success result of getAllNodeConnectorsStatistics : Node ID : " + node.getId());
    		}
    		
    		builder = new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns
    				.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutputBuilder();
    		builder.setNodeQos(nodeQosList);

    		output = builder.build();

    		rpcBuilder = RpcResultBuilder.success(output);

    	} catch (InterruptedException e) {
    		logger.error("InterruptedException in getAllNodeConnectorsStatistics : "+e.getMessage());
    	} catch (Exception e) {
    		logger.error("Exception in getAllNodeConnectorsStatistics : "+e.getMessage());
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
}
