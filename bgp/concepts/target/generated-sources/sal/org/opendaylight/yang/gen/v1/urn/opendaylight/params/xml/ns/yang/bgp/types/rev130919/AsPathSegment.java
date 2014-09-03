package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.as.path.segment.CSegment;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * grouping as-path-segment {
 *     choice c-segment {
 *         case a-list-case {
 *             container a-list {
 *                 list as-sequence {
 *                     key     leaf as {
 *                         type as-number;
 *                     }
 *                 }
 *             }
 *         }
 *         case a-set-case {
 *             container a-set {
 *                 leaf-list as-set {
 *                     type as-number;
 *                 }
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/as-path-segment</i>
 */
public interface AsPathSegment
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","as-path-segment");;

    CSegment getCSegment();

}

