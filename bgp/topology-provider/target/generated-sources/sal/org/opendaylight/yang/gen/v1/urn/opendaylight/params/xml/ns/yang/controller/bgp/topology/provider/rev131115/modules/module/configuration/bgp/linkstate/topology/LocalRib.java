package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-topology-provider-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-topology-provider-cfg.yang</i>):
 * <pre>
 * container local-rib {
 *     leaf type {
 *         type service-type-ref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)type {
 *             leaf type {
 *                 type service-type-ref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-topology-provider-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider?revision=2013-11-15)bgp-linkstate-topology/local-rib</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology.LocalRibBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology.LocalRibBuilder
 */
public interface LocalRib
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.topology.provider.rev131115.modules.module.configuration.bgp.linkstate.topology.LocalRib>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:topology:provider","2013-11-15","local-rib");;


}

