package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify
 */
public class NotifyBuilder {

    private byte[] _data;
    private java.lang.Short _errorCode;
    private static List<Range<BigInteger>> _errorCode_range;
    private java.lang.Short _errorSubcode;
    private static List<Range<BigInteger>> _errorSubcode_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> augmentation = new HashMap<>();

    public NotifyBuilder() {
    } 

    public NotifyBuilder(Notify base) {
        this._data = base.getData();
        this._errorCode = base.getErrorCode();
        this._errorSubcode = base.getErrorSubcode();
        if (base instanceof NotifyImpl) {
            NotifyImpl _impl = (NotifyImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public byte[] getData() {
        return _data;
    }
    
    public java.lang.Short getErrorCode() {
        return _errorCode;
    }
    
    public java.lang.Short getErrorSubcode() {
        return _errorSubcode;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public NotifyBuilder setData(byte[] value) {
        this._data = value;
        return this;
    }
    
    public NotifyBuilder setErrorCode(java.lang.Short value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _errorCode_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _errorCode_range));
            }
        }
        this._errorCode = value;
        return this;
    }
    public static List<Range<BigInteger>> _errorCode_range() {
        if (_errorCode_range == null) {
            synchronized (NotifyBuilder.class) {
                if (_errorCode_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(255L)));
                    _errorCode_range = builder.build();
                }
            }
        }
        return _errorCode_range;
    }
    
    public NotifyBuilder setErrorSubcode(java.lang.Short value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _errorSubcode_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _errorSubcode_range));
            }
        }
        this._errorSubcode = value;
        return this;
    }
    public static List<Range<BigInteger>> _errorSubcode_range() {
        if (_errorSubcode_range == null) {
            synchronized (NotifyBuilder.class) {
                if (_errorSubcode_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(255L)));
                    _errorSubcode_range = builder.build();
                }
            }
        }
        return _errorSubcode_range;
    }
    
    public NotifyBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public Notify build() {
        return new NotifyImpl(this);
    }

    private static final class NotifyImpl implements Notify {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify.class;
        }

        private final byte[] _data;
        private final java.lang.Short _errorCode;
        private final java.lang.Short _errorSubcode;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> augmentation = new HashMap<>();

        private NotifyImpl(NotifyBuilder base) {
            this._data = base.getData();
            this._errorCode = base.getErrorCode();
            this._errorSubcode = base.getErrorSubcode();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public byte[] getData() {
            return _data;
        }
        
        @Override
        public java.lang.Short getErrorCode() {
            return _errorCode;
        }
        
        @Override
        public java.lang.Short getErrorSubcode() {
            return _errorSubcode;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_data == null) ? 0 : Arrays.hashCode(_data));
            result = prime * result + ((_errorCode == null) ? 0 : _errorCode.hashCode());
            result = prime * result + ((_errorSubcode == null) ? 0 : _errorSubcode.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify)obj;
            if (_data == null) {
                if (other.getData() != null) {
                    return false;
                }
            } else if(!Arrays.equals(_data, other.getData())) {
                return false;
            }
            if (_errorCode == null) {
                if (other.getErrorCode() != null) {
                    return false;
                }
            } else if(!_errorCode.equals(other.getErrorCode())) {
                return false;
            }
            if (_errorSubcode == null) {
                if (other.getErrorSubcode() != null) {
                    return false;
                }
            } else if(!_errorSubcode.equals(other.getErrorSubcode())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NotifyImpl otherImpl = (NotifyImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Notify [");
            boolean first = true;
        
            if (_data != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_data=");
                builder.append(Arrays.toString(_data));
             }
            if (_errorCode != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_errorCode=");
                builder.append(_errorCode);
             }
            if (_errorSubcode != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_errorSubcode=");
                builder.append(_errorSubcode);
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
