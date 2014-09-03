package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AsPath;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AsPathSegment;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * list segments {
 *     key     choice c-segment {
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
 *     uses as-path-segment;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/path-attributes/as-path/segments</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path.SegmentsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path.SegmentsBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path.SegmentsKey
 */
public interface Segments
    extends
    ChildOf<AsPath>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path.Segments>,
    AsPathSegment
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","segments");;


}

