package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.3.1">http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.3.1</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)igp-bits/igp-bits]
 */
public interface IgpBits
    extends
    DataObject
{

    /**
     * The bits built-in type represents a bit set. That is, a bits value is a set of 
     * flags identified by small integer position numbers starting at 0. Each bit 
     * number has an assigned name.
     * Reference:
     *     https://tools.ietf.org/html/rfc6020#section-9.7
     * Module name:
     *     bgp-linkstate
     * Schema path:
     *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)igp-bits/igp-bits/up-down/(urn:ietf:params:xml:ns:yang:1)bits]
     */
    public static final class UpDown
     {
        final private java.lang.Boolean _upDown;
    
        public UpDown(java.lang.Boolean _upDown) {
            this._upDown = _upDown;
        }
        /**
         * Creates a copy from Source Object.
         *
         * @param source Source object
         */
        public UpDown(UpDown source) {
            this._upDown = source._upDown;
        }
        
    
        public java.lang.Boolean isUpDown() {
            return _upDown;
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_upDown == null) ? 0 : _upDown.hashCode());
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
            UpDown other = (UpDown) obj;
            if (_upDown == null) {
                if (other._upDown != null) {
                    return false;
                }
            } else if(!_upDown.equals(other._upDown)) {
                return false;
            }
            return true;
        }
    
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder("UpDown [");
            boolean first = true;
        
            if (_upDown != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_upDown=");
                builder.append(_upDown);
             }
            return builder.append(']').toString();
        }
    
    
    
    }
    


    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","igp-bits");;

    UpDown getUpDown();

}

