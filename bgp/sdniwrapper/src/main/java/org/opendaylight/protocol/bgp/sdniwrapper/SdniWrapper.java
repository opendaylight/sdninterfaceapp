/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.sdniwrapper;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONObject;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.OpendaylightSdniQosMsgService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.OpendaylightSdniTopologyMsgService;

import org.opendaylight.yangtools.yang.common.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniWrapper {

    private static final Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);

    public static Map peer_information = new HashMap();

    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    //   private static final String DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_TOPOLOGY_DATABASE";
    //  private static final String QOS_DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_QOS_DATABASE";
    private static SdniWrapper serviceObj = null;
    private static RpcProviderRegistry rpcRegistryDependency;
    private Set<String> aliveControllersList = new HashSet<String>();

    private Connection connection = null;

    {
        Timer timer=new Timer();
        timer.schedule(new CleanupDB(), 1000*60*5,1000*60*1);
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if ( connection == null ) {
            Class.forName("org.sqlite.JDBC", true, Thread.currentThread().getContextClassLoader());
            connection = DriverManager.getConnection("jdbc:sqlite:sdninterfaceapp:db");
        }
        return connection;
    }

    private SdniWrapper() {

    }

    public static SdniWrapper getInstance(){
        if ( serviceObj == null )
        {
            serviceObj = new SdniWrapper();

        }
        return serviceObj;
    }

    public static void setRPCRegistry(RpcProviderRegistry rpcRegistry)
    {
        rpcRegistryDependency = rpcRegistry;
    }



    public ByteBuf getSDNITopoMessage() {
        LOG.info("SdniWrapper  - getSDNITopoMessage -Start");
        List<String> linkList = new ArrayList<String>();
        byte[] defaultBytes = null;
        ByteBuf sdniBytes = null;

        NetworkCapabilities nCap = new NetworkCapabilities();
        StringBuilder data = new StringBuilder();
        try {

            OpendaylightSdniTopologyMsgService sdniTopoData = rpcRegistryDependency.getRpcService(OpendaylightSdniTopologyMsgService.class);
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

            data.append("{\"TOPOoutput\":"+nCap.toString()+"};");
            LOG.info("SdniWrapper  - getSDNITopoMessage " + "CONTROLLER : " + network.getControllerIp() + "-MESSAGE : " + data.toString());
            defaultBytes = data.toString().getBytes();
            sdniBytes = Unpooled.copiedBuffer(defaultBytes);
        } catch (InterruptedException | ExecutionException e) {
            LOG.info(e.getMessage());
        }
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
        LOG.info("SdniWrapper  - getSDNITopoMessage -END");
        return sdniBytes;
    }

    public String parseSDNITopoMessage(ByteBuf msg) {
        LOG.info("Sdniwrapper : parseSDNIMessage - Start");
        String result = "";
        byte[] bytes = new byte[msg.readableBytes()];
        int readerIndex = msg.readerIndex();
        msg.getBytes(readerIndex, bytes);
        String sdniMsg = new String(bytes);

        LOG.info("TOPO: Before parsing sdni message from ByteBuf to String: {}", sdniMsg);
        result = parseSDNITopoMessage(sdniMsg);
        LOG.info("Sdniwrapper : parseSDNIMessage - End");
        return result;
    }

    private String parseSDNITopoMessage(String sdnimsg) {
        LOG.info("Sdniwrapper : parseSDNIMessage (sdni msg)- Start");
        final List<NetworkCapabilities> listTopo = new ArrayList<NetworkCapabilities>();
        final NetworkCapabilities network = new NetworkCapabilities();
        try {

            String message = sdnimsg.replace('"', '\"');
            String[] outputArray = message.split(";");
            for(String token: outputArray) {
                if(token.contains("TOPOoutput")) {
                    JSONObject json = new JSONObject(token);
                    List<String> temp = new ArrayList<String>();
                    network.setController(json.getJSONObject("TOPOoutput").get("controller").toString());
                    JSONArray jArray = json.getJSONObject("TOPOoutput").getJSONArray("links");
                    for (int i = 0; i < jArray.length(); i++) {
                        temp.add(jArray.get(i).toString());
                    }
                    network.setLink(temp);
                }
            }

        } catch (Exception e) {
            LOG.error("Exception: {0}", e);
            return "IOException";
        }

        updatePeerTopoTable(network);
        LOG.info("Sdniwrapper : parseSDNIMessage (sdni msg)- END");
        return "success";

    }

    public void updateControllerTopoTable(NetworkCapabilities networkData) {
        LOG.info("Sdniwrapper : updateControllerTopoTable- Start");

        Connection conn = null;
        Statement stmt = null;
        LOG.info("TOPO: inside updateControllerTopoTable PeerCount:0");
        String controllerIp = null;

        try {

            controllerIp = networkData.getController().replace('.', '_');
            conn = getConnection();

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
            //            return;
        } catch (Exception e) {
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
                if (conn != null) {
                    conn.close();
                    connection = null;
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                //                return;
            }
        }
        LOG.info("Sdniwrapper : updateControllerTopoTable- End");
    }


    public void updatePeerTopoTable(NetworkCapabilities networkData) {
        LOG.info("Sdniwrapper : updatePeerTopoTable- Start");
        //   String ipAddress = networkData.getController().toString().replace("[", "").replace("]", "");
        String ipAddress = networkData.getController();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        String controllerIp = null;


        //      boolean tableExist = false;

        try {

            controllerIp = networkData.getController().replace('.', '_');

            conn = getConnection();

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

    public ByteBuf getSDNIQoSMessage() {
        byte[] defaultBytes = null;
        //String qosDetails = null;
        ByteBuf sdniQOSBytes = null;
        String controller = null;
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList();
        StringBuilder data = new StringBuilder();
        boolean flag = false;
        try {

            OpendaylightSdniQosMsgService sdniQoSData = rpcRegistryDependency.getRpcService(OpendaylightSdniQosMsgService.class);
            LOG.info("SdniWrapper  - getSDNIQoSMessage -got Qos rpc : {}" , sdniQoSData);

            Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> allNodeConnectorStats = sdniQoSData
                    .getAllNodeConnectorsStatistics();

            RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput> rpcObj = allNodeConnectorStats
                    .get();


            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput qosDetails = rpcObj
                    .getResult();
            List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeList> ndList = qosDetails.getNodeList();
            controller = qosDetails.getControllerIp();

            data.append("{\"QoSoutput\":{\"controller\":\"" + controller +"\",\"QoS\":[");
            //data.append("{controller:" + controller +"}");
            if ( ndList != null && !ndList.isEmpty() )
            {
                //data.append("[");
                for (NodeList nList : ndList) {
                    String nodeID = nList.getNodeId();
                    List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortList> portlist = nList
                            .getPortList();
                    if ( portlist!= null && !portlist.isEmpty())
                    {

                        for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortList Plist : portlist) {
                            String portID = Plist.getPortId();
                            List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParams> Pparamslist = Plist
                                    .getPortParams();

                            if ( Pparamslist != null && !Pparamslist.isEmpty())
                            {
                                LOG.info("Pparamslist size: {}", Pparamslist.size());
                                LOG.info("Pparamslist: {}", Pparamslist);

                                org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParams Pparams = Pparamslist.get(0);
                                NetworkCapabilitiesQOS ncQoS = new NetworkCapabilitiesQOS();

                                ncQoS.setController(controller);
                                ncQoS.setNode(nodeID);
                                ncQoS.setPort(portID);
                                ncQoS.setReceiveCrcError(Pparams.getReceiveCrcError().toString());
                                ncQoS.setReceiveFrameError(Pparams.getReceiveFrameError().toString());
                                ncQoS.setReceiveOverRunError(Pparams.getReceiveOverRunError().toString());
                                ncQoS.setCollisionCount(Pparams.getCollisionCount().toString());
                                ncQoS.setTransmitPackets(Pparams.getTransmitDrops().toString());
                                ncQoS.setReceivePackets(Pparams.getReceiveDrops().toString());

                                list_QoS.add(ncQoS);

                                if(!flag) {
                                    data.append(ncQoS.toString());
                                    flag = true;
                                }
                                else {
                                    data.append(","+ncQoS.toString());
                                }


                            }
                        }
                    }

                }

            }

            LOG.info("Sdniwrapper : getSDNIQoSMessage : Updating QoS DB");

            updateControllerQOSTable(list_QoS, controller);
            LOG.info("Sdniwrapper : getSDNIQoSMessage : DB updated successfully");

            data.append("]}};");
            LOG.info("final: data is {}",data);
            LOG.info("Sdniwrapper : getSDNIQoSMessage : MESSAGE : {}" , data.toString());
            defaultBytes = data.toString().getBytes();
            sdniQOSBytes = Unpooled.copiedBuffer(defaultBytes);

        } catch (InterruptedException | ExecutionException e) {

            LOG.error("Exception : {0}",e.getMessage());
        }
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
        return sdniQOSBytes;
    }

    public String parseSDNIQoSMessage(ByteBuf msg) {
        String result = "";
        byte[] bytes = new byte[msg.readableBytes()];
        int readerIndex =msg.readerIndex();
        msg.getBytes(readerIndex, bytes);
        String sdniQOSMsg = new String(bytes);

        LOG.info("QoS: After parsing sdni qos message from ByteBuf to String: {}",sdniQOSMsg);
        result = parseSDNIQoSMessage(sdniQOSMsg);
        return result;
    }

    private String parseSDNIQoSMessage(String sdniQOSMsg) {
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList<NetworkCapabilitiesQOS>();
        boolean peer = true;
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
                        list_QoS.add(qosData);
                    }

                }
            }

        }catch (Exception e) {
            LOG.error("Exception Message is: {0}", e);
        }

        LOG.info("parseSDNIQoSMessage : controller ip : {}", controller);
        updatePeerQOSTable(list_QoS, controller);
        return "";
    }

    private void updateControllerQOSTable(List<NetworkCapabilitiesQOS> list, String controller) {

        Connection conn = null;
        Statement stmt = null;
        String sql = null;

        try {
            controller = controller.replace('.', '_');
            conn = getConnection();

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
                    + " collisionCount TEXT NOT NULL, receivePackets TEXT NOT NULL, transmitPackets TEXT NOT NULL);";
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
    }

    public void updatePeerQOSTable(List<NetworkCapabilitiesQOS> list, String ipAddress) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        String controllerIp = null;
        try {

            if ( ipAddress == null )
            {
                return;
            }
            controllerIp = ipAddress.replace('.', '_');
            conn = getConnection();

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
                    + " receivePackets TEXT NOT NULL, transmitPackets TEXT NOT NULL);";
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
    }

    public String formQOSInsertQuery(List<NetworkCapabilitiesQOS> list, boolean isPeer) {
        String insertQuery = "";

        for (NetworkCapabilitiesQOS qosData : list) {
            String controller = qosData.getController().replace('.', '_');

            String node = qosData.getNode();
            String port = qosData.getPort();
            /*            String receiveFrameError = qosData.getReceiveFrameError();
            String receiveOverRunError = qosData.getReceiveOverRunError();
            String receiveCrcError = qosData.getReceiveCrcError();
            String collisionCount = qosData.getCollisionCount();
            String receivePackets = qosData.getReceivePackets();
            String transmitPackets = qosData.getTransmitPackets();*/
            String receiveFrameError = "" + getRandomNum();
            String receiveOverRunError = "" + getRandomNum();
            String receiveCrcError = "" + getRandomNum();
            String collisionCount = "" + getRandomNum();
            String receivePackets = "" + getRandomNum();
            String transmitPackets = "" + getRandomNum();

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
                            + "\",\"" + transmitPackets + "\"); -- ";
                } else {
                    insertQuery += "insert into QOS_DATABASE_PEER_" + controller + " values (\"" + controllerIP + "\",\""
                            + node + "\",\""
                            + port + "\",\"" + receiveFrameError + "\",\""
                            + receiveOverRunError + "\",\"" + receiveCrcError + "\",\"" + collisionCount + "\",\"" + receivePackets
                            + "\",\"" + transmitPackets + "\"); -- ";
                }
            }
        }

        LOG.info("QoS: At the end of formQOSInsertQuery() method insertQuery:{}", insertQuery);
        return insertQuery;
    }

    /*    public static String ntoa(long raw) {
        byte[] b = new byte[] { (byte) (raw >> 24), (byte) (raw >> 16), (byte) (raw >> 8), (byte) raw };
        try {
            return InetAddress.getByAddress(b).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }*/

    /*    public static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result & 0xFFFFFFFF;
    }*/


    public Set<String> getAliveControllers()
    {
        return aliveControllersList;
    }
    private int getRandomNum()
    {
        return new Random().nextInt(10);
    }
}
