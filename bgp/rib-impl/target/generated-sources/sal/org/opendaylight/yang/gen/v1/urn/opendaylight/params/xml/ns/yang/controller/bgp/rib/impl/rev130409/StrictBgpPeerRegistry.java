package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ModuleType;


/**
 * Registry of BGP peers that allows only one connection per 2 peers. Uses IP 
 * address for Peer identification and BGP Ids to resolve duplicate connections
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * identity strict-bgp-peer-registry {
 *     base "()IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)module-type]";
 *     description
 *         "Registry of BGP peers that allows only one connection per 2 peers. Uses IP address for Peer identification and BGP Ids to resolve duplicate connections";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/strict-bgp-peer-registry</i>
 */
public abstract class StrictBgpPeerRegistry extends ModuleType
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","strict-bgp-peer-registry");;
    
    public StrictBgpPeerRegistry() {
    }
    








}
