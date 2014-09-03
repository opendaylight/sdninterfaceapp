package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.reach.nlri;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.MpReachNlri;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.Destination;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * container advertized-routes {
 *     choice destination-type {
 *         case destination-ipv4-case {
 *             container destination-ipv4 {
 *                 leaf-list ipv4-prefixes {
 *                     type ipv4-prefix;
 *                 }
 *             }
 *         }
 *         case destination-ipv6-case {
 *             container destination-ipv6 {
 *                 leaf-list ipv6-prefixes {
 *                     type ipv6-prefix;
 *                 }
 *             }
 *         }
 *     }
 *     uses destination;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)mp-reach-nlri/advertized-routes</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.reach.nlri.AdvertizedRoutesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.reach.nlri.AdvertizedRoutesBuilder
 */
public interface AdvertizedRoutes
    extends
    ChildOf<MpReachNlri>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.update.path.attributes.mp.reach.nlri.AdvertizedRoutes>,
    Destination
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","advertized-routes");;


}

