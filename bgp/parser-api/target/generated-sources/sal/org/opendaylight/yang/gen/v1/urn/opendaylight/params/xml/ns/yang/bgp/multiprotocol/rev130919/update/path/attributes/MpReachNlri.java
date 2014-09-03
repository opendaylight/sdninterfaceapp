package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.BgpTableType;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.reach.nlri.AdvertizedRoutes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes1;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * container mp-reach-nlri {
 *     leaf afi {
 *         type identityref;
 *     }
 *     leaf safi {
 *         type identityref;
 *     }
 *     choice c-next-hop {
 *         case ipv4-next-hop-case {
 *             container ipv4-next-hop {
 *                 leaf global {
 *                     type ipv4-address;
 *                 }
 *             }
 *         }
 *         case ipv6-next-hop-case {
 *             container ipv6-next-hop {
 *                 leaf global {
 *                     type ipv6-address;
 *                 }
 *                 leaf link-local {
 *                     type ipv6-address;
 *                 }
 *             }
 *         }
 *     }
 *     container advertized-routes {
 *         choice destination-type {
 *             case destination-ipv4-case {
 *                 container destination-ipv4 {
 *                     leaf-list ipv4-prefixes {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *             case destination-ipv6-case {
 *                 container destination-ipv6 {
 *                     leaf-list ipv6-prefixes {
 *                         type ipv6-prefix;
 *                     }
 *                 }
 *             }
 *         }
 *         uses destination;
 *     }
 *     uses bgp-table-type;
 *     uses next-hop;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)mp-reach-nlri</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpReachNlriBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpReachNlriBuilder
 */
public interface MpReachNlri
    extends
    ChildOf<PathAttributes1>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpReachNlri>,
    BgpTableType,
    NextHop
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","mp-reach-nlri");;

    AdvertizedRoutes getAdvertizedRoutes();

}

