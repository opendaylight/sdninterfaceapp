package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.next.hop;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * choice c-next-hop {
 *     case ipv4-next-hop-case {
 *         container ipv4-next-hop {
 *             leaf global {
 *                 type ipv4-address;
 *             }
 *         }
 *     }
 *     case ipv6-next-hop-case {
 *         container ipv6-next-hop {
 *             leaf global {
 *                 type ipv6-address;
 *             }
 *             leaf link-local {
 *                 type ipv6-address;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/next-hop/c-next-hop</i>
 */
public interface CNextHop
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","c-next-hop");;


}

