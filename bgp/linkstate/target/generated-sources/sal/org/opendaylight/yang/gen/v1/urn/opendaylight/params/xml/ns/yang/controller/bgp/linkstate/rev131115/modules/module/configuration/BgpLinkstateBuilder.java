package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate
 */
public class BgpLinkstateBuilder {

    private java.lang.Boolean _ianaLinkstateAttributeType;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> augmentation = new HashMap<>();

    public BgpLinkstateBuilder() {
    } 
    

    public BgpLinkstateBuilder(BgpLinkstate base) {
        this._ianaLinkstateAttributeType = base.isIanaLinkstateAttributeType();
        if (base instanceof BgpLinkstateImpl) {
            BgpLinkstateImpl _impl = (BgpLinkstateImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public java.lang.Boolean isIanaLinkstateAttributeType() {
        return _ianaLinkstateAttributeType;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpLinkstateBuilder setIanaLinkstateAttributeType(java.lang.Boolean value) {
        this._ianaLinkstateAttributeType = value;
        return this;
    }
    
    public BgpLinkstateBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpLinkstate build() {
        return new BgpLinkstateImpl(this);
    }

    private static final class BgpLinkstateImpl implements BgpLinkstate {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate.class;
        }

        private final java.lang.Boolean _ianaLinkstateAttributeType;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> augmentation = new HashMap<>();

        private BgpLinkstateImpl(BgpLinkstateBuilder base) {
            this._ianaLinkstateAttributeType = base.isIanaLinkstateAttributeType();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public java.lang.Boolean isIanaLinkstateAttributeType() {
            return _ianaLinkstateAttributeType;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_ianaLinkstateAttributeType == null) ? 0 : _ianaLinkstateAttributeType.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate)obj;
            if (_ianaLinkstateAttributeType == null) {
                if (other.isIanaLinkstateAttributeType() != null) {
                    return false;
                }
            } else if(!_ianaLinkstateAttributeType.equals(other.isIanaLinkstateAttributeType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpLinkstateImpl otherImpl = (BgpLinkstateImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpLinkstate [");
            boolean first = true;
        
            if (_ianaLinkstateAttributeType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ianaLinkstateAttributeType=");
                builder.append(_ianaLinkstateAttributeType);
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
