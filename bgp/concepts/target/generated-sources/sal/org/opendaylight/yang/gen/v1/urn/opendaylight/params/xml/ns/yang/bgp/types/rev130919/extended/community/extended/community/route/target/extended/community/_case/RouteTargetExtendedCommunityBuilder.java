package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ShortAsNumber;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity
 */
public class RouteTargetExtendedCommunityBuilder {

    private ShortAsNumber _globalAdministrator;
    private static List<Range<BigInteger>> _globalAdministrator_range;
    private byte[] _localAdministrator;
    private static List<Range<BigInteger>> _localAdministrator_length;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> augmentation = new HashMap<>();

    public RouteTargetExtendedCommunityBuilder() {
    } 

    public RouteTargetExtendedCommunityBuilder(RouteTargetExtendedCommunity base) {
        this._globalAdministrator = base.getGlobalAdministrator();
        this._localAdministrator = base.getLocalAdministrator();
        if (base instanceof RouteTargetExtendedCommunityImpl) {
            RouteTargetExtendedCommunityImpl _impl = (RouteTargetExtendedCommunityImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public ShortAsNumber getGlobalAdministrator() {
        return _globalAdministrator;
    }
    
    public byte[] getLocalAdministrator() {
        return _localAdministrator;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RouteTargetExtendedCommunityBuilder setGlobalAdministrator(ShortAsNumber value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _globalAdministrator_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _globalAdministrator_range));
            }
        }
        this._globalAdministrator = value;
        return this;
    }
    public static List<Range<BigInteger>> _globalAdministrator_range() {
        if (_globalAdministrator_range == null) {
            synchronized (RouteTargetExtendedCommunityBuilder.class) {
                if (_globalAdministrator_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _globalAdministrator_range = builder.build();
                }
            }
        }
        return _globalAdministrator_range;
    }
    
    public RouteTargetExtendedCommunityBuilder setLocalAdministrator(byte[] value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.length);
            boolean isValidLength = false;
            for (Range<BigInteger> r : _localAdministrator_length()) {
                if (r.contains(_constraint)) {
                    isValidLength = true;
                }
            }
            if (!isValidLength) {
                throw new IllegalArgumentException(String.format("Invalid length: %s, expected: %s.", value, _localAdministrator_length));
            }
        }
        this._localAdministrator = value;
        return this;
    }
    public static List<Range<BigInteger>> _localAdministrator_length() {
        if (_localAdministrator_length == null) {
            synchronized (RouteTargetExtendedCommunityBuilder.class) {
                if (_localAdministrator_length == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.valueOf(4L), BigInteger.valueOf(4L)));
                    _localAdministrator_length = builder.build();
                }
            }
        }
        return _localAdministrator_length;
    }
    
    public RouteTargetExtendedCommunityBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public RouteTargetExtendedCommunity build() {
        return new RouteTargetExtendedCommunityImpl(this);
    }

    private static final class RouteTargetExtendedCommunityImpl implements RouteTargetExtendedCommunity {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity.class;
        }

        private final ShortAsNumber _globalAdministrator;
        private final byte[] _localAdministrator;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> augmentation = new HashMap<>();

        private RouteTargetExtendedCommunityImpl(RouteTargetExtendedCommunityBuilder base) {
            this._globalAdministrator = base.getGlobalAdministrator();
            this._localAdministrator = base.getLocalAdministrator();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public ShortAsNumber getGlobalAdministrator() {
            return _globalAdministrator;
        }
        
        @Override
        public byte[] getLocalAdministrator() {
            return _localAdministrator;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_globalAdministrator == null) ? 0 : _globalAdministrator.hashCode());
            result = prime * result + ((_localAdministrator == null) ? 0 : Arrays.hashCode(_localAdministrator));
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity)obj;
            if (_globalAdministrator == null) {
                if (other.getGlobalAdministrator() != null) {
                    return false;
                }
            } else if(!_globalAdministrator.equals(other.getGlobalAdministrator())) {
                return false;
            }
            if (_localAdministrator == null) {
                if (other.getLocalAdministrator() != null) {
                    return false;
                }
            } else if(!Arrays.equals(_localAdministrator, other.getLocalAdministrator())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RouteTargetExtendedCommunityImpl otherImpl = (RouteTargetExtendedCommunityImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.target.extended.community._case.RouteTargetExtendedCommunity>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RouteTargetExtendedCommunity [");
            boolean first = true;
        
            if (_globalAdministrator != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_globalAdministrator=");
                builder.append(_globalAdministrator);
             }
            if (_localAdministrator != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localAdministrator=");
                builder.append(Arrays.toString(_localAdministrator));
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
