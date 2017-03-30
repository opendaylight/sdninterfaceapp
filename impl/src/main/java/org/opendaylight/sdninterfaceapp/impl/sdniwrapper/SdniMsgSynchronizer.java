/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdninterfaceapp.impl.sdniwrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONObject;
import org.opendaylight.sdninterfaceapp.impl.OpendaylightSdniQosMsgServiceImpl;
import org.opendaylight.sdninterfaceapp.impl.SdniTopologyMsgServiceImpl;
import org.opendaylight.sdninterfaceapp.impl.database.CleanupDB;
import org.opendaylight.sdninterfaceapp.impl.database.SdniDataBase;
import org.opendaylight.sdninterfaceapp.impl.util.NetworkCapabilities;
import org.opendaylight.sdninterfaceapp.impl.util.NetworkCapabilitiesQOS;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.OpendaylightSdniQosMsgService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.NodeList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.OpendaylightSdniTopologyMsgService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.PortList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.nodes.node.list.port.list.PortParams;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.AddPeerControllersInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.AddTrustedControllersInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.GetConfiguredSdniPeersOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.OpendaylightSdniWrapperService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.RemovePeerControllersInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.wrapper.rev151006.UntrustedControllerBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.sdniwrapper.msg.rev170327.GetConfiguredSdniPeersOutputBuilder;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.Futures;


public class SdniMsgSynchronizer implements OpendaylightSdniWrapperService
{

    private static final Logger LOG = LoggerFactory.getLogger(SdniMsgSynchronizer.class);

    private static SdniMsgSynchronizer serviceObj = null;
    private NotificationProviderService notificationProvider;
    
    private Set<String> aliveControllersList = new HashSet<String>();

    private SdniDataBase sdniDataBase;
    
    private static CopyOnWriteArrayList<String> peerControllers = new CopyOnWriteArrayList<String>();

    {
        Timer timer=new Timer();
        timer.schedule(new CleanupDB(), 1000*60*5,1000*60*1);
    }

    private SdniMsgSynchronizer() {
    	sdniDataBase = SdniDataBase.getInstance();
    }

    public static SdniMsgSynchronizer getInstance(){
        if ( serviceObj == null )
        {
            serviceObj = new SdniMsgSynchronizer();

        }
        return serviceObj;
    }

    public void setNotificationService(NotificationProviderService notificationProviderService)
    {
    	notificationProvider = notificationProviderService;
    }

