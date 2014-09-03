package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.route.Attributes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6RouteKey;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv6Prefix;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route
 */
public class Ipv6RouteBuilder {

    private Attributes _attributes;
    private Ipv6RouteKey _key;
    private Ipv6Prefix _prefix;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> augmentation = new HashMap<>();

    public Ipv6RouteBuilder() {
    } 
    
    public Ipv6RouteBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route arg) {
        this._attributes = arg.getAttributes();
    }

    public Ipv6RouteBuilder(Ipv6Route base) {
        if (base.getKey() == null) {
            this._key = new Ipv6RouteKey(
                base.getPrefix()
            );
            this._prefix = base.getPrefix();
        } else {
            this._key = base.getKey();
            this._prefix = _key.getPrefix();
        }
        this._attributes = base.getAttributes();
        if (base instanceof Ipv6RouteImpl) {
            Ipv6RouteImpl _impl = (Ipv6RouteImpl) base;
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
    
    public Ipv6RouteKey getKey() {
        return _key;
    }
    
    public Ipv6Prefix getPrefix() {
        return _prefix;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public Ipv6RouteBuilder setAttributes(Attributes value) {
        this._attributes = value;
        return this;
    }
    
    public Ipv6RouteBuilder setKey(Ipv6RouteKey value) {
        this._key = value;
        return this;
    }
    
    public Ipv6RouteBuilder setPrefix(Ipv6Prefix value) {
        this._prefix = value;
        return this;
    }
    
    public Ipv6RouteBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public Ipv6Route build() {
        return new Ipv6RouteImpl(this);
    }

    private static final class Ipv6RouteImpl implements Ipv6Route {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route.class;
        }

        private final Attributes _attributes;
        private final Ipv6RouteKey _key;
        private final Ipv6Prefix _prefix;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> augmentation = new HashMap<>();

        private Ipv6RouteImpl(Ipv6RouteBuilder base) {
            if (base.getKey() == null) {
                this._key = new Ipv6RouteKey(
                    base.getPrefix()
                );
                this._prefix = base.getPrefix();
            } else {
                this._key = base.getKey();
                this._prefix = _key.getPrefix();
            }
            this._attributes = base.getAttributes();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>singletonMap(e.getKey(), e.getValue());       
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
        public Ipv6RouteKey getKey() {
            return _key;
        }
        
        @Override
        public Ipv6Prefix getPrefix() {
            return _prefix;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_prefix == null) ? 0 : _prefix.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route)obj;
            if (_attributes == null) {
                if (other.getAttributes() != null) {
                    return false;
                }
            } else if(!_attributes.equals(other.getAttributes())) {
                return false;
            }
            if (_key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if(!_key.equals(other.getKey())) {
                return false;
            }
            if (_prefix == null) {
                if (other.getPrefix() != null) {
                    return false;
                }
            } else if(!_prefix.equals(other.getPrefix())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                Ipv6RouteImpl otherImpl = (Ipv6RouteImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Ipv6Route [");
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
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_prefix != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_prefix=");
                builder.append(_prefix);
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
