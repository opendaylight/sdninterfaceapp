package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.LinkstateRoutes;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-rib?revision=2013-09-25)bgp-rib/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case]
 */
public class LinkstateRoutesCaseBuilder {

    private LinkstateRoutes _linkstateRoutes;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> augmentation = new HashMap<>();

    public LinkstateRoutesCaseBuilder() {
    } 
    

    public LinkstateRoutesCaseBuilder(LinkstateRoutesCase base) {
        this._linkstateRoutes = base.getLinkstateRoutes();
        if (base instanceof LinkstateRoutesCaseImpl) {
            LinkstateRoutesCaseImpl _impl = (LinkstateRoutesCaseImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public LinkstateRoutes getLinkstateRoutes() {
        return _linkstateRoutes;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public LinkstateRoutesCaseBuilder setLinkstateRoutes(LinkstateRoutes value) {
        this._linkstateRoutes = value;
        return this;
    }
    
    public LinkstateRoutesCaseBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public LinkstateRoutesCase build() {
        return new LinkstateRoutesCaseImpl(this);
    }

    private static final class LinkstateRoutesCaseImpl implements LinkstateRoutesCase {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase.class;
        }

        private final LinkstateRoutes _linkstateRoutes;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> augmentation = new HashMap<>();

        private LinkstateRoutesCaseImpl(LinkstateRoutesCaseBuilder base) {
            this._linkstateRoutes = base.getLinkstateRoutes();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public LinkstateRoutes getLinkstateRoutes() {
            return _linkstateRoutes;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.LinkstateRoutesCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_linkstateRoutes == null) ? 0 : _linkstateRoutes.hashCode());
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
            LinkstateRoutesCaseImpl other = (LinkstateRoutesCaseImpl) obj;
            if (_linkstateRoutes == null) {
                if (other._linkstateRoutes != null) {
                    return false;
                }
            } else if(!_linkstateRoutes.equals(other._linkstateRoutes)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("LinkstateRoutesCase [");
            boolean first = true;
        
            if (_linkstateRoutes != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkstateRoutes=");
                builder.append(_linkstateRoutes);
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
