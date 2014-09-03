package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import com.google.common.collect.Range;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.tcpmd5.cfg.rev140427.Rfc2385Key;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.AdvertizedTable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.Rib;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.PeerRegistry;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer
 */
public class BgpPeerBuilder {

    private List<AdvertizedTable> _advertizedTable;
    private java.lang.Short _holdtimer;
    private IpAddress _host;
    private Rfc2385Key _password;
    private static List<Range<BigInteger>> _password_length;
    private PeerRegistry _peerRegistry;
    private PortNumber _port;
    private static List<Range<BigInteger>> _port_range;
    private java.lang.Long _remoteAs;
    private static List<Range<BigInteger>> _remoteAs_range;
    private Rib _rib;
    private java.lang.Boolean _initiateConnection;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> augmentation = new HashMap<>();

    public BgpPeerBuilder() {
    } 
    

    public BgpPeerBuilder(BgpPeer base) {
        this._advertizedTable = base.getAdvertizedTable();
        this._holdtimer = base.getHoldtimer();
        this._host = base.getHost();
        this._password = base.getPassword();
        this._peerRegistry = base.getPeerRegistry();
        this._port = base.getPort();
        this._remoteAs = base.getRemoteAs();
        this._rib = base.getRib();
        this._initiateConnection = base.isInitiateConnection();
        if (base instanceof BgpPeerImpl) {
            BgpPeerImpl _impl = (BgpPeerImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public List<AdvertizedTable> getAdvertizedTable() {
        return _advertizedTable;
    }
    
    public java.lang.Short getHoldtimer() {
        return _holdtimer;
    }
    
    public IpAddress getHost() {
        return _host;
    }
    
    public Rfc2385Key getPassword() {
        return _password;
    }
    
    public PeerRegistry getPeerRegistry() {
        return _peerRegistry;
    }
    
    public PortNumber getPort() {
        return _port;
    }
    
    public java.lang.Long getRemoteAs() {
        return _remoteAs;
    }
    
    public Rib getRib() {
        return _rib;
    }
    
    public java.lang.Boolean isInitiateConnection() {
        return _initiateConnection;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpPeerBuilder setAdvertizedTable(List<AdvertizedTable> value) {
        this._advertizedTable = value;
        return this;
    }
    
    public BgpPeerBuilder setHoldtimer(java.lang.Short value) {
        this._holdtimer = value;
        return this;
    }
    
    public BgpPeerBuilder setHost(IpAddress value) {
        this._host = value;
        return this;
    }
    
    public BgpPeerBuilder setPassword(Rfc2385Key value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue().length());
            boolean isValidLength = false;
            for (Range<BigInteger> r : _password_length()) {
                if (r.contains(_constraint)) {
                    isValidLength = true;
                }
            }
            if (!isValidLength) {
                throw new IllegalArgumentException(String.format("Invalid length: %s, expected: %s.", value, _password_length));
            }
        }
        this._password = value;
        return this;
    }
    public static List<Range<BigInteger>> _password_length() {
        if (_password_length == null) {
            synchronized (BgpPeerBuilder.class) {
                if (_password_length == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ONE, BigInteger.valueOf(80L)));
                    _password_length = builder.build();
                }
            }
        }
        return _password_length;
    }
    
    public BgpPeerBuilder setPeerRegistry(PeerRegistry value) {
        this._peerRegistry = value;
        return this;
    }
    
