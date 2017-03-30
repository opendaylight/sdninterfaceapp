/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151007;

import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.sdninterfaceapp.impl.QosDataServiceProvider;
import org.opendaylight.sdninterfaceapp.impl.sdniwrapper.SDNiClientCommunicator;
import org.opendaylight.sdninterfaceapp.impl.sdniwrapper.SDNiServerListener;
import org.opendaylight.sdninterfaceapp.impl.sdniwrapper.SdniMsgSynchronizer;
import org.opendaylight.sdninterfaceapp.impl.sdniwrapper.SdniwrapperServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.opendaylight.controller.sal.binding.api.NotificationProviderService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniwrapperModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151007.AbstractSdniwrapperModule {

	private RpcProviderRegistry rpcRegistryDependency;
	private NotificationProviderService notificationProvider;
	private static final Logger LOG = LoggerFactory.getLogger(SdniwrapperModule.class);

	public SdniwrapperModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
		super(identifier, dependencyResolver);
	}

	public SdniwrapperModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151007.SdniwrapperModule oldModule, java.lang.AutoCloseable oldInstance) {
		super(identifier, dependencyResolver, oldModule, oldInstance);
	}

	@Override
	public void customValidation() {
		// add custom validation form module attributes here.
	}

	@Override
	public java.lang.AutoCloseable createInstance() {
		LOG.info("In SdniwrapperModule : createInstance : START");
		notificationProvider = getNotificationServiceDependency();

		SdniwrapperServiceProvider provider = new SdniwrapperServiceProvider(notificationProvider);
		getBrokerDependency().registerProvider(provider);
		LOG.info("In SdniwrapperModule : createInstance : END");
		return provider;
	}

}
