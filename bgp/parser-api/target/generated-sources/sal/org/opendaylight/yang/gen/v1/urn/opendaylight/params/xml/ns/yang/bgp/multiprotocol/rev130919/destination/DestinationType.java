package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.destination;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * choice destination-type {
 *     case destination-ipv4-case {
 *         container destination-ipv4 {
 *             leaf-list ipv4-prefixes {
 *                 type ipv4-prefix;
 *             }
 *         }
 *     }
 *     case destination-ipv6-case {
 *         container destination-ipv6 {
 *             leaf-list ipv6-prefixes {
 *                 type ipv6-prefix;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/destination/destination-type</i>
 */
public interface DestinationType
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","destination-type");;


}

