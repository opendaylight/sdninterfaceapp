package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.LinkStateAttribute;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PathAttributes1;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container linkstate-path-attribute {
 *     choice link-state-attribute {
 *         case link-attributes-case {
 *             container link-attributes {
 *                 leaf local-ipv4-router-id {
 *                     type ipv4-router-identifier;
 *                 }
 *                 leaf local-ipv6-router-id {
 *                     type ipv6-router-identifier;
 *                 }
 *                 leaf remote-ipv4-router-id {
 *                     type ipv4-router-identifier;
 *                 }
 *                 leaf remote-ipv6-router-id {
 *                     type ipv6-router-identifier;
 *                 }
 *                 leaf mpls-protocol {
 *                     type mpls-protocol-mask;
 *                 }
 *                 leaf te-metric {
 *                     type te-metric;
 *                 }
 *                 leaf metric {
 *                     type metric;
 *                 }
 *                 leaf-list shared-risk-link-groups {
 *                     type srlg-id;
 *                 }
 *                 leaf link-name {
 *                     type string;
 *                 }
 *                 leaf max-link-bandwidth {
 *                     type bandwidth;
 *                 }
 *                 leaf max-reservable-bandwidth {
 *                     type bandwidth;
 *                 }
 *                 list unreserved-bandwidth {
 *                     key "priority"
 *                     leaf priority {
 *                         type uint8;
 *                     }
 *                     leaf bandwidth {
 *                         type bandwidth;
 *                     }
 *                     uses unreserved-bandwidth;
 *                 }
 *                 leaf link-protection {
 *                     type link-protection-type;
 *                 }
 *                 leaf admin-group {
 *                     type administrative-group;
 *                 }
 *                 leaf sdni-link-state {
 *                     type string;
 *                 }
 *                 uses link-state;
 *             }
 *         }
 *         case node-attributes-case {
 *             container node-attributes {
 *                 leaf-list topology-identifier {
 *                     type topology-identifier;
 *                 }
 *                 leaf node-flags {
 *                     type node-flag-bits;
 *                 }
 *                 leaf-list isis-area-id {
 *                     type isis-area-identifier;
 *                 }
 *                 leaf dynamic-hostname {
 *                     type string;
 *                 }
 *                 leaf ipv4-router-id {
 *                     type ipv4-router-identifier;
 *                 }
 *                 leaf ipv6-router-id {
 *                     type ipv6-router-identifier;
 *                 }
 *                 uses node-state;
 *             }
 *         }
 *         case prefix-attributes-case {
 *             container prefix-attributes {
 *                 container igp-bits {
 *                     leaf up-down {
 *                         type bits;
 *                     }
 *                     uses igp-bits;
 *                 }
 *                 leaf-list route-tags {
 *                     type route-tag;
 *                 }
 *                 leaf-list extended-tags {
 *                     type extended-route-tag;
 *                 }
 *                 leaf prefix-metric {
 *                     type igp-metric;
 *                 }
 *                 leaf ospf-forwarding-address {
 *                     type ip-address;
 *                 }
 *                 uses prefix-state;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-path-attribute</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttributeBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttributeBuilder
 */
public interface LinkstatePathAttribute
    extends
    ChildOf<PathAttributes1>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttribute>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","linkstate-path-attribute");;

    LinkStateAttribute getLinkStateAttribute();

}

