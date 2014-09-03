package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.acceptor.AcceptingBgpDispatcher;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.peer.acceptor.AcceptingPeerRegistry;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * case bgp-peer-acceptor {
 *     leaf binding-address {
 *         type ip-address;
 *     }
 *     leaf binding-port {
 *         type port-number;
 *     }
 *     container accepting-bgp-dispatcher {
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
 *     container accepting-peer-registry {
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
 * <i>odl-bgp-rib-impl-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)bgp-peer-acceptor</i>
 */
public interface BgpPeerAcceptor
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpPeerAcceptor>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","bgp-peer-acceptor");;

    /**
     * IP address to bind to
     */
    IpAddress getBindingAddress();
    
    /**
     * Port to bind to
     */
    PortNumber getBindingPort();
    
    AcceptingBgpDispatcher getAcceptingBgpDispatcher();
    
    AcceptingPeerRegistry getAcceptingPeerRegistry();

}

