package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl.Extension;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     config-bgp-rib-spi
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)modules/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:spi?revision=2013-11-15)bgp-rib-extensions-impl]
 */
public class BgpRibExtensionsImplBuilder {

    private List<Extension> _extension;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> augmentation = new HashMap<>();

    public BgpRibExtensionsImplBuilder() {
    } 
    

    public BgpRibExtensionsImplBuilder(BgpRibExtensionsImpl base) {
        this._extension = base.getExtension();
        if (base instanceof BgpRibExtensionsImplImpl) {
            BgpRibExtensionsImplImpl _impl = (BgpRibExtensionsImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public List<Extension> getExtension() {
        return _extension;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpRibExtensionsImplBuilder setExtension(List<Extension> value) {
        this._extension = value;
        return this;
    }
    
    public BgpRibExtensionsImplBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpRibExtensionsImpl build() {
        return new BgpRibExtensionsImplImpl(this);
    }

    private static final class BgpRibExtensionsImplImpl implements BgpRibExtensionsImpl {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl.class;
        }

        private final List<Extension> _extension;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> augmentation = new HashMap<>();

        private BgpRibExtensionsImplImpl(BgpRibExtensionsImplBuilder base) {
            this._extension = base.getExtension();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>>singletonMap(e.getKey(), e.getValue());       
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
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.BgpRibExtensionsImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            BgpRibExtensionsImplImpl other = (BgpRibExtensionsImplImpl) obj;
            if (_extension == null) {
                if (other._extension != null) {
                    return false;
                }
            } else if(!_extension.equals(other._extension)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpRibExtensionsImpl [");
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
