package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.ProtocolVersion;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open
 */
public class OpenBuilder {

    private Ipv4Address _bgpIdentifier;
    private List<BgpParameters> _bgpParameters;
    private java.lang.Integer _holdTimer;
    private static List<Range<BigInteger>> _holdTimer_range;
    private java.lang.Integer _myAsNumber;
    private static List<Range<BigInteger>> _myAsNumber_range;
    private ProtocolVersion _version;
    private static List<Range<BigInteger>> _version_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> augmentation = new HashMap<>();

    public OpenBuilder() {
    } 

    public OpenBuilder(Open base) {
        this._bgpIdentifier = base.getBgpIdentifier();
        this._bgpParameters = base.getBgpParameters();
        this._holdTimer = base.getHoldTimer();
        this._myAsNumber = base.getMyAsNumber();
        this._version = base.getVersion();
        if (base instanceof OpenImpl) {
            OpenImpl _impl = (OpenImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public Ipv4Address getBgpIdentifier() {
        return _bgpIdentifier;
    }
    
    public List<BgpParameters> getBgpParameters() {
        return _bgpParameters;
    }
    
    public java.lang.Integer getHoldTimer() {
        return _holdTimer;
    }
    
    public java.lang.Integer getMyAsNumber() {
        return _myAsNumber;
    }
    
    public ProtocolVersion getVersion() {
        return _version;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public OpenBuilder setBgpIdentifier(Ipv4Address value) {
        this._bgpIdentifier = value;
        return this;
    }
    
    public OpenBuilder setBgpParameters(List<BgpParameters> value) {
        this._bgpParameters = value;
        return this;
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

        private final Ipv4Address _bgpIdentifier;
        private final List<BgpParameters> _bgpParameters;
        private final java.lang.Integer _holdTimer;
        private final java.lang.Integer _myAsNumber;
        private final ProtocolVersion _version;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> augmentation = new HashMap<>();

        private OpenImpl(OpenBuilder base) {
            this._bgpIdentifier = base.getBgpIdentifier();
            this._bgpParameters = base.getBgpParameters();
            this._holdTimer = base.getHoldTimer();
            this._myAsNumber = base.getMyAsNumber();
            this._version = base.getVersion();
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
        public Ipv4Address getBgpIdentifier() {
            return _bgpIdentifier;
        }
        
        @Override
        public List<BgpParameters> getBgpParameters() {
            return _bgpParameters;
        }
        
        @Override
        public java.lang.Integer getHoldTimer() {
            return _holdTimer;
        }
        
        @Override
        public java.lang.Integer getMyAsNumber() {
            return _myAsNumber;
        }
        
        @Override
        public ProtocolVersion getVersion() {
            return _version;
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
            result = prime * result + ((_bgpIdentifier == null) ? 0 : _bgpIdentifier.hashCode());
            result = prime * result + ((_bgpParameters == null) ? 0 : _bgpParameters.hashCode());
            result = prime * result + ((_holdTimer == null) ? 0 : _holdTimer.hashCode());
            result = prime * result + ((_myAsNumber == null) ? 0 : _myAsNumber.hashCode());
            result = prime * result + ((_version == null) ? 0 : _version.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open)obj;
            if (_bgpIdentifier == null) {
                if (other.getBgpIdentifier() != null) {
                    return false;
                }
            } else if(!_bgpIdentifier.equals(other.getBgpIdentifier())) {
                return false;
            }
            if (_bgpParameters == null) {
                if (other.getBgpParameters() != null) {
                    return false;
                }
            } else if(!_bgpParameters.equals(other.getBgpParameters())) {
                return false;
            }
            if (_holdTimer == null) {
                if (other.getHoldTimer() != null) {
                    return false;
                }
            } else if(!_holdTimer.equals(other.getHoldTimer())) {
                return false;
            }
            if (_myAsNumber == null) {
                if (other.getMyAsNumber() != null) {
                    return false;
                }
            } else if(!_myAsNumber.equals(other.getMyAsNumber())) {
                return false;
            }
            if (_version == null) {
                if (other.getVersion() != null) {
                    return false;
                }
            } else if(!_version.equals(other.getVersion())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                OpenImpl otherImpl = (OpenImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Open [");
            boolean first = true;
        
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
            if (_holdTimer != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdTimer=");
                builder.append(_holdTimer);
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
            if (_version != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_version=");
                builder.append(_version);
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
