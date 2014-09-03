package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth;


public class UnreservedBandwidthKey
 implements Identifier<UnreservedBandwidth> {
    private static final long serialVersionUID = -3909703380187695318L; 
    final private java.lang.Short _priority;
    
    public UnreservedBandwidthKey(java.lang.Short _priority) {
        this._priority = _priority;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public UnreservedBandwidthKey(UnreservedBandwidthKey source) {
        this._priority = source._priority;
    }


    public java.lang.Short getPriority() {
        return _priority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_priority == null) ? 0 : _priority.hashCode());
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
        UnreservedBandwidthKey other = (UnreservedBandwidthKey) obj;
        if (_priority == null) {
            if (other._priority != null) {
                return false;
            }
        } else if(!_priority.equals(other._priority)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_priority != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_priority=");
            builder.append(_priority);
         }
        return builder.append(']').toString();
    }



}
