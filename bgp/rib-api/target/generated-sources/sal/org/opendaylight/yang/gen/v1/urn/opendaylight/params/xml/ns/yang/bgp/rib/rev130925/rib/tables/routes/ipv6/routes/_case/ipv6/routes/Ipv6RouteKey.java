package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.tables.routes.ipv6.routes._case.ipv6.routes.Ipv6Route;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv6Prefix;


public class Ipv6RouteKey
 implements Identifier<Ipv6Route> {
    private static final long serialVersionUID = -8458276265334190707L; 
    final private Ipv6Prefix _prefix;

    public Ipv6RouteKey(Ipv6Prefix _prefix) {
        this._prefix = _prefix;
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv6RouteKey(Ipv6RouteKey source) {
        this._prefix = source._prefix;
    }
    

    public Ipv6Prefix getPrefix() {
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
        Ipv6RouteKey other = (Ipv6RouteKey) obj;
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
        java.lang.StringBuilder builder = new java.lang.StringBuilder("Ipv6RouteKey [");
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
