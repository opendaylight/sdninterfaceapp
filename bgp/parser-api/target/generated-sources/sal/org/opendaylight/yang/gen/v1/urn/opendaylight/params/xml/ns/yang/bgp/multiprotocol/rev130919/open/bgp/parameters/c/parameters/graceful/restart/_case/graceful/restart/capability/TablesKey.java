package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables;
import org.opendaylight.yangtools.yang.binding.Identifier;


public class TablesKey
 implements Identifier<Tables> {
    private static final long serialVersionUID = 7040661022102848903L; 
    final private java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AddressFamily> _afi;
    final private java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.SubsequentAddressFamily> _safi;
    
    public TablesKey(java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AddressFamily> _afi, java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.SubsequentAddressFamily> _safi) {
        this._afi = _afi;
        this._safi = _safi;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public TablesKey(TablesKey source) {
        this._afi = source._afi;
        this._safi = source._safi;
    }


    public java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AddressFamily> getAfi() {
        return _afi;
    }
    
    public java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.SubsequentAddressFamily> getSafi() {
        return _safi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_afi == null) ? 0 : _afi.hashCode());
        result = prime * result + ((_safi == null) ? 0 : _safi.hashCode());
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
        TablesKey other = (TablesKey) obj;
        if (_afi == null) {
            if (other._afi != null) {
                return false;
            }
        } else if(!_afi.equals(other._afi)) {
            return false;
        }
        if (_safi == null) {
            if (other._safi != null) {
                return false;
            }
        } else if(!_safi.equals(other._safi)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.TablesKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_afi != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_afi=");
            builder.append(_afi);
         }
        if (_safi != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_safi=");
            builder.append(_safi);
         }
        return builder.append(']').toString();
    }



}
