package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.AreaIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.DomainIdentifier;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.AsNumber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.CRouterIdentifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping node-identifier {
 *     leaf as-number {
 *         type as-number;
 *     }
 *     leaf area-id {
 *         type area-identifier;
 *     }
 *     leaf domain-id {
 *         type domain-identifier;
 *     }
 *     choice c-router-identifier {
 *         case isis-node-case {
 *             container isis-node {
 *                 leaf iso-system-id {
 *                     type iso-system-identifier;
 *                 }
 *                 uses isis-router-identifier;
 *             }
 *         }
 *         case isis-pseudonode-case {
 *             container isis-pseudonode {
 *                 container is-is-router-identifier {
 *                     leaf iso-system-id {
 *                         type iso-system-identifier;
 *                     }
 *                     uses isis-router-identifier;
 *                 }
 *                 leaf psn {
 *                     type uint8;
 *                 }
 *                 uses isis-lan-identifier;
 *             }
 *         }
 *         case ospf-node-case {
 *             container ospf-node {
 *                 leaf ospf-router-id {
 *                     type uint32;
 *                 }
 *                 uses ospf-router-identifier;
 *             }
 *         }
 *         case ospf-pseudonode-case {
 *             container ospf-pseudonode {
 *                 leaf ospf-router-id {
 *                     type uint32;
 *                 }
 *                 leaf lan-interface {
 *                     type ospf-interface-identifier;
 *                 }
 *                 uses ospf-v3-lan-identifier;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/node-identifier</i>
 */
public interface NodeIdentifier
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","node-identifier");;

    AsNumber getAsNumber();
    
    AreaIdentifier getAreaId();
    
    DomainIdentifier getDomainId();
    
    CRouterIdentifier getCRouterIdentifier();

}

