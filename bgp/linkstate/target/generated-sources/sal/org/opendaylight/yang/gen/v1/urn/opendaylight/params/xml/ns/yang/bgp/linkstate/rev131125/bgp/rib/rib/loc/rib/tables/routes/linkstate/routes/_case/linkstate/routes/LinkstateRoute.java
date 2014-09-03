package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.ObjectType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.LinkstateRoutes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.ProtocolId;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Identifiable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteKey;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Identifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.Route;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.RouteDistinguisher;


/**
 * Link-state information entry. Due to the complexity of link-state information 
 * and YANG limitations this is the top-level object from contract perspective. It 
 * is keyed by route-key, whose format is internal to the implementation exposing 
 * this information. As an explicit example it can rely on information stored in 
 * the entry's subtree, so the subtree MUST NOT be modified by outside entities. 
 * Augmentations can attach data, but must be explicitly aware that such data, 
 * unlike the data modeled directly here, does not have any effects on keys, 
 * especially they must not impact equality tests.
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * list linkstate-route {
 *     key "route-key"
 *     leaf route-key {
 *         type binary;
 *     }
 *     leaf distinguisher {
 *         type route-distinguisher;
 *     }
 *     leaf protocol-id {
 *         type protocol-id;
 *     }
 *     leaf identifier {
 *         type identifier;
 *     }
 *     choice object-type {
 *         case link-case {
 *             container local-node-descriptors {
 *                 leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf area-id {
 *                     type area-identifier;
 *                 }
 *                 leaf domain-id {
 *                     type domain-identifier;
 *                 }
 *                 choice c-router-identifier {
 *                     case isis-node-case {
 *                         container isis-node {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                     }
 *                     case isis-pseudonode-case {
 *                         container isis-pseudonode {
 *                             container is-is-router-identifier {
 *                                 leaf iso-system-id {
 *                                     type iso-system-identifier;
 *                                 }
 *                                 uses isis-router-identifier;
 *                             }
 *                             leaf psn {
 *                                 type uint8;
 *                             }
 *                             uses isis-lan-identifier;
 *                         }
 *                     }
 *                     case ospf-node-case {
 *                         container ospf-node {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             uses ospf-router-identifier;
 *                         }
 *                     }
 *                     case ospf-pseudonode-case {
 *                         container ospf-pseudonode {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             leaf lan-interface {
 *                                 type ospf-interface-identifier;
 *                             }
 *                             uses ospf-v3-lan-identifier;
 *                         }
 *                     }
 *                 }
 *                 uses node-identifier;
 *             }
 *             container remote-node-descriptors {
 *                 leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf area-id {
 *                     type area-identifier;
 *                 }
 *                 leaf domain-id {
 *                     type domain-identifier;
 *                 }
 *                 choice c-router-identifier {
 *                     case isis-node-case {
 *                         container isis-node {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                     }
 *                     case isis-pseudonode-case {
 *                         container isis-pseudonode {
 *                             container is-is-router-identifier {
 *                                 leaf iso-system-id {
 *                                     type iso-system-identifier;
 *                                 }
 *                                 uses isis-router-identifier;
 *                             }
 *                             leaf psn {
 *                                 type uint8;
 *                             }
 *                             uses isis-lan-identifier;
 *                         }
 *                     }
 *                     case ospf-node-case {
 *                         container ospf-node {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             uses ospf-router-identifier;
 *                         }
 *                     }
 *                     case ospf-pseudonode-case {
 *                         container ospf-pseudonode {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             leaf lan-interface {
 *                                 type ospf-interface-identifier;
 *                             }
 *                             uses ospf-v3-lan-identifier;
 *                         }
 *                     }
 *                 }
 *                 uses node-identifier;
 *             }
 *             container link-descriptors {
 *                 leaf link-local-identifier {
 *                     type uint32;
 *                 }
 *                 leaf link-remote-identifier {
 *                     type uint32;
 *                 }
 *                 leaf ipv4-interface-address {
 *                     type ipv4-interface-identifier;
 *                 }
 *                 leaf ipv6-interface-address {
 *                     type ipv6-interface-identifier;
 *                 }
 *                 leaf ipv4-neighbor-address {
 *                     type ipv4-interface-identifier;
 *                 }
 *                 leaf ipv6-neighbor-address {
 *                     type ipv6-interface-identifier;
 *                 }
 *                 leaf multi-topology-id {
 *                     type topology-identifier;
 *                 }
 *                 uses link-identifier;
 *             }
 *         }
 *         case node-case {
 *             container node-descriptors {
 *                 leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf area-id {
 *                     type area-identifier;
 *                 }
 *                 leaf domain-id {
 *                     type domain-identifier;
 *                 }
 *                 choice c-router-identifier {
 *                     case isis-node-case {
 *                         container isis-node {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                     }
 *                     case isis-pseudonode-case {
 *                         container isis-pseudonode {
 *                             container is-is-router-identifier {
 *                                 leaf iso-system-id {
 *                                     type iso-system-identifier;
 *                                 }
 *                                 uses isis-router-identifier;
 *                             }
 *                             leaf psn {
 *                                 type uint8;
 *                             }
 *                             uses isis-lan-identifier;
 *                         }
 *                     }
 *                     case ospf-node-case {
 *                         container ospf-node {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             uses ospf-router-identifier;
 *                         }
 *                     }
 *                     case ospf-pseudonode-case {
 *                         container ospf-pseudonode {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             leaf lan-interface {
 *                                 type ospf-interface-identifier;
 *                             }
 *                             uses ospf-v3-lan-identifier;
 *                         }
 *                     }
 *                 }
 *                 uses node-identifier;
 *             }
 *         }
 *         case prefix-case {
 *             container advertising-node-descriptors {
 *                 leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf area-id {
 *                     type area-identifier;
 *                 }
 *                 leaf domain-id {
 *                     type domain-identifier;
 *                 }
 *                 choice c-router-identifier {
 *                     case isis-node-case {
 *                         container isis-node {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                     }
 *                     case isis-pseudonode-case {
 *                         container isis-pseudonode {
 *                             container is-is-router-identifier {
 *                                 leaf iso-system-id {
 *                                     type iso-system-identifier;
 *                                 }
 *                                 uses isis-router-identifier;
 *                             }
 *                             leaf psn {
 *                                 type uint8;
 *                             }
 *                             uses isis-lan-identifier;
 *                         }
 *                     }
 *                     case ospf-node-case {
 *                         container ospf-node {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             uses ospf-router-identifier;
 *                         }
 *                     }
 *                     case ospf-pseudonode-case {
 *                         container ospf-pseudonode {
 *                             leaf ospf-router-id {
 *                                 type uint32;
 *                             }
 *                             leaf lan-interface {
 *                                 type ospf-interface-identifier;
 *                             }
 *                             uses ospf-v3-lan-identifier;
 *                         }
 *                     }
 *                 }
 *                 uses node-identifier;
 *             }
 *             leaf multi-topology-id {
 *                 type topology-identifier;
 *             }
 *             leaf ospf-route-type {
 *                 type ospf-route-type;
 *             }
 *             leaf ip-reachability-information {
 *                 type ip-prefix;
 *             }
 *         }
 *     }
 *     container attributes {
 *         container origin {
 *             leaf value {
 *                 type bgp-origin;
 *             }
 *         }
 *         container as-path {
 *             list segments {
 *                 key     choice c-segment {
 *                     case a-list-case {
 *                         container a-list {
 *                             list as-sequence {
 *                                 key     leaf as {
 *                                     type as-number;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     case a-set-case {
 *                         container a-set {
 *                             leaf-list as-set {
 *                                 type as-number;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 uses as-path-segment;
 *             }
 *         }
 *         choice c-next-hop {
 *             case ipv4-next-hop-case {
 *                 container ipv4-next-hop {
 *                     leaf global {
 *                         type ipv4-address;
 *                     }
 *                 }
 *             }
 *             case ipv6-next-hop-case {
 *                 container ipv6-next-hop {
 *                     leaf global {
 *                         type ipv6-address;
 *                     }
 *                     leaf link-local {
 *                         type ipv6-address;
 *                     }
 *                 }
 *             }
 *         }
 *         container multi-exit-disc {
 *             leaf med {
 *                 type uint32;
 *             }
 *         }
 *         container local-pref {
 *             leaf pref {
 *                 type uint32;
 *             }
 *         }
 *         container atomic-aggregate {
 *         }
 *         container aggregator {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf network-address {
 *                 type ipv4-address;
 *             }
 *             uses bgp-aggregator;
 *         }
 *         list communities {
 *             key     leaf as-number {
 *                 type as-number;
 *             }
 *             leaf semantics {
 *                 type uint16;
 *             }
 *             uses community;
 *         }
 *         list extended-communities {
 *             key     leaf comm-type {
 *                 type uint8;
 *             }
 *             leaf comm-sub-type {
 *                 type uint8;
 *             }
 *             choice extended-community {
 *                 case as-specific-extended-community-case {
 *                     container as-specific-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case inet4-specific-extended-community-case {
 *                     container inet4-specific-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf global-administrator {
 *                             type ipv4-address;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case opaque-extended-community-case {
 *                     container opaque-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf value {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case route-origin-extended-community-case {
 *                     container route-origin-extended-community {
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case route-target-extended-community-case {
 *                     container route-target-extended-community {
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses extended-community;
 *         }
 *         container originator-id {
 *             leaf originator {
 *                 type ipv4-address;
 *             }
 *             uses originator-id;
 *         }
 *         container cluster-id {
 *             leaf-list cluster {
 *                 type cluster-identifier;
 *             }
 *             uses cluster-id;
 *         }
 *         choice attribute-type {
 *             case link-case {
 *                 container link-attributes {
 *                     leaf local-ipv4-router-id {
 *                         type ipv4-router-identifier;
 *                     }
 *                     leaf local-ipv6-router-id {
 *                         type ipv6-router-identifier;
 *                     }
 *                     leaf remote-ipv4-router-id {
 *                         type ipv4-router-identifier;
 *                     }
 *                     leaf remote-ipv6-router-id {
 *                         type ipv6-router-identifier;
 *                     }
 *                     leaf mpls-protocol {
 *                         type mpls-protocol-mask;
 *                     }
 *                     leaf te-metric {
 *                         type te-metric;
 *                     }
 *                     leaf metric {
 *                         type metric;
 *                     }
 *                     leaf-list shared-risk-link-groups {
 *                         type srlg-id;
 *                     }
 *                     leaf link-name {
 *                         type string;
 *                     }
 *                     leaf max-link-bandwidth {
 *                         type bandwidth;
 *                     }
 *                     leaf max-reservable-bandwidth {
 *                         type bandwidth;
 *                     }
 *                     list unreserved-bandwidth {
 *                         key "priority"
 *                         leaf priority {
 *                             type uint8;
 *                         }
 *                         leaf bandwidth {
 *                             type bandwidth;
 *                         }
 *                         uses unreserved-bandwidth;
 *                     }
 *                     leaf link-protection {
 *                         type link-protection-type;
 *                     }
 *                     leaf admin-group {
 *                         type administrative-group;
 *                     }
 *                     leaf sdni-link-state {
 *                         type string;
 *                     }
 *                     uses link-state;
 *                 }
 *             }
 *             case node-case {
 *                 container node-attributes {
 *                     leaf-list topology-identifier {
 *                         type topology-identifier;
 *                     }
 *                     leaf node-flags {
 *                         type node-flag-bits;
 *                     }
 *                     leaf-list isis-area-id {
 *                         type isis-area-identifier;
 *                     }
 *                     leaf dynamic-hostname {
 *                         type string;
 *                     }
 *                     leaf ipv4-router-id {
 *                         type ipv4-router-identifier;
 *                     }
 *                     leaf ipv6-router-id {
 *                         type ipv6-router-identifier;
 *                     }
 *                     uses node-state;
 *                 }
 *             }
 *             case prefix-case {
 *                 container prefix-attributes {
 *                     container igp-bits {
 *                         leaf up-down {
 *                             type bits;
 *                         }
 *                         uses igp-bits;
 *                     }
 *                     leaf-list route-tags {
 *                         type route-tag;
 *                     }
 *                     leaf-list extended-tags {
 *                         type extended-route-tag;
 *                     }
 *                     leaf prefix-metric {
 *                         type igp-metric;
 *                     }
 *                     leaf ospf-forwarding-address {
 *                         type ip-address;
 *                     }
 *                     uses prefix-state;
 *                 }
 *             }
 *         }
 *         augment \(urn:opendaylight:params:xml:ns:yang:bgp-linkstate)attributes {
 *             status CURRENT;
 *             choice attribute-type {
 *                 case link-case {
 *                     container link-attributes {
 *                         leaf local-ipv4-router-id {
 *                             type ipv4-router-identifier;
 *                         }
 *                         leaf local-ipv6-router-id {
 *                             type ipv6-router-identifier;
 *                         }
 *                         leaf remote-ipv4-router-id {
 *                             type ipv4-router-identifier;
 *                         }
 *                         leaf remote-ipv6-router-id {
 *                             type ipv6-router-identifier;
 *                         }
 *                         leaf mpls-protocol {
 *                             type mpls-protocol-mask;
 *                         }
 *                         leaf te-metric {
 *                             type te-metric;
 *                         }
 *                         leaf metric {
 *                             type metric;
 *                         }
 *                         leaf-list shared-risk-link-groups {
 *                             type srlg-id;
 *                         }
 *                         leaf link-name {
 *                             type string;
 *                         }
 *                         leaf max-link-bandwidth {
 *                             type bandwidth;
 *                         }
 *                         leaf max-reservable-bandwidth {
 *                             type bandwidth;
 *                         }
 *                         list unreserved-bandwidth {
 *                             key "priority"
 *                             leaf priority {
 *                                 type uint8;
 *                             }
 *                             leaf bandwidth {
 *                                 type bandwidth;
 *                             }
 *                             uses unreserved-bandwidth;
 *                         }
 *                         leaf link-protection {
 *                             type link-protection-type;
 *                         }
 *                         leaf admin-group {
 *                             type administrative-group;
 *                         }
 *                         leaf sdni-link-state {
 *                             type string;
 *                         }
 *                         uses link-state;
 *                     }
 *                 }
 *                 case node-case {
 *                     container node-attributes {
 *                         leaf-list topology-identifier {
 *                             type topology-identifier;
 *                         }
 *                         leaf node-flags {
 *                             type node-flag-bits;
 *                         }
 *                         leaf-list isis-area-id {
 *                             type isis-area-identifier;
 *                         }
 *                         leaf dynamic-hostname {
 *                             type string;
 *                         }
 *                         leaf ipv4-router-id {
 *                             type ipv4-router-identifier;
 *                         }
 *                         leaf ipv6-router-id {
 *                             type ipv6-router-identifier;
 *                         }
 *                         uses node-state;
 *                     }
 *                 }
 *                 case prefix-case {
 *                     container prefix-attributes {
 *                         container igp-bits {
 *                             leaf up-down {
 *                                 type bits;
 *                             }
 *                             uses igp-bits;
 *                         }
 *                         leaf-list route-tags {
 *                             type route-tag;
 *                         }
 *                         leaf-list extended-tags {
 *                             type extended-route-tag;
 *                         }
 *                         leaf prefix-metric {
 *                             type igp-metric;
 *                         }
 *                         leaf ospf-forwarding-address {
 *                             type ip-address;
 *                         }
 *                         uses prefix-state;
 *                     }
 *                 }
 *             }
 *         }
 *         uses path-attributes;
 *     }
 *     uses route;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRouteKey
 */
public interface LinkstateRoute
    extends
    ChildOf<LinkstateRoutes>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute>,
    Route,
    Identifiable<LinkstateRouteKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","linkstate-route");;

    /**
     * The sole function of this leaf to act as the key in the list. Its format does 
     * not form the API contract of this model.
     */
    byte[] getRouteKey();
    
    RouteDistinguisher getDistinguisher();
    
    ProtocolId getProtocolId();
    
    Identifier getIdentifier();
    
    ObjectType getObjectType();
    
    /**
     * Returns Primary Key of Yang List Type
     */
    LinkstateRouteKey getKey();

}

