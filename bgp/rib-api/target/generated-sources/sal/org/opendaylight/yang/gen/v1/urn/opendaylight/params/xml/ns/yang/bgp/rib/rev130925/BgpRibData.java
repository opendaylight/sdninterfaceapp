package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925;
import org.opendaylight.yangtools.yang.binding.DataRoot;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.BgpRib;


/**
 * This module contains the concept of a Routing Information Base, as defined by 
 * RFC4271. Copyright (c)2013 Cisco Systems, Inc. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 * Reference:
 *     RFC4271
 * Module name:
 *     BgpRibData
 */
public interface BgpRibData
    extends
    DataRoot
{




    BgpRib getBgpRib();

}

