package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Update;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Keepalive;
import org.opendaylight.yangtools.yang.binding.NotificationListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify;


/**
 * This module contains the base data model of a BGP message. It rolls up the 
 * definitions contained in RFC4271 and RFC4893. Copyright (c)2013 Cisco Systems, 
 * Inc. All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Module name:
 *     BgpMessageListener
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

