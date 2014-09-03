package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthKey;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Identifiable;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * list unreserved-bandwidth {
 *     key "priority"
 *     leaf priority {
 *         type uint8;
 *     }
 *     leaf bandwidth {
 *         type bandwidth;
 *     }
 *     uses unreserved-bandwidth;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/link-state/unreserved-bandwidth</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthKey
 */
public interface UnreservedBandwidth
    extends
    ChildOf<LinkState>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>,
    org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth,
    Identifiable<UnreservedBandwidthKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","unreserved-bandwidth");;

    /**
     * Returns Primary Key of Yang List Type
     */
    UnreservedBandwidthKey getKey();

}

