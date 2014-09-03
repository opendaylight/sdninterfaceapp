package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixIdentifiers;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.ObjectType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.prefix._case.AdvertisingNodeDescriptors;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case prefix-case {
 *     container advertising-node-descriptors {
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
 *     leaf multi-topology-id {
 *         type topology-identifier;
 *     }
 *     leaf ospf-route-type {
 *         type ospf-route-type;
 *     }
 *     leaf ip-reachability-information {
 *         type ip-prefix;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route/object-type/prefix-case</i>
 */
public interface PrefixCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.PrefixCase>,
    PrefixIdentifiers,
    ObjectType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","prefix-case");;

    AdvertisingNodeDescriptors getAdvertisingNodeDescriptors();

}

