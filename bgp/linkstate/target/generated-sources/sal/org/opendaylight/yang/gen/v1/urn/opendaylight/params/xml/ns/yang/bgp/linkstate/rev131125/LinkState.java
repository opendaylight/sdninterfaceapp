package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.TeMetric;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkProtectionType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.MplsProtocolMask;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Metric;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.AdministrativeGroup;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4RouterIdentifier;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rsvp.rev130820.SrlgId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Bandwidth;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6RouterIdentifier;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.2">http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.2</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)link-state/link-state]
 */
public interface LinkState
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-state");;

    Ipv4RouterIdentifier getLocalIpv4RouterId();
    
    Ipv6RouterIdentifier getLocalIpv6RouterId();
    
    Ipv4RouterIdentifier getRemoteIpv4RouterId();
    
    Ipv6RouterIdentifier getRemoteIpv6RouterId();
    
    MplsProtocolMask getMplsProtocol();
    
    TeMetric getTeMetric();
    
    Metric getMetric();
    
    List<SrlgId> getSharedRiskLinkGroups();
    
    java.lang.String getLinkName();
    
    Bandwidth getMaxLinkBandwidth();
    
    Bandwidth getMaxReservableBandwidth();
    
    List<UnreservedBandwidth> getUnreservedBandwidth();
    
    LinkProtectionType getLinkProtection();
    
    AdministrativeGroup getAdminGroup();
    
    java.lang.String getSdniLinkState();

}

