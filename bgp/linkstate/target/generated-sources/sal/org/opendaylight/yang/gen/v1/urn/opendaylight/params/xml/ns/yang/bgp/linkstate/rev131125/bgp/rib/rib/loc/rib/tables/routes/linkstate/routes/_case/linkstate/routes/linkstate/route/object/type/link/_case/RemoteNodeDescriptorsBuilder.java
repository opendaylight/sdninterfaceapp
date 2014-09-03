package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.AreaIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.DomainIdentifier;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.AsNumber;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.CRouterIdentifier;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors
 */
public class RemoteNodeDescriptorsBuilder {

    private AreaIdentifier _areaId;
    private static List<Range<BigInteger>> _areaId_range;
    private AsNumber _asNumber;
    private static List<Range<BigInteger>> _asNumber_range;
    private CRouterIdentifier _cRouterIdentifier;
    private DomainIdentifier _domainId;
    private static List<Range<BigInteger>> _domainId_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> augmentation = new HashMap<>();

    public RemoteNodeDescriptorsBuilder() {
    } 
    
    public RemoteNodeDescriptorsBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier arg) {
        this._asNumber = arg.getAsNumber();
        this._areaId = arg.getAreaId();
        this._domainId = arg.getDomainId();
        this._cRouterIdentifier = arg.getCRouterIdentifier();
    }

    public RemoteNodeDescriptorsBuilder(RemoteNodeDescriptors base) {
        this._areaId = base.getAreaId();
        this._asNumber = base.getAsNumber();
        this._cRouterIdentifier = base.getCRouterIdentifier();
        this._domainId = base.getDomainId();
        if (base instanceof RemoteNodeDescriptorsImpl) {
            RemoteNodeDescriptorsImpl _impl = (RemoteNodeDescriptorsImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier) {
            this._asNumber = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier)arg).getAsNumber();
            this._areaId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier)arg).getAreaId();
            this._domainId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier)arg).getDomainId();
            this._cRouterIdentifier = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier)arg).getCRouterIdentifier();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier] \n" +
              "but was: " + arg
            );
        }
    }

    public AreaIdentifier getAreaId() {
        return _areaId;
    }
    
    public AsNumber getAsNumber() {
        return _asNumber;
    }
    
    public CRouterIdentifier getCRouterIdentifier() {
        return _cRouterIdentifier;
    }
    
    public DomainIdentifier getDomainId() {
        return _domainId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public RemoteNodeDescriptorsBuilder setAreaId(AreaIdentifier value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _areaId_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _areaId_range));
            }
        }
        this._areaId = value;
        return this;
    }
    public static List<Range<BigInteger>> _areaId_range() {
        if (_areaId_range == null) {
            synchronized (RemoteNodeDescriptorsBuilder.class) {
                if (_areaId_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _areaId_range = builder.build();
                }
            }
        }
        return _areaId_range;
    }
    
    public RemoteNodeDescriptorsBuilder setAsNumber(AsNumber value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _asNumber_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _asNumber_range));
            }
        }
        this._asNumber = value;
        return this;
    }
    public static List<Range<BigInteger>> _asNumber_range() {
        if (_asNumber_range == null) {
            synchronized (RemoteNodeDescriptorsBuilder.class) {
                if (_asNumber_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _asNumber_range = builder.build();
                }
            }
        }
        return _asNumber_range;
    }
    
    public RemoteNodeDescriptorsBuilder setCRouterIdentifier(CRouterIdentifier value) {
        this._cRouterIdentifier = value;
        return this;
    }
    
    public RemoteNodeDescriptorsBuilder setDomainId(DomainIdentifier value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _domainId_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _domainId_range));
            }
        }
        this._domainId = value;
        return this;
    }
    public static List<Range<BigInteger>> _domainId_range() {
        if (_domainId_range == null) {
            synchronized (RemoteNodeDescriptorsBuilder.class) {
                if (_domainId_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _domainId_range = builder.build();
                }
            }
        }
        return _domainId_range;
    }
    
    public RemoteNodeDescriptorsBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public RemoteNodeDescriptors build() {
        return new RemoteNodeDescriptorsImpl(this);
    }

    private static final class RemoteNodeDescriptorsImpl implements RemoteNodeDescriptors {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors.class;
        }

        private final AreaIdentifier _areaId;
        private final AsNumber _asNumber;
        private final CRouterIdentifier _cRouterIdentifier;
        private final DomainIdentifier _domainId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> augmentation = new HashMap<>();

        private RemoteNodeDescriptorsImpl(RemoteNodeDescriptorsBuilder base) {
            this._areaId = base.getAreaId();
            this._asNumber = base.getAsNumber();
            this._cRouterIdentifier = base.getCRouterIdentifier();
            this._domainId = base.getDomainId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public AreaIdentifier getAreaId() {
            return _areaId;
        }
        
        @Override
        public AsNumber getAsNumber() {
            return _asNumber;
        }
        
        @Override
        public CRouterIdentifier getCRouterIdentifier() {
            return _cRouterIdentifier;
        }
        
        @Override
        public DomainIdentifier getDomainId() {
            return _domainId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_areaId == null) ? 0 : _areaId.hashCode());
            result = prime * result + ((_asNumber == null) ? 0 : _asNumber.hashCode());
            result = prime * result + ((_cRouterIdentifier == null) ? 0 : _cRouterIdentifier.hashCode());
            result = prime * result + ((_domainId == null) ? 0 : _domainId.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors)obj;
            if (_areaId == null) {
                if (other.getAreaId() != null) {
                    return false;
                }
            } else if(!_areaId.equals(other.getAreaId())) {
                return false;
            }
            if (_asNumber == null) {
                if (other.getAsNumber() != null) {
                    return false;
                }
            } else if(!_asNumber.equals(other.getAsNumber())) {
                return false;
            }
            if (_cRouterIdentifier == null) {
                if (other.getCRouterIdentifier() != null) {
                    return false;
                }
            } else if(!_cRouterIdentifier.equals(other.getCRouterIdentifier())) {
                return false;
            }
            if (_domainId == null) {
                if (other.getDomainId() != null) {
                    return false;
                }
            } else if(!_domainId.equals(other.getDomainId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RemoteNodeDescriptorsImpl otherImpl = (RemoteNodeDescriptorsImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RemoteNodeDescriptors [");
            boolean first = true;
        
            if (_areaId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_areaId=");
                builder.append(_areaId);
             }
            if (_asNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_asNumber=");
                builder.append(_asNumber);
             }
            if (_cRouterIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_cRouterIdentifier=");
                builder.append(_cRouterIdentifier);
             }
            if (_domainId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_domainId=");
                builder.append(_domainId);
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