    public void getSDNITopoMessage(StringBuffer sdniMsg) {
        LOG.info("SdniWrapper  - getSDNITopoMessage -Start");
        List<String> linkList = new ArrayList<String>();

        NetworkCapabilities nCap = new NetworkCapabilities();
        try {

            OpendaylightSdniTopologyMsgService sdniTopoData = SdniTopologyMsgServiceImpl.getInstance();
            LOG.info("SdniWrapper  - getSDNITopoMessage -got topo rpc : {}" , sdniTopoData);
            Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput>> finalobject = sdniTopoData
                    .getTopology();

            LOG.info("SdniWrapper  - getSDNITopoMessage -got FUTURE : {}" ,  finalobject);

            RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput> rpcobject = finalobject
                    .get();


            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput outputobject = rpcobject
                    .getResult();
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopology network = outputobject
                    .getNetworkTopology();


            LOG.info("SdniWrapper  - getSDNITopoMessage -got CONTROLLER IP : {}" , network.getControllerIp());
            LOG.info(" SdniWrapper  - getSDNITopoMessage  : " + "CONTROLLER : " + network.getControllerIp() + " NETWORK TOPOLOGY :" +network);
            nCap.setController(network.getControllerIp());


            List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology> list_topo = network
                    .getTopology();
            LOG.debug("SdniWrapper  - getSDNITopoMessage  " + "CONTROLLER : " + network.getControllerIp() + "TOPO LIST : " + list_topo);
            LOG.info("SdniWrapper  - getSDNITopoMessage  " + "CONTROLLER : " + network.getControllerIp() + "TOPO LIST SIZE : " + list_topo.size());

            if ( list_topo != null && !list_topo.isEmpty() ){
                for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology topo : list_topo) {

                    List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link> listl = topo
                            .getLink();
                    LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + " LINKS : " + listl);

                    if (listl != null && !listl.isEmpty()) {
                        LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + " LINKS SIZE: " + listl.size());

                        for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link l : listl) {
                            String srcToDestLink = l.getSource().getSourceTp().getValue() + "->" + l.getDestination().getDestTp().getValue();
                            LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + " LINKS - srcToDestLink : " + srcToDestLink);
                            linkList.add(srcToDestLink);
                        }
                    }
                    else
                    {
                        LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + " : No links found");
                    }
                }
            }
            else
            {
                LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + " : Empty topology list");
            }
            nCap.setLink(linkList);


            LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + "Updating DB");
            updateControllerTopoTable(nCap);
            LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + "DB updated Successfully");

            sdniMsg.append("{\"TOPOoutput\":"+nCap.toString()+"};");
            LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + "-MESSAGE : " + sdniMsg.toString());
        } catch (InterruptedException | ExecutionException e) {
            LOG.info(e.getMessage());
        }
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
        LOG.info("SdniWrapper  - getSDNITopoMessage -END");
    }

    public void parseSDNITopoMessage(String sdnimsg) {
    	LOG.info("In parseSDNITopoMessage : {}" , sdnimsg);

        final NetworkCapabilities network = new NetworkCapabilities();
        try {

            String message = sdnimsg.replace('"', '\"');
            String[] outputArray = message.split(";");
            for(String token: outputArray) {
                if(token.contains("TOPOoutput")) {
                    JSONObject json = new JSONObject(token);
                    List<String> temp = new ArrayList<String>();
                    
                    String controller = json.getJSONObject("TOPOoutput").get("controller").toString();
                    try {
                        if (! isControllerTrusted(controller) )
                        {
                        //	send notification
                            LOG.info("SdniWrapper  - publish notification -Start");
                            notificationProvider.publish( new UntrustedControllerBuilder().setControllerip(controller).build() );
                            LOG.info("SdniWrapper  - publish notification -end");
                    	    break;
                        }
                    }
                    catch (Exception e) {
                        LOG.error("Notification Exception: {0}", e);
                    }

                    
                    network.setController(controller);
                    JSONArray jArray = json.getJSONObject("TOPOoutput").getJSONArray("links");
                    for (int i = 0; i < jArray.length(); i++) {
                        temp.add(jArray.get(i).toString());
                    }
                    network.setLink(temp);
                }
            }

        } catch (Exception e) {
            LOG.error("Exception: {0}", e);
        }

        updatePeerTopoTable(network);
        LOG.info("Sdniwrapper : parseSDNIMessage (sdni msg)- END");

    }

    public void updateControllerTopoTable(NetworkCapabilities networkData) {
        LOG.info("Sdniwrapper : updateControllerTopoTable- Start");

        Connection conn = null;
        Statement stmt = null;
        LOG.info("TOPO: inside updateControllerTopoTable PeerCount:0");
        String controllerIp = null;

        if ( networkData == null || networkData.getController() == null || networkData.getController() == "")
        {
        	return;
        }
        
        try {

            controllerIp = networkData.getController().replace('.', '_');
            conn = sdniDataBase.getConnection();

            LOG.info("TOPO: sql connection established");

            stmt = conn.createStatement();
            try{
                String sql = "drop table if exists TOPOLOGY_DATABASE_" + controllerIp;
                LOG.info("TOPO: SQL query to delete controller table: {}", sql);
                stmt.executeUpdate(sql);
            }
            catch (Exception e) {
                LOG.error("Exception: {0}", e);
            }
            String sql = "create table IF NOT EXISTS TOPOLOGY_DATABASE_" + controllerIp + " (controller TEXT NOT NULL, links TEXT NOT NULL);";
            LOG.info("TOPO: SQL query to create controller table: {}", sql);
            stmt.executeUpdate(sql);

            aliveControllersList.add("TOPOLOGY_DATABASE_" + controllerIp);

            String insertQueries = formTopoInsertQuery(networkData, false);
            String[] insertQuery = insertQueries.split("--");
            for (int j = 0; j < insertQuery.length; j++) {
                stmt.executeUpdate(insertQuery[j]);
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
            } catch (SQLException se2) {
                LOG.error("SQLException2: {0}", se2);
            }
        }
        LOG.info("Sdniwrapper : updateControllerTopoTable- End");
    }


    public void updatePeerTopoTable(NetworkCapabilities networkData) {
    	LOG.info("Sdniwrapper : updatePeerTopoTable- Start");

    	Connection conn = null;
    	Statement stmt = null;
    	String sql = null;
    	String controllerIp = null;

		try {

	    	if ( networkData == null || networkData.getController() == null || networkData.getController() == "")
	    	{
	    		return;
	    	} 
	    	
			controllerIp = networkData.getController().replace('.', '_');

			conn = sdniDataBase.getConnection();

			stmt = conn.createStatement();

			LOG.info("sql connection established");

			try {
				sql = "drop table if exists TOPOLOGY_DATABASE_PEER_" + controllerIp;
				stmt.executeUpdate(sql);
			} catch (Exception e)
			{
				LOG.warn("SQL: Warning {0}", e.getMessage());
			}

			if (networkData.getLink() == null && !networkData.getLink().isEmpty())
			{
				return;
			}

			LOG.info("TOPO: inside if, SQL query to delete topology peer table: {}", sql);

			sql = "create table IF NOT EXISTS TOPOLOGY_DATABASE_PEER_" + controllerIp
					+ " (controller TEXT NOT NULL, links TEXT NOT NULL);";
			LOG.info("TOPO: inside if SQL query to create topology peer table: {}", sql);
			stmt.executeUpdate(sql);

			aliveControllersList.add("TOPOLOGY_DATABASE_PEER_" + controllerIp);

			String insertQueries = formTopoInsertQuery(networkData, true);
			String[] insertQuery = insertQueries.split("--");
			for (int j = 0; j < insertQuery.length; j++) {
				stmt.executeUpdate(insertQuery[j]);
			}

		} catch (SQLException se) {
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
		}
    	LOG.info("Sdniwrapper : updatePeerTopoTable- End");
    }

    public String formTopoInsertQuery(NetworkCapabilities networkData, boolean isPeer) {
        LOG.info("QoS: Inside formTopoInsertQuery peer {}", isPeer);
        String insertQuery = "";

        String controller = networkData.getController().replace('.', '_');
        List<String> link_id_list = networkData.getLink();
        String controllerIP = networkData.getController();

        for (int i = 0; i < link_id_list.size(); i++) {
            String link = link_id_list.get(i);
            if (!isPeer) {
                insertQuery += "insert into TOPOLOGY_DATABASE_" + controller + " values (\"" + controllerIP + "\",\"" + link + "\"); -- ";
            } else {
                insertQuery += "insert into TOPOLOGY_DATABASE_PEER_" + controller + " values( \"" + controllerIP
                        + "\",\"" + link + "\"); -- ";
            }

        }
        LOG.info("QoS: At the end of formTopoInsertQuery() method insertQuery:{}", insertQuery);
        return insertQuery;
    }

    public void getSDNIQoSMessage(StringBuffer sdniMsg) {
        String controller = null;
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList();
        boolean flag = false;
        try {

            OpendaylightSdniQosMsgService sdniQoSData = OpendaylightSdniQosMsgServiceImpl.getInstance();
            LOG.info("SdniWrapper  - getSDNIQoSMessage -got Qos rpc : {}" , sdniQoSData);

            Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> allNodeConnectorStats = sdniQoSData
                    .getAllNodeConnectorsStatistics();

            RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput> rpcObj = allNodeConnectorStats
                    .get();


            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput qosDetails = rpcObj
                    .getResult();
            List<NodeList> ndList = qosDetails.getNodeList();
            controller = qosDetails.getControllerIp();
            
            sdniMsg.append("{\"QoSoutput\":{\"controller\":\"" + controller +"\",\"QoS\":[");
            if ( ndList != null && !ndList.isEmpty() )
            {
                for (NodeList nList : ndList) {
                    String nodeID = nList.getNodeId();
                    List<PortList> portlist = nList
                            .getPortList();
                    if ( portlist!= null && !portlist.isEmpty())
                    {

                        for (PortList Plist : portlist) {
                            String portID = Plist.getPortId();
                            List<PortParams> Pparamslist = Plist
                                    .getPortParams();

                            if ( Pparamslist != null && !Pparamslist.isEmpty())
                            {
                                LOG.info("Pparamslist size: {}", Pparamslist.size());
                                LOG.info("Pparamslist: {}", Pparamslist);

                                PortParams Pparams = Pparamslist.get(0);
                                NetworkCapabilitiesQOS ncQoS = new NetworkCapabilitiesQOS();

                                ncQoS.setController(controller);
                                ncQoS.setNode(nodeID);
                                ncQoS.setPort(portID);
                                ncQoS.setReceiveCrcError(Pparams.getReceiveCrcError().toString());
                                ncQoS.setReceiveFrameError(Pparams.getReceiveFrameError().toString());
                                ncQoS.setReceiveOverRunError(Pparams.getReceiveOverRunError().toString());
                                ncQoS.setCollisionCount(Pparams.getCollisionCount().toString());
                                ncQoS.setTransmitPackets(Pparams.getPackets().getTransmitted().toString());
                                ncQoS.setReceivePackets(Pparams.getPackets().getReceived().toString());
                                ncQoS.setBridgePort(Pparams.getPortName());
                                list_QoS.add(ncQoS);

                                if(!flag) {
                                	sdniMsg.append(ncQoS.toString());
                                    flag = true;
                                }
                                else {
                                	sdniMsg.append(","+ncQoS.toString());
                                }


                            }
                        }
                    }

                }

            }

            LOG.info("Sdniwrapper : getSDNIQoSMessage : Updating QoS DB");

            updateControllerQOSTable(list_QoS, controller);
            LOG.info("Sdniwrapper : getSDNIQoSMessage : DB updated successfully");

            sdniMsg.append("]}};");
            LOG.info("Sdniwrapper : getSDNIQoSMessage : MESSAGE : {}" , sdniMsg.toString());
        } catch (InterruptedException | ExecutionException e) {

            LOG.error("Exception : {0}",e.getMessage());
        }
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }


    public void parseSDNIQoSMessage(String sdniQOSMsg) {
    	LOG.info("In parseSDNIQoSMessage : {}" , sdniQOSMsg);
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList<NetworkCapabilitiesQOS>();
        String controller = null;

        try {

            String message = sdniQOSMsg.replace('"', '\"');
            String[] outputArray = message.split(";");
            LOG.info("TOKENS SIZE: {}", outputArray.length);

            for(String token: outputArray) {
                LOG.info("TOKEN MESSAGE : {}", token);

                if(token.contains("QoSoutput")) {
                    JSONObject json=new JSONObject(token);
                    LOG.info("sdni QOS Msg: {}", sdniQOSMsg);

                    controller = json.getJSONObject("QoSoutput").get("controller").toString();
                    try {

                        if (! isControllerTrusted(controller) )
                        {
                            LOG.info("SdniWrapper  - publish notification -Start");
                    	    //notificationProvider.publish( new UntrustedControllerBuilder().build() );
                            notificationProvider.publish( new UntrustedControllerBuilder().setControllerip(controller).build() );
                            LOG.info("SdniWrapper  - publish notification -end");
                    	    break;
                        }
                        }
                    catch (Exception e) {
                        LOG.error("Notification Exception: {0}", e);
                    }

                    
                    JSONArray jArray = json.getJSONObject("QoSoutput").getJSONArray("QoS");

                    for(int i=0;i<jArray.length();i++)
                    {
                        NetworkCapabilitiesQOS qosData = new NetworkCapabilitiesQOS();
                        JSONObject subJson = (JSONObject)jArray.get(i);
                        controller = subJson.get("controller").toString();
                        qosData.setController(controller);
                        qosData.setNode(subJson.get("node").toString());
                        qosData.setPort(subJson.get("port").toString());
                        qosData.setReceiveCrcError(subJson.get("receiveCrcError").toString());
                        qosData.setReceiveFrameError(subJson.get("receiveFrameError").toString());
                        qosData.setReceiveOverRunError(subJson.get("receiveOverRunError").toString());
                        qosData.setCollisionCount(subJson.get("collisionCount").toString());
                        qosData.setTransmitPackets(subJson.get("transmitPackets").toString());
                        qosData.setReceivePackets(subJson.get("receivePackets").toString());
                        qosData.setBridgePort(subJson.get("bridgePort").toString());
                        
                        list_QoS.add(qosData);
                    }

                }
            }

        }catch (Exception e) {
            LOG.error("Exception Message is: {0}", e);
        }

        LOG.info("parseSDNIQoSMessage : controller ip : {}", controller);
        updatePeerQOSTable(list_QoS, controller);
    }

    private void updateControllerQOSTable(List<NetworkCapabilitiesQOS> list, String controller) {

        Connection conn = null;
        Statement stmt = null;
        String sql = null;

        if ( controller == null || controller == "")
        {
        	return;
        }
        
        try {
            controller = controller.replace('.', '_');
            conn = sdniDataBase.getConnection();

            LOG.info("sql connection established");

            stmt = conn.createStatement();


            //Drop Table
            try{
                sql = "drop table if exists QOS_DATABASE_" + controller;
                LOG.info("QoS: SQL query to delete Controller QoS table: {}", sql);
                stmt.executeUpdate(sql);
            }
            catch(Exception e)
            {
                LOG.error("SQLException3: {0}", e);
            }

            //Create Table
            sql = "create table IF NOT EXISTS QOS_DATABASE_" + controller + " (controller TEXT NOT NULL, node TEXT NOT NULL, port TEXT NOT NULL,"
                    + " receiveFrameError TEXT NOT NULL, receiveOverRunError TEXT NOT NULL, receiveCrcError TEXT NOT NULL,"
                    + " collisionCount TEXT NOT NULL, receivePackets TEXT NOT NULL, transmitPackets TEXT NOT NULL, bridge_port TEXT NOT NULL);";
            LOG.info("QoS: SQL query to create Controller QoS table: {}", sql);
            stmt.executeUpdate(sql);
            aliveControllersList.add("QOS_DATABASE_" + controller);

            if ( list != null && !list.isEmpty() ) {
                String insertQueries = formQOSInsertQuery(list, false);
                String[] insertQuery = insertQueries.split("--");

                for (int j = 0; j < insertQuery.length; j++) {
                    String query = insertQuery[j].replace("LOCAL", "0");
                    LOG.info("QoS: InsertQuery after executing: {}", query);
                    stmt.executeUpdate(query);
                }
            }

        } catch (SQLException se) {
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
        }
    }

    public void updatePeerQOSTable(List<NetworkCapabilitiesQOS> list, String ipAddress) {
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        String controllerIp = null;
        try {

            if ( ipAddress == null || ipAddress == "")
            {
                return;
            }
            controllerIp = ipAddress.replace('.', '_');
            conn = sdniDataBase.getConnection();

            stmt = conn.createStatement();
            LOG.info("sql connection established");

            //Drop the PEER Table
            try{
                sql = "drop table if exists QOS_DATABASE_PEER_" + controllerIp;
                LOG.info("QoS: SQL query to delete Controller QoS table: {}", sql);
                stmt.executeUpdate(sql);
            }
            catch(Exception e)
            {
                LOG.error("SQLException3: {0}", e);
            }

            sql = "create table IF NOT EXISTS QOS_DATABASE_PEER_" + controllerIp
                    + " (controller TEXT NOT NULL, node TEXT NOT NULL, port TEXT NOT NULL, receiveFrameError TEXT NOT NULL,"
                    + " receiveOverRunError TEXT NOT NULL, receiveCrcError TEXT NOT NULL, collisionCount TEXT NOT NULL,"
                    + " receivePackets TEXT NOT NULL, transmitPackets TEXT NOT NULL, bridge_port TEXT NOT NULL);";
            LOG.info("QoS: SQL query to create QoS peer table: {}", sql);
            stmt.executeUpdate(sql);

            aliveControllersList.add("QOS_DATABASE_PEER_" + controllerIp);
            if ( list != null && !list.isEmpty() )
            {

                String insertQueries = formQOSInsertQuery(list, true);
                String[] insertQuery = insertQueries.split("--");
                for (int j = 0; j < insertQuery.length; j++) {
                    String query = insertQuery[j].replace("LOCAL", "0");
                    stmt.executeUpdate(query);
                }
            }

        } catch (SQLException se) {
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
        }
    }

    public String formQOSInsertQuery(List<NetworkCapabilitiesQOS> list, boolean isPeer) {
        String insertQuery = "";

        for (NetworkCapabilitiesQOS qosData : list) {
            String controller = qosData.getController().replace('.', '_');

            String node = qosData.getNode();
            String port = qosData.getPort();
            String receiveFrameError = qosData.getReceiveFrameError();
            String receiveOverRunError = qosData.getReceiveOverRunError();
            String receiveCrcError = qosData.getReceiveCrcError();
            String collisionCount = qosData.getCollisionCount();
            String receivePackets = qosData.getReceivePackets();
            String transmitPackets = qosData.getTransmitPackets();
            String bridgePort = qosData.getBridgePort();

            String controllerIP = qosData.getController();
            if (node == null || port == null) {
                if (!isPeer) {
                    insertQuery += "insert into QOS_DATABASE_" + controller + " (controller) values (" + controllerIP + "); -- ";
                } else {
                    insertQuery += "insert into QOS_DATABASE_PEER_"+controller + " (controller) values( "
                            + controllerIP + "); -- ";
                }
            } else {
                if (!isPeer) {
                    insertQuery += "insert into QOS_DATABASE_" + controller + " values (\"" + controllerIP + "\",\""
                            + node + "\",\""
                            + port + "\",\"" + receiveFrameError + "\",\""
                            + receiveOverRunError + "\",\"" + receiveCrcError + "\",\"" + collisionCount + "\",\"" + receivePackets
                            + "\",\"" + transmitPackets + "\",\"" + bridgePort + "\"); -- ";
                } else {
                    insertQuery += "insert into QOS_DATABASE_PEER_" + controller + " values (\"" + controllerIP + "\",\""
                            + node + "\",\""
                            + port + "\",\"" + receiveFrameError + "\",\""
                            + receiveOverRunError + "\",\"" + receiveCrcError + "\",\"" + collisionCount + "\",\"" + receivePackets
                            + "\",\"" + transmitPackets + "\",\"" + bridgePort + "\"); -- ";
                }
            }
        }

        LOG.info("QoS: At the end of formQOSInsertQuery() method insertQuery:{}", insertQuery);
        return insertQuery;
    }

    public Set<String> getAliveControllers()
    {
        return aliveControllersList;
    }
    
    private boolean isControllerTrusted(String controllerIp)
    {
        if ( controllerIp == null )
        {
            return false;
        }
        
        List<String> controllersList = getTrustedControllers();
        
        return controllersList.contains(controllerIp);
        
    }
    
    private List<String> getTrustedControllers()
    {
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String sql = null;
    	String controllerIp = null;
    	List<String> controllersList = new ArrayList<String>();
    	try {


    		conn = sdniDataBase.getConnection();

    		stmt = conn.createStatement();
    		LOG.info("sql connection established");

    		sql = "SELECT * FROM TRUSTED_CONTROLLERS";
    				LOG.info("QoS: SQL query to fetch trusted controllers : {}", sql);
    		rs = stmt.executeQuery(sql);
    		while(rs.next())
    		{
    			controllerIp = rs.getString(1);
    			controllersList.add(controllerIp);
    		}

    	} catch (SQLException se) {
    		LOG.error("SQLException: {0}", se);
    	} catch (Exception e) {
    		LOG.error("Exception: {0}", e);
    	} finally {
    		try {
    			if (rs != null ){
    				rs.close();
    			}
    			if (stmt != null) {
    				stmt.close();
    			}
    		} catch (SQLException se) {
    			LOG.error("SQLException3: {0}", se);
    		}
    	}
    	return controllersList;
    }

	@Override
	public Future<RpcResult<Void>> addTrustedControllers(AddTrustedControllersInput input) {
			
        	List<String> controllers = input.getControllers();
        	LOG.info("In addTrustedControllers : {}", controllers);

        	boolean result= SdniDataBase.getInstance().insertTrustedControllers(controllers);
        	
        	return buildResultFuture(result);
		
	}
	
	private Future<RpcResult<Void>> buildResultFuture(boolean result)
	{
		RpcResultBuilder<Void> rpcResultBuilder;
    	if (result)
    	{
    		rpcResultBuilder = RpcResultBuilder.success();
    	}
    	else
    	{
    		rpcResultBuilder = RpcResultBuilder.failed();
    	}
        return Futures.immediateFuture(rpcResultBuilder.build());
	}

	
	

	@Override
	public Future<RpcResult<Void>> addPeerControllers(AddPeerControllersInput input) {

		List<String> controllers = input.getControllers();
		LOG.info("In addPeerControllers : {}", controllers);
		peerControllers.addAll(controllers);
		LOG.info("List of peers configured : {}", peerControllers);
    	    	
    	return buildResultFuture(true);
	}

	public List<String> getPeerControllers()
	{
		LOG.info("In getPeerControllers : {}", peerControllers);
		return peerControllers;
	}
/*   @Override
   public void onUntrustedController(UntrustedController notification) {
       LOG.info("notification subscription started");
       LOG.info( "untrusted controller notification - controllerIp: {} ", notification.getControllerip() );
       LOG.info("notification subscription ended");

   }
*/

	@Override
	public Future<RpcResult<Void>> removePeerControllers(RemovePeerControllersInput input) {
		List<String> controllers = input.getControllers();
		LOG.info("In removePeerControllers : {}", controllers);
		peerControllers.removeAll(controllers);
		LOG.info("List of peers configured : {}", peerControllers);
    	    	
    	return buildResultFuture(true);
	}

	@Override
	public Future<RpcResult<GetConfiguredSdniPeersOutput>> getConfiguredSdniPeers() {
		
		GetConfiguredSdniPeersOutputBuilder outputBuilder = new GetConfiguredSdniPeersOutputBuilder();
		outputBuilder.setControllers(peerControllers);
		LOG.info("List of peers configured : {}", peerControllers);
		
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
	}
}