/*
 * Copyright (c) 2015 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sdninterfaceapp.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniDataBase {
	
    private static final Logger LOG = LoggerFactory.getLogger(SdniDataBase.class);

   private static Connection connection = null;
	
    private Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if ( connection == null ) {
            Class.forName("org.sqlite.JDBC", true, Thread.currentThread().getContextClassLoader());
            connection = DriverManager.getConnection("jdbc:sqlite:sdninterfaceapp:db");
        }
        return connection;
    }
    

   public void create_trusted_controllers()
    {
        Connection c = null;
        Statement stmt = null;
    	int check=0;
        try
        {
           c = getConnection();

           LOG.info("TOPO: sql connection established");

            stmt = c.createStatement();
            try{
                String sql = "drop table if exists TRUSTED_CONTROLLERS";
                LOG.info("TOPO: SQL query to delete TRUSTED CONTROLLERS table: {}", sql);
                stmt.executeUpdate(sql);
            }
            catch (Exception e) {
                LOG.error("Exception: {0}", e);
            }
            String sql = "create table IF NOT EXISTS TRUSTED_CONTROLLERS (controller TEXT NOT NULL);";
            LOG.info("TOPO: SQL query to create TRUSTED CONTROLLERS table: {}", sql);
            check=stmt.executeUpdate(sql);
            LOG.info("CHECKED VALUE:"+check);
            
        }
         catch (SQLException se) {
            LOG.error("SQLException: {0}", se);
            //            return;
        } 
          catch(ClassNotFoundException f) {
            LOG.error("FileNotFoundException: {0}",f);
        }  
           catch (Exception e) {
            LOG.error("Exception: {0}", e);
            //            return;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                LOG.error("SQLException2: {0}", se2);
                //                return;
            }
            try {
                if (c != null) {
                    c.close();
                    connection = null;
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                //                return;
            }
        }

    }
    
    /**
     * Get the QoS peer table data
     */
    
    public Map<String,Map<String,Map<String, PortStatistics>>> getAllQoSPeerData()
    {
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	//Map<controller,Map<nodeid,Map<portid, portparams>>>
    	Map<String,Map<String,Map<String, PortStatistics>>> peerControllerData = new HashMap<String,Map<String,Map<String, PortStatistics>>>();
    	
    	
    	try{
    		String query = "SELECT name FROM sqlite_master WHERE type = 'table' and  name like 'QOS%PEER%'";
    		List<String> dbTables = getTables(query);
    		conn = getConnection();

    		LOG.info("sql connection established");


    		for (String tableName : dbTables)
    		{
    			stmt = conn.createStatement();
    			String sqlInfo = "SELECT * FROM " + tableName;
    			
    			LOG.info("QoS: SQL query to fetch all the QoS Peer tables in database: {}", sqlInfo);
        		rset = stmt.executeQuery(sqlInfo);
    			
    			while(rset.next())
    			{

    				String controller = rset.getString(1);
    				String node = rset.getString(2);
    				String port = rset.getString(3);
    				String receiveFrameError = rset.getString(4);
    				String receiveOverRunError = rset.getString(5);
    				String receiveCrcError = rset.getString(6);
    				String collisionCount = rset.getString(7);
    				String receivePackets = rset.getString(8); 
    				String transmitPackets = rset.getString(9);

    				LOG.info(controller + ", " + node + ", " + port + ", " + receiveFrameError + ", " + 
    						receiveOverRunError + ", " + receiveCrcError + ", " + collisionCount + ", " + receivePackets + ", " + transmitPackets);

    				//If controller already exists
    				if (peerControllerData.containsKey(controller))
    				{
    					//Map<nodeid,Map<portid, portparams>>
    					Map<String,Map<String, PortStatistics>> nodeStatistics = peerControllerData.get(controller.trim());

    					//if nodeId already exists
    					if(nodeStatistics.containsKey(node))
    					{
    						Map<String, PortStatistics> nodeConnectorStatics = nodeStatistics.get(node);

    						nodeConnectorStatics.put(port, getPortStatistics(receiveFrameError, receiveOverRunError, receiveCrcError,
    								collisionCount, receivePackets, transmitPackets));
    					}
    					else
    					{
    						//Map<portid, portparams>
    						Map<String, PortStatistics> nodeConnectorStatics = new HashMap<String, PortStatistics>();
    						nodeConnectorStatics.put(port, getPortStatistics(receiveFrameError, receiveOverRunError, receiveCrcError,
    								collisionCount, receivePackets, transmitPackets));

    						nodeStatistics.put(node, nodeConnectorStatics);
    					}

    				}
    				else
    				{
    					//Map<nodeid,Map<portid, portparams>>
    					Map<String,Map<String, PortStatistics>> nodeStatistics = new HashMap<String,Map<String, PortStatistics>>();

    					//Map<portid, portparams>
    					Map<String, PortStatistics> nodeConnectorStatics = new HashMap<String, PortStatistics>();
    					nodeConnectorStatics.put(port, getPortStatistics(receiveFrameError, receiveOverRunError, receiveCrcError,
    							collisionCount, receivePackets, transmitPackets));

    					nodeStatistics.put(node, nodeConnectorStatics);

    					peerControllerData.put(controller, nodeStatistics);
    				}
    			}
    			
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
    	
    	LOG.info("QoS size : {}", peerControllerData.size());
    	return peerControllerData;
    }
    
    private PortStatistics getPortStatistics(String receiveFrameError, 
    		String receiveOverRunError,
    		String receiveCrcError,
    		String collisionCount,
    		String receivePackets,
    		String transmitPackets)
    {
    	PortStatistics portParams = new PortStatistics();
    	portParams.setReceiveFrameError(receiveFrameError);
    	portParams.setReceiveOverRunError(receiveOverRunError);
    	portParams.setReceiveCrcError(receiveCrcError);
    	portParams.setCollisionCount(collisionCount);
    	portParams.setReceivePackets(receivePackets);
    	portParams.setTransmitPackets(transmitPackets);
    	
    	return portParams;
    }
    
    
    private List<String> getTables(String sql)
    {
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	List<String> tablesList = new ArrayList<String>();
    	
    	try{
    		conn = getConnection();

    		LOG.info("sql connection established");

    		stmt = conn.createStatement();

    		LOG.info("QoS: SQL query to fetch all the QoS Peer tables in database: {}", sql);
    		rset = stmt.executeQuery(sql);
    		while(rset.next())
    		{
    			String tableName = rset.getString(1);
    			tablesList.add(tableName);
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
    	
    	
    	return tablesList;
    }
    
    
    public Map<String, List<String>> getAllPeerTopology()
    {
    	//Map<controller,List<links>
    	Map<String,List<String>> topologyData = new HashMap<String, List<String>>();
    	

    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rset = null;
    	
    	List<String> tablesList = new ArrayList<String>();
    	
    	try{
    		
    		
    		String query = "SELECT name FROM sqlite_master WHERE type = 'table' and  name like 'TOPOLOGY%PEER%'";
   
    		List<String> dbTables = getTables(query);
    		conn = getConnection();

    		LOG.info("sql connection established");


    		for (String tableName : dbTables)
    		{
    			stmt = conn.createStatement();
    			
    			String sql = "SELECT * FROM " + tableName;
    			LOG.info("Topo: SQL query to fetch all the Topo Peer tables in database: {}", sql);
    			rset = stmt.executeQuery(sql);
    			while(rset.next())
    			{
    				String controller = rset.getString(1);
    				String link = rset.getString(2);

    				if (topologyData.containsKey(controller))
    				{
    					List<String> links = topologyData.get(controller);
    					links.add(link);
    				}
    				else
    				{
    					List<String> links = new ArrayList<String>();
    					links.add(link);
    					
    					topologyData.put(controller, links);
    				}
    			}
    			
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
    	
    	LOG.info("topo size : {}", topologyData.size());
    	
    	return topologyData;
    }
    
    
    
    public void insertQosData(List<PortStatistics> list_QoS, String controllerIP)
    {
    	Connection conn = null;
    	Statement stmt = null;
    	String sql = null;
    	LOG.info("sql in insertQosData - START");

    		try{
    			controllerIP = controllerIP.replace('.', '_');
    			conn = getConnection();
    			LOG.info("sql connection established");
    			stmt = conn.createStatement();

    			//Drop Table
    			sql = "drop table if exists QOS_DATABASE_" + controllerIP;
    			LOG.info("QoS: SQL query to delete Controller QoS table: {}", sql);
    			stmt.executeUpdate(sql);
    		}
    		catch(Exception e)
    		{
    			LOG.error("SQLException3: {0}", e);
    		}

    		try {

    			//Create Table
    			sql = "create table IF NOT EXISTS QOS_DATABASE_" + controllerIP + " (controller TEXT NOT NULL, node TEXT NOT NULL, port TEXT NOT NULL,"
    					+ " receiveFrameError TEXT NOT NULL, receiveOverRunError TEXT NOT NULL, receiveCrcError TEXT NOT NULL,"
    					+ " collisionCount TEXT NOT NULL, receivePackets TEXT NOT NULL, transmitPackets TEXT NOT NULL, bridge_port TEXT NOT NULL);";
    			LOG.info("QoS: SQL query to create Controller QoS table: {}", sql);
    			stmt.executeUpdate(sql);

    	    	if (list_QoS != null && !list_QoS.isEmpty())
    	    	{
    			for ( PortStatistics ps : list_QoS )
    			{



    				String query = "insert into QOS_DATABASE_" + controllerIP + " values (\"" + ps.getController() + "\",\""
    						+ ps.getNodeID() + "\",\""
    						+ ps.getPortID() + "\",\"" 
    						+ ps.getReceiveFrameError() + "\",\""
    						+ ps.getReceiveOverRunError() + "\",\"" 
    						+ ps.getReceiveCrcError() + "\",\"" 
    						+ ps.getCollisionCount() + "\",\"" 
    						+ ps.getReceivePackets() + "\",\"" 
    						+ ps.getTransmitPackets() + "\",\""
    	    						+ ps.getPortName() + "\");";
    				query = query.replace("LOCAL", "0");
    				LOG.info("QoS: InsertQuery after executing: {}", query);
    				stmt.executeUpdate(query);
    			} 
    	    	}
    		}
    		catch (SQLException se) {
    			LOG.error("SQLException: {0}", se);
    			return;
    		} catch (Exception e) {
    			LOG.error("Exception: {0}", e);
    			return;
    		} finally {
    			try {
    				if (stmt != null) {
    					stmt.close();
    				}
    			} catch (SQLException se2) {
    				LOG.error("SQLException2: {0}", se2);
    				return;
    			}

    			try {
    				if (conn != null) {
    					conn.close();
    					connection = null;
    				}
    			} catch (SQLException se) {
    				LOG.error("SQLException3: {0}", se);
    				return;
    			}
    		}
    		LOG.info("sql in insertQosData - END");

    }
}
