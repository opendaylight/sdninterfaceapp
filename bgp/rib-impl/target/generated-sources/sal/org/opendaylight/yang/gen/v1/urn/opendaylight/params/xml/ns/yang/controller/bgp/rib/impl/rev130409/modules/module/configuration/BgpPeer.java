package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.Rib;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.tcpmd5.cfg.rev140427.Rfc2385Key;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.AdvertizedTable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.PeerRegistry;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * case bgp-peer {
 *     leaf host {
 *         type ip-address;
 *     }
 *     leaf port {
 *         type port-number;
 *     }
 *     leaf holdtimer {
 *         type int16;
 *     }
 *     leaf initiate-connection {
 *         type boolean;
 *     }
 *     list advertized-table {
 *         key     leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf remote-as {
 *         type uint32;
 *     }
 *     leaf password {
 *         type rfc2385-key;
 *     }
 *     container rib {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container peer-registry {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)bgp-peer</i>
 */
public interface BgpPeer
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeer>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","bgp-peer");;

    /**
     * Remote host IP address
     */
    IpAddress getHost();
    
    /**
     * Remote host port
     */
    PortNumber getPort();
    
    java.lang.Short getHoldtimer();
    
    /**
     * If true, connection will be initiated right away from current device. If not, 
     * the peer will only be registered to peer registry and available for incomming 
     * bgp connections.
     */
    java.lang.Boolean isInitiateConnection();
    
    List<AdvertizedTable> getAdvertizedTable();
    
    /**
     * Expected remote AS number. If not present, it is assumed to be the same as our 
     * local AS number.
     */
    java.lang.Long getRemoteAs();
    
    /**
     * RFC2385 shared secret
     */
    Rfc2385Key getPassword();
    
    Rib getRib();
    
    /**
     * BGP peer registry where current instance of BGP peer will be registered.
     */
    PeerRegistry getPeerRegistry();

}

