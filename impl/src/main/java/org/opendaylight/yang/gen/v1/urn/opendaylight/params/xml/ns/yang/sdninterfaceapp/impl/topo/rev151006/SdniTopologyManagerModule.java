package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.topo.rev151006;

import org.opendaylight.sdninterfaceapp.impl.SdniTopologyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniTopologyManagerModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.topo.rev151006.AbstractSdniTopologyManagerModule {

    private final Logger logger = LoggerFactory.getLogger(SdniTopologyManagerModule.class);

    public SdniTopologyManagerModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public SdniTopologyManagerModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.topo.rev151006.SdniTopologyManagerModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        logger.info("sdniTopologyModule :  Start");
	SdniTopologyProvider provider = new SdniTopologyProvider();
        getBrokerDependency().registerProvider(provider);
	return provider;
    }

}
