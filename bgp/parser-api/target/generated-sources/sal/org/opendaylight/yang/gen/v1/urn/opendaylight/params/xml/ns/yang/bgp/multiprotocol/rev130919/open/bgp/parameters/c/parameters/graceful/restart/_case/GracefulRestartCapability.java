package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc4724#section-3">http://tools.ietf.org/html/rfc4724#section-3</a>
 * Module name:
 *     bgp-multiprotocol
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)open/open/bgp-parameters/c-parameters/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)graceful-restart-case/graceful-restart-capability]
 */
public interface GracefulRestartCapability
    extends
    ChildOf<BgpParameters>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>
{

    /**
     * The bits built-in type represents a bit set. That is, a bits value is a set of 
     * flags identified by small integer position numbers starting at 0. Each bit 
     * number has an assigned name.
     * Reference:
     *     https://tools.ietf.org/html/rfc6020#section-9.7
     * Module name:
     *     bgp-multiprotocol
     * Schema path:
     *     [(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)graceful-restart-case/graceful-restart-case/graceful-restart-capability/restart-flags/(urn:ietf:params:xml:ns:yang:1)bits]
     */
    public static final class RestartFlags
     {
        final private java.lang.Boolean _restartState;
    
        public RestartFlags(java.lang.Boolean _restartState) {
            this._restartState = _restartState;
        }
        /**
         * Creates a copy from Source Object.
         *
         * @param source Source object
         */
        public RestartFlags(RestartFlags source) {
            this._restartState = source._restartState;
        }
        
    
        public java.lang.Boolean isRestartState() {
            return _restartState;
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_restartState == null) ? 0 : _restartState.hashCode());
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
            RestartFlags other = (RestartFlags) obj;
            if (_restartState == null) {
                if (other._restartState != null) {
                    return false;
                }
            } else if(!_restartState.equals(other._restartState)) {
                return false;
            }
            return true;
        }
    
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder("RestartFlags [");
            boolean first = true;
        
            if (_restartState != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_restartState=");
                builder.append(_restartState);
             }
            return builder.append(']').toString();
        }
    
    
    
    }
    


    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","graceful-restart-capability");;

    RestartFlags getRestartFlags();
    
    java.lang.Integer getRestartTime();
    
    List<Tables> getTables();

}

