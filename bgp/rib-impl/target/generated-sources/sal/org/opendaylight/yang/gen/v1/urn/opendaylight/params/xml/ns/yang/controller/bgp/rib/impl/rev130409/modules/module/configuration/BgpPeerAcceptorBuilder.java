package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import java.math.BigInteger;
import com.google.common.collect.ImmutableList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.acceptor.AcceptingBgpDispatcher;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.acceptor.AcceptingPeerRegistry;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor
 */
public class BgpPeerAcceptorBuilder {

    private AcceptingBgpDispatcher _acceptingBgpDispatcher;
    private AcceptingPeerRegistry _acceptingPeerRegistry;
    private IpAddress _bindingAddress;
    private PortNumber _bindingPort;
    private static List<Range<BigInteger>> _bindingPort_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> augmentation = new HashMap<>();

    public BgpPeerAcceptorBuilder() {
    } 
    

    public BgpPeerAcceptorBuilder(BgpPeerAcceptor base) {
        this._acceptingBgpDispatcher = base.getAcceptingBgpDispatcher();
        this._acceptingPeerRegistry = base.getAcceptingPeerRegistry();
        this._bindingAddress = base.getBindingAddress();
        this._bindingPort = base.getBindingPort();
        if (base instanceof BgpPeerAcceptorImpl) {
            BgpPeerAcceptorImpl _impl = (BgpPeerAcceptorImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public AcceptingBgpDispatcher getAcceptingBgpDispatcher() {
        return _acceptingBgpDispatcher;
    }
    
    public AcceptingPeerRegistry getAcceptingPeerRegistry() {
        return _acceptingPeerRegistry;
    }
    
    public IpAddress getBindingAddress() {
        return _bindingAddress;
    }
    
    public PortNumber getBindingPort() {
        return _bindingPort;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpPeerAcceptorBuilder setAcceptingBgpDispatcher(AcceptingBgpDispatcher value) {
        this._acceptingBgpDispatcher = value;
        return this;
    }
    
    public BgpPeerAcceptorBuilder setAcceptingPeerRegistry(AcceptingPeerRegistry value) {
        this._acceptingPeerRegistry = value;
        return this;
    }
    
    public BgpPeerAcceptorBuilder setBindingAddress(IpAddress value) {
        this._bindingAddress = value;
        return this;
    }
    
    public BgpPeerAcceptorBuilder setBindingPort(PortNumber value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _bindingPort_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _bindingPort_range));
            }
        }
        this._bindingPort = value;
        return this;
    }
    public static List<Range<BigInteger>> _bindingPort_range() {
        if (_bindingPort_range == null) {
            synchronized (BgpPeerAcceptorBuilder.class) {
                if (_bindingPort_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _bindingPort_range = builder.build();
                }
            }
        }
        return _bindingPort_range;
    }
    
    public BgpPeerAcceptorBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpPeerAcceptor build() {
        return new BgpPeerAcceptorImpl(this);
    }

    private static final class BgpPeerAcceptorImpl implements BgpPeerAcceptor {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor.class;
        }

        private final AcceptingBgpDispatcher _acceptingBgpDispatcher;
        private final AcceptingPeerRegistry _acceptingPeerRegistry;
        private final IpAddress _bindingAddress;
        private final PortNumber _bindingPort;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> augmentation = new HashMap<>();

        private BgpPeerAcceptorImpl(BgpPeerAcceptorBuilder base) {
            this._acceptingBgpDispatcher = base.getAcceptingBgpDispatcher();
            this._acceptingPeerRegistry = base.getAcceptingPeerRegistry();
            this._bindingAddress = base.getBindingAddress();
            this._bindingPort = base.getBindingPort();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public AcceptingBgpDispatcher getAcceptingBgpDispatcher() {
            return _acceptingBgpDispatcher;
        }
        
        @Override
        public AcceptingPeerRegistry getAcceptingPeerRegistry() {
            return _acceptingPeerRegistry;
        }
        
        @Override
        public IpAddress getBindingAddress() {
            return _bindingAddress;
        }
        
        @Override
        public PortNumber getBindingPort() {
            return _bindingPort;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_acceptingBgpDispatcher == null) ? 0 : _acceptingBgpDispatcher.hashCode());
            result = prime * result + ((_acceptingPeerRegistry == null) ? 0 : _acceptingPeerRegistry.hashCode());
            result = prime * result + ((_bindingAddress == null) ? 0 : _bindingAddress.hashCode());
            result = prime * result + ((_bindingPort == null) ? 0 : _bindingPort.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor)obj;
            if (_acceptingBgpDispatcher == null) {
                if (other.getAcceptingBgpDispatcher() != null) {
                    return false;
                }
            } else if(!_acceptingBgpDispatcher.equals(other.getAcceptingBgpDispatcher())) {
                return false;
            }
            if (_acceptingPeerRegistry == null) {
                if (other.getAcceptingPeerRegistry() != null) {
                    return false;
                }
            } else if(!_acceptingPeerRegistry.equals(other.getAcceptingPeerRegistry())) {
                return false;
            }
            if (_bindingAddress == null) {
                if (other.getBindingAddress() != null) {
                    return false;
                }
            } else if(!_bindingAddress.equals(other.getBindingAddress())) {
                return false;
            }
            if (_bindingPort == null) {
                if (other.getBindingPort() != null) {
                    return false;
                }
            } else if(!_bindingPort.equals(other.getBindingPort())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpPeerAcceptorImpl otherImpl = (BgpPeerAcceptorImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpPeerAcceptor [");
            boolean first = true;
        
            if (_acceptingBgpDispatcher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_acceptingBgpDispatcher=");
                builder.append(_acceptingBgpDispatcher);
             }
            if (_acceptingPeerRegistry != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_acceptingPeerRegistry=");
                builder.append(_acceptingPeerRegistry);
             }
            if (_bindingAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bindingAddress=");
                builder.append(_bindingAddress);
             }
            if (_bindingPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bindingPort=");
                builder.append(_bindingPort);
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
