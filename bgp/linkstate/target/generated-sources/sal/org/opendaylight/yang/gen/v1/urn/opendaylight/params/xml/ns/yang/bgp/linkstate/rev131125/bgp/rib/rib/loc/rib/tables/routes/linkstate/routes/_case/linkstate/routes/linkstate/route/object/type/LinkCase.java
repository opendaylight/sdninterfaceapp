package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.ObjectType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.RemoteNodeDescriptors;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LocalNodeDescriptors;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case link-case {
 *     container local-node-descriptors {
 *         leaf as-number {
 *             type as-number;
 *         }
 *         leaf area-id {
 *             type area-identifier;
 *         }
 *         leaf domain-id {
 *             type domain-identifier;
 *         }
 *         choice c-router-identifier {
 *             case isis-node-case {
 *                 container isis-node {
 *                     leaf iso-system-id {
 *                         type iso-system-identifier;
 *                     }
 *                     uses isis-router-identifier;
 *                 }
 *             }
 *             case isis-pseudonode-case {
 *                 container isis-pseudonode {
 *                     container is-is-router-identifier {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                     leaf psn {
 *                         type uint8;
 *                     }
 *                     uses isis-lan-identifier;
 *                 }
 *             }
 *             case ospf-node-case {
 *                 container ospf-node {
 *                     leaf ospf-router-id {
 *                         type uint32;
 *                     }
 *                     uses ospf-router-identifier;
 *                 }
 *             }
 *             case ospf-pseudonode-case {
 *                 container ospf-pseudonode {
 *                     leaf ospf-router-id {
 *                         type uint32;
 *                     }
 *                     leaf lan-interface {
 *                         type ospf-interface-identifier;
 *                     }
 *                     uses ospf-v3-lan-identifier;
 *                 }
 *             }
 *         }
 *         uses node-identifier;
 *     }
 *     container remote-node-descriptors {
 *         leaf as-number {
 *             type as-number;
 *         }
 *         leaf area-id {
 *             type area-identifier;
 *         }
 *         leaf domain-id {
 *             type domain-identifier;
 *         }
 *         choice c-router-identifier {
 *             case isis-node-case {
 *                 container isis-node {
 *                     leaf iso-system-id {
 *                         type iso-system-identifier;
 *                     }
 *                     uses isis-router-identifier;
 *                 }
 *             }
 *             case isis-pseudonode-case {
 *                 container isis-pseudonode {
 *                     container is-is-router-identifier {
 *                         leaf iso-system-id {
 *                             type iso-system-identifier;
 *                         }
 *                         uses isis-router-identifier;
 *                     }
 *                     leaf psn {
 *                         type uint8;
 *                     }
 *                     uses isis-lan-identifier;
 *                 }
 *             }
 *             case ospf-node-case {
 *                 container ospf-node {
 *                     leaf ospf-router-id {
 *                         type uint32;
 *                     }
 *                     uses ospf-router-identifier;
 *                 }
 *             }
 *             case ospf-pseudonode-case {
 *                 container ospf-pseudonode {
 *                     leaf ospf-router-id {
 *                         type uint32;
 *                     }
 *                     leaf lan-interface {
 *                         type ospf-interface-identifier;
 *                     }
 *                     uses ospf-v3-lan-identifier;
 *                 }
 *             }
 *         }
 *         uses node-identifier;
 *     }
 *     container link-descriptors {
 *         leaf link-local-identifier {
 *             type uint32;
 *         }
 *         leaf link-remote-identifier {
 *             type uint32;
 *         }
 *         leaf ipv4-interface-address {
 *             type ipv4-interface-identifier;
 *         }
 *         leaf ipv6-interface-address {
 *             type ipv6-interface-identifier;
 *         }
 *         leaf ipv4-neighbor-address {
 *             type ipv4-interface-identifier;
 *         }
 *         leaf ipv6-neighbor-address {
 *             type ipv6-interface-identifier;
 *         }
 *         leaf multi-topology-id {
 *             type topology-identifier;
 *         }
 *         uses link-identifier;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route/object-type/link-case</i>
 */
public interface LinkCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.LinkCase>,
    ObjectType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-case");;

    LocalNodeDescriptors getLocalNodeDescriptors();
    
    RemoteNodeDescriptors getRemoteNodeDescriptors();
    
    LinkDescriptors getLinkDescriptors();

}

