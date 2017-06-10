/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;

import java.util.Collection;
import java.util.List;
import java.util.Collections;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.data.DataProviderService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.OpendaylightSdniTopologyMsgService;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SdniTopologyProvider implements BindingAwareProvider, AutoCloseable {

    private final static Logger LOG = LoggerFactory.getLogger(SdniTopologyProvider.class);
    private DataBroker dataBroker = null;
    private RpcRegistration<OpendaylightSdniTopologyMsgService> sdniTopologyServiceRpc; 

    @Override
    public void onSessionInitiated(ProviderContext session) {
    	LOG.info("SdniTopology Plugin Started");
        SdniTopologyMsgServiceImpl sdniTopologyMsgServiceImpl = SdniTopologyMsgServiceImpl.getInstance();
        sdniTopologyServiceRpc = session.addRpcImplementation(OpendaylightSdniTopologyMsgService.class,  sdniTopologyMsgServiceImpl);
        dataBroker = session.getSALService(DataBroker.class);   
        sdniTopologyMsgServiceImpl.setBroker(dataBroker);
    }

    @Override
    public void close() throws Exception {
        LOG.info("SdniTopologyProvider Closed");
        if (sdniTopologyServiceRpc != null) {
            sdniTopologyServiceRpc.close();
        }
    }
}
