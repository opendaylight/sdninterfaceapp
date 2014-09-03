package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * grouping extended-community {
 *     leaf comm-type {
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
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/extended-community</i>
 */
public interface ExtendedCommunity
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","extended-community");;

    java.lang.Short getCommType();
    
    java.lang.Short getCommSubType();
    
    org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.ExtendedCommunity getExtendedCommunity();

}

