package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.RibId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.Extensions;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.DataProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.BgpDispatcher;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.SessionReconnectStrategy;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.TcpReconnectStrategy;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.rib.impl.LocalTable;
import java.util.List;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>odl-bgp-rib-impl-cfg</b>
 * <br />(Source path: <i>META-INF/yang/odl-bgp-rib-impl-cfg.yang</i>):
 * <pre>
 * case rib-impl {
 *     container extensions {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container bgp-dispatcher {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container session-reconnect-strategy {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container tcp-reconnect-strategy {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     container data-provider {
 *         leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf local-as {
 *         type uint32;
 *     }
 *     leaf bgp-id {
 *         type ipv4-address;
 *     }
 *     list local-table {
 *         key     leaf type {
 *             type service-type-ref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)type {
 *                 leaf type {
 *                     type service-type-ref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf rib-id {
 *         type rib-id;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>odl-bgp-rib-impl-cfg/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)rib-impl</i>
 */
public interface RibImpl
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.RibImpl>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl","2013-04-09","rib-impl");;

    Extensions getExtensions();
    
    BgpDispatcher getBgpDispatcher();
    
    SessionReconnectStrategy getSessionReconnectStrategy();
    
    TcpReconnectStrategy getTcpReconnectStrategy();
    
    DataProvider getDataProvider();
    
    /**
     * Our local AS number. Needed by best selection path attribute.
     */
    java.lang.Long getLocalAs();
    
    /**
     * Our local BGP identifier. Needed by best selection path attribute.
     */
    Ipv4Address getBgpId();
    
    List<LocalTable> getLocalTable();
    
    /**
     * Identifier of this RIB in local data store.
     */
    RibId getRibId();

}

