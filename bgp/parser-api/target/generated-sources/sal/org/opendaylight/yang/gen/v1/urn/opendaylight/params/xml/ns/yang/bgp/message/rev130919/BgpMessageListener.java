package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Keepalive;
import org.opendaylight.yangtools.yang.binding.NotificationListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify;


/**
 * Interface for receiving the following YANG notifications defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * notification keepalive {
 *     description
 *         "Keepalive Message";
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.4";
 *     status CURRENT;
 * }
 * notification notify {
 *     description
 *         "Notification Message";
 *     leaf error-code {
 *         type uint8;
 *     }
 *     leaf error-subcode {
 *         type uint8;
 *     }
 *     leaf data {
 *         type binary;
 *     }
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.5";
 *     status CURRENT;
 * }
 * notification open {
 *     description
 *         "Open Message";
 *     leaf version {
 *         type protocol-version;
 *     }
 *     leaf my-as-number {
 *         type uint16;
 *     }
 *     leaf hold-timer {
 *         type uint16;
 *     }
 *     leaf bgp-identifier {
 *         type ipv4-address;
 *     }
 *     list bgp-parameters {
 *         key     choice c-parameters {
 *             case as4-bytes-case {
 *                 container as4-bytes-capability {
 *                     leaf as-number {
 *                         type as-number;
 *                     }
 *                 }
 *             }
 *             case graceful-restart-case {
 *                 container graceful-restart-capability {
 *                     leaf restart-flags {
 *                         type bits;
 *                     }
 *                     leaf restart-time {
 *                         type uint16;
 *                     }
 *                     list tables {
 *                         key "afi" 
 *                     "safi"
 *                         leaf afi {
 *                             type identityref;
 *                         }
 *                         leaf safi {
 *                             type identityref;
 *                         }
 *                         leaf afi-flags {
 *                             type bits;
 *                         }
 *                         uses bgp-table-type;
 *                     }
 *                 }
 *             }
 *             case multiprotocol-case {
 *                 container multiprotocol-capability {
 *                     leaf afi {
 *                         type identityref;
 *                     }
 *                     leaf safi {
 *                         type identityref;
 *                     }
 *                     uses bgp-table-type;
 *                 }
 *             }
 *         }
 *     }
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.2";
 *     status CURRENT;
 * }
 * notification update {
 *     description
 *         "Update Message";
 *     container path-attributes {
 *         container origin {
 *             leaf value {
 *                 type bgp-origin;
 *             }
 *         }
 *         container as-path {
 *             list segments {
 *                 key     choice c-segment {
 *                     case a-list-case {
 *                         container a-list {
 *                             list as-sequence {
 *                                 key     leaf as {
 *                                     type as-number;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     case a-set-case {
 *                         container a-set {
 *                             leaf-list as-set {
 *                                 type as-number;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 uses as-path-segment;
 *             }
 *         }
 *         choice c-next-hop {
 *             case ipv4-next-hop-case {
 *                 container ipv4-next-hop {
 *                     leaf global {
 *                         type ipv4-address;
 *                     }
 *                 }
 *             }
 *             case ipv6-next-hop-case {
 *                 container ipv6-next-hop {
 *                     leaf global {
 *                         type ipv6-address;
 *                     }
 *                     leaf link-local {
 *                         type ipv6-address;
 *                     }
 *                 }
 *             }
 *         }
 *         container multi-exit-disc {
 *             leaf med {
 *                 type uint32;
 *             }
 *         }
 *         container local-pref {
 *             leaf pref {
 *                 type uint32;
 *             }
 *         }
 *         container atomic-aggregate {
 *         }
 *         container aggregator {
 *             leaf as-number {
 *                 type as-number;
 *             }
 *             leaf network-address {
 *                 type ipv4-address;
 *             }
 *             uses bgp-aggregator;
 *         }
 *         list communities {
 *             key     leaf as-number {
 *                 type as-number;
 *             }
 *             leaf semantics {
 *                 type uint16;
 *             }
 *             uses community;
 *         }
 *         list extended-communities {
 *             key     leaf comm-type {
 *                 type uint8;
 *             }
 *             leaf comm-sub-type {
 *                 type uint8;
 *             }
 *             choice extended-community {
 *                 case as-specific-extended-community-case {
 *                     container as-specific-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case inet4-specific-extended-community-case {
 *                     container inet4-specific-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf global-administrator {
 *                             type ipv4-address;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case opaque-extended-community-case {
 *                     container opaque-extended-community {
 *                         leaf transitive {
 *                             type boolean;
 *                         }
 *                         leaf value {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case route-origin-extended-community-case {
 *                     container route-origin-extended-community {
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *                 case route-target-extended-community-case {
 *                     container route-target-extended-community {
 *                         leaf global-administrator {
 *                             type short-as-number;
 *                         }
 *                         leaf local-administrator {
 *                             type binary;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses extended-community;
 *         }
 *         container originator-id {
 *             leaf originator {
 *                 type ipv4-address;
 *             }
 *             uses originator-id;
 *         }
 *         container cluster-id {
 *             leaf-list cluster {
 *                 type cluster-identifier;
 *             }
 *             uses cluster-id;
 *         }
 *         container mp-reach-nlri {
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             choice c-next-hop {
 *                 case ipv4-next-hop-case {
 *                     container ipv4-next-hop {
 *                         leaf global {
 *                             type ipv4-address;
 *                         }
 *                     }
 *                 }
 *                 case ipv6-next-hop-case {
 *                     container ipv6-next-hop {
 *                         leaf global {
 *                             type ipv6-address;
 *                         }
 *                         leaf link-local {
 *                             type ipv6-address;
 *                         }
 *                     }
 *                 }
 *             }
 *             container advertized-routes {
 *                 choice destination-type {
 *                     case destination-ipv4-case {
 *                         container destination-ipv4 {
 *                             leaf-list ipv4-prefixes {
 *                                 type ipv4-prefix;
 *                             }
 *                         }
 *                     }
 *                     case destination-ipv6-case {
 *                         container destination-ipv6 {
 *                             leaf-list ipv6-prefixes {
 *                                 type ipv6-prefix;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 uses destination;
 *             }
 *             uses bgp-table-type;
 *             uses next-hop;
 *         }
 *         container mp-unreach-nlri {
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             container withdrawn-routes {
 *                 choice destination-type {
 *                     case destination-ipv4-case {
 *                         container destination-ipv4 {
 *                             leaf-list ipv4-prefixes {
 *                                 type ipv4-prefix;
 *                             }
 *                         }
 *                     }
 *                     case destination-ipv6-case {
 *                         container destination-ipv6 {
 *                             leaf-list ipv6-prefixes {
 *                                 type ipv6-prefix;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 uses destination;
 *             }
 *             uses bgp-table-type;
 *         }
 *         augment \(urn:opendaylight:params:xml:ns:yang:bgp-message)update\(urn:opendaylight:params:xml:ns:yang:bgp-message)path-attributes {
 *             status CURRENT;
 *             container mp-reach-nlri {
 *                 leaf afi {
 *                     type identityref;
 *                 }
 *                 leaf safi {
 *                     type identityref;
 *                 }
 *                 choice c-next-hop {
 *                     case ipv4-next-hop-case {
 *                         container ipv4-next-hop {
 *                             leaf global {
 *                                 type ipv4-address;
 *                             }
 *                         }
 *                     }
 *                     case ipv6-next-hop-case {
 *                         container ipv6-next-hop {
 *                             leaf global {
 *                                 type ipv6-address;
 *                             }
 *                             leaf link-local {
 *                                 type ipv6-address;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 container advertized-routes {
 *                     choice destination-type {
 *                         case destination-ipv4-case {
 *                             container destination-ipv4 {
 *                                 leaf-list ipv4-prefixes {
 *                                     type ipv4-prefix;
 *                                 }
 *                             }
 *                         }
 *                         case destination-ipv6-case {
 *                             container destination-ipv6 {
 *                                 leaf-list ipv6-prefixes {
 *                                     type ipv6-prefix;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     uses destination;
 *                 }
 *                 uses bgp-table-type;
 *                 uses next-hop;
 *             }
 *         }
 *         augment \(urn:opendaylight:params:xml:ns:yang:bgp-message)update\(urn:opendaylight:params:xml:ns:yang:bgp-message)path-attributes {
 *             status CURRENT;
 *             container mp-unreach-nlri {
 *                 leaf afi {
 *                     type identityref;
 *                 }
 *                 leaf safi {
 *                     type identityref;
 *                 }
 *                 container withdrawn-routes {
 *                     choice destination-type {
 *                         case destination-ipv4-case {
 *                             container destination-ipv4 {
 *                                 leaf-list ipv4-prefixes {
 *                                     type ipv4-prefix;
 *                                 }
 *                             }
 *                         }
 *                         case destination-ipv6-case {
 *                             container destination-ipv6 {
 *                                 leaf-list ipv6-prefixes {
 *                                     type ipv6-prefix;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     uses destination;
 *                 }
 *                 uses bgp-table-type;
 *             }
 *         }
 *         uses path-attributes;
 *     }
 *     container withdrawn-routes {
 *         leaf-list withdrawn-routes {
 *             type ipv4-prefix;
 *         }
 *     }
 *     container nlri {
 *         leaf-list nlri {
 *             type ipv4-prefix;
 *         }
 *     }
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.3";
 *     status CURRENT;
 * }
 * </pre>
 */
public interface BgpMessageListener
    extends
    NotificationListener
{




    /**
     * Keepalive Message
     */
    void onKeepalive(Keepalive notification);
    
    /**
     * Notification Message
     */
    void onNotify(Notify notification);
    
    /**
     * Open Message
     */
    void onOpen(Open notification);
    
    /**
     * Update Message
     */
    void onUpdate(Update notification);

}

