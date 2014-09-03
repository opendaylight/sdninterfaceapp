package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IsisAreaIdentifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4RouterIdentifier;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeFlagBits;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6RouterIdentifier;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping node-state {
 *     leaf-list topology-identifier {
 *         type topology-identifier;
 *     }
 *     leaf node-flags {
 *         type node-flag-bits;
 *     }
 *     leaf-list isis-area-id {
 *         type isis-area-identifier;
 *     }
 *     leaf dynamic-hostname {
 *         type string;
 *     }
 *     leaf ipv4-router-id {
 *         type ipv4-router-identifier;
 *     }
 *     leaf ipv6-router-id {
 *         type ipv6-router-identifier;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/node-state</i>
 */
public interface NodeState
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","node-state");;

    List<TopologyIdentifier> getTopologyIdentifier();
    
    NodeFlagBits getNodeFlags();
    
    List<IsisAreaIdentifier> getIsisAreaId();
    
    java.lang.String getDynamicHostname();
    
    Ipv4RouterIdentifier getIpv4RouterId();
    
    Ipv6RouterIdentifier getIpv6RouterId();

}

