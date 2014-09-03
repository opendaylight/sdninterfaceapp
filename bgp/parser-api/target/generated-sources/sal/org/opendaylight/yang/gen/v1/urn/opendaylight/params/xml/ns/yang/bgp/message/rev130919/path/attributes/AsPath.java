package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.as.path.Segments;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * container as-path {
 *     list segments {
 *         key     choice c-segment {
 *             case a-list-case {
 *                 container a-list {
 *                     list as-sequence {
 *                         key     leaf as {
 *                             type as-number;
 *                         }
 *                     }
 *                 }
 *             }
 *             case a-set-case {
 *                 container a-set {
 *                     leaf-list as-set {
 *                         type as-number;
 *                     }
 *                 }
 *             }
 *         }
 *         uses as-path-segment;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/path-attributes/as-path</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AsPathBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AsPathBuilder
 */
public interface AsPath
    extends
    ChildOf<PathAttributes>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AsPath>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","as-path");;

    List<Segments> getSegments();

}

