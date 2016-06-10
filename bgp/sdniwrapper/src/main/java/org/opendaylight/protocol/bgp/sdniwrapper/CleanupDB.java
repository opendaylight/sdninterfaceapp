/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.sdniwrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import java.util.TimerTask;
import org.opendaylight.protocol.bgp.sdniwrapper.SdniWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanupDB extends TimerTask{

    private static final Logger LOG = LoggerFactory.getLogger(CleanupDB.class);

    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private Connection connection = null;

    @Override
    public void run() {
        LOG.info("Starting timer..........!");
        deleteControllersFromDB();
    }


    private Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if ( connection == null ) {
            Class.forName("org.sqlite.JDBC", true, Thread.currentThread().getContextClassLoader());
            connection = DriverManager.getConnection("jdbc:sqlite:sdninterfaceapp:db");
        }
        return connection;
    }



    private List<String> readDBTables()
    {
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        ResultSet rset = null;
        LOG.info("QoS: Inside readDBTables()");
        List<String> dbControllers = new ArrayList<String>();

        try {
            conn = getConnection();

            LOG.info("sql connection established");

            stmt = conn.createStatement();

            LOG.info("In readDBTables : stmt {}", stmt);
            sql = "SELECT name FROM sqlite_master WHERE type = 'table'";
            LOG.info("QoS: SQL query to fetch all the tables in database: {}", sql);
            rset = stmt.executeQuery(sql);
            while(rset.next())
            {
                String tablename = rset.getString(1);
                dbControllers.add(tablename);
            }
        } catch (SQLException se) {
            LOG.error("SQLException: {0}", se);
        } catch (Exception e) {
            LOG.error("Exception: {0}", e);
        } finally {
            try {
                if (rset != null ){
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                    connection = null;
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
            }
        }
        return dbControllers;
    }

    private void deleteControllersFromDB()
    {
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        LOG.info("QoS: Inside deleteControllersFromDB()");

        try {
            List<String> controllers = readDBTables();

            conn = getConnection();
            LOG.info("sql connection established");

            stmt = conn.createStatement();


            Set<String> aliveControllersList = SdniWrapper.getInstance().getAliveControllers();

            LOG.info("Controllers from DB: {}", controllers.size());
            LOG.info("Controllers alive : {}", aliveControllersList.size());
            controllers.removeAll(aliveControllersList);

            LOG.info("Controllers to be deleted from DB: {}", controllers.size());

            for ( String controllerName : controllers)
            {
                //Drop Table
                sql = "DROP TABLE " + controllerName;
                LOG.info("SQL query to drop table from database: {}", sql);
                stmt.executeUpdate(sql);
            }
        } catch (SQLException se) {
            LOG.error("SQLException: {0}", se);
        } catch (Exception e) {
            LOG.error("Exception: {0}", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                    connection = null;
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
            }
        }
    }
}