package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.ProtocolVersion;


/**
 * Open Message
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc4271#section-4.2">http://tools.ietf.org/html/rfc4271#section-4.2</a>
 * Module name:
 *     bgp-message
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)open/open]
 */
public class OpenBuilder {

    private ProtocolVersion _version;
    private static List<Range<BigInteger>> _version_range;
    private java.lang.Integer _myAsNumber;
    private static List<Range<BigInteger>> _myAsNumber_range;
    private java.lang.Integer _holdTimer;
    private static List<Range<BigInteger>> _holdTimer_range;
    private Ipv4Address _bgpIdentifier;
    private List<BgpParameters> _bgpParameters;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> augmentation = new HashMap<>();

    public OpenBuilder() {
    } 

    public OpenBuilder(Open base) {
        this._version = base.getVersion();
        this._myAsNumber = base.getMyAsNumber();
        this._holdTimer = base.getHoldTimer();
        this._bgpIdentifier = base.getBgpIdentifier();
        this._bgpParameters = base.getBgpParameters();
        if (base instanceof OpenImpl) {
            OpenImpl _impl = (OpenImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public ProtocolVersion getVersion() {
        return _version;
    }
    
    public java.lang.Integer getMyAsNumber() {
        return _myAsNumber;
    }
    
    public java.lang.Integer getHoldTimer() {
        return _holdTimer;
    }
    
    public Ipv4Address getBgpIdentifier() {
        return _bgpIdentifier;
    }
    
    public List<BgpParameters> getBgpParameters() {
        return _bgpParameters;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public OpenBuilder setVersion(ProtocolVersion value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _version_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _version_range));
            }
        }
        this._version = value;
        return this;
    }
    public static List<Range<BigInteger>> _version_range() {
        if (_version_range == null) {
            synchronized (OpenBuilder.class) {
                if (_version_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ONE, BigInteger.valueOf(7L)));
                    _version_range = builder.build();
                }
            }
        }
        return _version_range;
    }
    
    public OpenBuilder setMyAsNumber(java.lang.Integer value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _myAsNumber_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _myAsNumber_range));
            }
        }
        this._myAsNumber = value;
        return this;
    }
    public static List<Range<BigInteger>> _myAsNumber_range() {
        if (_myAsNumber_range == null) {
            synchronized (OpenBuilder.class) {
                if (_myAsNumber_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _myAsNumber_range = builder.build();
                }
            }
        }
        return _myAsNumber_range;
    }
    
    public OpenBuilder setHoldTimer(java.lang.Integer value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _holdTimer_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _holdTimer_range));
            }
        }
        this._holdTimer = value;
        return this;
    }
    public static List<Range<BigInteger>> _holdTimer_range() {
        if (_holdTimer_range == null) {
            synchronized (OpenBuilder.class) {
                if (_holdTimer_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _holdTimer_range = builder.build();
                }
            }
        }
        return _holdTimer_range;
    }
    
    public OpenBuilder setBgpIdentifier(Ipv4Address value) {
        this._bgpIdentifier = value;
        return this;
    }
    
    public OpenBuilder setBgpParameters(List<BgpParameters> value) {
        this._bgpParameters = value;
        return this;
    }
    
    public OpenBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public Open build() {
        return new OpenImpl(this);
    }

    private static final class OpenImpl implements Open {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open.class;
        }

        private final ProtocolVersion _version;
        private final java.lang.Integer _myAsNumber;
        private final java.lang.Integer _holdTimer;
        private final Ipv4Address _bgpIdentifier;
        private final List<BgpParameters> _bgpParameters;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> augmentation = new HashMap<>();

        private OpenImpl(OpenBuilder base) {
            this._version = base.getVersion();
            this._myAsNumber = base.getMyAsNumber();
            this._holdTimer = base.getHoldTimer();
            this._bgpIdentifier = base.getBgpIdentifier();
            this._bgpParameters = base.getBgpParameters();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public ProtocolVersion getVersion() {
            return _version;
        }
        
        @Override
        public java.lang.Integer getMyAsNumber() {
            return _myAsNumber;
        }
        
        @Override
        public java.lang.Integer getHoldTimer() {
            return _holdTimer;
        }
        
        @Override
        public Ipv4Address getBgpIdentifier() {
            return _bgpIdentifier;
        }
        
        @Override
        public List<BgpParameters> getBgpParameters() {
            return _bgpParameters;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_version == null) ? 0 : _version.hashCode());
            result = prime * result + ((_myAsNumber == null) ? 0 : _myAsNumber.hashCode());
            result = prime * result + ((_holdTimer == null) ? 0 : _holdTimer.hashCode());
            result = prime * result + ((_bgpIdentifier == null) ? 0 : _bgpIdentifier.hashCode());
            result = prime * result + ((_bgpParameters == null) ? 0 : _bgpParameters.hashCode());
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
            OpenImpl other = (OpenImpl) obj;
            if (_version == null) {
                if (other._version != null) {
                    return false;
                }
            } else if(!_version.equals(other._version)) {
                return false;
            }
            if (_myAsNumber == null) {
                if (other._myAsNumber != null) {
                    return false;
                }
            } else if(!_myAsNumber.equals(other._myAsNumber)) {
                return false;
            }
            if (_holdTimer == null) {
                if (other._holdTimer != null) {
                    return false;
                }
            } else if(!_holdTimer.equals(other._holdTimer)) {
                return false;
            }
            if (_bgpIdentifier == null) {
                if (other._bgpIdentifier != null) {
                    return false;
                }
            } else if(!_bgpIdentifier.equals(other._bgpIdentifier)) {
                return false;
            }
            if (_bgpParameters == null) {
                if (other._bgpParameters != null) {
                    return false;
                }
            } else if(!_bgpParameters.equals(other._bgpParameters)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Open [");
            boolean first = true;
        
            if (_version != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_version=");
                builder.append(_version);
             }
            if (_myAsNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_myAsNumber=");
                builder.append(_myAsNumber);
             }
            if (_holdTimer != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdTimer=");
                builder.append(_holdTimer);
             }
            if (_bgpIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpIdentifier=");
                builder.append(_bgpIdentifier);
             }
            if (_bgpParameters != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpParameters=");
                builder.append(_bgpParameters);
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
