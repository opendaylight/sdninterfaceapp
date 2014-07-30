package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.reachability.ipv6.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.reachability.ipv6.LocalRib;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;


/**
 * Module name:
 *     config-bgp-topology-provider
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)modules/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)bgp-reachability-ipv6]
 */
public class BgpReachabilityIpv6Builder {

    private DataProvider _dataProvider;
    private LocalRib _localRib;
    private TopologyId _topologyId;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> augmentation = new HashMap<>();

    public BgpReachabilityIpv6Builder() {
    } 
    

    public BgpReachabilityIpv6Builder(BgpReachabilityIpv6 base) {
        this._dataProvider = base.getDataProvider();
        this._localRib = base.getLocalRib();
        this._topologyId = base.getTopologyId();
        if (base instanceof BgpReachabilityIpv6Impl) {
            BgpReachabilityIpv6Impl _impl = (BgpReachabilityIpv6Impl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public DataProvider getDataProvider() {
        return _dataProvider;
    }
    
    public LocalRib getLocalRib() {
        return _localRib;
    }
    
    public TopologyId getTopologyId() {
        return _topologyId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpReachabilityIpv6Builder setDataProvider(DataProvider value) {
        this._dataProvider = value;
        return this;
    }
    
    public BgpReachabilityIpv6Builder setLocalRib(LocalRib value) {
        this._localRib = value;
        return this;
    }
    
    public BgpReachabilityIpv6Builder setTopologyId(TopologyId value) {
        this._topologyId = value;
        return this;
    }
    
    public BgpReachabilityIpv6Builder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpReachabilityIpv6 build() {
        return new BgpReachabilityIpv6Impl(this);
    }

    private static final class BgpReachabilityIpv6Impl implements BgpReachabilityIpv6 {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6.class;
        }

        private final DataProvider _dataProvider;
        private final LocalRib _localRib;
        private final TopologyId _topologyId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> augmentation = new HashMap<>();

        private BgpReachabilityIpv6Impl(BgpReachabilityIpv6Builder base) {
            this._dataProvider = base.getDataProvider();
            this._localRib = base.getLocalRib();
            this._topologyId = base.getTopologyId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public DataProvider getDataProvider() {
            return _dataProvider;
        }
        
        @Override
        public LocalRib getLocalRib() {
            return _localRib;
        }
        
        @Override
        public TopologyId getTopologyId() {
            return _topologyId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpReachabilityIpv6>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_dataProvider == null) ? 0 : _dataProvider.hashCode());
            result = prime * result + ((_localRib == null) ? 0 : _localRib.hashCode());
            result = prime * result + ((_topologyId == null) ? 0 : _topologyId.hashCode());
            result = prime * result + ((augmentation == null) ? 0 : augmentation.hashCode());
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            BgpReachabilityIpv6Impl other = (BgpReachabilityIpv6Impl) obj;
            if (_dataProvider == null) {
                if (other._dataProvider != null) {
                    return false;
                }
            } else if(!_dataProvider.equals(other._dataProvider)) {
                return false;
            }
            if (_localRib == null) {
                if (other._localRib != null) {
                    return false;
                }
            } else if(!_localRib.equals(other._localRib)) {
                return false;
            }
            if (_topologyId == null) {
                if (other._topologyId != null) {
                    return false;
                }
            } else if(!_topologyId.equals(other._topologyId)) {
                return false;
            }
            if (augmentation == null) {
                if (other.augmentation != null) {
                    return false;
                }
            } else if(!augmentation.equals(other.augmentation)) {
                return false;
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpReachabilityIpv6 [");
            boolean first = true;
        
            if (_dataProvider != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dataProvider=");
                builder.append(_dataProvider);
             }
            if (_localRib != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localRib=");
                builder.append(_localRib);
             }
            if (_topologyId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_topologyId=");
                builder.append(_topologyId);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
