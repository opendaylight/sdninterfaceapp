package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * choice object-type {
 *     case link-case {
 *         container local-node-descriptors {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf area-id {
 *                 type area-identifier;
 *             }
 *             leaf domain-id {
 *                 type domain-identifier;
 *             }
 *             choice c-router-identifier {
 *                 case isis-node-case {
 *                     container isis-node {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                 }
 *                 case isis-pseudonode-case {
 *                     container isis-pseudonode {
 *                         container is-is-router-identifier {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                         leaf psn {
 *                             type uint8;
 *                         }
 *                         uses isis-lan-identifier;
 *                     }
 *                 }
 *                 case ospf-node-case {
 *                     container ospf-node {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         uses ospf-router-identifier;
 *                     }
 *                 }
 *                 case ospf-pseudonode-case {
 *                     container ospf-pseudonode {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         leaf lan-interface {
 *                             type ospf-interface-identifier;
 *                         }
 *                         uses ospf-v3-lan-identifier;
 *                     }
 *                 }
 *             }
 *             uses node-identifier;
 *         }
 *         container remote-node-descriptors {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf area-id {
 *                 type area-identifier;
 *             }
 *             leaf domain-id {
 *                 type domain-identifier;
 *             }
 *             choice c-router-identifier {
 *                 case isis-node-case {
 *                     container isis-node {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                 }
 *                 case isis-pseudonode-case {
 *                     container isis-pseudonode {
 *                         container is-is-router-identifier {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                         leaf psn {
 *                             type uint8;
 *                         }
 *                         uses isis-lan-identifier;
 *                     }
 *                 }
 *                 case ospf-node-case {
 *                     container ospf-node {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         uses ospf-router-identifier;
 *                     }
 *                 }
 *                 case ospf-pseudonode-case {
 *                     container ospf-pseudonode {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         leaf lan-interface {
 *                             type ospf-interface-identifier;
 *                         }
 *                         uses ospf-v3-lan-identifier;
 *                     }
 *                 }
 *             }
 *             uses node-identifier;
 *         }
 *         container link-descriptors {
 *             leaf link-local-identifier {
 *                 type uint32;
 *             }
 *             leaf link-remote-identifier {
 *                 type uint32;
 *             }
 *             leaf ipv4-interface-address {
 *                 type ipv4-interface-identifier;
 *             }
 *             leaf ipv6-interface-address {
 *                 type ipv6-interface-identifier;
 *             }
 *             leaf ipv4-neighbor-address {
 *                 type ipv4-interface-identifier;
 *             }
 *             leaf ipv6-neighbor-address {
 *                 type ipv6-interface-identifier;
 *             }
 *             leaf multi-topology-id {
 *                 type topology-identifier;
 *             }
 *             uses link-identifier;
 *         }
 *     }
 *     case node-case {
 *         container node-descriptors {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf area-id {
 *                 type area-identifier;
 *             }
 *             leaf domain-id {
 *                 type domain-identifier;
 *             }
 *             choice c-router-identifier {
 *                 case isis-node-case {
 *                     container isis-node {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                 }
 *                 case isis-pseudonode-case {
 *                     container isis-pseudonode {
 *                         container is-is-router-identifier {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                         leaf psn {
 *                             type uint8;
 *                         }
 *                         uses isis-lan-identifier;
 *                     }
 *                 }
 *                 case ospf-node-case {
 *                     container ospf-node {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         uses ospf-router-identifier;
 *                     }
 *                 }
 *                 case ospf-pseudonode-case {
 *                     container ospf-pseudonode {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         leaf lan-interface {
 *                             type ospf-interface-identifier;
 *                         }
 *                         uses ospf-v3-lan-identifier;
 *                     }
 *                 }
 *             }
 *             uses node-identifier;
 *         }
 *     }
 *     case prefix-case {
 *         container advertising-node-descriptors {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf area-id {
 *                 type area-identifier;
 *             }
 *             leaf domain-id {
 *                 type domain-identifier;
 *             }
 *             choice c-router-identifier {
 *                 case isis-node-case {
 *                     container isis-node {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                 }
 *                 case isis-pseudonode-case {
 *                     container isis-pseudonode {
 *                         container is-is-router-identifier {
 *                             leaf iso-system-id {
 *                                 type iso-system-identifier;
 *                             }
 *                             uses isis-router-identifier;
 *                         }
 *                         leaf psn {
 *                             type uint8;
 *                         }
 *                         uses isis-lan-identifier;
 *                     }
 *                 }
 *                 case ospf-node-case {
 *                     container ospf-node {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         uses ospf-router-identifier;
 *                     }
 *                 }
 *                 case ospf-pseudonode-case {
 *                     container ospf-pseudonode {
 *                         leaf ospf-router-id {
 *                             type uint32;
 *                         }
 *                         leaf lan-interface {
 *                             type ospf-interface-identifier;
 *                         }
 *                         uses ospf-v3-lan-identifier;
 *                     }
 *                 }
 *             }
 *             uses node-identifier;
 *         }
 *         leaf multi-topology-id {
 *             type topology-identifier;
 *         }
 *         leaf ospf-route-type {
 *             type ospf-route-type;
 *         }
 *         leaf ip-reachability-information {
 *             type ip-prefix;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route/object-type</i>
 */
public interface ObjectType
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","object-type");;


}

