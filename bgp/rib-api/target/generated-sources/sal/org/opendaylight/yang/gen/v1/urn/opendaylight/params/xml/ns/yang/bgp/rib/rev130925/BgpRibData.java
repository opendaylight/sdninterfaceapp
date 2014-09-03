package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.ApplicationRib;
import org.opendaylight.yangtools.yang.binding.DataRoot;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.BgpRib;


/**
 * This module contains the concept of a Routing Information Base, as defined by 
 * RFC4271. Copyright (c)2013 Cisco Systems, Inc. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-rib</b>
 * <br />Source path: <i>META-INF/yang/bgp-rib.yang</i>):
 * <pre>
 * module bgp-rib {
 *     yang-version 1;
 *     namespace "urn:opendaylight:params:xml:ns:yang:bgp-rib";
 *     prefix "rib";
 *     import bgp-message { prefix "bgp-msg"; }
 *     
 *     import ietf-inet-types { prefix "inet"; }
 *     
 *     import bgp-multiprotocol { prefix "bgp-mp"; }
 *     revision 2013-00-25 {
 *         description "This module contains the concept of a Routing Information Base, as defined by 
 *                     RFC4271. Copyright (c)2013 Cisco Systems, Inc. All rights reserved. This program
 *                     and the accompanying materials are made available under the terms of the Eclipse
 *                     Public License v1.0 which accompanies this distribution, and is available at 
 *                     http://www.eclipse.org/legal/epl-v10.html
 *         ";
 *     }
 *     list application-rib {
 *         key "id"
 *         leaf id {
 *             type application-rib-id;
 *         }
 *         list tables {
 *             key "afi" 
 *         "safi"
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             container attributes {
 *                 leaf uptodate {
 *                     type boolean;
 *                 }
 *             }
 *             choice routes {
 *                 case ipv4-routes-case {
 *                     container ipv4-routes {
 *                         list ipv4-route {
 *                             key "prefix"
 *                             leaf prefix {
 *                                 type ipv4-prefix;
 *                             }
 *                             container attributes {
 *                                 container origin {
 *                                     leaf value {
 *                                         type bgp-origin;
 *                                     }
 *                                 }
 *                                 container as-path {
 *                                     list segments {
 *                                         key     choice c-segment {
 *                                             case a-list-case {
 *                                                 container a-list {
 *                                                     list as-sequence {
 *                                                         key     leaf as {
 *                                                             type as-number;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case a-set-case {
 *                                                 container a-set {
 *                                                     leaf-list as-set {
 *                                                         type as-number;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         uses as-path-segment;
 *                                     }
 *                                 }
 *                                 choice c-next-hop {
 *                                     case ipv4-next-hop-case {
 *                                         container ipv4-next-hop {
 *                                             leaf global {
 *                                                 type ipv4-address;
 *                                             }
 *                                         }
 *                                     }
 *                                     case ipv6-next-hop-case {
 *                                         container ipv6-next-hop {
 *                                             leaf global {
 *                                                 type ipv6-address;
 *                                             }
 *                                             leaf link-local {
 *                                                 type ipv6-address;
 *                                             }
 *                                         }
 *                                     }
 *                                 }
 *                                 container multi-exit-disc {
 *                                     leaf med {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container local-pref {
 *                                     leaf pref {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container atomic-aggregate {
 *                                 }
 *                                 container aggregator {
 *                                     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf network-address {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses bgp-aggregator;
 *                                 }
 *                                 list communities {
 *                                     key     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf semantics {
 *                                         type uint16;
 *                                     }
 *                                     uses community;
 *                                 }
 *                                 list extended-communities {
 *                                     key     leaf comm-type {
 *                                         type uint8;
 *                                     }
 *                                     leaf comm-sub-type {
 *                                         type uint8;
 *                                     }
 *                                     choice extended-community {
 *                                         case as-specific-extended-community-case {
 *                                             container as-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case inet4-specific-extended-community-case {
 *                                             container inet4-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case opaque-extended-community-case {
 *                                             container opaque-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf value {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-origin-extended-community-case {
 *                                             container route-origin-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-target-extended-community-case {
 *                                             container route-target-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                     }
 *                                     uses extended-community;
 *                                 }
 *                                 container originator-id {
 *                                     leaf originator {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses originator-id;
 *                                 }
 *                                 container cluster-id {
 *                                     leaf-list cluster {
 *                                         type cluster-identifier;
 *                                     }
 *                                     uses cluster-id;
 *                                 }
 *                                 uses path-attributes;
 *                             }
 *                             uses route;
 *                         }
 *                     }
 *                 }
 *                 case ipv6-routes-case {
 *                     container ipv6-routes {
 *                         list ipv6-route {
 *                             key "prefix"
 *                             leaf prefix {
 *                                 type ipv6-prefix;
 *                             }
 *                             container attributes {
 *                                 container origin {
 *                                     leaf value {
 *                                         type bgp-origin;
 *                                     }
 *                                 }
 *                                 container as-path {
 *                                     list segments {
 *                                         key     choice c-segment {
 *                                             case a-list-case {
 *                                                 container a-list {
 *                                                     list as-sequence {
 *                                                         key     leaf as {
 *                                                             type as-number;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case a-set-case {
 *                                                 container a-set {
 *                                                     leaf-list as-set {
 *                                                         type as-number;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         uses as-path-segment;
 *                                     }
 *                                 }
 *                                 choice c-next-hop {
 *                                     case ipv4-next-hop-case {
 *                                         container ipv4-next-hop {
 *                                             leaf global {
 *                                                 type ipv4-address;
 *                                             }
 *                                         }
 *                                     }
 *                                     case ipv6-next-hop-case {
 *                                         container ipv6-next-hop {
 *                                             leaf global {
 *                                                 type ipv6-address;
 *                                             }
 *                                             leaf link-local {
 *                                                 type ipv6-address;
 *                                             }
 *                                         }
 *                                     }
 *                                 }
 *                                 container multi-exit-disc {
 *                                     leaf med {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container local-pref {
 *                                     leaf pref {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container atomic-aggregate {
 *                                 }
 *                                 container aggregator {
 *                                     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf network-address {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses bgp-aggregator;
 *                                 }
 *                                 list communities {
 *                                     key     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf semantics {
 *                                         type uint16;
 *                                     }
 *                                     uses community;
 *                                 }
 *                                 list extended-communities {
 *                                     key     leaf comm-type {
 *                                         type uint8;
 *                                     }
 *                                     leaf comm-sub-type {
 *                                         type uint8;
 *                                     }
 *                                     choice extended-community {
 *                                         case as-specific-extended-community-case {
 *                                             container as-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case inet4-specific-extended-community-case {
 *                                             container inet4-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case opaque-extended-community-case {
 *                                             container opaque-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf value {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-origin-extended-community-case {
 *                                             container route-origin-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-target-extended-community-case {
 *                                             container route-target-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                     }
 *                                     uses extended-community;
 *                                 }
 *                                 container originator-id {
 *                                     leaf originator {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses originator-id;
 *                                 }
 *                                 container cluster-id {
 *                                     leaf-list cluster {
 *                                         type cluster-identifier;
 *                                     }
 *                                     uses cluster-id;
 *                                 }
 *                                 uses path-attributes;
 *                             }
 *                             uses route;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses bgp-table-type;
 *         }
 *         uses rib;
 *     }
 *     container bgp-rib {
 *         list rib {
 *             key "id"
 *             leaf id {
 *                 type rib-id;
 *             }
 *             list peers {
 *                 key     container adj-rib-in {
 *                     list tables {
 *                         key "afi" 
 *                     "safi"
 *                         leaf afi {
 *                             type identityref;
 *                         }
 *                         leaf safi {
 *                             type identityref;
 *                         }
 *                         container attributes {
 *                             leaf uptodate {
 *                                 type boolean;
 *                             }
 *                         }
 *                         choice routes {
 *                             case ipv4-routes-case {
 *                                 container ipv4-routes {
 *                                     list ipv4-route {
 *                                         key "prefix"
 *                                         leaf prefix {
 *                                             type ipv4-prefix;
 *                                         }
 *                                         container attributes {
 *                                             container origin {
 *                                                 leaf value {
 *                                                     type bgp-origin;
 *                                                 }
 *                                             }
 *                                             container as-path {
 *                                                 list segments {
 *                                                     key     choice c-segment {
 *                                                         case a-list-case {
 *                                                             container a-list {
 *                                                                 list as-sequence {
 *                                                                     key     leaf as {
 *                                                                         type as-number;
 *                                                                     }
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                         case a-set-case {
 *                                                             container a-set {
 *                                                                 leaf-list as-set {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     uses as-path-segment;
 *                                                 }
 *                                             }
 *                                             choice c-next-hop {
 *                                                 case ipv4-next-hop-case {
 *                                                     container ipv4-next-hop {
 *                                                         leaf global {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case ipv6-next-hop-case {
 *                                                     container ipv6-next-hop {
 *                                                         leaf global {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                         leaf link-local {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             container multi-exit-disc {
 *                                                 leaf med {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container local-pref {
 *                                                 leaf pref {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container atomic-aggregate {
 *                                             }
 *                                             container aggregator {
 *                                                 leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf network-address {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses bgp-aggregator;
 *                                             }
 *                                             list communities {
 *                                                 key     leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf semantics {
 *                                                     type uint16;
 *                                                 }
 *                                                 uses community;
 *                                             }
 *                                             list extended-communities {
 *                                                 key     leaf comm-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 leaf comm-sub-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 choice extended-community {
 *                                                     case as-specific-extended-community-case {
 *                                                         container as-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case inet4-specific-extended-community-case {
 *                                                         container inet4-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type ipv4-address;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case opaque-extended-community-case {
 *                                                         container opaque-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf value {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-origin-extended-community-case {
 *                                                         container route-origin-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-target-extended-community-case {
 *                                                         container route-target-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses extended-community;
 *                                             }
 *                                             container originator-id {
 *                                                 leaf originator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses originator-id;
 *                                             }
 *                                             container cluster-id {
 *                                                 leaf-list cluster {
 *                                                     type cluster-identifier;
 *                                                 }
 *                                                 uses cluster-id;
 *                                             }
 *                                             uses path-attributes;
 *                                         }
 *                                         uses route;
 *                                     }
 *                                 }
 *                             }
 *                             case ipv6-routes-case {
 *                                 container ipv6-routes {
 *                                     list ipv6-route {
 *                                         key "prefix"
 *                                         leaf prefix {
 *                                             type ipv6-prefix;
 *                                         }
 *                                         container attributes {
 *                                             container origin {
 *                                                 leaf value {
 *                                                     type bgp-origin;
 *                                                 }
 *                                             }
 *                                             container as-path {
 *                                                 list segments {
 *                                                     key     choice c-segment {
 *                                                         case a-list-case {
 *                                                             container a-list {
 *                                                                 list as-sequence {
 *                                                                     key     leaf as {
 *                                                                         type as-number;
 *                                                                     }
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                         case a-set-case {
 *                                                             container a-set {
 *                                                                 leaf-list as-set {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     uses as-path-segment;
 *                                                 }
 *                                             }
 *                                             choice c-next-hop {
 *                                                 case ipv4-next-hop-case {
 *                                                     container ipv4-next-hop {
 *                                                         leaf global {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case ipv6-next-hop-case {
 *                                                     container ipv6-next-hop {
 *                                                         leaf global {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                         leaf link-local {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             container multi-exit-disc {
 *                                                 leaf med {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container local-pref {
 *                                                 leaf pref {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container atomic-aggregate {
 *                                             }
 *                                             container aggregator {
 *                                                 leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf network-address {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses bgp-aggregator;
 *                                             }
 *                                             list communities {
 *                                                 key     leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf semantics {
 *                                                     type uint16;
 *                                                 }
 *                                                 uses community;
 *                                             }
 *                                             list extended-communities {
 *                                                 key     leaf comm-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 leaf comm-sub-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 choice extended-community {
 *                                                     case as-specific-extended-community-case {
 *                                                         container as-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case inet4-specific-extended-community-case {
 *                                                         container inet4-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type ipv4-address;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case opaque-extended-community-case {
 *                                                         container opaque-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf value {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-origin-extended-community-case {
 *                                                         container route-origin-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-target-extended-community-case {
 *                                                         container route-target-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses extended-community;
 *                                             }
 *                                             container originator-id {
 *                                                 leaf originator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses originator-id;
 *                                             }
 *                                             container cluster-id {
 *                                                 leaf-list cluster {
 *                                                     type cluster-identifier;
 *                                                 }
 *                                                 uses cluster-id;
 *                                             }
 *                                             uses path-attributes;
 *                                         }
 *                                         uses route;
 *                                     }
 *                                 }
 *                             }
 *                         }
 *                         uses bgp-table-type;
 *                     }
 *                     uses rib;
 *                 }
 *                 container adj-rib-out {
 *                     list tables {
 *                         key "afi" 
 *                     "safi"
 *                         leaf afi {
 *                             type identityref;
 *                         }
 *                         leaf safi {
 *                             type identityref;
 *                         }
 *                         container attributes {
 *                             leaf uptodate {
 *                                 type boolean;
 *                             }
 *                         }
 *                         choice routes {
 *                             case ipv4-routes-case {
 *                                 container ipv4-routes {
 *                                     list ipv4-route {
 *                                         key "prefix"
 *                                         leaf prefix {
 *                                             type ipv4-prefix;
 *                                         }
 *                                         container attributes {
 *                                             container origin {
 *                                                 leaf value {
 *                                                     type bgp-origin;
 *                                                 }
 *                                             }
 *                                             container as-path {
 *                                                 list segments {
 *                                                     key     choice c-segment {
 *                                                         case a-list-case {
 *                                                             container a-list {
 *                                                                 list as-sequence {
 *                                                                     key     leaf as {
 *                                                                         type as-number;
 *                                                                     }
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                         case a-set-case {
 *                                                             container a-set {
 *                                                                 leaf-list as-set {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     uses as-path-segment;
 *                                                 }
 *                                             }
 *                                             choice c-next-hop {
 *                                                 case ipv4-next-hop-case {
 *                                                     container ipv4-next-hop {
 *                                                         leaf global {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case ipv6-next-hop-case {
 *                                                     container ipv6-next-hop {
 *                                                         leaf global {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                         leaf link-local {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             container multi-exit-disc {
 *                                                 leaf med {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container local-pref {
 *                                                 leaf pref {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container atomic-aggregate {
 *                                             }
 *                                             container aggregator {
 *                                                 leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf network-address {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses bgp-aggregator;
 *                                             }
 *                                             list communities {
 *                                                 key     leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf semantics {
 *                                                     type uint16;
 *                                                 }
 *                                                 uses community;
 *                                             }
 *                                             list extended-communities {
 *                                                 key     leaf comm-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 leaf comm-sub-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 choice extended-community {
 *                                                     case as-specific-extended-community-case {
 *                                                         container as-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case inet4-specific-extended-community-case {
 *                                                         container inet4-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type ipv4-address;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case opaque-extended-community-case {
 *                                                         container opaque-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf value {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-origin-extended-community-case {
 *                                                         container route-origin-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-target-extended-community-case {
 *                                                         container route-target-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses extended-community;
 *                                             }
 *                                             container originator-id {
 *                                                 leaf originator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses originator-id;
 *                                             }
 *                                             container cluster-id {
 *                                                 leaf-list cluster {
 *                                                     type cluster-identifier;
 *                                                 }
 *                                                 uses cluster-id;
 *                                             }
 *                                             uses path-attributes;
 *                                         }
 *                                         uses route;
 *                                     }
 *                                 }
 *                             }
 *                             case ipv6-routes-case {
 *                                 container ipv6-routes {
 *                                     list ipv6-route {
 *                                         key "prefix"
 *                                         leaf prefix {
 *                                             type ipv6-prefix;
 *                                         }
 *                                         container attributes {
 *                                             container origin {
 *                                                 leaf value {
 *                                                     type bgp-origin;
 *                                                 }
 *                                             }
 *                                             container as-path {
 *                                                 list segments {
 *                                                     key     choice c-segment {
 *                                                         case a-list-case {
 *                                                             container a-list {
 *                                                                 list as-sequence {
 *                                                                     key     leaf as {
 *                                                                         type as-number;
 *                                                                     }
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                         case a-set-case {
 *                                                             container a-set {
 *                                                                 leaf-list as-set {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     uses as-path-segment;
 *                                                 }
 *                                             }
 *                                             choice c-next-hop {
 *                                                 case ipv4-next-hop-case {
 *                                                     container ipv4-next-hop {
 *                                                         leaf global {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case ipv6-next-hop-case {
 *                                                     container ipv6-next-hop {
 *                                                         leaf global {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                         leaf link-local {
 *                                                             type ipv6-address;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             container multi-exit-disc {
 *                                                 leaf med {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container local-pref {
 *                                                 leaf pref {
 *                                                     type uint32;
 *                                                 }
 *                                             }
 *                                             container atomic-aggregate {
 *                                             }
 *                                             container aggregator {
 *                                                 leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf network-address {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses bgp-aggregator;
 *                                             }
 *                                             list communities {
 *                                                 key     leaf as-number {
 *                                                     type as-number;
 *                                                 }
 *                                                 leaf semantics {
 *                                                     type uint16;
 *                                                 }
 *                                                 uses community;
 *                                             }
 *                                             list extended-communities {
 *                                                 key     leaf comm-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 leaf comm-sub-type {
 *                                                     type uint8;
 *                                                 }
 *                                                 choice extended-community {
 *                                                     case as-specific-extended-community-case {
 *                                                         container as-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case inet4-specific-extended-community-case {
 *                                                         container inet4-specific-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf global-administrator {
 *                                                                 type ipv4-address;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case opaque-extended-community-case {
 *                                                         container opaque-extended-community {
 *                                                             leaf transitive {
 *                                                                 type boolean;
 *                                                             }
 *                                                             leaf value {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-origin-extended-community-case {
 *                                                         container route-origin-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case route-target-extended-community-case {
 *                                                         container route-target-extended-community {
 *                                                             leaf global-administrator {
 *                                                                 type short-as-number;
 *                                                             }
 *                                                             leaf local-administrator {
 *                                                                 type binary;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses extended-community;
 *                                             }
 *                                             container originator-id {
 *                                                 leaf originator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 uses originator-id;
 *                                             }
 *                                             container cluster-id {
 *                                                 leaf-list cluster {
 *                                                     type cluster-identifier;
 *                                                 }
 *                                                 uses cluster-id;
 *                                             }
 *                                             uses path-attributes;
 *                                         }
 *                                         uses route;
 *                                     }
 *                                 }
 *                             }
 *                         }
 *                         uses bgp-table-type;
 *                     }
 *                     uses rib;
 *                 }
 *             }
 *             container loc-rib {
 *                 list tables {
 *                     key "afi" 
 *                 "safi"
 *                     leaf afi {
 *                         type identityref;
 *                     }
 *                     leaf safi {
 *                         type identityref;
 *                     }
 *                     container attributes {
 *                         leaf uptodate {
 *                             type boolean;
 *                         }
 *                     }
 *                     choice routes {
 *                         case ipv4-routes-case {
 *                             container ipv4-routes {
 *                                 list ipv4-route {
 *                                     key "prefix"
 *                                     leaf prefix {
 *                                         type ipv4-prefix;
 *                                     }
 *                                     container attributes {
 *                                         container origin {
 *                                             leaf value {
 *                                                 type bgp-origin;
 *                                             }
 *                                         }
 *                                         container as-path {
 *                                             list segments {
 *                                                 key     choice c-segment {
 *                                                     case a-list-case {
 *                                                         container a-list {
 *                                                             list as-sequence {
 *                                                                 key     leaf as {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case a-set-case {
 *                                                         container a-set {
 *                                                             leaf-list as-set {
 *                                                                 type as-number;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses as-path-segment;
 *                                             }
 *                                         }
 *                                         choice c-next-hop {
 *                                             case ipv4-next-hop-case {
 *                                                 container ipv4-next-hop {
 *                                                     leaf global {
 *                                                         type ipv4-address;
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case ipv6-next-hop-case {
 *                                                 container ipv6-next-hop {
 *                                                     leaf global {
 *                                                         type ipv6-address;
 *                                                     }
 *                                                     leaf link-local {
 *                                                         type ipv6-address;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         container multi-exit-disc {
 *                                             leaf med {
 *                                                 type uint32;
 *                                             }
 *                                         }
 *                                         container local-pref {
 *                                             leaf pref {
 *                                                 type uint32;
 *                                             }
 *                                         }
 *                                         container atomic-aggregate {
 *                                         }
 *                                         container aggregator {
 *                                             leaf as-number {
 *                                                 type as-number;
 *                                             }
 *                                             leaf network-address {
 *                                                 type ipv4-address;
 *                                             }
 *                                             uses bgp-aggregator;
 *                                         }
 *                                         list communities {
 *                                             key     leaf as-number {
 *                                                 type as-number;
 *                                             }
 *                                             leaf semantics {
 *                                                 type uint16;
 *                                             }
 *                                             uses community;
 *                                         }
 *                                         list extended-communities {
 *                                             key     leaf comm-type {
 *                                                 type uint8;
 *                                             }
 *                                             leaf comm-sub-type {
 *                                                 type uint8;
 *                                             }
 *                                             choice extended-community {
 *                                                 case as-specific-extended-community-case {
 *                                                     container as-specific-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case inet4-specific-extended-community-case {
 *                                                     container inet4-specific-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf global-administrator {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case opaque-extended-community-case {
 *                                                     container opaque-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf value {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case route-origin-extended-community-case {
 *                                                     container route-origin-extended-community {
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case route-target-extended-community-case {
 *                                                     container route-target-extended-community {
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             uses extended-community;
 *                                         }
 *                                         container originator-id {
 *                                             leaf originator {
 *                                                 type ipv4-address;
 *                                             }
 *                                             uses originator-id;
 *                                         }
 *                                         container cluster-id {
 *                                             leaf-list cluster {
 *                                                 type cluster-identifier;
 *                                             }
 *                                             uses cluster-id;
 *                                         }
 *                                         uses path-attributes;
 *                                     }
 *                                     uses route;
 *                                 }
 *                             }
 *                         }
 *                         case ipv6-routes-case {
 *                             container ipv6-routes {
 *                                 list ipv6-route {
 *                                     key "prefix"
 *                                     leaf prefix {
 *                                         type ipv6-prefix;
 *                                     }
 *                                     container attributes {
 *                                         container origin {
 *                                             leaf value {
 *                                                 type bgp-origin;
 *                                             }
 *                                         }
 *                                         container as-path {
 *                                             list segments {
 *                                                 key     choice c-segment {
 *                                                     case a-list-case {
 *                                                         container a-list {
 *                                                             list as-sequence {
 *                                                                 key     leaf as {
 *                                                                     type as-number;
 *                                                                 }
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                     case a-set-case {
 *                                                         container a-set {
 *                                                             leaf-list as-set {
 *                                                                 type as-number;
 *                                                             }
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 uses as-path-segment;
 *                                             }
 *                                         }
 *                                         choice c-next-hop {
 *                                             case ipv4-next-hop-case {
 *                                                 container ipv4-next-hop {
 *                                                     leaf global {
 *                                                         type ipv4-address;
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case ipv6-next-hop-case {
 *                                                 container ipv6-next-hop {
 *                                                     leaf global {
 *                                                         type ipv6-address;
 *                                                     }
 *                                                     leaf link-local {
 *                                                         type ipv6-address;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         container multi-exit-disc {
 *                                             leaf med {
 *                                                 type uint32;
 *                                             }
 *                                         }
 *                                         container local-pref {
 *                                             leaf pref {
 *                                                 type uint32;
 *                                             }
 *                                         }
 *                                         container atomic-aggregate {
 *                                         }
 *                                         container aggregator {
 *                                             leaf as-number {
 *                                                 type as-number;
 *                                             }
 *                                             leaf network-address {
 *                                                 type ipv4-address;
 *                                             }
 *                                             uses bgp-aggregator;
 *                                         }
 *                                         list communities {
 *                                             key     leaf as-number {
 *                                                 type as-number;
 *                                             }
 *                                             leaf semantics {
 *                                                 type uint16;
 *                                             }
 *                                             uses community;
 *                                         }
 *                                         list extended-communities {
 *                                             key     leaf comm-type {
 *                                                 type uint8;
 *                                             }
 *                                             leaf comm-sub-type {
 *                                                 type uint8;
 *                                             }
 *                                             choice extended-community {
 *                                                 case as-specific-extended-community-case {
 *                                                     container as-specific-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case inet4-specific-extended-community-case {
 *                                                     container inet4-specific-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf global-administrator {
 *                                                             type ipv4-address;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case opaque-extended-community-case {
 *                                                     container opaque-extended-community {
 *                                                         leaf transitive {
 *                                                             type boolean;
 *                                                         }
 *                                                         leaf value {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case route-origin-extended-community-case {
 *                                                     container route-origin-extended-community {
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                                 case route-target-extended-community-case {
 *                                                     container route-target-extended-community {
 *                                                         leaf global-administrator {
 *                                                             type short-as-number;
 *                                                         }
 *                                                         leaf local-administrator {
 *                                                             type binary;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             uses extended-community;
 *                                         }
 *                                         container originator-id {
 *                                             leaf originator {
 *                                                 type ipv4-address;
 *                                             }
 *                                             uses originator-id;
 *                                         }
 *                                         container cluster-id {
 *                                             leaf-list cluster {
 *                                                 type cluster-identifier;
 *                                             }
 *                                             uses cluster-id;
 *                                         }
 *                                         uses path-attributes;
 *                                     }
 *                                     uses route;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     uses bgp-table-type;
 *                 }
 *                 uses rib;
 *             }
 *         }
 *     }
 *     grouping rib {
 *         list tables {
 *             key "afi" 
 *         "safi"
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             container attributes {
 *                 leaf uptodate {
 *                     type boolean;
 *                 }
 *             }
 *             choice routes {
 *                 case ipv4-routes-case {
 *                     container ipv4-routes {
 *                         list ipv4-route {
 *                             key "prefix"
 *                             leaf prefix {
 *                                 type ipv4-prefix;
 *                             }
 *                             container attributes {
 *                                 container origin {
 *                                     leaf value {
 *                                         type bgp-origin;
 *                                     }
 *                                 }
 *                                 container as-path {
 *                                     list segments {
 *                                         key     choice c-segment {
 *                                             case a-list-case {
 *                                                 container a-list {
 *                                                     list as-sequence {
 *                                                         key     leaf as {
 *                                                             type as-number;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case a-set-case {
 *                                                 container a-set {
 *                                                     leaf-list as-set {
 *                                                         type as-number;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         uses as-path-segment;
 *                                     }
 *                                 }
 *                                 choice c-next-hop {
 *                                     case ipv4-next-hop-case {
 *                                         container ipv4-next-hop {
 *                                             leaf global {
 *                                                 type ipv4-address;
 *                                             }
 *                                         }
 *                                     }
 *                                     case ipv6-next-hop-case {
 *                                         container ipv6-next-hop {
 *                                             leaf global {
 *                                                 type ipv6-address;
 *                                             }
 *                                             leaf link-local {
 *                                                 type ipv6-address;
 *                                             }
 *                                         }
 *                                     }
 *                                 }
 *                                 container multi-exit-disc {
 *                                     leaf med {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container local-pref {
 *                                     leaf pref {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container atomic-aggregate {
 *                                 }
 *                                 container aggregator {
 *                                     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf network-address {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses bgp-aggregator;
 *                                 }
 *                                 list communities {
 *                                     key     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf semantics {
 *                                         type uint16;
 *                                     }
 *                                     uses community;
 *                                 }
 *                                 list extended-communities {
 *                                     key     leaf comm-type {
 *                                         type uint8;
 *                                     }
 *                                     leaf comm-sub-type {
 *                                         type uint8;
 *                                     }
 *                                     choice extended-community {
 *                                         case as-specific-extended-community-case {
 *                                             container as-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case inet4-specific-extended-community-case {
 *                                             container inet4-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case opaque-extended-community-case {
 *                                             container opaque-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf value {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-origin-extended-community-case {
 *                                             container route-origin-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-target-extended-community-case {
 *                                             container route-target-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                     }
 *                                     uses extended-community;
 *                                 }
 *                                 container originator-id {
 *                                     leaf originator {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses originator-id;
 *                                 }
 *                                 container cluster-id {
 *                                     leaf-list cluster {
 *                                         type cluster-identifier;
 *                                     }
 *                                     uses cluster-id;
 *                                 }
 *                                 uses path-attributes;
 *                             }
 *                             uses route;
 *                         }
 *                     }
 *                 }
 *                 case ipv6-routes-case {
 *                     container ipv6-routes {
 *                         list ipv6-route {
 *                             key "prefix"
 *                             leaf prefix {
 *                                 type ipv6-prefix;
 *                             }
 *                             container attributes {
 *                                 container origin {
 *                                     leaf value {
 *                                         type bgp-origin;
 *                                     }
 *                                 }
 *                                 container as-path {
 *                                     list segments {
 *                                         key     choice c-segment {
 *                                             case a-list-case {
 *                                                 container a-list {
 *                                                     list as-sequence {
 *                                                         key     leaf as {
 *                                                             type as-number;
 *                                                         }
 *                                                     }
 *                                                 }
 *                                             }
 *                                             case a-set-case {
 *                                                 container a-set {
 *                                                     leaf-list as-set {
 *                                                         type as-number;
 *                                                     }
 *                                                 }
 *                                             }
 *                                         }
 *                                         uses as-path-segment;
 *                                     }
 *                                 }
 *                                 choice c-next-hop {
 *                                     case ipv4-next-hop-case {
 *                                         container ipv4-next-hop {
 *                                             leaf global {
 *                                                 type ipv4-address;
 *                                             }
 *                                         }
 *                                     }
 *                                     case ipv6-next-hop-case {
 *                                         container ipv6-next-hop {
 *                                             leaf global {
 *                                                 type ipv6-address;
 *                                             }
 *                                             leaf link-local {
 *                                                 type ipv6-address;
 *                                             }
 *                                         }
 *                                     }
 *                                 }
 *                                 container multi-exit-disc {
 *                                     leaf med {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container local-pref {
 *                                     leaf pref {
 *                                         type uint32;
 *                                     }
 *                                 }
 *                                 container atomic-aggregate {
 *                                 }
 *                                 container aggregator {
 *                                     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf network-address {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses bgp-aggregator;
 *                                 }
 *                                 list communities {
 *                                     key     leaf as-number {
 *                                         type as-number;
 *                                     }
 *                                     leaf semantics {
 *                                         type uint16;
 *                                     }
 *                                     uses community;
 *                                 }
 *                                 list extended-communities {
 *                                     key     leaf comm-type {
 *                                         type uint8;
 *                                     }
 *                                     leaf comm-sub-type {
 *                                         type uint8;
 *                                     }
 *                                     choice extended-community {
 *                                         case as-specific-extended-community-case {
 *                                             container as-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case inet4-specific-extended-community-case {
 *                                             container inet4-specific-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf global-administrator {
 *                                                     type ipv4-address;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case opaque-extended-community-case {
 *                                             container opaque-extended-community {
 *                                                 leaf transitive {
 *                                                     type boolean;
 *                                                 }
 *                                                 leaf value {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-origin-extended-community-case {
 *                                             container route-origin-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                         case route-target-extended-community-case {
 *                                             container route-target-extended-community {
 *                                                 leaf global-administrator {
 *                                                     type short-as-number;
 *                                                 }
 *                                                 leaf local-administrator {
 *                                                     type binary;
 *                                                 }
 *                                             }
 *                                         }
 *                                     }
 *                                     uses extended-community;
 *                                 }
 *                                 container originator-id {
 *                                     leaf originator {
 *                                         type ipv4-address;
 *                                     }
 *                                     uses originator-id;
 *                                 }
 *                                 container cluster-id {
 *                                     leaf-list cluster {
 *                                         type cluster-identifier;
 *                                     }
 *                                     uses cluster-id;
 *                                 }
 *                                 uses path-attributes;
 *                             }
 *                             uses route;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses bgp-table-type;
 *         }
 *     }
 *     grouping route {
 *         container attributes {
 *             container origin {
 *                 leaf value {
 *                     type bgp-origin;
 *                 }
 *             }
 *             container as-path {
 *                 list segments {
 *                     key     choice c-segment {
 *                         case a-list-case {
 *                             container a-list {
 *                                 list as-sequence {
 *                                     key     leaf as {
 *                                         type as-number;
 *                                     }
 *                                 }
 *                             }
 *                         }
 *                         case a-set-case {
 *                             container a-set {
 *                                 leaf-list as-set {
 *                                     type as-number;
 *                                 }
 *                             }
 *                         }
 *                     }
 *                     uses as-path-segment;
 *                 }
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
 *             container multi-exit-disc {
 *                 leaf med {
 *                     type uint32;
 *                 }
 *             }
 *             container local-pref {
 *                 leaf pref {
 *                     type uint32;
 *                 }
 *             }
 *             container atomic-aggregate {
 *             }
 *             container aggregator {
 *                 leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf network-address {
 *                     type ipv4-address;
 *                 }
 *                 uses bgp-aggregator;
 *             }
 *             list communities {
 *                 key     leaf as-number {
 *                     type as-number;
 *                 }
 *                 leaf semantics {
 *                     type uint16;
 *                 }
 *                 uses community;
 *             }
 *             list extended-communities {
 *                 key     leaf comm-type {
 *                     type uint8;
 *                 }
 *                 leaf comm-sub-type {
 *                     type uint8;
 *                 }
 *                 choice extended-community {
 *                     case as-specific-extended-community-case {
 *                         container as-specific-extended-community {
 *                             leaf transitive {
 *                                 type boolean;
 *                             }
 *                             leaf global-administrator {
 *                                 type short-as-number;
 *                             }
 *                             leaf local-administrator {
 *                                 type binary;
 *                             }
 *                         }
 *                     }
 *                     case inet4-specific-extended-community-case {
 *                         container inet4-specific-extended-community {
 *                             leaf transitive {
 *                                 type boolean;
 *                             }
 *                             leaf global-administrator {
 *                                 type ipv4-address;
 *                             }
 *                             leaf local-administrator {
 *                                 type binary;
 *                             }
 *                         }
 *                     }
 *                     case opaque-extended-community-case {
 *                         container opaque-extended-community {
 *                             leaf transitive {
 *                                 type boolean;
 *                             }
 *                             leaf value {
 *                                 type binary;
 *                             }
 *                         }
 *                     }
 *                     case route-origin-extended-community-case {
 *                         container route-origin-extended-community {
 *                             leaf global-administrator {
 *                                 type short-as-number;
 *                             }
 *                             leaf local-administrator {
 *                                 type binary;
 *                             }
 *                         }
 *                     }
 *                     case route-target-extended-community-case {
 *                         container route-target-extended-community {
 *                             leaf global-administrator {
 *                                 type short-as-number;
 *                             }
 *                             leaf local-administrator {
 *                                 type binary;
 *                             }
 *                         }
 *                     }
 *                 }
 *                 uses extended-community;
 *             }
 *             container originator-id {
 *                 leaf originator {
 *                     type ipv4-address;
 *                 }
 *                 uses originator-id;
 *             }
 *             container cluster-id {
 *                 leaf-list cluster {
 *                     type cluster-identifier;
 *                 }
 *                 uses cluster-id;
 *             }
 *             uses path-attributes;
 *         }
 *     }
 * }
 * </pre>
 */
public interface BgpRibData
    extends
    DataRoot
{




    List<ApplicationRib> getApplicationRib();
    
    BgpRib getBgpRib();

}

