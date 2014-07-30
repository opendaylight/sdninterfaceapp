package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv4.routes._case.ipv4.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv4.routes._case.ipv4.routes.Ipv4Route;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yangtools.yang.binding.Identifier;


public class Ipv4RouteKey
 implements Identifier<Ipv4Route> {
    private static final long serialVersionUID = -8880790420965273375L; 
    final private Ipv4Prefix _prefix;

    public Ipv4RouteKey(Ipv4Prefix _prefix) {
        this._prefix = _prefix;
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv4RouteKey(Ipv4RouteKey source) {
        this._prefix = source._prefix;
    }
    

    public Ipv4Prefix getPrefix() {
        return _prefix;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_prefix == null) ? 0 : _prefix.hashCode());
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
        Ipv4RouteKey other = (Ipv4RouteKey) obj;
        if (_prefix == null) {
            if (other._prefix != null) {
                return false;
            }
        } else if(!_prefix.equals(other._prefix)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder("Ipv4RouteKey [");
        boolean first = true;
    
        if (_prefix != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_prefix=");
            builder.append(_prefix);
         }
        return builder.append(']').toString();
    }



}
