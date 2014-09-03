package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-treachability-ipv4-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-reachability-ipv4-cfg.yang</i>):
 * <pre>
 * container local-rib {
 *     leaf type {
 *         type service-type-ref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv4?revision=2013-11-15)type {
 *             leaf type {
 *                 type service-type-ref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-treachability-ipv4-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv4?revision=2013-11-15)bgp-reachability-ipv4/local-rib</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4.LocalRibBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4.LocalRibBuilder
 */
public interface LocalRib
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.reachability.ipv4.rev131115.modules.module.configuration.bgp.reachability.ipv4.LocalRib>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:reachability:ipv4","2013-11-15","local-rib");;


}

