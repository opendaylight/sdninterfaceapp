/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl.sdniwrapper;

import java.util.Timer;

import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.OpendaylightSdniWrapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniwrapperServiceProvider implements BindingAwareProvider, AutoCloseable {

    private final Logger logger = LoggerFactory.getLogger(SdniwrapperServiceProvider.class);
    private RpcRegistration<OpendaylightSdniWrapperService> wrapperService;
    private NotificationProviderService notificationProvider;

    public SdniwrapperServiceProvider(final NotificationProviderService notificationProvider) {
        this.notificationProvider = notificationProvider;
    }

    @Override
    public void onSessionInitiated(ProviderContext session) {
        logger.info("Provider Session initialized");
        final SdniMsgSynchronizer wrapperImpl = SdniMsgSynchronizer.getInstance();
        wrapperService = session.addRpcImplementation(OpendaylightSdniWrapperService.class, wrapperImpl);
        
        
		SdniMsgSynchronizer.getInstance().setNotificationService(notificationProvider);
		Timer serverTimer=new Timer();
		serverTimer.schedule(SDNiServerListener.getInstance(), 0,1000*60);
		
		Timer clientTimer=new Timer();
		clientTimer.schedule(SDNiClientCommunicator.getInstance(), 1000*20,1000*60);
    }

    @Override
    public void close() throws Exception {
        logger.info("QosDataService Closed");
        if (wrapperService != null) {
        	wrapperService.close();
        }
    }
}

