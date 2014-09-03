package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.Extensions;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.RibId;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.BgpDispatcher;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.SessionReconnectStrategy;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.TcpReconnectStrategy;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.LocalTable;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl
 */
public class RibImplBuilder {

    private BgpDispatcher _bgpDispatcher;
    private Ipv4Address _bgpId;
    private DataProvider _dataProvider;
    private Extensions _extensions;
    private java.lang.Long _localAs;
    private static List<Range<BigInteger>> _localAs_range;
    private List<LocalTable> _localTable;
    private RibId _ribId;
    private SessionReconnectStrategy _sessionReconnectStrategy;
    private TcpReconnectStrategy _tcpReconnectStrategy;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> augmentation = new HashMap<>();

    public RibImplBuilder() {
    } 
    

    public RibImplBuilder(RibImpl base) {
        this._bgpDispatcher = base.getBgpDispatcher();
        this._bgpId = base.getBgpId();
        this._dataProvider = base.getDataProvider();
        this._extensions = base.getExtensions();
        this._localAs = base.getLocalAs();
        this._localTable = base.getLocalTable();
        this._ribId = base.getRibId();
        this._sessionReconnectStrategy = base.getSessionReconnectStrategy();
        this._tcpReconnectStrategy = base.getTcpReconnectStrategy();
        if (base instanceof RibImplImpl) {
            RibImplImpl _impl = (RibImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public BgpDispatcher getBgpDispatcher() {
        return _bgpDispatcher;
    }
    
    public Ipv4Address getBgpId() {
        return _bgpId;
    }
    
    public DataProvider getDataProvider() {
        return _dataProvider;
    }
    
    public Extensions getExtensions() {
        return _extensions;
    }
    
    public java.lang.Long getLocalAs() {
        return _localAs;
    }
    
    public List<LocalTable> getLocalTable() {
        return _localTable;
    }
    
    public RibId getRibId() {
        return _ribId;
    }
    
    public SessionReconnectStrategy getSessionReconnectStrategy() {
        return _sessionReconnectStrategy;
    }
    
    public TcpReconnectStrategy getTcpReconnectStrategy() {
        return _tcpReconnectStrategy;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RibImplBuilder setBgpDispatcher(BgpDispatcher value) {
        this._bgpDispatcher = value;
        return this;
    }
    
    public RibImplBuilder setBgpId(Ipv4Address value) {
        this._bgpId = value;
        return this;
    }
    
    public RibImplBuilder setDataProvider(DataProvider value) {
        this._dataProvider = value;
        return this;
    }
    
    public RibImplBuilder setExtensions(Extensions value) {
        this._extensions = value;
        return this;
    }
    
    public RibImplBuilder setLocalAs(java.lang.Long value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _localAs_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _localAs_range));
            }
        }
        this._localAs = value;
        return this;
    }
    public static List<Range<BigInteger>> _localAs_range() {
        if (_localAs_range == null) {
            synchronized (RibImplBuilder.class) {
                if (_localAs_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _localAs_range = builder.build();
                }
            }
        }
        return _localAs_range;
    }
    
    public RibImplBuilder setLocalTable(List<LocalTable> value) {
        this._localTable = value;
        return this;
    }
    
    public RibImplBuilder setRibId(RibId value) {
        this._ribId = value;
        return this;
    }
    
    public RibImplBuilder setSessionReconnectStrategy(SessionReconnectStrategy value) {
        this._sessionReconnectStrategy = value;
        return this;
    }
    
    public RibImplBuilder setTcpReconnectStrategy(TcpReconnectStrategy value) {
        this._tcpReconnectStrategy = value;
        return this;
    }
    
    public RibImplBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public RibImpl build() {
        return new RibImplImpl(this);
    }

    private static final class RibImplImpl implements RibImpl {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl.class;
        }

        private final BgpDispatcher _bgpDispatcher;
        private final Ipv4Address _bgpId;
        private final DataProvider _dataProvider;
        private final Extensions _extensions;
        private final java.lang.Long _localAs;
        private final List<LocalTable> _localTable;
        private final RibId _ribId;
        private final SessionReconnectStrategy _sessionReconnectStrategy;
        private final TcpReconnectStrategy _tcpReconnectStrategy;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> augmentation = new HashMap<>();

