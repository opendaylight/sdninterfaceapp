package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.prefix.attributes._case.PrefixAttributes;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.LinkStateAttribute;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * case prefix-attributes-case {
 *     container prefix-attributes {
 *         container igp-bits {
 *             leaf up-down {
 *                 type bits;
 *             }
 *             uses igp-bits;
 *         }
 *         leaf-list route-tags {
 *             type route-tag;
 *         }
 *         leaf-list extended-tags {
 *             type extended-route-tag;
 *         }
 *         leaf prefix-metric {
 *             type igp-metric;
 *         }
 *         leaf ospf-forwarding-address {
 *             type ip-address;
 *         }
 *         uses prefix-state;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-path-attribute/link-state-attribute/prefix-attributes-case</i>
 */
public interface PrefixAttributesCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.PrefixAttributesCase>,
    LinkStateAttribute
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","prefix-attributes-case");;

    PrefixAttributes getPrefixAttributes();

}