    public BgpPeerBuilder setPort(PortNumber value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _port_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _port_range));
            }
        }
        this._port = value;
        return this;
    }
    public static List<Range<BigInteger>> _port_range() {
        if (_port_range == null) {
            synchronized (BgpPeerBuilder.class) {
                if (_port_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _port_range = builder.build();
                }
            }
        }
        return _port_range;
    }
    
    public BgpPeerBuilder setRemoteAs(java.lang.Long value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _remoteAs_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _remoteAs_range));
            }
        }
        this._remoteAs = value;
        return this;
    }
    public static List<Range<BigInteger>> _remoteAs_range() {
        if (_remoteAs_range == null) {
            synchronized (BgpPeerBuilder.class) {
                if (_remoteAs_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _remoteAs_range = builder.build();
                }
            }
        }
        return _remoteAs_range;
    }
    
    public BgpPeerBuilder setRib(Rib value) {
        this._rib = value;
        return this;
    }
    
    public BgpPeerBuilder setInitiateConnection(java.lang.Boolean value) {
        this._initiateConnection = value;
        return this;
    }
    
    public BgpPeerBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpPeer build() {
        return new BgpPeerImpl(this);
    }

    private static final class BgpPeerImpl implements BgpPeer {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer.class;
        }

        private final List<AdvertizedTable> _advertizedTable;
        private final java.lang.Short _holdtimer;
        private final IpAddress _host;
        private final Rfc2385Key _password;
        private final PeerRegistry _peerRegistry;
        private final PortNumber _port;
        private final java.lang.Long _remoteAs;
        private final Rib _rib;
        private final java.lang.Boolean _initiateConnection;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> augmentation = new HashMap<>();

        private BgpPeerImpl(BgpPeerBuilder base) {
            this._advertizedTable = base.getAdvertizedTable();
            this._holdtimer = base.getHoldtimer();
            this._host = base.getHost();
            this._password = base.getPassword();
            this._peerRegistry = base.getPeerRegistry();
            this._port = base.getPort();
            this._remoteAs = base.getRemoteAs();
            this._rib = base.getRib();
            this._initiateConnection = base.isInitiateConnection();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public List<AdvertizedTable> getAdvertizedTable() {
            return _advertizedTable;
        }
        
        @Override
        public java.lang.Short getHoldtimer() {
            return _holdtimer;
        }
        
        @Override
        public IpAddress getHost() {
            return _host;
        }
        
        @Override
        public Rfc2385Key getPassword() {
            return _password;
        }
        
        @Override
        public PeerRegistry getPeerRegistry() {
            return _peerRegistry;
        }
        
        @Override
        public PortNumber getPort() {
            return _port;
        }
        
        @Override
        public java.lang.Long getRemoteAs() {
            return _remoteAs;
        }
        
        @Override
        public Rib getRib() {
            return _rib;
        }
        
        @Override
        public java.lang.Boolean isInitiateConnection() {
            return _initiateConnection;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_advertizedTable == null) ? 0 : _advertizedTable.hashCode());
            result = prime * result + ((_holdtimer == null) ? 0 : _holdtimer.hashCode());
            result = prime * result + ((_host == null) ? 0 : _host.hashCode());
            result = prime * result + ((_password == null) ? 0 : _password.hashCode());
            result = prime * result + ((_peerRegistry == null) ? 0 : _peerRegistry.hashCode());
            result = prime * result + ((_port == null) ? 0 : _port.hashCode());
            result = prime * result + ((_remoteAs == null) ? 0 : _remoteAs.hashCode());
            result = prime * result + ((_rib == null) ? 0 : _rib.hashCode());
            result = prime * result + ((_initiateConnection == null) ? 0 : _initiateConnection.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer)obj;
            if (_advertizedTable == null) {
                if (other.getAdvertizedTable() != null) {
                    return false;
                }
            } else if(!_advertizedTable.equals(other.getAdvertizedTable())) {
                return false;
            }
            if (_holdtimer == null) {
                if (other.getHoldtimer() != null) {
                    return false;
                }
            } else if(!_holdtimer.equals(other.getHoldtimer())) {
                return false;
            }
            if (_host == null) {
                if (other.getHost() != null) {
                    return false;
                }
            } else if(!_host.equals(other.getHost())) {
                return false;
            }
            if (_password == null) {
                if (other.getPassword() != null) {
                    return false;
                }
            } else if(!_password.equals(other.getPassword())) {
                return false;
            }
            if (_peerRegistry == null) {
                if (other.getPeerRegistry() != null) {
                    return false;
                }
            } else if(!_peerRegistry.equals(other.getPeerRegistry())) {
                return false;
            }
            if (_port == null) {
                if (other.getPort() != null) {
                    return false;
                }
            } else if(!_port.equals(other.getPort())) {
                return false;
            }
            if (_remoteAs == null) {
                if (other.getRemoteAs() != null) {
                    return false;
                }
            } else if(!_remoteAs.equals(other.getRemoteAs())) {
                return false;
            }
            if (_rib == null) {
                if (other.getRib() != null) {
                    return false;
                }
            } else if(!_rib.equals(other.getRib())) {
                return false;
            }
            if (_initiateConnection == null) {
                if (other.isInitiateConnection() != null) {
                    return false;
                }
            } else if(!_initiateConnection.equals(other.isInitiateConnection())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpPeerImpl otherImpl = (BgpPeerImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpPeer [");
            boolean first = true;
        
            if (_advertizedTable != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_advertizedTable=");
                builder.append(_advertizedTable);
             }
            if (_holdtimer != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdtimer=");
                builder.append(_holdtimer);
             }
            if (_host != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_host=");
                builder.append(_host);
             }
            if (_password != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_password=");
                builder.append(_password);
             }
            if (_peerRegistry != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_peerRegistry=");
                builder.append(_peerRegistry);
             }
            if (_port != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_port=");
                builder.append(_port);
             }
            if (_remoteAs != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_remoteAs=");
                builder.append(_remoteAs);
             }
            if (_rib != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_rib=");
                builder.append(_rib);
             }
            if (_initiateConnection != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_initiateConnection=");
                builder.append(_initiateConnection);
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
