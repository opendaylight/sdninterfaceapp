package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.WithdrawnRoutes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.Nlri;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update
 */
public class UpdateBuilder {

    private Nlri _nlri;
    private PathAttributes _pathAttributes;
    private WithdrawnRoutes _withdrawnRoutes;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> augmentation = new HashMap<>();

    public UpdateBuilder() {
    } 

    public UpdateBuilder(Update base) {
        this._nlri = base.getNlri();
        this._pathAttributes = base.getPathAttributes();
        this._withdrawnRoutes = base.getWithdrawnRoutes();
        if (base instanceof UpdateImpl) {
            UpdateImpl _impl = (UpdateImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public Nlri getNlri() {
        return _nlri;
    }
    
    public PathAttributes getPathAttributes() {
        return _pathAttributes;
    }
    
    public WithdrawnRoutes getWithdrawnRoutes() {
        return _withdrawnRoutes;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public UpdateBuilder setNlri(Nlri value) {
        this._nlri = value;
        return this;
    }
    
    public UpdateBuilder setPathAttributes(PathAttributes value) {
        this._pathAttributes = value;
        return this;
    }
    
    public UpdateBuilder setWithdrawnRoutes(WithdrawnRoutes value) {
        this._withdrawnRoutes = value;
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

        private final Nlri _nlri;
        private final PathAttributes _pathAttributes;
        private final WithdrawnRoutes _withdrawnRoutes;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> augmentation = new HashMap<>();

        private UpdateImpl(UpdateBuilder base) {
            this._nlri = base.getNlri();
            this._pathAttributes = base.getPathAttributes();
            this._withdrawnRoutes = base.getWithdrawnRoutes();
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
        public Nlri getNlri() {
            return _nlri;
        }
        
        @Override
        public PathAttributes getPathAttributes() {
            return _pathAttributes;
        }
        
        @Override
        public WithdrawnRoutes getWithdrawnRoutes() {
            return _withdrawnRoutes;
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
            result = prime * result + ((_nlri == null) ? 0 : _nlri.hashCode());
            result = prime * result + ((_pathAttributes == null) ? 0 : _pathAttributes.hashCode());
            result = prime * result + ((_withdrawnRoutes == null) ? 0 : _withdrawnRoutes.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update)obj;
            if (_nlri == null) {
                if (other.getNlri() != null) {
                    return false;
                }
            } else if(!_nlri.equals(other.getNlri())) {
                return false;
            }
            if (_pathAttributes == null) {
                if (other.getPathAttributes() != null) {
                    return false;
                }
            } else if(!_pathAttributes.equals(other.getPathAttributes())) {
                return false;
            }
            if (_withdrawnRoutes == null) {
                if (other.getWithdrawnRoutes() != null) {
                    return false;
                }
            } else if(!_withdrawnRoutes.equals(other.getWithdrawnRoutes())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                UpdateImpl otherImpl = (UpdateImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Update [");
            boolean first = true;
        
            if (_nlri != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nlri=");
                builder.append(_nlri);
             }
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
