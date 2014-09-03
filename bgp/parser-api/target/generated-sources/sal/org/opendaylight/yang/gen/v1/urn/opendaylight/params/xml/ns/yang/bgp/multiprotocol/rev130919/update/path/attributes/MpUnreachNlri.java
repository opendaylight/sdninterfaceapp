package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.BgpTableType;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.PathAttributes2;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.unreach.nlri.WithdrawnRoutes;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * container mp-unreach-nlri {
 *     leaf afi {
 *         type identityref;
 *     }
 *     leaf safi {
 *         type identityref;
 *     }
 *     container withdrawn-routes {
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
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)mp-unreach-nlri</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpUnreachNlriBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpUnreachNlriBuilder
 */
public interface MpUnreachNlri
    extends
    ChildOf<PathAttributes2>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpUnreachNlri>,
    BgpTableType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","mp-unreach-nlri");;

    WithdrawnRoutes getWithdrawnRoutes();

}

