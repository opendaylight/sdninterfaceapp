package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.inet4.specific.extended.community._case.Inet4SpecificExtendedCommunity;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.ExtendedCommunity;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * case inet4-specific-extended-community-case {
 *     container inet4-specific-extended-community {
 *         leaf transitive {
 *             type boolean;
 *         }
 *         leaf global-administrator {
 *             type ipv4-address;
 *         }
 *         leaf local-administrator {
 *             type binary;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/extended-community/extended-community/inet4-specific-extended-community-case</i>
 */
public interface Inet4SpecificExtendedCommunityCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.extended.community.extended.community.Inet4SpecificExtendedCommunityCase>,
    ExtendedCommunity
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","inet4-specific-extended-community-case");;

    Inet4SpecificExtendedCommunity getInet4SpecificExtendedCommunity();

}

