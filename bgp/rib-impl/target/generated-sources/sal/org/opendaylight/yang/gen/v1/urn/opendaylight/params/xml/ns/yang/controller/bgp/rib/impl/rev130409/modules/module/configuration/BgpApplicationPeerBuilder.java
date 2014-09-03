package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.ApplicationRibId;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.application.peer.DataBroker;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.application.peer.TargetRib;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer
 */
public class BgpApplicationPeerBuilder {

    private ApplicationRibId _applicationRibId;
    private Ipv4Address _bgpId;
    private DataBroker _dataBroker;
    private TargetRib _targetRib;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> augmentation = new HashMap<>();

    public BgpApplicationPeerBuilder() {
    } 
    

    public BgpApplicationPeerBuilder(BgpApplicationPeer base) {
        this._applicationRibId = base.getApplicationRibId();
        this._bgpId = base.getBgpId();
        this._dataBroker = base.getDataBroker();
        this._targetRib = base.getTargetRib();
        if (base instanceof BgpApplicationPeerImpl) {
            BgpApplicationPeerImpl _impl = (BgpApplicationPeerImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public ApplicationRibId getApplicationRibId() {
        return _applicationRibId;
    }
    
    public Ipv4Address getBgpId() {
        return _bgpId;
    }
    
    public DataBroker getDataBroker() {
        return _dataBroker;
    }
    
    public TargetRib getTargetRib() {
        return _targetRib;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpApplicationPeerBuilder setApplicationRibId(ApplicationRibId value) {
        this._applicationRibId = value;
        return this;
    }
    
    public BgpApplicationPeerBuilder setBgpId(Ipv4Address value) {
        this._bgpId = value;
        return this;
    }
    
    public BgpApplicationPeerBuilder setDataBroker(DataBroker value) {
        this._dataBroker = value;
        return this;
    }
    
    public BgpApplicationPeerBuilder setTargetRib(TargetRib value) {
        this._targetRib = value;
        return this;
    }
    
    public BgpApplicationPeerBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpApplicationPeer build() {
        return new BgpApplicationPeerImpl(this);
    }

    private static final class BgpApplicationPeerImpl implements BgpApplicationPeer {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer.class;
        }

        private final ApplicationRibId _applicationRibId;
        private final Ipv4Address _bgpId;
        private final DataBroker _dataBroker;
        private final TargetRib _targetRib;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> augmentation = new HashMap<>();

        private BgpApplicationPeerImpl(BgpApplicationPeerBuilder base) {
            this._applicationRibId = base.getApplicationRibId();
            this._bgpId = base.getBgpId();
            this._dataBroker = base.getDataBroker();
            this._targetRib = base.getTargetRib();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public ApplicationRibId getApplicationRibId() {
            return _applicationRibId;
        }
        
        @Override
        public Ipv4Address getBgpId() {
            return _bgpId;
        }
        
        @Override
        public DataBroker getDataBroker() {
            return _dataBroker;
        }
        
        @Override
        public TargetRib getTargetRib() {
            return _targetRib;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_applicationRibId == null) ? 0 : _applicationRibId.hashCode());
            result = prime * result + ((_bgpId == null) ? 0 : _bgpId.hashCode());
            result = prime * result + ((_dataBroker == null) ? 0 : _dataBroker.hashCode());
            result = prime * result + ((_targetRib == null) ? 0 : _targetRib.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer)obj;
            if (_applicationRibId == null) {
                if (other.getApplicationRibId() != null) {
                    return false;
                }
            } else if(!_applicationRibId.equals(other.getApplicationRibId())) {
                return false;
            }
            if (_bgpId == null) {
                if (other.getBgpId() != null) {
                    return false;
                }
            } else if(!_bgpId.equals(other.getBgpId())) {
                return false;
            }
            if (_dataBroker == null) {
                if (other.getDataBroker() != null) {
                    return false;
                }
            } else if(!_dataBroker.equals(other.getDataBroker())) {
                return false;
            }
            if (_targetRib == null) {
                if (other.getTargetRib() != null) {
                    return false;
                }
            } else if(!_targetRib.equals(other.getTargetRib())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpApplicationPeerImpl otherImpl = (BgpApplicationPeerImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpApplicationPeer>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpApplicationPeer [");
            boolean first = true;
        
            if (_applicationRibId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_applicationRibId=");
                builder.append(_applicationRibId);
             }
            if (_bgpId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpId=");
                builder.append(_bgpId);
             }
            if (_dataBroker != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dataBroker=");
                builder.append(_dataBroker);
             }
            if (_targetRib != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_targetRib=");
                builder.append(_targetRib);
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
