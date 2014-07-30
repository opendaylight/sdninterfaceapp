package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.Rib;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.tcpmd5.cfg.rev140427.Rfc2385Key;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.AdvertizedTable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-rib-impl
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)modules/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)bgp-peer]
 */
public class BgpPeerBuilder {

    private IpAddress _host;
    private PortNumber _port;
    private static List<Range<BigInteger>> _port_range;
    private java.lang.Short _holdtimer;
    private List<AdvertizedTable> _advertizedTable;
    private java.lang.Long _remoteAs;
    private static List<Range<BigInteger>> _remoteAs_range;
    private Rfc2385Key _password;
    private static List<Range<BigInteger>> _password_length;
    private Rib _rib;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> augmentation = new HashMap<>();

    public BgpPeerBuilder() {
    } 
    

    public BgpPeerBuilder(BgpPeer base) {
        this._host = base.getHost();
        this._port = base.getPort();
        this._holdtimer = base.getHoldtimer();
        this._advertizedTable = base.getAdvertizedTable();
        this._remoteAs = base.getRemoteAs();
        this._password = base.getPassword();
        this._rib = base.getRib();
        if (base instanceof BgpPeerImpl) {
            BgpPeerImpl _impl = (BgpPeerImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public IpAddress getHost() {
        return _host;
    }
    
    public PortNumber getPort() {
        return _port;
    }
    
    public java.lang.Short getHoldtimer() {
        return _holdtimer;
    }
    
    public List<AdvertizedTable> getAdvertizedTable() {
        return _advertizedTable;
    }
    
    public java.lang.Long getRemoteAs() {
        return _remoteAs;
    }
    
    public Rfc2385Key getPassword() {
        return _password;
    }
    
    public Rib getRib() {
        return _rib;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpPeerBuilder setHost(IpAddress value) {
        this._host = value;
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
    
    public BgpPeerBuilder setHoldtimer(java.lang.Short value) {
        this._holdtimer = value;
        return this;
    }
    
    public BgpPeerBuilder setAdvertizedTable(List<AdvertizedTable> value) {
        this._advertizedTable = value;
        return this;
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
    
    public BgpPeerBuilder setRib(Rib value) {
        this._rib = value;
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

        private final IpAddress _host;
        private final PortNumber _port;
        private final java.lang.Short _holdtimer;
        private final List<AdvertizedTable> _advertizedTable;
        private final java.lang.Long _remoteAs;
        private final Rfc2385Key _password;
        private final Rib _rib;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>> augmentation = new HashMap<>();

        private BgpPeerImpl(BgpPeerBuilder base) {
            this._host = base.getHost();
            this._port = base.getPort();
            this._holdtimer = base.getHoldtimer();
            this._advertizedTable = base.getAdvertizedTable();
            this._remoteAs = base.getRemoteAs();
            this._password = base.getPassword();
            this._rib = base.getRib();
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
        public IpAddress getHost() {
            return _host;
        }
        
        @Override
        public PortNumber getPort() {
            return _port;
        }
        
        @Override
        public java.lang.Short getHoldtimer() {
            return _holdtimer;
        }
        
        @Override
        public List<AdvertizedTable> getAdvertizedTable() {
            return _advertizedTable;
        }
        
        @Override
        public java.lang.Long getRemoteAs() {
            return _remoteAs;
        }
        
        @Override
        public Rfc2385Key getPassword() {
            return _password;
        }
        
        @Override
        public Rib getRib() {
            return _rib;
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
            result = prime * result + ((_host == null) ? 0 : _host.hashCode());
            result = prime * result + ((_port == null) ? 0 : _port.hashCode());
            result = prime * result + ((_holdtimer == null) ? 0 : _holdtimer.hashCode());
            result = prime * result + ((_advertizedTable == null) ? 0 : _advertizedTable.hashCode());
            result = prime * result + ((_remoteAs == null) ? 0 : _remoteAs.hashCode());
            result = prime * result + ((_password == null) ? 0 : _password.hashCode());
            result = prime * result + ((_rib == null) ? 0 : _rib.hashCode());
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
            BgpPeerImpl other = (BgpPeerImpl) obj;
            if (_host == null) {
                if (other._host != null) {
                    return false;
                }
            } else if(!_host.equals(other._host)) {
                return false;
            }
            if (_port == null) {
                if (other._port != null) {
                    return false;
                }
            } else if(!_port.equals(other._port)) {
                return false;
            }
            if (_holdtimer == null) {
                if (other._holdtimer != null) {
                    return false;
                }
            } else if(!_holdtimer.equals(other._holdtimer)) {
                return false;
            }
            if (_advertizedTable == null) {
                if (other._advertizedTable != null) {
                    return false;
                }
            } else if(!_advertizedTable.equals(other._advertizedTable)) {
                return false;
            }
            if (_remoteAs == null) {
                if (other._remoteAs != null) {
                    return false;
                }
            } else if(!_remoteAs.equals(other._remoteAs)) {
                return false;
            }
            if (_password == null) {
                if (other._password != null) {
                    return false;
                }
            } else if(!_password.equals(other._password)) {
                return false;
            }
            if (_rib == null) {
                if (other._rib != null) {
                    return false;
                }
            } else if(!_rib.equals(other._rib)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpPeer [");
            boolean first = true;
        
            if (_host != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_host=");
                builder.append(_host);
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
            if (_holdtimer != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdtimer=");
                builder.append(_holdtimer);
             }
            if (_advertizedTable != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_advertizedTable=");
                builder.append(_advertizedTable);
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
            if (_password != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_password=");
                builder.append(_password);
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
