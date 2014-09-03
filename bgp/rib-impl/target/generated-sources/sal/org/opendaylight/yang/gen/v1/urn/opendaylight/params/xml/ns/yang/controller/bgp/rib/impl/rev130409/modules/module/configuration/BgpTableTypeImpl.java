package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * case bgp-table-type-impl {
 *     leaf afi {
 *         type identityref;
 *     }
 *     leaf safi {
 *         type identityref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)bgp-table-type-impl</i>
 */
public interface BgpTableTypeImpl
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpTableTypeImpl>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","bgp-table-type-impl");;

    java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AddressFamily> getAfi();
    
    java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.SubsequentAddressFamily> getSafi();

}

