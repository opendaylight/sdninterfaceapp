package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Arrays;


public class LinkstateRouteKey
 implements Identifier<LinkstateRoute> {
    private static final long serialVersionUID = -3176362559430158355L; 
    final private byte[] _routeKey;
    
    public LinkstateRouteKey(byte[] _routeKey) {
        this._routeKey = _routeKey;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public LinkstateRouteKey(LinkstateRouteKey source) {
        this._routeKey = source._routeKey;
    }


    public byte[] getRouteKey() {
        return _routeKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_routeKey == null) ? 0 : Arrays.hashCode(_routeKey));
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
        LinkstateRouteKey other = (LinkstateRouteKey) obj;
        if (_routeKey == null) {
            if (other._routeKey != null) {
                return false;
            }
        } else if(!Arrays.equals(_routeKey, other._routeKey)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_routeKey != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_routeKey=");
            builder.append(Arrays.toString(_routeKey));
         }
        return builder.append(']').toString();
    }



}
