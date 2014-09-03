package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * container graceful-restart-capability {
 *     leaf restart-flags {
 *         type bits;
 *     }
 *     leaf restart-time {
 *         type uint16;
 *     }
 *     list tables {
 *         key "afi" 
 *     "safi"
 *         leaf afi {
 *             type identityref;
 *         }
 *         leaf safi {
 *             type identityref;
 *         }
 *         leaf afi-flags {
 *             type bits;
 *         }
 *         uses bgp-table-type;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/open/bgp-parameters/c-parameters/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)graceful-restart-case/graceful-restart-capability</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapabilityBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapabilityBuilder
 */
public interface GracefulRestartCapability
    extends
    ChildOf<BgpParameters>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>
{

    /**
     * The bits built-in type represents a bit set.  That is, a bits value is a set of flags identified by small integer position numbers starting at 0.  Each bit number has an assigned name.
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability.RestartFlags.class.getSimpleName()).append(" [");
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

