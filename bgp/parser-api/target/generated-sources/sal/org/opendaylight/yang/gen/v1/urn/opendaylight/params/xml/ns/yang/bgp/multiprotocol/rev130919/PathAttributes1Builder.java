package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpReachNlri;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1
 */
public class PathAttributes1Builder {

    private MpReachNlri _mpReachNlri;


    public PathAttributes1Builder() {
    } 

    public PathAttributes1Builder(PathAttributes1 base) {
        this._mpReachNlri = base.getMpReachNlri();
    }


    public MpReachNlri getMpReachNlri() {
        return _mpReachNlri;
    }

    public PathAttributes1Builder setMpReachNlri(MpReachNlri value) {
        this._mpReachNlri = value;
        return this;
    }

    public PathAttributes1 build() {
        return new PathAttributes1Impl(this);
    }

    private static final class PathAttributes1Impl implements PathAttributes1 {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1.class;
        }

        private final MpReachNlri _mpReachNlri;


        private PathAttributes1Impl(PathAttributes1Builder base) {
            this._mpReachNlri = base.getMpReachNlri();
        }

        @Override
        public MpReachNlri getMpReachNlri() {
            return _mpReachNlri;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_mpReachNlri == null) ? 0 : _mpReachNlri.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1 other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1)obj;
            if (_mpReachNlri == null) {
                if (other.getMpReachNlri() != null) {
                    return false;
                }
            } else if(!_mpReachNlri.equals(other.getMpReachNlri())) {
                return false;
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PathAttributes1 [");
            boolean first = true;
        
            if (_mpReachNlri != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_mpReachNlri=");
                builder.append(_mpReachNlri);
             }
            return builder.append(']').toString();
        }
    }

}
