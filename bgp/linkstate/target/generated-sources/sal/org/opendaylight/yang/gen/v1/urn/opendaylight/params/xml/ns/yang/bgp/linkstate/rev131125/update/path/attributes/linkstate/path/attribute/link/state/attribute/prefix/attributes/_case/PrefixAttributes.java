package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.prefix.attributes._case;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttribute;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container prefix-attributes {
 *     container igp-bits {
 *         leaf up-down {
 *             type bits;
 *         }
 *         uses igp-bits;
 *     }
 *     leaf-list route-tags {
 *         type route-tag;
 *     }
 *     leaf-list extended-tags {
 *         type extended-route-tag;
 *     }
 *     leaf prefix-metric {
 *         type igp-metric;
 *     }
 *     leaf ospf-forwarding-address {
 *         type ip-address;
 *     }
 *     uses prefix-state;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/update/path-attributes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-path-attribute/link-state-attribute/prefix-attributes-case/prefix-attributes</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.prefix.attributes._case.PrefixAttributesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.prefix.attributes._case.PrefixAttributesBuilder
 */
public interface PrefixAttributes
    extends
    ChildOf<LinkstatePathAttribute>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.prefix.attributes._case.PrefixAttributes>,
    PrefixState
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","prefix-attributes");;


}

