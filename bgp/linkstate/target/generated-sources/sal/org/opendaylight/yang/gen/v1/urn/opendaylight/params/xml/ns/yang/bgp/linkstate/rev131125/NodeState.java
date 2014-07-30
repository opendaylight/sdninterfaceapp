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
 * Reference:
 *     <a href = "http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.1">http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.1</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)node-state/node-state]
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

