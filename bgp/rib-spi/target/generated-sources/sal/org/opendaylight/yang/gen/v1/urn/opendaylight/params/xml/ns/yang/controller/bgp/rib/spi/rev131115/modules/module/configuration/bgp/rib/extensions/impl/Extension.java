package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-spi-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-spi-cfg.yang</i>):
 * <pre>
 * list extension {
 *     key     leaf type {
 *         type service-type-ref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:spi?revision=2013-11-15)type {
 *             leaf type {
 *                 type service-type-ref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-spi-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:spi?revision=2013-11-15)bgp-rib-extensions-impl/extension</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl.ExtensionBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl.ExtensionBuilder@see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl.ExtensionKey
 */
public interface Extension
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115.modules.module.configuration.bgp.rib.extensions.impl.Extension>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:spi","2013-11-15","extension");;


}

