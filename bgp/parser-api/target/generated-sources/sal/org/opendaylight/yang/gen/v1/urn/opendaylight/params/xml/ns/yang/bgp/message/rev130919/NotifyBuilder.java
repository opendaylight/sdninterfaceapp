package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Notification Message
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc4271#section-4.5">http://tools.ietf.org/html/rfc4271#section-4.5</a>
 * Module name:
 *     bgp-message
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)notify/notify]
 */
public class NotifyBuilder {

    private java.lang.Short _errorCode;
    private static List<Range<BigInteger>> _errorCode_range;
    private java.lang.Short _errorSubcode;
    private static List<Range<BigInteger>> _errorSubcode_range;
    private byte[] _data;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> augmentation = new HashMap<>();

    public NotifyBuilder() {
    } 

    public NotifyBuilder(Notify base) {
        this._errorCode = base.getErrorCode();
        this._errorSubcode = base.getErrorSubcode();
        this._data = base.getData();
        if (base instanceof NotifyImpl) {
            NotifyImpl _impl = (NotifyImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public java.lang.Short getErrorCode() {
        return _errorCode;
    }
    
    public java.lang.Short getErrorSubcode() {
        return _errorSubcode;
    }
    
    public byte[] getData() {
        return _data;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
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
    
    public NotifyBuilder setData(byte[] value) {
        this._data = value;
        return this;
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

        private final java.lang.Short _errorCode;
        private final java.lang.Short _errorSubcode;
        private final byte[] _data;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>> augmentation = new HashMap<>();

        private NotifyImpl(NotifyBuilder base) {
            this._errorCode = base.getErrorCode();
            this._errorSubcode = base.getErrorSubcode();
            this._data = base.getData();
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
        public java.lang.Short getErrorCode() {
            return _errorCode;
        }
        
        @Override
        public java.lang.Short getErrorSubcode() {
            return _errorSubcode;
        }
        
        @Override
        public byte[] getData() {
            return _data;
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
            result = prime * result + ((_errorCode == null) ? 0 : _errorCode.hashCode());
            result = prime * result + ((_errorSubcode == null) ? 0 : _errorSubcode.hashCode());
            result = prime * result + ((_data == null) ? 0 : Arrays.hashCode(_data));
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
            NotifyImpl other = (NotifyImpl) obj;
            if (_errorCode == null) {
                if (other._errorCode != null) {
                    return false;
                }
            } else if(!_errorCode.equals(other._errorCode)) {
                return false;
            }
            if (_errorSubcode == null) {
                if (other._errorSubcode != null) {
                    return false;
                }
            } else if(!_errorSubcode.equals(other._errorSubcode)) {
                return false;
            }
            if (_data == null) {
                if (other._data != null) {
                    return false;
                }
            } else if(!Arrays.equals(_data, other._data)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Notify [");
            boolean first = true;
        
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
            if (_data != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_data=");
                builder.append(Arrays.toString(_data));
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
