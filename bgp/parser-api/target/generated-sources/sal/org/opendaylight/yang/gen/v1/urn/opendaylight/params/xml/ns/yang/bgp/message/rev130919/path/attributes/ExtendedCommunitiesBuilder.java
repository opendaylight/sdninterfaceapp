package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.ExtendedCommunity;


/**
 * Module name:
 *     bgp-message
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)path-attributes/path-attributes/extended-communities]
 */
public class ExtendedCommunitiesBuilder {

    private java.lang.Short _commType;
    private static List<Range<BigInteger>> _commType_range;
    private java.lang.Short _commSubType;
    private static List<Range<BigInteger>> _commSubType_range;
    private ExtendedCommunity _extendedCommunity;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> augmentation = new HashMap<>();

    public ExtendedCommunitiesBuilder() {
    } 
    
    public ExtendedCommunitiesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity arg) {
        this._commType = arg.getCommType();
        this._commSubType = arg.getCommSubType();
        this._extendedCommunity = arg.getExtendedCommunity();
    }

    public ExtendedCommunitiesBuilder(ExtendedCommunities base) {
        this._commType = base.getCommType();
        this._commSubType = base.getCommSubType();
        this._extendedCommunity = base.getExtendedCommunity();
        if (base instanceof ExtendedCommunitiesImpl) {
            ExtendedCommunitiesImpl _impl = (ExtendedCommunitiesImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity) {
            this._commType = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity)arg).getCommType();
            this._commSubType = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity)arg).getCommSubType();
            this._extendedCommunity = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity)arg).getExtendedCommunity();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Short getCommType() {
        return _commType;
    }
    
    public java.lang.Short getCommSubType() {
        return _commSubType;
    }
    
    public ExtendedCommunity getExtendedCommunity() {
        return _extendedCommunity;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public ExtendedCommunitiesBuilder setCommType(java.lang.Short value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _commType_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _commType_range));
            }
        }
        this._commType = value;
        return this;
    }
    public static List<Range<BigInteger>> _commType_range() {
        if (_commType_range == null) {
            synchronized (ExtendedCommunitiesBuilder.class) {
                if (_commType_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(255L)));
                    _commType_range = builder.build();
                }
            }
        }
        return _commType_range;
    }
    
    public ExtendedCommunitiesBuilder setCommSubType(java.lang.Short value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _commSubType_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _commSubType_range));
            }
        }
        this._commSubType = value;
        return this;
    }
    public static List<Range<BigInteger>> _commSubType_range() {
        if (_commSubType_range == null) {
            synchronized (ExtendedCommunitiesBuilder.class) {
                if (_commSubType_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(255L)));
                    _commSubType_range = builder.build();
                }
            }
        }
        return _commSubType_range;
    }
    
    public ExtendedCommunitiesBuilder setExtendedCommunity(ExtendedCommunity value) {
        this._extendedCommunity = value;
        return this;
    }
    
    public ExtendedCommunitiesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public ExtendedCommunities build() {
        return new ExtendedCommunitiesImpl(this);
    }

    private static final class ExtendedCommunitiesImpl implements ExtendedCommunities {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities.class;
        }

        private final java.lang.Short _commType;
        private final java.lang.Short _commSubType;
        private final ExtendedCommunity _extendedCommunity;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> augmentation = new HashMap<>();

        private ExtendedCommunitiesImpl(ExtendedCommunitiesBuilder base) {
            this._commType = base.getCommType();
            this._commSubType = base.getCommSubType();
            this._extendedCommunity = base.getExtendedCommunity();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public java.lang.Short getCommType() {
            return _commType;
        }
        
        @Override
        public java.lang.Short getCommSubType() {
            return _commSubType;
        }
        
        @Override
        public ExtendedCommunity getExtendedCommunity() {
            return _extendedCommunity;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_commType == null) ? 0 : _commType.hashCode());
            result = prime * result + ((_commSubType == null) ? 0 : _commSubType.hashCode());
            result = prime * result + ((_extendedCommunity == null) ? 0 : _extendedCommunity.hashCode());
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
            ExtendedCommunitiesImpl other = (ExtendedCommunitiesImpl) obj;
            if (_commType == null) {
                if (other._commType != null) {
                    return false;
                }
            } else if(!_commType.equals(other._commType)) {
                return false;
            }
            if (_commSubType == null) {
                if (other._commSubType != null) {
                    return false;
                }
            } else if(!_commSubType.equals(other._commSubType)) {
                return false;
            }
            if (_extendedCommunity == null) {
                if (other._extendedCommunity != null) {
                    return false;
                }
            } else if(!_extendedCommunity.equals(other._extendedCommunity)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ExtendedCommunities [");
            boolean first = true;
        
            if (_commType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_commType=");
                builder.append(_commType);
             }
            if (_commSubType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_commSubType=");
                builder.append(_commSubType);
             }
            if (_extendedCommunity != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extendedCommunity=");
                builder.append(_extendedCommunity);
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
