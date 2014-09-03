package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6InterfaceIdentifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4InterfaceIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping link-identifier {
 *     leaf link-local-identifier {
 *         type uint32;
 *     }
 *     leaf link-remote-identifier {
 *         type uint32;
 *     }
 *     leaf ipv4-interface-address {
 *         type ipv4-interface-identifier;
 *     }
 *     leaf ipv6-interface-address {
 *         type ipv6-interface-identifier;
 *     }
 *     leaf ipv4-neighbor-address {
 *         type ipv4-interface-identifier;
 *     }
 *     leaf ipv6-neighbor-address {
 *         type ipv6-interface-identifier;
 *     }
 *     leaf multi-topology-id {
 *         type topology-identifier;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/link-identifier</i>
 */
public interface LinkIdentifier
    extends
    DataObject,
    LinkLrIdentifiers
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-identifier");;

    Ipv4InterfaceIdentifier getIpv4InterfaceAddress();
    
    Ipv6InterfaceIdentifier getIpv6InterfaceAddress();
    
    Ipv4InterfaceIdentifier getIpv4NeighborAddress();
    
    Ipv6InterfaceIdentifier getIpv6NeighborAddress();
    
    TopologyIdentifier getMultiTopologyId();

}

