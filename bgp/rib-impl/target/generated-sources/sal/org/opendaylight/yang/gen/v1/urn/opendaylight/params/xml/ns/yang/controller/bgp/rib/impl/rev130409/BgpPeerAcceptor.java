package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ModuleType;


/**
 * BGP peer acceptor that handles incomming bgp connections. Uses BGP peer registry
 * to accept or decline incomming connections
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * identity bgp-peer-acceptor {
 *     base "()IdentitySchemaNodeImpl[base=null, qname=(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)module-type]";
 *     description
 *         "BGP peer acceptor that handles incomming bgp connections. Uses BGP peer registry to accept or decline incomming connections";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/bgp-peer-acceptor</i>
 */
public abstract class BgpPeerAcceptor extends ModuleType
 {
    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","bgp-peer-acceptor");;
    
    public BgpPeerAcceptor() {
    }
    








}
