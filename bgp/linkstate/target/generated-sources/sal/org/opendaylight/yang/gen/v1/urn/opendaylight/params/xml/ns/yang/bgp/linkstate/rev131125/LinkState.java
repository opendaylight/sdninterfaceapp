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
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping link-state {
 *     leaf local-ipv4-router-id {
 *         type ipv4-router-identifier;
 *     }
 *     leaf local-ipv6-router-id {
 *         type ipv6-router-identifier;
 *     }
 *     leaf remote-ipv4-router-id {
 *         type ipv4-router-identifier;
 *     }
 *     leaf remote-ipv6-router-id {
 *         type ipv6-router-identifier;
 *     }
 *     leaf mpls-protocol {
 *         type mpls-protocol-mask;
 *     }
 *     leaf te-metric {
 *         type te-metric;
 *     }
 *     leaf metric {
 *         type metric;
 *     }
 *     leaf-list shared-risk-link-groups {
 *         type srlg-id;
 *     }
 *     leaf link-name {
 *         type string;
 *     }
 *     leaf max-link-bandwidth {
 *         type bandwidth;
 *     }
 *     leaf max-reservable-bandwidth {
 *         type bandwidth;
 *     }
 *     list unreserved-bandwidth {
 *         key "priority"
 *         leaf priority {
 *             type uint8;
 *         }
 *         leaf bandwidth {
 *             type bandwidth;
 *         }
 *         uses unreserved-bandwidth;
 *     }
 *     leaf link-protection {
 *         type link-protection-type;
 *     }
 *     leaf admin-group {
 *         type administrative-group;
 *     }
 *     leaf sdni-link-state {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/link-state</i>
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

