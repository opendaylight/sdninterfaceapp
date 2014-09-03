package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.prefix._case.AdvertisingNodeDescriptors;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpPrefix;
import com.google.common.collect.ImmutableList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouteType;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase
 */
public class PrefixCaseBuilder {

    private AdvertisingNodeDescriptors _advertisingNodeDescriptors;
    private IpPrefix _ipReachabilityInformation;
    private TopologyIdentifier _multiTopologyId;
    private static List<Range<BigInteger>> _multiTopologyId_range;
    private OspfRouteType _ospfRouteType;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> augmentation = new HashMap<>();

    public PrefixCaseBuilder() {
    } 
    
    public PrefixCaseBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers arg) {
        this._multiTopologyId = arg.getMultiTopologyId();
        this._ospfRouteType = arg.getOspfRouteType();
        this._ipReachabilityInformation = arg.getIpReachabilityInformation();
    }
    

    public PrefixCaseBuilder(PrefixCase base) {
        this._advertisingNodeDescriptors = base.getAdvertisingNodeDescriptors();
        this._ipReachabilityInformation = base.getIpReachabilityInformation();
        this._multiTopologyId = base.getMultiTopologyId();
        this._ospfRouteType = base.getOspfRouteType();
        if (base instanceof PrefixCaseImpl) {
            PrefixCaseImpl _impl = (PrefixCaseImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers) {
            this._multiTopologyId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers)arg).getMultiTopologyId();
            this._ospfRouteType = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers)arg).getOspfRouteType();
            this._ipReachabilityInformation = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers)arg).getIpReachabilityInformation();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers] \n" +
              "but was: " + arg
            );
        }
    }

    public AdvertisingNodeDescriptors getAdvertisingNodeDescriptors() {
        return _advertisingNodeDescriptors;
    }
    
    public IpPrefix getIpReachabilityInformation() {
        return _ipReachabilityInformation;
    }
    
    public TopologyIdentifier getMultiTopologyId() {
        return _multiTopologyId;
    }
    
    public OspfRouteType getOspfRouteType() {
        return _ospfRouteType;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PrefixCaseBuilder setAdvertisingNodeDescriptors(AdvertisingNodeDescriptors value) {
        this._advertisingNodeDescriptors = value;
        return this;
    }
    
    public PrefixCaseBuilder setIpReachabilityInformation(IpPrefix value) {
        this._ipReachabilityInformation = value;
        return this;
    }
    
    public PrefixCaseBuilder setMultiTopologyId(TopologyIdentifier value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _multiTopologyId_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _multiTopologyId_range));
            }
        }
        this._multiTopologyId = value;
        return this;
    }
    public static List<Range<BigInteger>> _multiTopologyId_range() {
        if (_multiTopologyId_range == null) {
            synchronized (PrefixCaseBuilder.class) {
                if (_multiTopologyId_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4095L)));
                    _multiTopologyId_range = builder.build();
                }
            }
        }
        return _multiTopologyId_range;
    }
    
    public PrefixCaseBuilder setOspfRouteType(OspfRouteType value) {
        this._ospfRouteType = value;
        return this;
    }
    
    public PrefixCaseBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public PrefixCase build() {
        return new PrefixCaseImpl(this);
    }

    private static final class PrefixCaseImpl implements PrefixCase {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase.class;
        }

        private final AdvertisingNodeDescriptors _advertisingNodeDescriptors;
        private final IpPrefix _ipReachabilityInformation;
        private final TopologyIdentifier _multiTopologyId;
        private final OspfRouteType _ospfRouteType;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> augmentation = new HashMap<>();

        private PrefixCaseImpl(PrefixCaseBuilder base) {
            this._advertisingNodeDescriptors = base.getAdvertisingNodeDescriptors();
            this._ipReachabilityInformation = base.getIpReachabilityInformation();
            this._multiTopologyId = base.getMultiTopologyId();
            this._ospfRouteType = base.getOspfRouteType();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public AdvertisingNodeDescriptors getAdvertisingNodeDescriptors() {
            return _advertisingNodeDescriptors;
        }
        
        @Override
        public IpPrefix getIpReachabilityInformation() {
            return _ipReachabilityInformation;
        }
        
        @Override
        public TopologyIdentifier getMultiTopologyId() {
            return _multiTopologyId;
        }
        
        @Override
        public OspfRouteType getOspfRouteType() {
            return _ospfRouteType;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_advertisingNodeDescriptors == null) ? 0 : _advertisingNodeDescriptors.hashCode());
            result = prime * result + ((_ipReachabilityInformation == null) ? 0 : _ipReachabilityInformation.hashCode());
            result = prime * result + ((_multiTopologyId == null) ? 0 : _multiTopologyId.hashCode());
            result = prime * result + ((_ospfRouteType == null) ? 0 : _ospfRouteType.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase)obj;
            if (_advertisingNodeDescriptors == null) {
                if (other.getAdvertisingNodeDescriptors() != null) {
                    return false;
                }
            } else if(!_advertisingNodeDescriptors.equals(other.getAdvertisingNodeDescriptors())) {
                return false;
            }
            if (_ipReachabilityInformation == null) {
                if (other.getIpReachabilityInformation() != null) {
                    return false;
                }
            } else if(!_ipReachabilityInformation.equals(other.getIpReachabilityInformation())) {
                return false;
            }
            if (_multiTopologyId == null) {
                if (other.getMultiTopologyId() != null) {
                    return false;
                }
            } else if(!_multiTopologyId.equals(other.getMultiTopologyId())) {
                return false;
            }
            if (_ospfRouteType == null) {
                if (other.getOspfRouteType() != null) {
                    return false;
                }
            } else if(!_ospfRouteType.equals(other.getOspfRouteType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                PrefixCaseImpl otherImpl = (PrefixCaseImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PrefixCase [");
            boolean first = true;
        
            if (_advertisingNodeDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_advertisingNodeDescriptors=");
                builder.append(_advertisingNodeDescriptors);
             }
            if (_ipReachabilityInformation != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipReachabilityInformation=");
                builder.append(_ipReachabilityInformation);
             }
            if (_multiTopologyId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_multiTopologyId=");
                builder.append(_multiTopologyId);
             }
            if (_ospfRouteType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ospfRouteType=");
                builder.append(_ospfRouteType);
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
