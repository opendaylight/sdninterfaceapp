package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.route.Attributes;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.ProtocolId;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.Arrays;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.RouteDistinguisher;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.ObjectType;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteKey;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Identifier;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute
 */
public class LinkstateRouteBuilder {

    private Attributes _attributes;
    private RouteDistinguisher _distinguisher;
    private static List<Range<BigInteger>> _distinguisher_range;
    private Identifier _identifier;
    private static List<Range<BigInteger>> _identifier_range;
    private LinkstateRouteKey _key;
    private ObjectType _objectType;
    private ProtocolId _protocolId;
    private byte[] _routeKey;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> augmentation = new HashMap<>();

    public LinkstateRouteBuilder() {
    } 
    
    public LinkstateRouteBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route arg) {
        this._attributes = arg.getAttributes();
    }

    public LinkstateRouteBuilder(LinkstateRoute base) {
        if (base.getKey() == null) {
            this._key = new LinkstateRouteKey(
                base.getRouteKey()
            );
            this._routeKey = base.getRouteKey();
        } else {
            this._key = base.getKey();
            this._routeKey = _key.getRouteKey();
        }
        this._attributes = base.getAttributes();
        this._distinguisher = base.getDistinguisher();
        this._identifier = base.getIdentifier();
        this._objectType = base.getObjectType();
        this._protocolId = base.getProtocolId();
        if (base instanceof LinkstateRouteImpl) {
            LinkstateRouteImpl _impl = (LinkstateRouteImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route) {
            this._attributes = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route)arg).getAttributes();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route] \n" +
              "but was: " + arg
            );
        }
    }

    public Attributes getAttributes() {
        return _attributes;
    }
    
    public RouteDistinguisher getDistinguisher() {
        return _distinguisher;
    }
    
    public Identifier getIdentifier() {
        return _identifier;
    }
    
    public LinkstateRouteKey getKey() {
        return _key;
    }
    
    public ObjectType getObjectType() {
        return _objectType;
    }
    
    public ProtocolId getProtocolId() {
        return _protocolId;
    }
    
    public byte[] getRouteKey() {
        return _routeKey;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public LinkstateRouteBuilder setAttributes(Attributes value) {
        this._attributes = value;
        return this;
    }
    
    public LinkstateRouteBuilder setDistinguisher(RouteDistinguisher value) {
        if (value != null) {
            BigInteger _constraint = value.getValue();
            boolean isValidRange = false;
            for (Range<BigInteger> r : _distinguisher_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _distinguisher_range));
            }
        }
        this._distinguisher = value;
        return this;
    }
    public static List<Range<BigInteger>> _distinguisher_range() {
        if (_distinguisher_range == null) {
            synchronized (LinkstateRouteBuilder.class) {
                if (_distinguisher_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
                    _distinguisher_range = builder.build();
                }
            }
        }
        return _distinguisher_range;
    }
    
    public LinkstateRouteBuilder setIdentifier(Identifier value) {
        if (value != null) {
            BigInteger _constraint = value.getValue();
            boolean isValidRange = false;
            for (Range<BigInteger> r : _identifier_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _identifier_range));
            }
        }
        this._identifier = value;
        return this;
    }
    public static List<Range<BigInteger>> _identifier_range() {
        if (_identifier_range == null) {
            synchronized (LinkstateRouteBuilder.class) {
                if (_identifier_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
                    _identifier_range = builder.build();
                }
            }
        }
        return _identifier_range;
    }
    
    public LinkstateRouteBuilder setKey(LinkstateRouteKey value) {
        this._key = value;
        return this;
    }
    
    public LinkstateRouteBuilder setObjectType(ObjectType value) {
        this._objectType = value;
        return this;
    }
    
    public LinkstateRouteBuilder setProtocolId(ProtocolId value) {
        this._protocolId = value;
        return this;
    }
    
    public LinkstateRouteBuilder setRouteKey(byte[] value) {
        this._routeKey = value;
        return this;
    }
    
    public LinkstateRouteBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public LinkstateRoute build() {
        return new LinkstateRouteImpl(this);
    }

    private static final class LinkstateRouteImpl implements LinkstateRoute {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute.class;
        }

        private final Attributes _attributes;
        private final RouteDistinguisher _distinguisher;
        private final Identifier _identifier;
        private final LinkstateRouteKey _key;
        private final ObjectType _objectType;
        private final ProtocolId _protocolId;
        private final byte[] _routeKey;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> augmentation = new HashMap<>();

        private LinkstateRouteImpl(LinkstateRouteBuilder base) {
            if (base.getKey() == null) {
                this._key = new LinkstateRouteKey(
                    base.getRouteKey()
                );
                this._routeKey = base.getRouteKey();
            } else {
                this._key = base.getKey();
                this._routeKey = _key.getRouteKey();
            }
            this._attributes = base.getAttributes();
            this._distinguisher = base.getDistinguisher();
            this._identifier = base.getIdentifier();
            this._objectType = base.getObjectType();
            this._protocolId = base.getProtocolId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public Attributes getAttributes() {
            return _attributes;
        }
        
        @Override
        public RouteDistinguisher getDistinguisher() {
            return _distinguisher;
        }
        
        @Override
        public Identifier getIdentifier() {
            return _identifier;
        }
        
        @Override
        public LinkstateRouteKey getKey() {
            return _key;
        }
        
        @Override
        public ObjectType getObjectType() {
            return _objectType;
        }
        
        @Override
        public ProtocolId getProtocolId() {
            return _protocolId;
        }
        
        @Override
        public byte[] getRouteKey() {
            return _routeKey;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_attributes == null) ? 0 : _attributes.hashCode());
            result = prime * result + ((_distinguisher == null) ? 0 : _distinguisher.hashCode());
            result = prime * result + ((_identifier == null) ? 0 : _identifier.hashCode());
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_objectType == null) ? 0 : _objectType.hashCode());
            result = prime * result + ((_protocolId == null) ? 0 : _protocolId.hashCode());
            result = prime * result + ((_routeKey == null) ? 0 : Arrays.hashCode(_routeKey));
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute)obj;
            if (_attributes == null) {
                if (other.getAttributes() != null) {
                    return false;
                }
            } else if(!_attributes.equals(other.getAttributes())) {
                return false;
            }
            if (_distinguisher == null) {
                if (other.getDistinguisher() != null) {
                    return false;
                }
            } else if(!_distinguisher.equals(other.getDistinguisher())) {
                return false;
            }
            if (_identifier == null) {
                if (other.getIdentifier() != null) {
                    return false;
                }
            } else if(!_identifier.equals(other.getIdentifier())) {
                return false;
            }
            if (_key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if(!_key.equals(other.getKey())) {
                return false;
            }
            if (_objectType == null) {
                if (other.getObjectType() != null) {
                    return false;
                }
            } else if(!_objectType.equals(other.getObjectType())) {
                return false;
            }
            if (_protocolId == null) {
                if (other.getProtocolId() != null) {
                    return false;
                }
            } else if(!_protocolId.equals(other.getProtocolId())) {
                return false;
            }
            if (_routeKey == null) {
                if (other.getRouteKey() != null) {
                    return false;
                }
            } else if(!Arrays.equals(_routeKey, other.getRouteKey())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                LinkstateRouteImpl otherImpl = (LinkstateRouteImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("LinkstateRoute [");
            boolean first = true;
        
            if (_attributes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_attributes=");
                builder.append(_attributes);
             }
            if (_distinguisher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_distinguisher=");
                builder.append(_distinguisher);
             }
            if (_identifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identifier=");
                builder.append(_identifier);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_objectType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_objectType=");
                builder.append(_objectType);
             }
            if (_protocolId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocolId=");
                builder.append(_protocolId);
             }
            if (_routeKey != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_routeKey=");
                builder.append(Arrays.toString(_routeKey));
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
