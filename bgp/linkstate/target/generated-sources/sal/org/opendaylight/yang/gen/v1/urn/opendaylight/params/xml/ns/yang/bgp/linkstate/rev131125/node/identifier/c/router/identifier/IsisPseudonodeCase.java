package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.CRouterIdentifier;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.isis.pseudonode._case.IsisPseudonode;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case isis-pseudonode-case {
 *     container isis-pseudonode {
 *         container is-is-router-identifier {
 *             leaf iso-system-id {
 *                 type iso-system-identifier;
 *             }
 *             uses isis-router-identifier;
 *         }
 *         leaf psn {
 *             type uint8;
 *         }
 *         uses isis-lan-identifier;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/node-identifier/c-router-identifier/isis-pseudonode-case</i>
 */
public interface IsisPseudonodeCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.IsisPseudonodeCase>,
    CRouterIdentifier
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","isis-pseudonode-case");;

    IsisPseudonode getIsisPseudonode();

}

