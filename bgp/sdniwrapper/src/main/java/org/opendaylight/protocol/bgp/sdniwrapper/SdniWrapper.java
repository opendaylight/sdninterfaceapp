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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.NodeList;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.LinkId;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniWrapper {


    private static final Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);

    public static Map peer_information = new HashMap();
    private static int peer_count = 0;
    private static int qos_peer_count = 0;
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_TOPOLOGY_DATABASE";
    private static final String QOS_DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_QOS_DATABASE";

    /**
     * Finds IPv4 address of the local VM TODO: This method is
     * non-deterministic. There may be more than one IPv4 address. Cant say
     * which address will be returned. Read IP from a property file or enhance
     * the code to make it deterministic.
     *
     * @return String
     */
    public String findIpAddress() {
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            LOG.warn("Failed to get list of interfaces {0}", e1);
            return null;
        }
        while (e.hasMoreElements()) {

            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                if ((i instanceof Inet4Address) && (!i.isLoopbackAddress())) {
                    String hostAddress = i.getHostAddress();
                    return hostAddress;
                }
            }
        }
        LOG.debug("Failed to find a suitable host address");
        return null;
    }


    public ByteBuf getSDNITopoMessage() {
        LOG.info("SdniWrapper  - getSDNITopoMessage -Start");
        List<String> linkList = new ArrayList<String>();
        byte[] defaultBytes = null;
        ByteBuf sdniBytes = null;

        NetworkCapabilities nCap = new NetworkCapabilities();
        StringBuilder data = new StringBuilder();
        try {
            org.opendaylight.sdninterfaceapp.impl.SdniTopologyMsgServiceImpl sdniTopoData = org.opendaylight.sdninterfaceapp.impl.SdniTopologyMsgServiceImpl.getInstance();
            // Parse rest api content and populate TOPOLOGY_DATABASE data in sqlite
            Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput>> finalobject = sdniTopoData
                    .getTopology();

            RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput> rpcobject = finalobject
                    .get();

            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.msg.rev151006.GetTopologyOutput outputobject = rpcobject
                    .getResult();
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.NetworkTopology network = outputobject
                    .getNetworkTopology();

            nCap.setController(network.getControllerIp());

            List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology> list_topo = network
                    .getTopology();
            for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.Topology topo : list_topo) {

                List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link> listl = topo
                        .getLink();
                for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.topology.params.rev151006.sdn.topology.network.topology.topology.Link l : listl) {

                    LinkId lid = l.getLinkId();
                    linkList.add(lid.toString());
                }
            }
            nCap.setLink(linkList);
            data.append("{\"output\":"+nCap.toString()+"}");
            LOG.info("message: ",data);
            defaultBytes = data.toString().getBytes();
            sdniBytes = Unpooled.copiedBuffer(defaultBytes);
        } catch (InterruptedException | ExecutionException e) {
            LOG.trace(e.getMessage());
        }
        LOG.info("SdniWrapper  - getSDNITopoMessage -Start");
        return sdniBytes;
    }

    public String parseSDNITopoMessage(ByteBuf msg) {
        LOG.trace("Sdniwrapper : parseSDNIMessage - Start");
        String result = "";
        byte[] bytes = new byte[msg.readableBytes()];
        int readerIndex = msg.readerIndex();
        msg.getBytes(readerIndex, bytes);
        String sdniMsg = new String(bytes);

        LOG.trace("TOPO: Before parsing sdni message from ByteBuf to String: {}", sdniMsg);
        result = parseSDNITopoMessage(sdniMsg);
        LOG.trace("Sdniwrapper : parseSDNIMessage - End");
        return result;
    }

    private String parseSDNITopoMessage(String sdnimsg) {
        LOG.trace("Sdniwrapper : parseSDNIMessage (sdni msg)- Start");
        final List<NetworkCapabilities> listTopo = new ArrayList<NetworkCapabilities>();
        final NetworkCapabilities network = new NetworkCapabilities();
        try {

            String message = sdnimsg.replace('"', '\"');
            JSONObject json = new JSONObject(message);
            List<String> temp = new ArrayList<String>();
            network.setController(json.getJSONObject("output").get("controller").toString());
            JSONArray jArray = json.getJSONObject("output").getJSONArray("links");
            for (int i = 0; i < jArray.length(); i++) {
                temp.add(jArray.get(i).toString());
            }
            network.setLink(temp);

        } catch (Exception e) {
            LOG.error("Exception: {0}", e);
            return "IOException";
        }
        boolean peer = false;
        String controllerIP = network.getController();
        if (!controllerIP.equals(findIpAddress())) {
            peer = true;
        }
        if (peer) {
            LOG.trace("TOPO: Before calling updatePeerTable");
            updatePeerTable(network);
        } else {
            updateControllerTable(network);
        }
        LOG.trace("Sdniwrapper : parseSDNIMessage (sdni msg)- END");
        return "success";

    }

    public void updateControllerTable(NetworkCapabilities networkData) {
        LOG.trace("Sdniwrapper : updateControllerTable- Start");

        Connection conn = null;
        Statement stmt = null;
        int peer_count = 0;
        LOG.trace("TOPO: inside updateControllerTable PeerCount:0");

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL);

            LOG.trace("TOPO: sql connection established");

            stmt = conn.createStatement();
            String sql = "drop table if exists TOPOLOGY_DATABASE ";
            stmt.executeUpdate(sql);
            LOG.trace("TOPO: SQL query to delete controller table: {}", sql);

            sql = "create table TOPOLOGY_DATABASE (controller varchar(50), links varchar(128));";
            stmt.executeUpdate(sql);
            LOG.trace("TOPO: SQL query to create controller table: {}", sql);

            String insertQueries = formInsertQuery(networkData, peer_count);
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
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                return;
            }
        }
        LOG.trace("Sdniwrapper : updateControllerTable- End");
    }

    public void updatePeerTable(NetworkCapabilities networkData) {
        LOG.trace("Sdniwrapper : updatePeerTable- Start");
        String ipAddress = networkData.getController().toString().replace("[", "").replace("]", "");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean tableExist = false;
        LOG.trace("TOPO:Inside updatePeerTable PeerCount: {}", peer_count);

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();

            LOG.trace("sql connection established");

            LOG.trace("TOPO:in update Peer Table ipAddress: {} findIpAddress(): {}", ipAddress, findIpAddress());

            // check for the self controller ip
            if (ipAddress != findIpAddress()) {
                // if not, get the peercount and loop it
                for (int i = 1; i <= peer_count; i++) {
                    // check for the exist of peer controller 1 table
                    String tableName = "TOPOLOGY_DATABASE_PEER_" + i;
                    String sql = "SELECT controller FROM " + tableName + " LIMIT 1";
                    rs = stmt.executeQuery(sql);
                    long peerIP = 0L;
                    while (rs.next()) {
                        peerIP = rs.getLong("controller");
                    }
                    String peerIPAddress = ntoa(peerIP);
                    LOG.trace("TOPO: Inside for loop, ipAddress: {} peerIPAdrress:{}", ipAddress, peerIPAddress);
                    if (ipAddress.equals(peerIPAddress)) {

                        sql = "drop table TOPOLOGY_DATABASE_PEER_" + i;
                        stmt.executeUpdate(sql);
                        LOG.trace("TOPO: inside if, SQL query to delete topology peer table: {}", sql);

                        sql = "create table TOPOLOGY_DATABASE_PEER_" + i
                                + " (ccontroller varchar(50), links varchar(128));";
                        LOG.trace("TOPO: inside if SQL query to create topology peer table: {}", sql);
                        stmt.executeUpdate(sql);

                        String insertQueries = formInsertQuery(networkData, i);
                        String[] insertQuery = insertQueries.split("--");
                        for (int j = 0; j < insertQuery.length; j++) {
                            stmt.executeUpdate(insertQuery[j]);
                        }
                        tableExist = true;
                    }
                }

                if (!tableExist) {
                    peer_count++;
                    LOG.trace("TOPO: now peerCount: {}", peer_count);
                    // create a new table TOPOLOGY_DATABASE_PEER + count
                    String sql = "create table TOPOLOGY_DATABASE_PEER_" + peer_count
                            + " (controller varchar(50), links varchar(128));";
                    LOG.trace("TOPO:SQL query to create topology peer table for first time: {}", sql);
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    String insertQueries = formInsertQuery(networkData, peer_count);
                    String[] insertQuery = insertQueries.split("--");
                    for (int i = 0; i < insertQuery.length - 1; i++) {
                        stmt.executeUpdate(insertQuery[i]);
                    }
                }
            } else {
                // update self controller table
                LOG.trace("inside update self controller table ie topology_database");
            }
            LOG.trace("TOPO:Peer count at the end of try in topology updatetable {}", peer_count);
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
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                return;
            }
        }
        LOG.trace("Sdniwrapper : updatePeerTable- End");
    }

    public String formInsertQuery(NetworkCapabilities networkData, int peer_count) {
        LOG.trace("QoS: Inside formQOSInsertQuery peercount {}", peer_count);
        String insertQuery = "";

        String controller = networkData.getController();
        List<String> link_id_list = networkData.getLink();
        long controllerIP = ipToLong(controller);

        for (int i = 0; i < link_id_list.size(); i++) {
            String link = link_id_list.get(i);
            if (peer_count == 0) {
                insertQuery += "insert into TOPOLOGY_DATABASE values (\"" + controllerIP + "\",\"" + link + "\"); -- ";
            } else {
                insertQuery += "insert into TOPOLOGY_DATABASE_PEER_" + peer_count + " values( \"" + controllerIP
                        + "\",\"" + link + "\"); -- ";
            }

        }
        LOG.trace("QoS: At the end of formQOSInsertQuery() method insertQuery:{}", insertQuery);
        return insertQuery;
    }

    public ByteBuf getSDNIQoSMessage() {
        byte[] defaultBytes = null;
        //String qosDetails = null;
        ByteBuf sdniQOSBytes = null;
        String controller = null;
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList();
        StringBuilder data = new StringBuilder();

        try {
            org.opendaylight.sdninterfaceapp.impl.OpendaylightSdniQosMsgServiceImpl sdniQoSData = org.opendaylight.sdninterfaceapp.impl.OpendaylightSdniQosMsgServiceImpl.getInstance();
            // Parse rest api content and populate TOPOLOGY_DATABASE data in sqlite
            Future<RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput>> allNodeConnectorStats = sdniQoSData
                    .getAllNodeConnectorsStatistics();

            RpcResult<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput> rpcObj = allNodeConnectorStats
                    .get();


            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.GetAllNodeConnectorsStatisticsOutput qosDetails = rpcObj
                    .getResult();
            List<NodeList> ndList = qosDetails.getNodeList();
            controller = qosDetails.getControllerIp();

            for (NodeList nList : ndList) {
                String nodeID = nList.getNodeId();
                List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortList> portlist = nList
                        .getPortList();
                for (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.PortList Plist : portlist) {
                    String portID = Plist.getPortId();
                    List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParams> Pparamslist = Plist
                            .getPortParams();

                    data.append("{\"output\":[");
                    for(int i=0; i<Pparamslist.size();i++)
                    {
                        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdninterfaceapp.qos.msg.rev151006.get.all.node.connectors.statistics.output.node.list.port.list.PortParams Pparams = Pparamslist.get(i);
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
                        if(i==0)
                            data.append(ncQoS.toString());
                        else
                            data.append(","+ncQoS.toString());
                    }
                    data.append("]}");
                }
            }

            defaultBytes = data.toString().getBytes();
            sdniQOSBytes = Unpooled.copiedBuffer(defaultBytes);
        } catch (InterruptedException | ExecutionException e) {

            LOG.error("Exception : ",e.getMessage());
        }
        return sdniQOSBytes;
    }

    public String parseSDNIQoSMessage(ByteBuf msg) {
        String result = "";
        byte[] bytes = new byte[msg.readableBytes()];
        int readerIndex =msg.readerIndex();
        msg.getBytes(readerIndex, bytes);
        String sdniQOSMsg = new String(bytes);

        LOG.trace("QoS: After parsing sdni qos message from ByteBuf to String: {}",sdniQOSMsg);
        result = parseSDNIQoSMessage(sdniQOSMsg);
        return result;
    }

    private String parseSDNIQoSMessage(String sdniQOSMsg) {
        final List<NetworkCapabilitiesQOS> list_QoS = new ArrayList<NetworkCapabilitiesQOS>();
        boolean peer = true;
        String controller = null;

        try {

            String message = sdniQOSMsg.replace('"', '\"');
            JSONObject json=new JSONObject(message);
            for(int i=0;i<json.getJSONArray("output").length();i++)
            {
                NetworkCapabilitiesQOS qosData = new NetworkCapabilitiesQOS();
                JSONObject subJson = (JSONObject)json.getJSONArray("output").get(i);

                qosData.setController(subJson.get("controller").toString());
                controller = subJson.get("controller").toString();
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

        }catch (Exception e) {
            LOG.error("Exception Message is: ", e);
        }

        //Update peer/controller table in database
        if (!controller.equals(findIpAddress())) {
            peer = false;
        }

        if (peer) {
            LOG.trace("Before calling updatePeerQOSTable");
            updatePeerQOSTable(list_QoS);
        } else {
            LOG.trace("Before calling updateControllerQOSTable");
            updateControllerQOSTable(list_QoS);
        }
        return "";
    }

    public void updateControllerQOSTable(List<NetworkCapabilitiesQOS> list) {

        Connection conn = null;
        Statement stmt = null;
        int qos_peer_count = 0;

        LOG.trace("QoS: Inside updateControllerQOSTable PeerCount:0");

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(QOS_DB_URL);

            LOG.trace("sql connection established");

            stmt = conn.createStatement();
            String sql = "drop table if exists QOS_DATABASE ";
            stmt.executeUpdate(sql);
            LOG.trace("QoS: SQL query to delete Controller QoS table: {}", sql);

            sql = "create table QOS_DATABASE (controller varchar(20), node varchar(20), port varchar(20), receiveFrameError varchar(10) , receiveOverRunError varchar(10), receiveCrcError varchar(10), collisionCount varchar(10), receivePackets varchar(10), transmitPackets varchar(10));";
            stmt.executeUpdate(sql);
            LOG.trace("QoS: SQL query to create Controller QoS table: {}", sql);
            String insertQueries = formQOSInsertQuery(list, qos_peer_count);
            String[] insertQuery = insertQueries.split("--");

            for (int j = 0; j < insertQuery.length; j++) {
                String query = insertQuery[j].replace("LOCAL", "0");
                stmt.executeUpdate(query);
            }
            LOG.trace("QoS: InsertQuery after executing:");

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
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                return;
            }
        }
    }

    public void updatePeerQOSTable(List<NetworkCapabilitiesQOS> list) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean tableExist = false;
        String ipAddress = null;
        for (NetworkCapabilitiesQOS qosData : list) {
            ipAddress = qosData.getController();
        }
        LOG.trace("QoS: Inside updatePeerQOSTable PeerCount: {}", qos_peer_count);
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(QOS_DB_URL);
            stmt = conn.createStatement();
            LOG.trace("sql connection established");

            LOG.trace("QoS: ipAddress: {} findIpAddress(): {}", ipAddress, findIpAddress());
            String sql;
            // check for the self controller ip
            if (ipAddress != findIpAddress()) {
                // if not, get the peercount and loop it

                for (int i = 1; i <= qos_peer_count; i++) {
                    LOG.trace("QoS: Inside trp block in updatePeerTable");
                    // check for the exist of peer controller 1 table
                    String tableName = "QOS_DATABASE_PEER_" + i;
                    sql = "SELECT controller FROM " + tableName + " LIMIT 1";
                    rs = stmt.executeQuery(sql);
                    long peerIP = 0L;
                    while (rs.next()) {
                        peerIP = rs.getLong("controller");
                    }
                    String peerIPAddress = ntoa(peerIP);
                    LOG.trace("QoS: Before if block, IPaddress: {} peerIPaddress: {}", ipAddress, peerIPAddress);
                    if (ipAddress.equals(peerIPAddress)) {

                        sql = "drop table QOS_DATABASE_PEER_" + i;
                        stmt.executeUpdate(sql);
                        sql = "create table QOS_DATABASE_PEER_" + i
                                + " (controller varchar(20), node varchar(30), port varchar(30), receiveFrameError varchar(10) , receiveOverRunError varchar(10), receiveCrcError varchar(10), collisionCount varchar(10), receivePackets varchar(10), transmitPackets varchar(10));";
                        LOG.trace("QoS: SQL query to create QoS peer table: {}", sql);
                        stmt.executeUpdate(sql);

                        String insertQueries = formQOSInsertQuery(list, i);
                        String[] insertQuery = insertQueries.split("--");
                        for (int j = 0; j < insertQuery.length; j++) {
                            String query = insertQuery[j].replace("LOCAL", "0");
                            stmt.executeUpdate(query);
                        }
                        tableExist = true;
                    }
                }

                if (!tableExist) {
                    qos_peer_count++;
                    LOG.info("QoS: now peerCount: {}", qos_peer_count);
                    // create a new table QOS_DATABASE_PEER + count
                    sql = "create table QOS_DATABASE_PEER_" + qos_peer_count
                            + "(controller varchar(20), node varchar(30), port varchar(30), receiveFrameError varchar(10) , receiveOverRunError varchar(10), receiveCrcError varchar(10), collisionCount varchar(10), receivePackets varchar(10), transmitPackets varchar(10));";
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    String insertQueries = formQOSInsertQuery(list, qos_peer_count);
                    String[] insertQuery = insertQueries.split("--");
                    for (int i = 0; i < insertQuery.length - 1; i++) {
                        String query = insertQuery[i].replace("LOCAL", "0");
                        stmt.executeUpdate(query);
                    }

                    LOG.trace("QoS: Peer table creation for first time");
                }
            }
            LOG.trace("QoS: Peer count at the end of try in updatetable {}", qos_peer_count);

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
                }
            } catch (SQLException se) {
                LOG.error("SQLException3: {0}", se);
                return;
            }
        }
    }

    public String formQOSInsertQuery(List<NetworkCapabilitiesQOS> list, int qos_peer_count) {
        LOG.trace("QoS: Inside formQOSInsertQuery peercount {}", qos_peer_count);
        String insertQuery = "";

        for (NetworkCapabilitiesQOS qosData : list) {
            String controller = qosData.getController();

            String node = qosData.getNode();
            String port = qosData.getPort();
            String receiveFrameError = qosData.getReceiveFrameError();
            String receiveOverRunError = qosData.getReceiveOverRunError();
            String receiveCrcError = qosData.getReceiveCrcError();
            String collisionCount = qosData.getCollisionCount();
            String receivePackets = qosData.getReceivePackets();
            String transmitPackets = qosData.getTransmitPackets();
//            LOG.trace(
//                    "QoS: Contents in list: Controller {} Node {} port {} ReceiveFrameError {} ReceiveOverRunError {} ReceiveCrcError {} CollisionCount {} ReceivePackets {} TransmitPackets {}",
//                    controller, node, port, receiveFrameError, receiveOverRunError, receiveCrcError, collisionCount,
//                    receivePackets, transmitPackets);
            long controllerIP = ipToLong(controller);
            if (node == null || port == null) {
                if (qos_peer_count == 0) {
                    insertQuery += "insert into QOS_DATABASE (controller) values (" + controllerIP + "); -- ";
                } else {
                    insertQuery += "insert into QOS_DATABASE_PEER_" + qos_peer_count + " (controller) values( "
                            + controllerIP + "); -- ";
                }
            } else {
                if (qos_peer_count == 0) {
                    insertQuery += "insert into QOS_DATABASE values (\"" + controllerIP + "\",\""
                            + node + "\",\""
                            + port + "\",\"" + receiveFrameError + "\",\""
                            + receiveOverRunError + "\",\"" + receiveCrcError + "\",\"" + collisionCount + "\",\"" + receivePackets
                            + "\",\"" + transmitPackets + "\"); -- ";
                } else {
                    insertQuery += "insert into QOS_DATABASE_PEER_" + qos_peer_count + " values (\"" + controllerIP + "\",\""
                            + node + "\",\""
                            + port + "\",\"" + receiveFrameError + "\",\""
                            + receiveOverRunError + "\",\"" + receiveCrcError + "\",\"" + collisionCount + "\",\"" + receivePackets
                            + "\",\"" + transmitPackets + "\"); -- ";
                }
            }
        }

        LOG.trace("QoS: At the end of formQOSInsertQuery() method insertQuery:{}", insertQuery);
        return insertQuery;
    }

    public static String ntoa(long raw) {
        byte[] b = new byte[] { (byte) (raw >> 24), (byte) (raw >> 16), (byte) (raw >> 8), (byte) raw };
        try {
            return InetAddress.getByAddress(b).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result & 0xFFFFFFFF;
    }

}
