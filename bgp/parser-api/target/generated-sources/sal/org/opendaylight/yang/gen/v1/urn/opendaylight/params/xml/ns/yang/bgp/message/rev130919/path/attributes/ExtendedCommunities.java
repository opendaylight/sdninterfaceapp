package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ExtendedCommunity;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * list extended-communities {
 *     key     leaf comm-type {
 *         type uint8;
 *     }
 *     leaf comm-sub-type {
 *         type uint8;
 *     }
 *     choice extended-community {
 *         case as-specific-extended-community-case {
 *             container as-specific-extended-community {
 *                 leaf transitive {
 *                     type boolean;
 *                 }
 *                 leaf global-administrator {
 *                     type short-as-number;
 *                 }
 *                 leaf local-administrator {
 *                     type binary;
 *                 }
 *             }
 *         }
 *         case inet4-specific-extended-community-case {
 *             container inet4-specific-extended-community {
 *                 leaf transitive {
 *                     type boolean;
 *                 }
 *                 leaf global-administrator {
 *                     type ipv4-address;
 *                 }
 *                 leaf local-administrator {
 *                     type binary;
 *                 }
 *             }
 *         }
 *         case opaque-extended-community-case {
 *             container opaque-extended-community {
 *                 leaf transitive {
 *                     type boolean;
 *                 }
 *                 leaf value {
 *                     type binary;
 *                 }
 *             }
 *         }
 *         case route-origin-extended-community-case {
 *             container route-origin-extended-community {
 *                 leaf global-administrator {
 *                     type short-as-number;
 *                 }
 *                 leaf local-administrator {
 *                     type binary;
 *                 }
 *             }
 *         }
 *         case route-target-extended-community-case {
 *             container route-target-extended-community {
 *                 leaf global-administrator {
 *                     type short-as-number;
 *                 }
 *                 leaf local-administrator {
 *                     type binary;
 *                 }
 *             }
 *         }
 *     }
 *     uses extended-community;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/path-attributes/extended-communities</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunitiesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunitiesBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunitiesKey
 */
public interface ExtendedCommunities
    extends
    ChildOf<PathAttributes>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities>,
    ExtendedCommunity
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","extended-communities");;


}

