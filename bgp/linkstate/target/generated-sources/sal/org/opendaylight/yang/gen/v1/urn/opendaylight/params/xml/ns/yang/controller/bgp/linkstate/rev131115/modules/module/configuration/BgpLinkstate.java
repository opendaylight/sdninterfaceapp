package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-linkstate-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-linkstate-cfg.yang</i>):
 * <pre>
 * case bgp-linkstate {
 *     leaf iana-linkstate-attribute-type {
 *         type boolean;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-linkstate-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:linkstate?revision=2013-11-15)bgp-linkstate</i>
 */
public interface BgpLinkstate
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.linkstate.rev131115.modules.module.configuration.BgpLinkstate>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:linkstate","2013-11-15","bgp-linkstate");;

    /**
     * If true (default) linkstate attribute type (=29) allocated by IANA is used, else
     * type (=99) is used for parsing/serialization
     */
    java.lang.Boolean isIanaLinkstateAttributeType();

}

