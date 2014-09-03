package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.cfg.rev130701;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceType;


/**
 * Service representing a BGP RIB service. Each instance allows registration of 
 * listeners.
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-cfg.yang</i>):
 * <pre>
 * identity rib {
 *     base "()IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)service-type]";
 *     description
 *         "Service representing a BGP RIB service. Each instance allows
 *                      registration of listeners.";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-cfg/rib</i>
 */
public abstract class Rib extends ServiceType
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:cfg","2013-07-01","rib");;
    
    public Rib() {
    }
    








}
