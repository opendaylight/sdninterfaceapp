package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.mp.reach.nlri.advertized.routes.destination.type.destination.linkstate._case;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkstateDestination;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.Destination;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container destination-linkstate {
 *     list c-linkstate-destination {
 *         key     leaf nlri-type {
 *             type nlri-type;
 *         }
 *         leaf distinguisher {
 *             type route-distinguisher;
 *         }
 *         leaf protocol-id {
 *             type protocol-id;
 *         }
 *         leaf identifier {
 *             type identifier;
 *         }
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
 *         container prefix-descriptors {
 *             leaf multi-topology-id {
 *                 type topology-identifier;
 *             }
 *             leaf ospf-route-type {
 *                 type ospf-route-type;
 *             }
 *             leaf ip-reachability-information {
 *                 type ip-prefix;
 *             }
 *             uses prefix-identifiers;
 *         }
 *         container link-sdni-descriptors {
 *             leaf sdni-identifier {
 *                 type string;
 *             }
 *             leaf sdni-parameter {
 *                 type uint64;
 *             }
 *             uses link-sdni-identifiers;
 *         }
 *     }
 *     uses linkstate-destination;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)mp-reach-nlri/advertized-routes/destination-type/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)destination-linkstate-case/destination-linkstate</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.mp.reach.nlri.advertized.routes.destination.type.destination.linkstate._case.DestinationLinkstateBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.mp.reach.nlri.advertized.routes.destination.type.destination.linkstate._case.DestinationLinkstateBuilder
 */
public interface DestinationLinkstate
    extends
    ChildOf<Destination>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.mp.reach.nlri.advertized.routes.destination.type.destination.linkstate._case.DestinationLinkstate>,
    LinkstateDestination
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","destination-linkstate");;


}

