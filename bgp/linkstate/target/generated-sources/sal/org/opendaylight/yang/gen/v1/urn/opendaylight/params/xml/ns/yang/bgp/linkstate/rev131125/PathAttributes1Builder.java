package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttribute;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1
 */
public class PathAttributes1Builder {

    private LinkstatePathAttribute _linkstatePathAttribute;


    public PathAttributes1Builder() {
    } 

    public PathAttributes1Builder(PathAttributes1 base) {
        this._linkstatePathAttribute = base.getLinkstatePathAttribute();
    }


    public LinkstatePathAttribute getLinkstatePathAttribute() {
        return _linkstatePathAttribute;
    }

    public PathAttributes1Builder setLinkstatePathAttribute(LinkstatePathAttribute value) {
        this._linkstatePathAttribute = value;
        return this;
    }

    public PathAttributes1 build() {
        return new PathAttributes1Impl(this);
    }

    private static final class PathAttributes1Impl implements PathAttributes1 {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1.class;
        }

        private final LinkstatePathAttribute _linkstatePathAttribute;


        private PathAttributes1Impl(PathAttributes1Builder base) {
            this._linkstatePathAttribute = base.getLinkstatePathAttribute();
        }

        @Override
        public LinkstatePathAttribute getLinkstatePathAttribute() {
            return _linkstatePathAttribute;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_linkstatePathAttribute == null) ? 0 : _linkstatePathAttribute.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1 other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1)obj;
            if (_linkstatePathAttribute == null) {
                if (other.getLinkstatePathAttribute() != null) {
                    return false;
                }
            } else if(!_linkstatePathAttribute.equals(other.getLinkstatePathAttribute())) {
                return false;
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PathAttributes1 [");
            boolean first = true;
        
            if (_linkstatePathAttribute != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkstatePathAttribute=");
                builder.append(_linkstatePathAttribute);
             }
            return builder.append(']').toString();
        }
    }

}
