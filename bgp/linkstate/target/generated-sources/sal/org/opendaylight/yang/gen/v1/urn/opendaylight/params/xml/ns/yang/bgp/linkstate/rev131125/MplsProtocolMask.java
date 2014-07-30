package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import java.io.Serializable;
import java.util.List;
import com.google.common.collect.Lists;


/**
 * The bits built-in type represents a bit set. That is, a bits value is a set of 
 * flags identified by small integer position numbers starting at 0. Each bit 
 * number has an assigned name.
 * Reference:
 *     https://tools.ietf.org/html/rfc6020#section-9.7
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)mpls-protocol-mask/mpls-protocol-mask/(urn:ietf:params:xml:ns:yang:1)bits]
 */
public class MplsProtocolMask
 implements Serializable {
    private static final long serialVersionUID = -3533580884068242141L; 
    final private java.lang.Boolean _ldp;
    final private java.lang.Boolean _rsvpte;

    public MplsProtocolMask(java.lang.Boolean _ldp, java.lang.Boolean _rsvpte) {
        this._ldp = _ldp;
        this._rsvpte = _rsvpte;
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public MplsProtocolMask(MplsProtocolMask source) {
        this._ldp = source._ldp;
        this._rsvpte = source._rsvpte;
    }
    
    public static MplsProtocolMask getDefaultInstance(String defaultValue) {
        List<java.lang.String> properties = Lists.newArrayList("ldp",
        "rsvpte"
        );
        if (!properties.contains(defaultValue)) {
            throw new java.lang.IllegalArgumentException("invalid default parameter");
        }
        int i = 0;
        return new MplsProtocolMask(
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null,
        properties.get(i++).equals(defaultValue) ? new java.lang.Boolean("true") : null
        );
    }

    public java.lang.Boolean isLdp() {
        return _ldp;
    }
    
    public java.lang.Boolean isRsvpte() {
        return _rsvpte;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_ldp == null) ? 0 : _ldp.hashCode());
        result = prime * result + ((_rsvpte == null) ? 0 : _rsvpte.hashCode());
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
        MplsProtocolMask other = (MplsProtocolMask) obj;
        if (_ldp == null) {
            if (other._ldp != null) {
                return false;
            }
        } else if(!_ldp.equals(other._ldp)) {
            return false;
        }
        if (_rsvpte == null) {
            if (other._rsvpte != null) {
                return false;
            }
        } else if(!_rsvpte.equals(other._rsvpte)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder("MplsProtocolMask [");
        boolean first = true;
    
        if (_ldp != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_ldp=");
            builder.append(_ldp);
         }
        if (_rsvpte != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_rsvpte=");
            builder.append(_rsvpte);
         }
        return builder.append(']').toString();
    }



}
