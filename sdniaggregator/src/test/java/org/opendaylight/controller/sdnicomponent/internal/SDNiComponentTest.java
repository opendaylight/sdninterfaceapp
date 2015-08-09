/*
 * Copyright (c) 2014 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */


package org.opendaylight.controller.sdnicomponent.internal;


import org.junit.Assert;
import org.junit.Test;
import org.opendaylight.controller.sdniaggregator.SdniManager;

public class SDNiComponentTest  {

        @Test
        public void testSDNiComponentCreation() {

                SdniManager ah = null;
                ah = new SdniManager();
                Assert.assertTrue(ah != null);

        }

}
