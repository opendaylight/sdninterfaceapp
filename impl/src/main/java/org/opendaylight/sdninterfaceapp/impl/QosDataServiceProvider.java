/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;

import java.util.Collection;
import java.util.Collections;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.sdninterfaceapp.impl.OpendaylightSdniQosMsgServiceImpl;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.OpendaylightSdniQosMsgService;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QosDataServiceProvider implements BindingAwareProvider, AutoCloseable {

    private final Logger logger = LoggerFactory.getLogger(QosDataServiceProvider.class);
    private RpcRegistration<OpendaylightSdniQosMsgService> qosDataServiceRpcReg;
    private final DataBroker dataBroker;

    public QosDataServiceProvider(final DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    @Override
    public void onSessionInitiated(ProviderContext session) {
        logger.info("Provider Session initialized");
        final OpendaylightSdniQosMsgServiceImpl opendaylightSdniQosMsgService = OpendaylightSdniQosMsgServiceImpl.getInstance();
        opendaylightSdniQosMsgService.setDataBroker(dataBroker);
        qosDataServiceRpcReg = session.addRpcImplementation(OpendaylightSdniQosMsgService.class, opendaylightSdniQosMsgService);
        SdniDataBase sdb = new SdniDataBase();
        sdb.create_trusted_controllers();
    }
    
    @Override
    public void close() throws Exception {
        logger.info("QosDataService Closed");
        if (qosDataServiceRpcReg != null) {
            qosDataServiceRpcReg.close();
        }
    }
}