        private RibImplImpl(RibImplBuilder base) {
            this._bgpDispatcher = base.getBgpDispatcher();
            this._bgpId = base.getBgpId();
            this._dataProvider = base.getDataProvider();
            this._extensions = base.getExtensions();
            this._localAs = base.getLocalAs();
            this._localTable = base.getLocalTable();
            this._ribId = base.getRibId();
            this._sessionReconnectStrategy = base.getSessionReconnectStrategy();
            this._tcpReconnectStrategy = base.getTcpReconnectStrategy();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public BgpDispatcher getBgpDispatcher() {
            return _bgpDispatcher;
        }
        
        @Override
        public Ipv4Address getBgpId() {
            return _bgpId;
        }
        
        @Override
        public DataProvider getDataProvider() {
            return _dataProvider;
        }
        
        @Override
        public Extensions getExtensions() {
            return _extensions;
        }
        
        @Override
        public java.lang.Long getLocalAs() {
            return _localAs;
        }
        
        @Override
        public List<LocalTable> getLocalTable() {
            return _localTable;
        }
        
        @Override
        public RibId getRibId() {
            return _ribId;
        }
        
        @Override
        public SessionReconnectStrategy getSessionReconnectStrategy() {
            return _sessionReconnectStrategy;
        }
        
        @Override
        public TcpReconnectStrategy getTcpReconnectStrategy() {
            return _tcpReconnectStrategy;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_bgpDispatcher == null) ? 0 : _bgpDispatcher.hashCode());
            result = prime * result + ((_bgpId == null) ? 0 : _bgpId.hashCode());
            result = prime * result + ((_dataProvider == null) ? 0 : _dataProvider.hashCode());
            result = prime * result + ((_extensions == null) ? 0 : _extensions.hashCode());
            result = prime * result + ((_localAs == null) ? 0 : _localAs.hashCode());
            result = prime * result + ((_localTable == null) ? 0 : _localTable.hashCode());
            result = prime * result + ((_ribId == null) ? 0 : _ribId.hashCode());
            result = prime * result + ((_sessionReconnectStrategy == null) ? 0 : _sessionReconnectStrategy.hashCode());
            result = prime * result + ((_tcpReconnectStrategy == null) ? 0 : _tcpReconnectStrategy.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl)obj;
            if (_bgpDispatcher == null) {
                if (other.getBgpDispatcher() != null) {
                    return false;
                }
            } else if(!_bgpDispatcher.equals(other.getBgpDispatcher())) {
                return false;
            }
            if (_bgpId == null) {
                if (other.getBgpId() != null) {
                    return false;
                }
            } else if(!_bgpId.equals(other.getBgpId())) {
                return false;
            }
            if (_dataProvider == null) {
                if (other.getDataProvider() != null) {
                    return false;
                }
            } else if(!_dataProvider.equals(other.getDataProvider())) {
                return false;
            }
            if (_extensions == null) {
                if (other.getExtensions() != null) {
                    return false;
                }
            } else if(!_extensions.equals(other.getExtensions())) {
                return false;
            }
            if (_localAs == null) {
                if (other.getLocalAs() != null) {
                    return false;
                }
            } else if(!_localAs.equals(other.getLocalAs())) {
                return false;
            }
            if (_localTable == null) {
                if (other.getLocalTable() != null) {
                    return false;
                }
            } else if(!_localTable.equals(other.getLocalTable())) {
                return false;
            }
            if (_ribId == null) {
                if (other.getRibId() != null) {
                    return false;
                }
            } else if(!_ribId.equals(other.getRibId())) {
                return false;
            }
            if (_sessionReconnectStrategy == null) {
                if (other.getSessionReconnectStrategy() != null) {
                    return false;
                }
            } else if(!_sessionReconnectStrategy.equals(other.getSessionReconnectStrategy())) {
                return false;
            }
            if (_tcpReconnectStrategy == null) {
                if (other.getTcpReconnectStrategy() != null) {
                    return false;
                }
            } else if(!_tcpReconnectStrategy.equals(other.getTcpReconnectStrategy())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RibImplImpl otherImpl = (RibImplImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RibImpl [");
            boolean first = true;
        
            if (_bgpDispatcher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpDispatcher=");
                builder.append(_bgpDispatcher);
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
            if (_dataProvider != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dataProvider=");
                builder.append(_dataProvider);
             }
            if (_extensions != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extensions=");
                builder.append(_extensions);
             }
            if (_localAs != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localAs=");
                builder.append(_localAs);
             }
            if (_localTable != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localTable=");
                builder.append(_localTable);
             }
            if (_ribId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ribId=");
                builder.append(_ribId);
             }
            if (_sessionReconnectStrategy != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sessionReconnectStrategy=");
                builder.append(_sessionReconnectStrategy);
             }
            if (_tcpReconnectStrategy != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_tcpReconnectStrategy=");
                builder.append(_tcpReconnectStrategy);
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
