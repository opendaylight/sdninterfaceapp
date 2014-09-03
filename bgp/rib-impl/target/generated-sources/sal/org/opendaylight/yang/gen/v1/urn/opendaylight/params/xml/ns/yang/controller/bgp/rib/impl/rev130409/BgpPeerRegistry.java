package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceType;


/**
 * Registry of BGP peers. Every new BGP in/out connection looks for peers to handle
 * bgp messages in this registry
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * identity bgp-peer-registry {
 *     base "()IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)service-type]";
 *     description
 *         "Registry of BGP peers. Every new BGP in/out connection looks for peers to handle bgp messages in this registry";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/bgp-peer-registry</i>
 */
public abstract class BgpPeerRegistry extends ServiceType
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","bgp-peer-registry");;
    
    public BgpPeerRegistry() {
    }
    








}
