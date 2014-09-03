package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container local-node-descriptors {
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
 *     uses node-identifier;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/linkstate-destination/c-linkstate-destination/local-node-descriptors</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LocalNodeDescriptorsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LocalNodeDescriptorsBuilder
 */
public interface LocalNodeDescriptors
    extends
    ChildOf<CLinkstateDestination>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LocalNodeDescriptors>,
    NodeIdentifier
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","local-node-descriptors");;


}

