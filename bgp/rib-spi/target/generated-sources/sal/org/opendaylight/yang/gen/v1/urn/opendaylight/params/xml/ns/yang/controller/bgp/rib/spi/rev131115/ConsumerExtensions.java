package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.spi.rev131115;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceType;


/**
 * Service representing a BGP RIB extension registry. Extension consumers have this
 * service injected.
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-spi-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-spi-cfg.yang</i>):
 * <pre>
 * identity consumer-extensions {
 *     base "()IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)service-type]";
 *     description
 *         "Service representing a BGP RIB extension registry. Extension
 *                     consumers have this service injected.";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-spi-cfg/consumer-extensions</i>
 */
public abstract class ConsumerExtensions extends ServiceType
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:spi","2013-11-15","consumer-extensions");;
    
    public ConsumerExtensions() {
    }
    








}
