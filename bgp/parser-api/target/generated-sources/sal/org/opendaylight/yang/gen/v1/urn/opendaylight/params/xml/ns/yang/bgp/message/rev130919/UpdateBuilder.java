package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.Nlri;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.WithdrawnRoutes;


/**
 * Update Message
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc4271#section-4.3">http://tools.ietf.org/html/rfc4271#section-4.3</a>
 * Module name:
 *     bgp-message
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)update/update]
 */
public class UpdateBuilder {

    private PathAttributes _pathAttributes;
    private WithdrawnRoutes _withdrawnRoutes;
    private Nlri _nlri;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> augmentation = new HashMap<>();

    public UpdateBuilder() {
    } 

    public UpdateBuilder(Update base) {
        this._pathAttributes = base.getPathAttributes();
        this._withdrawnRoutes = base.getWithdrawnRoutes();
        this._nlri = base.getNlri();
        if (base instanceof UpdateImpl) {
            UpdateImpl _impl = (UpdateImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public PathAttributes getPathAttributes() {
        return _pathAttributes;
    }
    
    public WithdrawnRoutes getWithdrawnRoutes() {
        return _withdrawnRoutes;
    }
    
    public Nlri getNlri() {
        return _nlri;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public UpdateBuilder setPathAttributes(PathAttributes value) {
        this._pathAttributes = value;
        return this;
    }
    
    public UpdateBuilder setWithdrawnRoutes(WithdrawnRoutes value) {
        this._withdrawnRoutes = value;
        return this;
    }
    
    public UpdateBuilder setNlri(Nlri value) {
        this._nlri = value;
        return this;
    }
    
    public UpdateBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public Update build() {
        return new UpdateImpl(this);
    }

    private static final class UpdateImpl implements Update {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update.class;
        }

        private final PathAttributes _pathAttributes;
        private final WithdrawnRoutes _withdrawnRoutes;
        private final Nlri _nlri;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> augmentation = new HashMap<>();

        private UpdateImpl(UpdateBuilder base) {
            this._pathAttributes = base.getPathAttributes();
            this._withdrawnRoutes = base.getWithdrawnRoutes();
            this._nlri = base.getNlri();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public PathAttributes getPathAttributes() {
            return _pathAttributes;
        }
        
        @Override
        public WithdrawnRoutes getWithdrawnRoutes() {
            return _withdrawnRoutes;
        }
        
        @Override
        public Nlri getNlri() {
            return _nlri;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_pathAttributes == null) ? 0 : _pathAttributes.hashCode());
            result = prime * result + ((_withdrawnRoutes == null) ? 0 : _withdrawnRoutes.hashCode());
            result = prime * result + ((_nlri == null) ? 0 : _nlri.hashCode());
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
            UpdateImpl other = (UpdateImpl) obj;
            if (_pathAttributes == null) {
                if (other._pathAttributes != null) {
                    return false;
                }
            } else if(!_pathAttributes.equals(other._pathAttributes)) {
                return false;
            }
            if (_withdrawnRoutes == null) {
                if (other._withdrawnRoutes != null) {
                    return false;
                }
            } else if(!_withdrawnRoutes.equals(other._withdrawnRoutes)) {
                return false;
            }
            if (_nlri == null) {
                if (other._nlri != null) {
                    return false;
                }
            } else if(!_nlri.equals(other._nlri)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Update [");
            boolean first = true;
        
            if (_pathAttributes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_pathAttributes=");
                builder.append(_pathAttributes);
             }
            if (_withdrawnRoutes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_withdrawnRoutes=");
                builder.append(_withdrawnRoutes);
             }
            if (_nlri != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nlri=");
                builder.append(_nlri);
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
