package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.parser.spi.rev131115.ConsumerExtensions;


/**
 * Service representing a BGP parser extension registry. Extension providers have 
 * this service injected for registration.
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-parser-spi-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-parser-spi-cfg.yang</i>):
 * <pre>
 * identity extensions {
 *     base "()IdentitySchemaNodeImpl[base=IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)service-type], qname=(urn:opendaylight:params:xml:ns:yang:controller:bgp:parser:spi?revision=2013-11-15)consumer-extensions]";
 *     description
 *         "Service representing a BGP parser extension registry. Extension
 *                     providers have this service injected for registration.";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-parser-spi-cfg/extensions</i>
 */
public abstract class Extensions extends ConsumerExtensions
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:parser:spi","2013-11-15","extensions");;
    
    public Extensions() {
    }
    








}
