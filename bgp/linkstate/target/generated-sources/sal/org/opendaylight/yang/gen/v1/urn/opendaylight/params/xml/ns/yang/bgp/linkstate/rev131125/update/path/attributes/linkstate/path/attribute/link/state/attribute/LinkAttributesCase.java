package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.LinkStateAttribute;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case link-attributes-case {
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
 * <i>bgp-linkstate/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-path-attribute/link-state-attribute/link-attributes-case</i>
 */
public interface LinkAttributesCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.LinkAttributesCase>,
    LinkStateAttribute
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-attributes-case");;

    LinkAttributes getLinkAttributes();

}

