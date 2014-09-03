package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.link._case.LinkAttributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.AttributeType;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case link-case {
 *     container link-attributes {
 *         leaf local-ipv4-router-id {
 *             type ipv4-router-identifier;
 *         }
 *         leaf local-ipv6-router-id {
 *             type ipv6-router-identifier;
 *         }
 *         leaf remote-ipv4-router-id {
 *             type ipv4-router-identifier;
 *         }
 *         leaf remote-ipv6-router-id {
 *             type ipv6-router-identifier;
 *         }
 *         leaf mpls-protocol {
 *             type mpls-protocol-mask;
 *         }
 *         leaf te-metric {
 *             type te-metric;
 *         }
 *         leaf metric {
 *             type metric;
 *         }
 *         leaf-list shared-risk-link-groups {
 *             type srlg-id;
 *         }
 *         leaf link-name {
 *             type string;
 *         }
 *         leaf max-link-bandwidth {
 *             type bandwidth;
 *         }
 *         leaf max-reservable-bandwidth {
 *             type bandwidth;
 *         }
 *         list unreserved-bandwidth {
 *             key "priority"
 *             leaf priority {
 *                 type uint8;
 *             }
 *             leaf bandwidth {
 *                 type bandwidth;
 *             }
 *             uses unreserved-bandwidth;
 *         }
 *         leaf link-protection {
 *             type link-protection-type;
 *         }
 *         leaf admin-group {
 *             type administrative-group;
 *         }
 *         leaf sdni-link-state {
 *             type string;
 *         }
 *         uses link-state;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route/attributes/attribute-type/link-case</i>
 */
public interface LinkCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.LinkCase>,
    AttributeType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-case");;

    LinkAttributes getLinkAttributes();

}

