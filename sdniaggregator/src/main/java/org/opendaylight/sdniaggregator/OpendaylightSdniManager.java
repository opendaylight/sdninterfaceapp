/**
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdniaggregator;

import com.google.common.base.Optional;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.opendaylight.openflowplugin.api.openflow.device.DeviceContext;
import org.opendaylight.openflowplugin.api.openflow.device.RequestContextStack;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetAllNodeConnectorsStatisticsInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetAllNodeConnectorsStatisticsOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetNodeConnectorStatisticsInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetNodeConnectorStatisticsOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.OpendaylightPortStatisticsService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetNodeConnectorStatisticsInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.GetAllNodeConnectorsStatisticsInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeContextRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;

import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.openflowplugin.openflow.md.core.session.OFSessionUtil;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

import org.opendaylight.yangtools.yang.common.RpcResult;

public class OpendaylightSdniManager {
    private final AllPortStatsService allPortStats;
    private static final InstanceIdentifier<NodeContextRef> NODES_IDENTIFIER = InstanceIdentifier.create(NodeContextRef.class);

    public OpendaylightSdniManager(final RequestContextStack requestContextStack, final DeviceContext deviceContext) {
        allPortStats = new AllPortStatsService(requestContextStack, deviceContext);
    }

    public List<NodeConnectorStatisticsAndPortNumberMap> getNodeConnectorStatistics() throws Exception {
    	
  
    	//creating node class 
    	NodeContextRef nodes = getDataObject(OFSessionUtil.getSessionManager().getDataBroker().newReadOnlyTransaction(), NODES_IDENTIFIER);
    	NodeRef nodeRef = nodes.getNode();
    	List<NodeConnectorStatisticsAndPortNumberMap> listNodeConnectorStatisticsAndPortNumberMap= new ArrayList<NodeConnectorStatisticsAndPortNumberMap>();
        GetAllNodeConnectorsStatisticsInputBuilder input = new GetAllNodeConnectorsStatisticsInputBuilder().setNode(nodeRef);
        Future<RpcResult<GetAllNodeConnectorsStatisticsOutput>> resultFuture = getAllNodeConnectorsStatistics(input.build());
    	RpcResult<GetAllNodeConnectorsStatisticsOutput> rpcResult = resultFuture.get();
    	GetAllNodeConnectorsStatisticsOutput resultNCSO = rpcResult.getResult(); 
    	listNodeConnectorStatisticsAndPortNumberMap = resultNCSO.getNodeConnectorStatisticsAndPortNumberMap();
    		
    	return listNodeConnectorStatisticsAndPortNumberMap;
    }

   
    public Future<RpcResult<GetAllNodeConnectorsStatisticsOutput>> getAllNodeConnectorsStatistics(
            final GetAllNodeConnectorsStatisticsInput input) {
        return allPortStats.handleServiceCall(input);
    }    
   
    private static <T extends DataObject> T getDataObject(final ReadTransaction readOnlyTransaction, final InstanceIdentifier<T> identifier) {
        Optional<T> optionalData = null;
        try {
            optionalData = readOnlyTransaction.read(LogicalDatastoreType.OPERATIONAL, identifier).get();
            if (optionalData.isPresent()) {
                return optionalData.get();
            }
        } catch (ExecutionException | InterruptedException e) {
        }
        return null;
    }
}
