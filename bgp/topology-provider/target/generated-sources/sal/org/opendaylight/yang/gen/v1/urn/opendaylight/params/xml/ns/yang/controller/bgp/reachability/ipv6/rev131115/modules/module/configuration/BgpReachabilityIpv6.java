package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv6.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv6.rev131115.modules.module.configuration.bgp.reachability.ipv6.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv6.rev131115.modules.module.configuration.bgp.reachability.ipv6.LocalRib;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-treachability-ipv6-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-reachability-ipv6-cfg.yang</i>):
 * <pre>
 * case bgp-reachability-ipv6 {
 *     container data-provider {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv6?revision=2013-11-15)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container local-rib {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv6?revision=2013-11-15)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf topology-id {
 *         type topology-id;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-treachability-ipv6-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv6?revision=2013-11-15)bgp-reachability-ipv6</i>
 */
public interface BgpReachabilityIpv6
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv6.rev131115.modules.module.configuration.BgpReachabilityIpv6>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv6","2013-11-15","bgp-reachability-ipv6");;

    DataProvider getDataProvider();
    
    LocalRib getLocalRib();
    
    TopologyId getTopologyId();

}

