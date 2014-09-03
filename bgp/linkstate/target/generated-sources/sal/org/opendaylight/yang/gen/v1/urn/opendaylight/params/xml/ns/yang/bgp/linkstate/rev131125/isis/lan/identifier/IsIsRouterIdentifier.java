package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.isis.lan.identifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IsisLanIdentifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IsisRouterIdentifier;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * container is-is-router-identifier {
 *     leaf iso-system-id {
 *         type iso-system-identifier;
 *     }
 *     uses isis-router-identifier;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/isis-lan-identifier/is-is-router-identifier</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.isis.lan.identifier.IsIsRouterIdentifierBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.isis.lan.identifier.IsIsRouterIdentifierBuilder
 */
public interface IsIsRouterIdentifier
    extends
    ChildOf<IsisLanIdentifier>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.isis.lan.identifier.IsIsRouterIdentifier>,
    IsisRouterIdentifier
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","is-is-router-identifier");;


}

