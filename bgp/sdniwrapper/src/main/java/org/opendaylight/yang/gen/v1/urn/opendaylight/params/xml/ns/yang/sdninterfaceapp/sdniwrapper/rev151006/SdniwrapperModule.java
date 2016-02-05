package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151006;

import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.protocol.bgp.sdniwrapper.SdniWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniwrapperModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151006.AbstractSdniwrapperModule {


    private RpcProviderRegistry rpcRegistryDependency;
    private static final Logger LOG = LoggerFactory.getLogger(SdniwrapperModule.class);

    public SdniwrapperModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public SdniwrapperModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.rev151006.SdniwrapperModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        // TODO:implement

        LOG.info("In SdniwrapperModule : createInstance : START");
        rpcRegistryDependency = getRpcRegistryDependency();
        SdniWrapper.setRPCRegistry(rpcRegistryDependency);
        LOG.info("In SdniwrapperModule : createInstance : END");
        return new AutoCloseable() {

            @Override
            public void close() throws Exception {
                // TODO Auto-generated method stub

            }
        };
    }
}
