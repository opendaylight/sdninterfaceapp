package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.IgpMetric;
import com.google.common.collect.Range;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state.IgpBits;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.ExtendedRouteTag;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.RouteTag;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes
 */
public class PrefixAttributesBuilder {

    private List<ExtendedRouteTag> _extendedTags;
    private IgpBits _igpBits;
    private IpAddress _ospfForwardingAddress;
    private IgpMetric _prefixMetric;
    private static List<Range<BigInteger>> _prefixMetric_range;
    private List<RouteTag> _routeTags;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> augmentation = new HashMap<>();

    public PrefixAttributesBuilder() {
    } 
    
    public PrefixAttributesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState arg) {
        this._igpBits = arg.getIgpBits();
        this._routeTags = arg.getRouteTags();
        this._extendedTags = arg.getExtendedTags();
        this._prefixMetric = arg.getPrefixMetric();
        this._ospfForwardingAddress = arg.getOspfForwardingAddress();
    }

    public PrefixAttributesBuilder(PrefixAttributes base) {
        this._extendedTags = base.getExtendedTags();
        this._igpBits = base.getIgpBits();
        this._ospfForwardingAddress = base.getOspfForwardingAddress();
        this._prefixMetric = base.getPrefixMetric();
        this._routeTags = base.getRouteTags();
        if (base instanceof PrefixAttributesImpl) {
            PrefixAttributesImpl _impl = (PrefixAttributesImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState) {
            this._igpBits = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState)arg).getIgpBits();
            this._routeTags = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState)arg).getRouteTags();
            this._extendedTags = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState)arg).getExtendedTags();
            this._prefixMetric = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState)arg).getPrefixMetric();
            this._ospfForwardingAddress = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState)arg).getOspfForwardingAddress();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState] \n" +
              "but was: " + arg
            );
        }
    }

    public List<ExtendedRouteTag> getExtendedTags() {
        return _extendedTags;
    }
    
    public IgpBits getIgpBits() {
        return _igpBits;
    }
    
    public IpAddress getOspfForwardingAddress() {
        return _ospfForwardingAddress;
    }
    
    public IgpMetric getPrefixMetric() {
        return _prefixMetric;
    }
    
    public List<RouteTag> getRouteTags() {
        return _routeTags;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PrefixAttributesBuilder setExtendedTags(List<ExtendedRouteTag> value) {
        this._extendedTags = value;
        return this;
    }
    
    public PrefixAttributesBuilder setIgpBits(IgpBits value) {
        this._igpBits = value;
        return this;
    }
    
    public PrefixAttributesBuilder setOspfForwardingAddress(IpAddress value) {
        this._ospfForwardingAddress = value;
        return this;
    }
    
    public PrefixAttributesBuilder setPrefixMetric(IgpMetric value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _prefixMetric_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _prefixMetric_range));
            }
        }
        this._prefixMetric = value;
        return this;
    }
    public static List<Range<BigInteger>> _prefixMetric_range() {
        if (_prefixMetric_range == null) {
            synchronized (PrefixAttributesBuilder.class) {
                if (_prefixMetric_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(16777215L)));
                    _prefixMetric_range = builder.build();
                }
            }
        }
        return _prefixMetric_range;
    }
    
    public PrefixAttributesBuilder setRouteTags(List<RouteTag> value) {
        this._routeTags = value;
        return this;
    }
    
    public PrefixAttributesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public PrefixAttributes build() {
        return new PrefixAttributesImpl(this);
    }

    private static final class PrefixAttributesImpl implements PrefixAttributes {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes.class;
        }

        private final List<ExtendedRouteTag> _extendedTags;
        private final IgpBits _igpBits;
        private final IpAddress _ospfForwardingAddress;
        private final IgpMetric _prefixMetric;
        private final List<RouteTag> _routeTags;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> augmentation = new HashMap<>();

        private PrefixAttributesImpl(PrefixAttributesBuilder base) {
            this._extendedTags = base.getExtendedTags();
            this._igpBits = base.getIgpBits();
            this._ospfForwardingAddress = base.getOspfForwardingAddress();
            this._prefixMetric = base.getPrefixMetric();
            this._routeTags = base.getRouteTags();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public List<ExtendedRouteTag> getExtendedTags() {
            return _extendedTags;
        }
        
        @Override
        public IgpBits getIgpBits() {
            return _igpBits;
        }
        
        @Override
        public IpAddress getOspfForwardingAddress() {
            return _ospfForwardingAddress;
        }
        
        @Override
        public IgpMetric getPrefixMetric() {
            return _prefixMetric;
        }
        
        @Override
        public List<RouteTag> getRouteTags() {
            return _routeTags;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_extendedTags == null) ? 0 : _extendedTags.hashCode());
            result = prime * result + ((_igpBits == null) ? 0 : _igpBits.hashCode());
            result = prime * result + ((_ospfForwardingAddress == null) ? 0 : _ospfForwardingAddress.hashCode());
            result = prime * result + ((_prefixMetric == null) ? 0 : _prefixMetric.hashCode());
            result = prime * result + ((_routeTags == null) ? 0 : _routeTags.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes)obj;
            if (_extendedTags == null) {
                if (other.getExtendedTags() != null) {
                    return false;
                }
            } else if(!_extendedTags.equals(other.getExtendedTags())) {
                return false;
            }
            if (_igpBits == null) {
                if (other.getIgpBits() != null) {
                    return false;
                }
            } else if(!_igpBits.equals(other.getIgpBits())) {
                return false;
            }
            if (_ospfForwardingAddress == null) {
                if (other.getOspfForwardingAddress() != null) {
                    return false;
                }
            } else if(!_ospfForwardingAddress.equals(other.getOspfForwardingAddress())) {
                return false;
            }
            if (_prefixMetric == null) {
                if (other.getPrefixMetric() != null) {
                    return false;
                }
            } else if(!_prefixMetric.equals(other.getPrefixMetric())) {
                return false;
            }
            if (_routeTags == null) {
                if (other.getRouteTags() != null) {
                    return false;
                }
            } else if(!_routeTags.equals(other.getRouteTags())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                PrefixAttributesImpl otherImpl = (PrefixAttributesImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.prefix._case.PrefixAttributes>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PrefixAttributes [");
            boolean first = true;
        
            if (_extendedTags != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extendedTags=");
                builder.append(_extendedTags);
             }
            if (_igpBits != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_igpBits=");
                builder.append(_igpBits);
             }
            if (_ospfForwardingAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ospfForwardingAddress=");
                builder.append(_ospfForwardingAddress);
             }
            if (_prefixMetric != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_prefixMetric=");
                builder.append(_prefixMetric);
             }
            if (_routeTags != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_routeTags=");
                builder.append(_routeTags);
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
