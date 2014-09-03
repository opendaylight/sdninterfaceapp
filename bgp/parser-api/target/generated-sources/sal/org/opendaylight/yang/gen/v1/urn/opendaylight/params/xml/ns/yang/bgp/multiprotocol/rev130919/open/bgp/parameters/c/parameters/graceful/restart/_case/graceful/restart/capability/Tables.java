package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Identifiable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.TablesKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.BgpTableType;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * list tables {
 *     key "afi" 
 * "safi"
 *     leaf afi {
 *         type identityref;
 *     }
 *     leaf safi {
 *         type identityref;
 *     }
 *     leaf afi-flags {
 *         type bits;
 *     }
 *     uses bgp-table-type;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/open/bgp-parameters/c-parameters/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)graceful-restart-case/graceful-restart-capability/tables</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.TablesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.TablesBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.TablesKey
 */
public interface Tables
    extends
    ChildOf<GracefulRestartCapability>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables>,
    BgpTableType,
    Identifiable<TablesKey>
{

    /**
     * The bits built-in type represents a bit set.  That is, a bits value is a set of flags identified by small integer position numbers starting at 0.  Each bit number has an assigned name.
     */
    public static final class AfiFlags
     {
        final private java.lang.Boolean _forwardingState;
        
        public AfiFlags(java.lang.Boolean _forwardingState) {
            this._forwardingState = _forwardingState;
        }
        
        /**
         * Creates a copy from Source Object.
         *
         * @param source Source object
         */
        public AfiFlags(AfiFlags source) {
            this._forwardingState = source._forwardingState;
        }
    
    
        public java.lang.Boolean isForwardingState() {
            return _forwardingState;
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_forwardingState == null) ? 0 : _forwardingState.hashCode());
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
            AfiFlags other = (AfiFlags) obj;
            if (_forwardingState == null) {
                if (other._forwardingState != null) {
                    return false;
                }
            } else if(!_forwardingState.equals(other._forwardingState)) {
                return false;
            }
            return true;
        }
    
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables.AfiFlags.class.getSimpleName()).append(" [");
            boolean first = true;
        
            if (_forwardingState != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_forwardingState=");
                builder.append(_forwardingState);
             }
            return builder.append(']').toString();
        }
    
    
    
    }
    


    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","tables");;

    AfiFlags getAfiFlags();
    
    /**
     * Returns Primary Key of Yang List Type
     */
    TablesKey getKey();

}

