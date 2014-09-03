package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import java.io.Serializable;
import java.util.List;
import com.google.common.collect.Lists;


/**
 * The bits built-in type represents a bit set.  That is, a bits value is a set of flags identified by small integer position numbers starting at 0.  Each bit number has an assigned name.
 */
public class NodeFlagBits
 implements Serializable {
    private static final long serialVersionUID = 1289247311861661989L; 
    final private java.lang.Boolean _overload;
    final private java.lang.Boolean _attached;
    final private java.lang.Boolean _external;
    final private java.lang.Boolean _abr;
    
    public NodeFlagBits(java.lang.Boolean _abr, java.lang.Boolean _attached, java.lang.Boolean _external, java.lang.Boolean _overload) {
        this._overload = _overload;
        this._attached = _attached;
        this._external = _external;
        this._abr = _abr;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public NodeFlagBits(NodeFlagBits source) {
        this._overload = source._overload;
        this._attached = source._attached;
        this._external = source._external;
        this._abr = source._abr;
    }

    public static NodeFlagBits getDefaultInstance(String defaultValue) {
        List<java.lang.String> properties = Lists.newArrayList("abr",
        "attached",
        "external",
        "overload"
        );
        if (!properties.contains(defaultValue)) {
            throw new java.lang.IllegalArgumentException("invalid default parameter");
        }
        int i = 0;
        return new NodeFlagBits(
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null,
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null,
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null,
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null
        );
    }

    public java.lang.Boolean isOverload() {
        return _overload;
    }
    
    public java.lang.Boolean isAttached() {
        return _attached;
    }
    
    public java.lang.Boolean isExternal() {
        return _external;
    }
    
    public java.lang.Boolean isAbr() {
        return _abr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_overload == null) ? 0 : _overload.hashCode());
        result = prime * result + ((_attached == null) ? 0 : _attached.hashCode());
        result = prime * result + ((_external == null) ? 0 : _external.hashCode());
        result = prime * result + ((_abr == null) ? 0 : _abr.hashCode());
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
        NodeFlagBits other = (NodeFlagBits) obj;
        if (_overload == null) {
            if (other._overload != null) {
                return false;
            }
        } else if(!_overload.equals(other._overload)) {
            return false;
        }
        if (_attached == null) {
            if (other._attached != null) {
                return false;
            }
        } else if(!_attached.equals(other._attached)) {
            return false;
        }
        if (_external == null) {
            if (other._external != null) {
                return false;
            }
        } else if(!_external.equals(other._external)) {
            return false;
        }
        if (_abr == null) {
            if (other._abr != null) {
                return false;
            }
        } else if(!_abr.equals(other._abr)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeFlagBits.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_overload != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_overload=");
            builder.append(_overload);
         }
        if (_attached != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_attached=");
            builder.append(_attached);
         }
        if (_external != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_external=");
            builder.append(_external);
         }
        if (_abr != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_abr=");
            builder.append(_abr);
         }
        return builder.append(']').toString();
    }



}
