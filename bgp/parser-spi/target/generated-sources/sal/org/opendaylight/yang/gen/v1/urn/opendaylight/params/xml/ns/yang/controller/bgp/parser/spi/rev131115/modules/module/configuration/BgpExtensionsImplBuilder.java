package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.bgp.extensions.impl.Extension;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl
 */
public class BgpExtensionsImplBuilder {

    private List<Extension> _extension;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> augmentation = new HashMap<>();

    public BgpExtensionsImplBuilder() {
    } 
    

    public BgpExtensionsImplBuilder(BgpExtensionsImpl base) {
        this._extension = base.getExtension();
        if (base instanceof BgpExtensionsImplImpl) {
            BgpExtensionsImplImpl _impl = (BgpExtensionsImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public List<Extension> getExtension() {
        return _extension;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpExtensionsImplBuilder setExtension(List<Extension> value) {
        this._extension = value;
        return this;
    }
    
    public BgpExtensionsImplBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpExtensionsImpl build() {
        return new BgpExtensionsImplImpl(this);
    }

    private static final class BgpExtensionsImplImpl implements BgpExtensionsImpl {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl.class;
        }

        private final List<Extension> _extension;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> augmentation = new HashMap<>();

        private BgpExtensionsImplImpl(BgpExtensionsImplBuilder base) {
            this._extension = base.getExtension();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public List<Extension> getExtension() {
            return _extension;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_extension == null) ? 0 : _extension.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl)obj;
            if (_extension == null) {
                if (other.getExtension() != null) {
                    return false;
                }
            } else if(!_extension.equals(other.getExtension())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpExtensionsImplImpl otherImpl = (BgpExtensionsImplImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.modules.module.configuration.BgpExtensionsImpl>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpExtensionsImpl [");
            boolean first = true;
        
            if (_extension != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extension=");
                builder.append(_extension);
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
