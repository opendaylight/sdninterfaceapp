package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case;
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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity
 */
public class RouteOriginExtendedCommunityBuilder {

    private ShortAsNumber _globalAdministrator;
    private static List<Range<BigInteger>> _globalAdministrator_range;
    private byte[] _localAdministrator;
    private static List<Range<BigInteger>> _localAdministrator_length;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> augmentation = new HashMap<>();

    public RouteOriginExtendedCommunityBuilder() {
    } 

    public RouteOriginExtendedCommunityBuilder(RouteOriginExtendedCommunity base) {
        this._globalAdministrator = base.getGlobalAdministrator();
        this._localAdministrator = base.getLocalAdministrator();
        if (base instanceof RouteOriginExtendedCommunityImpl) {
            RouteOriginExtendedCommunityImpl _impl = (RouteOriginExtendedCommunityImpl) base;
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
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RouteOriginExtendedCommunityBuilder setGlobalAdministrator(ShortAsNumber value) {
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
            synchronized (RouteOriginExtendedCommunityBuilder.class) {
                if (_globalAdministrator_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
                    _globalAdministrator_range = builder.build();
                }
            }
        }
        return _globalAdministrator_range;
    }
    
    public RouteOriginExtendedCommunityBuilder setLocalAdministrator(byte[] value) {
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
            synchronized (RouteOriginExtendedCommunityBuilder.class) {
                if (_localAdministrator_length == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.valueOf(4L), BigInteger.valueOf(4L)));
                    _localAdministrator_length = builder.build();
                }
            }
        }
        return _localAdministrator_length;
    }
    
    public RouteOriginExtendedCommunityBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public RouteOriginExtendedCommunity build() {
        return new RouteOriginExtendedCommunityImpl(this);
    }

    private static final class RouteOriginExtendedCommunityImpl implements RouteOriginExtendedCommunity {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity.class;
        }

        private final ShortAsNumber _globalAdministrator;
        private final byte[] _localAdministrator;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> augmentation = new HashMap<>();

        private RouteOriginExtendedCommunityImpl(RouteOriginExtendedCommunityBuilder base) {
            this._globalAdministrator = base.getGlobalAdministrator();
            this._localAdministrator = base.getLocalAdministrator();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>singletonMap(e.getKey(), e.getValue());       
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
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity)obj;
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
                RouteOriginExtendedCommunityImpl otherImpl = (RouteOriginExtendedCommunityImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.route.origin.extended.community._case.RouteOriginExtendedCommunity>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RouteOriginExtendedCommunity [");
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
