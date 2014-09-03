package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.bgp.parameters;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * choice c-parameters {
 *     case as4-bytes-case {
 *         container as4-bytes-capability {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *         }
 *     }
 *     case graceful-restart-case {
 *         container graceful-restart-capability {
 *             leaf restart-flags {
 *                 type bits;
 *             }
 *             leaf restart-time {
 *                 type uint16;
 *             }
 *             list tables {
 *                 key "afi" 
 *             "safi"
 *                 leaf afi {
 *                     type identityref;
 *                 }
 *                 leaf safi {
 *                     type identityref;
 *                 }
 *                 leaf afi-flags {
 *                     type bits;
 *                 }
 *                 uses bgp-table-type;
 *             }
 *         }
 *     }
 *     case multiprotocol-case {
 *         container multiprotocol-capability {
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             uses bgp-table-type;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/open/bgp-parameters/c-parameters</i>
 */
public interface CParameters
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","c-parameters");;


}

