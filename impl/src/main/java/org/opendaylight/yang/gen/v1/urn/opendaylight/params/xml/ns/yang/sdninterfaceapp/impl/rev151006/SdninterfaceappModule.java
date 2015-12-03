package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.rev151006;

import org.opendaylight.sdninterfaceapp.impl.QosDataServiceProvider;


public class SdninterfaceappModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.rev151006.AbstractSdninterfaceappModule {
    public SdninterfaceappModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public SdninterfaceappModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.impl.rev151006.SdninterfaceappModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        QosDataServiceProvider provider = new QosDataServiceProvider();
        getBrokerDependency().registerProvider(provider);
        provider.setRpcRegistry(getRpcRegistryDependency());
        return provider;
    }

}
