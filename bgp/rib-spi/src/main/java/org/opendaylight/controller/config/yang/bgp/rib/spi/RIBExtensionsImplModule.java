/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
/**
 * Generated file

 * Generated from: yang module name: config-bgp-rib-spi  yang module local name: bgp-rib-extensions-impl
 * Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
 * Generated at: Wed Nov 27 12:38:57 CET 2013
 *
 * Do not modify this file unless it is present under src/main directory
 */
package org.opendaylight.controller.config.yang.bgp.rib.spi;

import org.opendaylight.protocol.bgp.rib.spi.RIBExtensionProviderActivator;
import org.opendaylight.protocol.bgp.rib.spi.SimpleRIBExtensionProviderContext;

/**
 *
 */
public final class RIBExtensionsImplModule extends org.opendaylight.controller.config.yang.bgp.rib.spi.AbstractRIBExtensionsImplModule {

    public RIBExtensionsImplModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public RIBExtensionsImplModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, final RIBExtensionsImplModule oldModule,
            final java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    protected void customValidation() {
        // Add custom validation for module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        final class RIBExtensionProviderContextImplCloseable extends SimpleRIBExtensionProviderContext implements AutoCloseable {
            @Override
            public void close() {
                for (final RIBExtensionProviderActivator e : getExtensionDependency()) {
                    e.stopRIBExtensionProvider();
                }
            }
        }

        final RIBExtensionProviderContextImplCloseable ret = new RIBExtensionProviderContextImplCloseable();
        for (final RIBExtensionProviderActivator e : getExtensionDependency()) {
            e.startRIBExtensionProvider(ret);
        }

        return ret;
    }
}
