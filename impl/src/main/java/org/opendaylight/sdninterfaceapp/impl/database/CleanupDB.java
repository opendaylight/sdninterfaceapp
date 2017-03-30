/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdninterfaceapp.impl.database;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanupDB extends TimerTask {

    private static final Logger LOG = LoggerFactory.getLogger(CleanupDB.class);
    private SdniDataBase sdniDataBase;

    public CleanupDB() {
    	sdniDataBase = SdniDataBase.getInstance();
	}
    
    @Override
    public void run() {
        LOG.info("Starting CleanupDB timer..........!");
        sdniDataBase.deleteControllersFromDB();
    }
}
