package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.as.path.segment;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * choice c-segment {
 *     case a-list-case {
 *         container a-list {
 *             list as-sequence {
 *                 key     leaf as {
 *                     type as-number;
 *                 }
 *             }
 *         }
 *     }
 *     case a-set-case {
 *         container a-set {
 *             leaf-list as-set {
 *                 type as-number;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/as-path-segment/c-segment</i>
 */
public interface CSegment
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","c-segment");;


}

