package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.opaque.extended.community._case.OpaqueExtendedCommunity;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase
 */
public class OpaqueExtendedCommunityCaseBuilder {

    private OpaqueExtendedCommunity _opaqueExtendedCommunity;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> augmentation = new HashMap<>();

    public OpaqueExtendedCommunityCaseBuilder() {
    } 
    

    public OpaqueExtendedCommunityCaseBuilder(OpaqueExtendedCommunityCase base) {
        this._opaqueExtendedCommunity = base.getOpaqueExtendedCommunity();
        if (base instanceof OpaqueExtendedCommunityCaseImpl) {
            OpaqueExtendedCommunityCaseImpl _impl = (OpaqueExtendedCommunityCaseImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public OpaqueExtendedCommunity getOpaqueExtendedCommunity() {
        return _opaqueExtendedCommunity;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public OpaqueExtendedCommunityCaseBuilder setOpaqueExtendedCommunity(OpaqueExtendedCommunity value) {
        this._opaqueExtendedCommunity = value;
        return this;
    }
    
    public OpaqueExtendedCommunityCaseBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public OpaqueExtendedCommunityCase build() {
        return new OpaqueExtendedCommunityCaseImpl(this);
    }

    private static final class OpaqueExtendedCommunityCaseImpl implements OpaqueExtendedCommunityCase {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase.class;
        }

        private final OpaqueExtendedCommunity _opaqueExtendedCommunity;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> augmentation = new HashMap<>();

        private OpaqueExtendedCommunityCaseImpl(OpaqueExtendedCommunityCaseBuilder base) {
            this._opaqueExtendedCommunity = base.getOpaqueExtendedCommunity();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public OpaqueExtendedCommunity getOpaqueExtendedCommunity() {
            return _opaqueExtendedCommunity;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_opaqueExtendedCommunity == null) ? 0 : _opaqueExtendedCommunity.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase)obj;
            if (_opaqueExtendedCommunity == null) {
                if (other.getOpaqueExtendedCommunity() != null) {
                    return false;
                }
            } else if(!_opaqueExtendedCommunity.equals(other.getOpaqueExtendedCommunity())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                OpaqueExtendedCommunityCaseImpl otherImpl = (OpaqueExtendedCommunityCaseImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.OpaqueExtendedCommunityCase>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("OpaqueExtendedCommunityCase [");
            boolean first = true;
        
            if (_opaqueExtendedCommunity != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_opaqueExtendedCommunity=");
                builder.append(_opaqueExtendedCommunity);
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
