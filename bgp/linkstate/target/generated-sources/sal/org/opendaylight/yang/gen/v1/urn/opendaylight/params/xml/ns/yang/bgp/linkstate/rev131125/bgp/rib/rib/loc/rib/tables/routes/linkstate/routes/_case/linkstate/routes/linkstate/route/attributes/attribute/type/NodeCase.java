package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.AttributeType;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case node-case {
 *     container node-attributes {
 *         leaf-list topology-identifier {
 *             type topology-identifier;
 *         }
 *         leaf node-flags {
 *             type node-flag-bits;
 *         }
 *         leaf-list isis-area-id {
 *             type isis-area-identifier;
 *         }
 *         leaf dynamic-hostname {
 *             type string;
 *         }
 *         leaf ipv4-router-id {
 *             type ipv4-router-identifier;
 *         }
 *         leaf ipv6-router-id {
 *             type ipv6-router-identifier;
 *         }
 *         uses node-state;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes/linkstate-route/attributes/attribute-type/node-case</i>
 */
public interface NodeCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.NodeCase>,
    AttributeType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","node-case");;

    NodeAttributes getNodeAttributes();

}

