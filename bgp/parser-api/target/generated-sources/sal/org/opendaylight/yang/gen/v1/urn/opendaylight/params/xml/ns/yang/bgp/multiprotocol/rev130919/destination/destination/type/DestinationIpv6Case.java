package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.destination.destination.type;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.destination.destination.type.destination.ipv6._case.DestinationIpv6;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.destination.DestinationType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * case destination-ipv6-case {
 *     container destination-ipv6 {
 *         leaf-list ipv6-prefixes {
 *             type ipv6-prefix;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/destination/destination-type/destination-ipv6-case</i>
 */
public interface DestinationIpv6Case
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.destination.destination.type.DestinationIpv6Case>,
    DestinationType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","destination-ipv6-case");;

    DestinationIpv6 getDestinationIpv6();

}

