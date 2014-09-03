package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.PrefixState;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container igp-bits {
 *     leaf up-down {
 *         type bits;
 *     }
 *     uses igp-bits;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/prefix-state/igp-bits</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state.IgpBitsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state.IgpBitsBuilder
 */
public interface IgpBits
    extends
    ChildOf<PrefixState>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state.IgpBits>,
    org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IgpBits
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","igp-bits");;


}

