package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology.LocalRib;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-topology-provider-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-topology-provider-cfg.yang</i>):
 * <pre>
 * case bgp-linkstate-topology {
 *     container data-provider {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)type {
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
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)type {
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
 * <i>odl-bgp-topology-provider-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)bgp-linkstate-topology</i>
 */
public interface BgpLinkstateTopology
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.BgpLinkstateTopology>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider","2013-11-15","bgp-linkstate-topology");;

    DataProvider getDataProvider();
    
    LocalRib getLocalRib();
    
    TopologyId getTopologyId();

}

