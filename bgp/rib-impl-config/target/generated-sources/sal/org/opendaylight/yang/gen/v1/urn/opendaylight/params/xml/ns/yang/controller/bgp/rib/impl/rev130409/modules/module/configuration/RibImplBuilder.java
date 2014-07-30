package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.Extensions;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.RibId;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.BgpDispatcher;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.SessionReconnectStrategy;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.TcpReconnectStrategy;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.LocalTable;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-rib-impl
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)modules/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)rib-impl]
 */
public class RibImplBuilder {

    private Extensions _extensions;
    private BgpDispatcher _bgpDispatcher;
    private SessionReconnectStrategy _sessionReconnectStrategy;
    private TcpReconnectStrategy _tcpReconnectStrategy;
    private DataProvider _dataProvider;
    private java.lang.Long _localAs;
    private static List<Range<BigInteger>> _localAs_range;
    private Ipv4Address _bgpId;
    private List<LocalTable> _localTable;
    private RibId _ribId;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> augmentation = new HashMap<>();

    public RibImplBuilder() {
    } 
    

    public RibImplBuilder(RibImpl base) {
        this._extensions = base.getExtensions();
        this._bgpDispatcher = base.getBgpDispatcher();
        this._sessionReconnectStrategy = base.getSessionReconnectStrategy();
        this._tcpReconnectStrategy = base.getTcpReconnectStrategy();
        this._dataProvider = base.getDataProvider();
        this._localAs = base.getLocalAs();
        this._bgpId = base.getBgpId();
        this._localTable = base.getLocalTable();
        this._ribId = base.getRibId();
        if (base instanceof RibImplImpl) {
            RibImplImpl _impl = (RibImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public Extensions getExtensions() {
        return _extensions;
    }
    
    public BgpDispatcher getBgpDispatcher() {
        return _bgpDispatcher;
    }
    
    public SessionReconnectStrategy getSessionReconnectStrategy() {
        return _sessionReconnectStrategy;
    }
    
    public TcpReconnectStrategy getTcpReconnectStrategy() {
        return _tcpReconnectStrategy;
    }
    
    public DataProvider getDataProvider() {
        return _dataProvider;
    }
    
    public java.lang.Long getLocalAs() {
        return _localAs;
    }
    
    public Ipv4Address getBgpId() {
        return _bgpId;
    }
    
    public List<LocalTable> getLocalTable() {
        return _localTable;
    }
    
    public RibId getRibId() {
        return _ribId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RibImplBuilder setExtensions(Extensions value) {
        this._extensions = value;
        return this;
    }
    
    public RibImplBuilder setBgpDispatcher(BgpDispatcher value) {
        this._bgpDispatcher = value;
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
    
    public RibImplBuilder setDataProvider(DataProvider value) {
        this._dataProvider = value;
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
    
    public RibImplBuilder setBgpId(Ipv4Address value) {
        this._bgpId = value;
        return this;
    }
    
    public RibImplBuilder setLocalTable(List<LocalTable> value) {
        this._localTable = value;
        return this;
    }
    
    public RibImplBuilder setRibId(RibId value) {
        this._ribId = value;
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

        private final Extensions _extensions;
        private final BgpDispatcher _bgpDispatcher;
        private final SessionReconnectStrategy _sessionReconnectStrategy;
        private final TcpReconnectStrategy _tcpReconnectStrategy;
        private final DataProvider _dataProvider;
        private final java.lang.Long _localAs;
        private final Ipv4Address _bgpId;
        private final List<LocalTable> _localTable;
        private final RibId _ribId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>> augmentation = new HashMap<>();

        private RibImplImpl(RibImplBuilder base) {
            this._extensions = base.getExtensions();
            this._bgpDispatcher = base.getBgpDispatcher();
            this._sessionReconnectStrategy = base.getSessionReconnectStrategy();
            this._tcpReconnectStrategy = base.getTcpReconnectStrategy();
            this._dataProvider = base.getDataProvider();
            this._localAs = base.getLocalAs();
            this._bgpId = base.getBgpId();
            this._localTable = base.getLocalTable();
            this._ribId = base.getRibId();
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
        public Extensions getExtensions() {
            return _extensions;
        }
        
        @Override
        public BgpDispatcher getBgpDispatcher() {
            return _bgpDispatcher;
        }
        
        @Override
        public SessionReconnectStrategy getSessionReconnectStrategy() {
            return _sessionReconnectStrategy;
        }
        
        @Override
        public TcpReconnectStrategy getTcpReconnectStrategy() {
            return _tcpReconnectStrategy;
        }
        
        @Override
        public DataProvider getDataProvider() {
            return _dataProvider;
        }
        
        @Override
        public java.lang.Long getLocalAs() {
            return _localAs;
        }
        
        @Override
        public Ipv4Address getBgpId() {
            return _bgpId;
        }
        
        @Override
        public List<LocalTable> getLocalTable() {
            return _localTable;
        }
        
        @Override
        public RibId getRibId() {
            return _ribId;
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
            result = prime * result + ((_extensions == null) ? 0 : _extensions.hashCode());
            result = prime * result + ((_bgpDispatcher == null) ? 0 : _bgpDispatcher.hashCode());
            result = prime * result + ((_sessionReconnectStrategy == null) ? 0 : _sessionReconnectStrategy.hashCode());
            result = prime * result + ((_tcpReconnectStrategy == null) ? 0 : _tcpReconnectStrategy.hashCode());
            result = prime * result + ((_dataProvider == null) ? 0 : _dataProvider.hashCode());
            result = prime * result + ((_localAs == null) ? 0 : _localAs.hashCode());
            result = prime * result + ((_bgpId == null) ? 0 : _bgpId.hashCode());
            result = prime * result + ((_localTable == null) ? 0 : _localTable.hashCode());
            result = prime * result + ((_ribId == null) ? 0 : _ribId.hashCode());
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
            RibImplImpl other = (RibImplImpl) obj;
            if (_extensions == null) {
                if (other._extensions != null) {
                    return false;
                }
            } else if(!_extensions.equals(other._extensions)) {
                return false;
            }
            if (_bgpDispatcher == null) {
                if (other._bgpDispatcher != null) {
                    return false;
                }
            } else if(!_bgpDispatcher.equals(other._bgpDispatcher)) {
                return false;
            }
            if (_sessionReconnectStrategy == null) {
                if (other._sessionReconnectStrategy != null) {
                    return false;
                }
            } else if(!_sessionReconnectStrategy.equals(other._sessionReconnectStrategy)) {
                return false;
            }
            if (_tcpReconnectStrategy == null) {
                if (other._tcpReconnectStrategy != null) {
                    return false;
                }
            } else if(!_tcpReconnectStrategy.equals(other._tcpReconnectStrategy)) {
                return false;
            }
            if (_dataProvider == null) {
                if (other._dataProvider != null) {
                    return false;
                }
            } else if(!_dataProvider.equals(other._dataProvider)) {
                return false;
            }
            if (_localAs == null) {
                if (other._localAs != null) {
                    return false;
                }
            } else if(!_localAs.equals(other._localAs)) {
                return false;
            }
            if (_bgpId == null) {
                if (other._bgpId != null) {
                    return false;
                }
            } else if(!_bgpId.equals(other._bgpId)) {
                return false;
            }
            if (_localTable == null) {
                if (other._localTable != null) {
                    return false;
                }
            } else if(!_localTable.equals(other._localTable)) {
                return false;
            }
            if (_ribId == null) {
                if (other._ribId != null) {
                    return false;
                }
            } else if(!_ribId.equals(other._ribId)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RibImpl [");
            boolean first = true;
        
            if (_extensions != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extensions=");
                builder.append(_extensions);
             }
            if (_bgpDispatcher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpDispatcher=");
                builder.append(_bgpDispatcher);
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
            if (_dataProvider != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dataProvider=");
                builder.append(_dataProvider);
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
            if (_bgpId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpId=");
                builder.append(_bgpId);
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
