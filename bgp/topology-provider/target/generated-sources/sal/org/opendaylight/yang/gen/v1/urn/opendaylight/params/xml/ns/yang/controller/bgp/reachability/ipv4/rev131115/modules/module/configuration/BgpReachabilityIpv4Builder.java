package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4.LocalRib;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4
 */
public class BgpReachabilityIpv4Builder {

    private DataProvider _dataProvider;
    private LocalRib _localRib;
    private TopologyId _topologyId;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> augmentation = new HashMap<>();

    public BgpReachabilityIpv4Builder() {
    } 
    

    public BgpReachabilityIpv4Builder(BgpReachabilityIpv4 base) {
        this._dataProvider = base.getDataProvider();
        this._localRib = base.getLocalRib();
        this._topologyId = base.getTopologyId();
        if (base instanceof BgpReachabilityIpv4Impl) {
            BgpReachabilityIpv4Impl _impl = (BgpReachabilityIpv4Impl) base;
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
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpReachabilityIpv4Builder setDataProvider(DataProvider value) {
        this._dataProvider = value;
        return this;
    }
    
    public BgpReachabilityIpv4Builder setLocalRib(LocalRib value) {
        this._localRib = value;
        return this;
    }
    
    public BgpReachabilityIpv4Builder setTopologyId(TopologyId value) {
        this._topologyId = value;
        return this;
    }
    
    public BgpReachabilityIpv4Builder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpReachabilityIpv4 build() {
        return new BgpReachabilityIpv4Impl(this);
    }

    private static final class BgpReachabilityIpv4Impl implements BgpReachabilityIpv4 {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4.class;
        }

        private final DataProvider _dataProvider;
        private final LocalRib _localRib;
        private final TopologyId _topologyId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> augmentation = new HashMap<>();

        private BgpReachabilityIpv4Impl(BgpReachabilityIpv4Builder base) {
            this._dataProvider = base.getDataProvider();
            this._localRib = base.getLocalRib();
            this._topologyId = base.getTopologyId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>singletonMap(e.getKey(), e.getValue());       
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
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4 other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4)obj;
            if (_dataProvider == null) {
                if (other.getDataProvider() != null) {
                    return false;
                }
            } else if(!_dataProvider.equals(other.getDataProvider())) {
                return false;
            }
            if (_localRib == null) {
                if (other.getLocalRib() != null) {
                    return false;
                }
            } else if(!_localRib.equals(other.getLocalRib())) {
                return false;
            }
            if (_topologyId == null) {
                if (other.getTopologyId() != null) {
                    return false;
                }
            } else if(!_topologyId.equals(other.getTopologyId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpReachabilityIpv4Impl otherImpl = (BgpReachabilityIpv4Impl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.BgpReachabilityIpv4>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpReachabilityIpv4 [");
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
