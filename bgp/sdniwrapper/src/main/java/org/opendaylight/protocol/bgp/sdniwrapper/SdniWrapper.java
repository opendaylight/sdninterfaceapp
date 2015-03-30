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

import java.io.IOException;
import java.net.Authenticator;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.PasswordAuthentication;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class SdniWrapper {

	private static Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);
	private static final NetworkCapabilities networkData = new NetworkCapabilities();
        private static final List<NetworkCapabilitiesQOS> list = new ArrayList();
	private final String QOS_URL = "http://localhost:8080/controller/nb/v2/sdni/default/qos";
        private final String CONTROLLER_URL = "http://localhost:8080/controller/nb/v2/sdni/default/topology";
	public static Map peer_information = new HashMap();
	private static int peer_count = 0;

        private static final String JDBC_DRIVER = "org.sqlite.JDBC";
        private static final String DB_URL = "jdbc:sqlite:/home/lte/sdni/database/CONTROLLER_TOPOLOGY_DATABASE";
        private static final String QOS_DB_URL = "jdbc:sqlite:/home/lte/sdni/database/CONTROLLER_QOS_DATABASE";



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
			LOG.warn("Failed to get list of interfaces" + e1);
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

	/*public void printPeerInformation() {
		LOG.info("inside printPeerInformation");
		Iterator<Map.Entry<Integer, Integer>> entries = peer_information
				.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			LOG.info("Key = " + entry.getKey() + ", Value = "
					+ entry.getValue());
		}
	}*/
        public ByteBuf getSDNIMessage() {
		byte[] defaultBytes = null;
		String topologyDetails = null;
		ByteBuf sdniBytes = null;

		// Read the message/topology details from the controller's Rest API
		topologyDetails = callRestAPI(CONTROLLER_URL);

		// Convert the message from string to byte array
		defaultBytes = topologyDetails.getBytes();
		sdniBytes = Unpooled.copiedBuffer(defaultBytes);
		LOG.trace("Convert sdni message into ByteBuf:" + sdniBytes);

		//Parse rest api content and populate TOPOLOGY_DATABASE data in sqlite
                parseSDNIMessage(topologyDetails);

		return sdniBytes;
	}

	
	public String parseSDNIMessage(ByteBuf msg) {
		String result = "";
		byte[] bytes = new byte[msg.readableBytes()];
		int readerIndex = msg.readerIndex();
		msg.getBytes(readerIndex, bytes);
		String sdniMsg = new String(bytes);
		
		LOG.trace("After parsing sdni message from ByteBuf to String: " + sdniMsg);
		result = parseSDNIMessage(sdniMsg);
		return result;

	}

	@SuppressWarnings("unchecked")
	public String parseSDNIMessage(String sdnimsg) {
		boolean peer = true;

		try {
			JsonFactory jfactory = new JsonFactory();

			String message = sdnimsg.replace('"', '\"');

			JsonParser jParser = jfactory.createJsonParser(message);

			LOG.trace("Started parsing sdni message to NetworkCapabilities " + message);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();
				if ("link".equals(fieldname)) {
					jParser.nextToken();
					String links = jParser.getText();
					List<String> tempList = new ArrayList<String>();	
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						System.out.println("link:"+jParser.getText());
						tempList.add(jParser.getText());
			                }
					networkData.setLink(tempList);
				}
				if ("bandwidth".equals(fieldname)) {
					jParser.nextToken();
					String bandwidth = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	                		}
					networkData.setBandwidth(tempList);
				}
				if ("latency".equals(fieldname)) {
					jParser.nextToken();
					String latency = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	                		}
					networkData.setLatency(tempList);
				}
				if ("macAddressList".equals(fieldname)) {
					jParser.nextToken();
					String macAddressList = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	                		}
					networkData.setMacAddressList(tempList);	
				}
				if ("ipAddressList".equals(fieldname)) {
					jParser.nextToken();
					String ipAddressList = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	                		}
					networkData.setIpAddressList(tempList);
				}
				if ("controller".equals(fieldname)) {
					jParser.nextToken();
					String controller = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	        		        }
					networkData.setController(tempList);
				}
				if ("node".equals(fieldname)) {
					jParser.nextToken();
					String node = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
	        		        }
					networkData.setNode(tempList);
				}
				if ("host".equals(fieldname)) {
					jParser.nextToken();
					String host = jParser.getText();
					List<String> tempList = new ArrayList<String>();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						tempList.add(jParser.getText());
			                }
					networkData.setHost(tempList);
				}
			}
			jParser.close();
		} catch (JsonGenerationException e) {
			LOG.trace("JsonGenerationException:" + e);
			return "JsonGenerationException";
		} catch (JsonMappingException e) {
			LOG.trace("JsonMappingException:" + e);
			return "JsonMappingException";
		} catch (IOException e) {
			LOG.trace("IOException:" + e);
			return "IOException";
		}
	 //Check the IP address for controller or not
                String controllerIP = networkData.getController().toString().replace("[", "").replace("]", "");
                if(controllerIP.equals(findIpAddress())){
                        peer = false;
                }

                //Update peer/controller table in database
       		if(peer){
                	peer_information.put(networkData.getController().toString(),networkData);
                	LOG.trace("Before calling updatePeerTable");
                	updatePeerTable(networkData);
                	LOG.trace("After storing sdni message in peer_info:"
                	    + peer_information.get(networkData.getController().toString()));
        	}else {
                	updateControllerTable(networkData);
        	}
        return "success";
        }

	
public void updateControllerTable(NetworkCapabilities networkData){

                Connection conn = null;
        Statement stmt = null;
        int peer_count = 0;

        LOG.trace("inside updateControllerTable PeerCount:0");

        try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL);

            LOG.trace("sql connection established");

            stmt = conn.createStatement();
            String sql = "drop table if exists TOPOLOGY_DATABASE ";
            stmt.executeUpdate(sql);
            LOG.trace("SQL query to delete controller table:"+sql);

            sql = "create table TOPOLOGY_DATABASE (controller bigint(20), links int(11), nodes int(11), hosts int(11), link_bandwidths bigint(20) , latencies int(11), macAddressList bigint(20), ipAddressList bigint(20));";
            stmt.executeUpdate(sql);
            LOG.trace("SQL query to create controller table:"+sql);

            String insertQueries = formInsertQuery(networkData, peer_count);
            String[] insertQuery = insertQueries.split("--");
            for(int j = 0; j< insertQuery.length;j++){
                LOG.trace("insertQuery:"+insertQuery[j]);
                stmt.executeUpdate(insertQuery[j]);
            }
        } catch (SQLException se) {
                        LOG.trace("SQLException:"+se);
            return;
        } catch (Exception e) {
                LOG.trace("Exception:"+e);
            return;
        } finally {
		 try {
                        if (stmt != null)
                                stmt.close();
                } catch (SQLException se2) {
                                LOG.trace("SQLException2:"+se2);
                                return;
                }

                try {
                if (conn != null)
                        conn.close();
            } catch (SQLException se) {
                LOG.trace("SQLException3:"+se);
                return;
            }
        }
        }
    public void updatePeerTable(NetworkCapabilities networkData){
        String ipAddress = networkData.getController().toString().replace("[","").replace("]","");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean tableExist = false;
        LOG.trace("inside updatePeerTable PeerCount:"+peer_count);

        try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL);
                stmt = conn.createStatement();

            LOG.trace("sql connection established");
            LOG.trace("ipAddress:"+ipAddress+" findIpAddress():"+findIpAddress());

            //check for the self controller ip
            if(ipAddress != findIpAddress()){
                //if not, get the peercount and loop it
                for(int i=1;i<=peer_count;i++){
			//check for the exist of peer controller 1 table
                    String tableName = "TOPOLOGY_DATABASE_PEER_"+i;
                    String sql = "SELECT controller FROM "+tableName +" LIMIT 1";
                    rs = stmt.executeQuery(sql);
                    long peerIP = 0L;
                    while(rs.next()){
                        peerIP = rs.getLong("controller");
                    }
                         String peerIPAddress =ntoa(peerIP);
                         if(ipAddress.equals(peerIPAddress)){
                                 sql = "drop table TOPOLOGY_DATABASE_PEER_"+i;
                             stmt.executeUpdate(sql);

                             sql = "create table TOPOLOGY_DATABASE_PEER_"+i+" (controller bigint(20), links int(11), nodes int(11), hosts int(11), link_bandwidths bigint(20) , latencies int(11), macAddressList bigint(20), ipAddressList bigint(20));";
                             LOG.trace("SQL query to delete/create peer table:"+sql);
                             stmt.executeUpdate(sql);

                             String insertQueries = formInsertQuery(networkData, i);
                             String[] insertQuery = insertQueries.split("--");
                             for(int j = 0; j< insertQuery.length;j++){
                                 LOG.trace("insertQUery:"+insertQuery[j]);
                                 stmt.executeUpdate(insertQuery[j]);
                             }
                     tableExist = true;
                         }
                }

                if(!tableExist){
                        peer_count++;
                    LOG.trace("now peerCount:"+peer_count);
			 //create a new table TOPOLOGY_DATABASE_PEER + count
                    String sql = "create table TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller bigint(20), links int(11), nodes int(11), hosts int(11), link_bandwidths bigint(20) , latencies int(11), macAddressList bigint(20), ipAddressList bigint(20));";
                    LOG.trace("SQL query to create peer table:"+sql);
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);

                    String insertQueries = formInsertQuery(networkData, peer_count);
                    String[] insertQuery = insertQueries.split("--");
                    for(int i = 0; i< insertQuery.length-1;i++){
                        LOG.trace("insertQUery:"+insertQuery[i]);
                        stmt.executeUpdate(insertQuery[i]);
                    }
                }
        }else {
                //update self controller table
                LOG.trace("inside update self controller table ie topology_database");
        }
                } catch (SQLException se) {
                        LOG.trace("SQLException:"+se);
            return;
        } catch (Exception e) {
                LOG.trace("Exception:"+e);
            return;
        } finally {
                try {
                        if (stmt != null)
                                stmt.close();
                } catch (SQLException se2) {
                                LOG.trace("SQLException2:"+se2);
                                return;
                }

                try {
                if (conn != null)
                        conn.close();
            } catch (SQLException se) {
		 LOG.trace("SQLException3:"+se);
                return;
            }
        }
    }

    public String formInsertQuery(NetworkCapabilities networkData, int peer_count){
        LOG.trace("inside formInsertQuery");
        String insertQuery = "";
        List<String> uniqueLinks =  new ArrayList<String>();
        List<String> uniqueBandwidth = new ArrayList<String>();
        int i=0;

        List<String> hosts = networkData.getHost();
        List<String> hostIpAddress = networkData.getIpAddressList();
        List<String> macAddress = networkData.getMacAddressList();
        List<String> nodes = networkData.getNode();
        List<String> bandwidth = networkData.getBandwidth();
        Iterator<String> lt = networkData.getLink().iterator();

        String IpAddress  = networkData.getController().toString().replace("[","").replace("]","");
        long controllerIP = ipToLong(IpAddress);
        LOG.trace("ipAddress:"+IpAddress+" After long conversion:"+controllerIP);

        while(lt.hasNext()){
                String linkname = lt.next().toString();

            int breakpoint1 = linkname.indexOf("->");
                String first1 = linkname.substring(0, breakpoint1);
                String second1 = linkname.substring(breakpoint1);

            int firstStr=1;
	    String digitCheck = first1.substring(first1.lastIndexOf(':') + 1, first1.lastIndexOf(':') + 2);
            if(digitCheck.equals("0")){firstStr=2;}

            int secondStr=1;
                String digitSecCheck = second1.substring(second1.lastIndexOf(':') + 1, second1.length() - 2);
                if(digitSecCheck.equals("0")){secondStr=2;}

            String finalLink = first1.substring(first1.lastIndexOf(':') + firstStr, breakpoint1)
                        + second1.substring(second1.lastIndexOf(':') + secondStr,second1.length() - 1);

                String reverseLink = second1.substring(second1.lastIndexOf(':') + secondStr, second1.length() - 1)
                        + first1.substring(first1.lastIndexOf(':') + firstStr,breakpoint1);

            LOG.trace("final:"+finalLink+" reverse:"+reverseLink);

            if(!uniqueLinks.contains(finalLink) && !uniqueLinks.contains(reverseLink)){
                        uniqueLinks.add(finalLink);
                        if(bandwidth.size()>0){
	              	    try{
                                String bandwidthTemp = bandwidth.get(i).substring(0,bandwidth.get(i).indexOf("Gbps"));
                                LOG.trace("bandwidthTemp:"+ bandwidthTemp);
                                uniqueBandwidth.add(bandwidthTemp);
                            }catch(java.lang.IndexOutOfBoundsException e){
                                uniqueBandwidth.add("0");
                            }catch(Exception e){
                                uniqueBandwidth.add("0");
                            }

                        }
                }
            i++;
        }

        LOG.trace("size of uniqueLInks"+uniqueLinks.size());
            int linkSize = uniqueLinks.size();

                if(linkSize == 0){
                        if(peer_count == 0){
                                insertQuery +=  "insert into TOPOLOGY_DATABASE (controller) values (" + controllerIP + "); -- ";
                        }else {
                                insertQuery +=  "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller) values ( "
                                                        + controllerIP + "); -- ";
                        }
                } else {
			if(peer_count == 0){
                                for(int j=0;j<uniqueLinks.size();j++){
                                        if(uniqueBandwidth.size()==uniqueLinks.size()){
                                                        if(nodes.size()>j && macAddress.size()>j){
                                                                String nodeList = nodes.get(j).toString();
                                                                LOG.trace("nodeList"+nodeList);
                                                                String node = nodeList.substring(nodes.get(j).lastIndexOf(":")+2);
                                                                LOG.trace("node:"+node);
                                                                String macList = macAddress.get(j).toString();
                                                                LOG.trace("macList:"+macList);
                                                                String mac = macList.substring(macAddress.get(j).lastIndexOf(":")+2);
                                                                LOG.trace("mac:"+mac);
                                                                LOG.trace("mac:"+mac+"node:"+node);
                                                                if(hosts.size()>j&& hostIpAddress.size()>j){
                                                                        long hostIP = ipToLong(hostIpAddress.get(j));
                                                                        LOG.trace("mac:"+mac+"node:"+node+"hostIP:"+hostIP);
                                                                        insertQuery += "insert into TOPOLOGY_DATABASE (controller, links, link_bandwidths, nodes, macAddressList, hosts, ipAddressList) values ( "
                                                + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "," + node + "," + mac + "," + hosts.get(j) + "," + hostIP + "); -- ";
                                                                }else{
                                                                        insertQuery += "insert into TOPOLOGY_DATABASE (controller, links, link_bandwidths, nodes, macAddressList) values ( "
                                                + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "," + node + "," + mac + "); -- ";
                                                                }
                                                        }else{
                                                                insertQuery += "insert into TOPOLOGY_DATABASE (controller, links, link_bandwidths) values ( "
                                        + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "); -- ";
                                                        }

                                        }else{
                                                if(nodes.size()>j && macAddress.size()>j){
                                                        String nodeList = nodes.get(j).toString();
							LOG.trace("nodeList"+nodeList);
                                                        String node = nodeList.substring(nodes.get(j).lastIndexOf(":")+2);
                                                        LOG.trace("node:"+node);
                                                        String macList = macAddress.get(j).toString();
                                                        LOG.trace("macList:"+macList);
                                                        String mac = macList.substring(macAddress.get(j).lastIndexOf(":")+2);
                                                        LOG.trace("mac:"+mac);
                                                        LOG.trace("mac:"+mac+"node:"+node);
                                                        if(hosts.size()>j&& hostIpAddress.size()>j){
                                                                long hostIP = ipToLong(hostIpAddress.get(j));
                                                                LOG.trace("mac:"+mac+"node:"+node+"hostIP:"+hostIP);
                                                                insertQuery += "insert into TOPOLOGY_DATABASE (controller, links, nodes, macAddressList, hosts, ipAddressList) values ("
                                                                                + controllerIP + "," + uniqueLinks.get(j)  + "," + node + "," + mac + "," + hosts.get(j) + "," + hostIP  +"); -- ";
                                                        }else {
                                                                insertQuery += "insert into TOPOLOGY_DATABASE (controller, links, nodes, macAddressList) values ("
                                                                        + controllerIP + "," + uniqueLinks.get(j) + "," + node + "," +mac +"); -- ";
                                                        }
                                                } else {
                                                        insertQuery += "insert into TOPOLOGY_DATABASE (controller, links) values ("
                                                                + controllerIP + "," + uniqueLinks.get(j) +"); -- ";
                                                }
                                        }
                    }
                        }else {
                                for(int j=0;j<uniqueLinks.size();j++){
                                        if(uniqueBandwidth.size()==uniqueLinks.size()){
                                                        if(nodes.size()>j && macAddress.size()>j){
                                                                String nodeList = nodes.get(j).toString();
                                                                LOG.trace("nodeList"+nodeList);
                                                                String node = nodeList.substring(nodes.get(j).lastIndexOf(":")+2);
                                                                LOG.trace("node:"+node);
                                                                String macList = macAddress.get(j).toString();
                                                                LOG.trace("macList:"+macList);
								 String mac = macList.substring(macAddress.get(j).lastIndexOf(":")+2);
                                                                LOG.trace("mac:"+mac);
                                                                LOG.trace("mac:"+mac+"node:"+node);
                                                                if(hosts.size()>j&& hostIpAddress.size()>j){
                                                                        long hostIP = ipToLong(hostIpAddress.get(j));
                                                                        LOG.trace("mac:"+mac+"node:"+node+"hostIP:"+hostIP);

                                                                        insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links, link_bandwidths, nodes, macAddressList, hosts, ipAddressList) values ( "
                                                + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "," + node + "," + mac + "," + hosts.get(j) + "," + hostIP + "); -- ";
                                                                }else{
                                                                        insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links, link_bandwidths, nodes, macAddressList) values ( "
                                                + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "," + node + "," + mac + "); -- ";
                                                                }
                                                        }else{
                                                                insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links, link_bandwidths) values ( "
                                        + controllerIP + "," + uniqueLinks.get(j) + "," + uniqueBandwidth.get(j) + "); -- ";
                                                        }

                                        }else{
                                                if(nodes.size()>j && macAddress.size()>j){
                                                        String nodeList = nodes.get(j).toString();
                                                        LOG.trace("nodeList"+nodeList);
                                                        String node = nodeList.substring(nodes.get(j).lastIndexOf(":")+2);
                                                        LOG.trace("node:"+node);
                                                        String macList = macAddress.get(j).toString();
                                                        LOG.trace("macList:"+macList);
                                                        String mac = macList.substring(macAddress.get(j).lastIndexOf(":")+2);
                                                        LOG.trace("mac:"+mac);
                                                        LOG.trace("mac:"+mac+"node:"+node);
                                                        if(hosts.size()>j&& hostIpAddress.size()>j){
                                                                long hostIP = ipToLong(hostIpAddress.get(j));
                                                                LOG.trace("mac:"+mac+"node:"+node+"hostIP:"+hostIP);
								insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links, nodes, macAddressList, hosts, ipAddressList) values ("
                                                                                + controllerIP + "," + uniqueLinks.get(j)  + "," + node + "," + mac + "," + hosts.get(j) + "," + hostIP  +"); -- ";
                                                        }else {
                                                                insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links, nodes, macAddressList) values ("
                                                                        + controllerIP + "," + uniqueLinks.get(j) + "," + node + "," + mac +"); -- ";
                                                        }
                                                } else {
                                                        insertQuery += "insert into TOPOLOGY_DATABASE_PEER_"+peer_count+" (controller, links) values ("
                                                                + controllerIP + "," + uniqueLinks.get(j) +"); -- ";
                                                }
                                        }
                    }
                        }
                }
                LOG.trace("insertQuery at the end of formInsertQuery() method:"+insertQuery);
                return insertQuery;
    }

	public ByteBuf getSDNIQOSMessage() {
		byte[] defaultBytes = null;
		String qosDetails = null;
		ByteBuf sdniQOSBytes = null;

		// Read the message/topology details from the controller's Rest API
		qosDetails = callRestAPI(QOS_URL);

		// Convert the message from string to byte array
		defaultBytes = qosDetails.getBytes();
		sdniQOSBytes = Unpooled.copiedBuffer(defaultBytes);
		LOG.trace("Convert sdni qos message into ByteBuf:" + sdniQOSBytes);

		//Parse rest api content and populate TOPOLOGY_DATABASE data in sqlite
                parseSDNIQOSMessage(qosDetails);

		return sdniQOSBytes;
	}

	public String parseSDNIQOSMessage(ByteBuf msg) {
		String result = "";
		byte[] bytes = new byte[msg.readableBytes()];
		int readerIndex = msg.readerIndex();
		msg.getBytes(readerIndex, bytes);
		String sdniQOSMsg = new String(bytes);
		
		LOG.trace("After parsing sdni qos message from ByteBuf to String: " + sdniQOSMsg);
		result = parseSDNIQOSMessage(sdniQOSMsg);
		return result;

	}
        @SuppressWarnings("unchecked")
	public String parseSDNIQOSMessage(String sdniQOSMsg) {
		 boolean peer = true;

		try {
		        JsonFactory jfactory = new JsonFactory();
			String message = sdniQOSMsg.replace('"', '\"');

        		JsonParser jParser = jfactory.createJsonParser(message);

        		LOG.trace("Started parsing sdni message to NetworkCapabilities " + sdniQOSMsg);
			while (jParser.nextToken() != JsonToken.END_ARRAY) {

			    NetworkCapabilitiesQOS qosData = new NetworkCapabilitiesQOS();
		            while (jParser.nextToken() != JsonToken.END_OBJECT) {
		
		                String fieldname = jParser.getCurrentName();
		                
		                            if ("port".equals(jParser.getText())) {
		                                 jParser.nextToken();
		                                 qosData.setPort(jParser.getText());
		                             }
		                            if ("node".equals(jParser.getText())) {
		                                 jParser.nextToken();
		                                 qosData.setNode(jParser.getText());
		                             }
		                            if ("receiveFrameError".equals(jParser.getText())) {
		                                jParser.nextToken();
		                                qosData.setReceiveFrameError(jParser.getText());
		                            }
					    if ("receivePackets".equals(jParser.getText())){
						jParser.nextToken();
						qosData.setReceivePackets(jParser.getText());
					    }
					    if ("transmitPackets".equals(jParser.getText())){
						jParser.nextToken();
						qosData.setTransmitPackets(jParser.getText());
					    }
		                            if ("receiveOverRunError".equals(jParser.getText())) {
		                                jParser.nextToken();
		                                qosData.setReceiveOverRunError(jParser.getText());
		                            }
		                            if ("receiveCrcError".equals(jParser.getText())) {
		                                jParser.nextToken();
		                                qosData.setReceiveCrcError(jParser.getText());
		                            }
		                            if ("collisionCount".equals(jParser.getText())) {
		                                jParser.nextToken();
		                                qosData.setCollisionCount(jParser.getText());
		                            }
		                        }
		                        list.add(qosData);
		                    }
			jParser.close();
		}
		catch (JsonGenerationException e) {
			LOG.trace("JsonGenerationException:" + e);
			return "JsonGenerationException";
		}
		catch (JsonMappingException e) {
			LOG.trace("JsonMappingException:" + e);
			return "JsonMappingException";
		} 
		catch (IOException e) {
			LOG.trace("IOException:" + e);
			return "IOException";
		}
 		//Check the IP address for controller or not
                String controllerIP = networkData.getController().toString().replace("[", "").replace("]", "");
                if(controllerIP.equals(findIpAddress())){
                        peer = false;
                }

                //Update peer/controller table in database
                if(peer){
                	peer_information.put(networkData.getController().toString(),list);
	                LOG.trace("Before calling updatePeerTable");
        	        updatePeerQOSTable(list);
        	        LOG.trace("After storing sdni message in peer_info:"+ peer_information.get(networkData.getController().toString()));
        	}else {
                updateControllerQOSTable(list);
        	}
        	return "success";
        }

	public void updateControllerQOSTable(List<NetworkCapabilitiesQOS> list){

        Connection conn = null;
        Statement stmt = null;
        int peer_count = 0;

        LOG.trace("inside updateControllerQOSTable PeerCount:0");

        try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(QOS_DB_URL);

          	LOG.trace("sql connection established");

	        stmt = conn.createStatement();
        	String sql = "drop table if exists QOS_DATABASE ";
                stmt.executeUpdate(sql);
            	LOG.trace("SQL query to delete Controller QOS table:"+sql);

            	sql = "create table QOS_DATABASE (controller bigint(20), node int(11), port int(10), receiveFrameError int(10) , receiveOverRunError int(10), receiveCrcError int(10), collisionCount int(10), receivePackets int(10), transmitPackets int(10));";
            	stmt.executeUpdate(sql);
            	LOG.trace("SQL query to create Controller QOS table:"+sql);

            	String insertQueries = formQOSInsertQuery(list, peer_count); 
            	String[] insertQuery = insertQueries.split("--");
            	for(int j = 0; j< insertQuery.length;j++){
                	LOG.trace("insertQuery:"+insertQuery[j]);
                	stmt.executeUpdate(insertQuery[j]);
            	}
           } catch (SQLException se) {
             	LOG.trace("SQLException:"+se);
             	return;
           } catch (Exception e) {
                LOG.trace("Exception:"+e);
                return;
           } finally {
		try {
                    if (stmt != null)
                    stmt.close();
                } catch (SQLException se2) {
                    LOG.trace("SQLException2:"+se2);
                    return;
                }

                try {
                    if (conn != null)
                    conn.close();
                } catch (SQLException se) {
                    LOG.trace("SQLException3:"+se);
                    return;
                }
            }
        }
	
	public void updatePeerQOSTable(List<NetworkCapabilitiesQOS> list){
        String ipAddress = networkData.getController().toString().replace("[","").replace("]","");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean tableExist = false;
        LOG.trace("inside updatePeerQOSTable PeerCount:"+peer_count);

        try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(QOS_DB_URL);
                stmt = conn.createStatement();

          	LOG.trace("sql connection established");
            	LOG.trace("ipAddress:"+ipAddress+" findIpAddress():"+findIpAddress());

                //check for the self controller ip
           	if(ipAddress != findIpAddress()){
                	//if not, get the peercount and loop it
               		 for(int i=1;i<=peer_count;i++){
				//check for the exist of peer controller 1 table
                    		String tableName = "QOS_DATABASE_PEER_"+i;
                    		String sql = "SELECT controller FROM "+tableName +" LIMIT 1";
                    		rs = stmt.executeQuery(sql);
                    		long peerIP = 0L;
                    		while(rs.next()){
                        		peerIP = rs.getLong("controller");
                    		}
                        	String peerIPAddress =ntoa(peerIP);
                         	if(ipAddress.equals(peerIPAddress)){
                                 	sql = "drop table QOS_DATABASE_PEER_"+i;
                             		stmt.executeUpdate(sql);

                             		sql = "create table QOS_DATABASE_PEER_"+i+" (controller bigint(20), node int(11), port int(10), receiveFrameError int(10) , receiveOverRunError int(10), receiveCrcError int(10), collisionCount int(10), receivePackets int(10), transmitPackets int(10));";
                            		LOG.trace("SQL query to delete/create QOS peer table:"+sql);
                            		stmt.executeUpdate(sql);

                            		String insertQueries = formQOSInsertQuery(list, i);
                             		String[] insertQuery = insertQueries.split("--");
                            		for(int j = 0; j< insertQuery.length;j++){
                               	 		LOG.trace("insertQUery:"+insertQuery[j]);
                                		stmt.executeUpdate(insertQuery[j]);
                             		}
                     			tableExist = true;
                         	}
                	}

               		if(!tableExist){
                        	peer_count++;
                    		LOG.trace("now peerCount:"+peer_count);
			 	//create a new table TOPOLOGY_DATABASE_PEER + count
                    		String sql = "create table QOS_DATABASE_PEER_"+peer_count+" (controller bigint(20), node int(11), port int(10), receiveFrameError int(10) , receiveOverRunError int(10), receiveCrcError int(10), collisionCount int(10), receivePackets int(10), transmitPackets int(10));";
                   		LOG.trace("SQL query to create QOS peer table:"+sql);
                    		stmt = conn.createStatement();
                    		stmt.executeUpdate(sql);

                    		String insertQueries = formQOSInsertQuery(list, peer_count);
                    		String[] insertQuery = insertQueries.split("--");
                    		for(int i = 0; i< insertQuery.length-1;i++){
                        		LOG.trace("insertQUery:"+insertQuery[i]);
                        		stmt.executeUpdate(insertQuery[i]);
                    		}
                	}
        	    }else {
                //update self controller table
                	LOG.trace("inside update self controller table ie QOS_database");
        	    }
                } catch (SQLException se) {
                        LOG.trace("SQLException:"+se);
                        return;
        	} catch (Exception e) {
                	LOG.trace("Exception:"+e);
            		return;
       		} finally {
                	try {
                        	if (stmt != null)
                                stmt.close();
                        } catch (SQLException se2) {
                                LOG.trace("SQLException2:"+se2);
                                return;
                	}

                	try {
                		if (conn != null)
                        	conn.close();
           		} catch (SQLException se) {
		 		LOG.trace("SQLException3:"+se);
                		return;
            		}
        	}
    }

    public String formQOSInsertQuery(List<NetworkCapabilitiesQOS> list, int peer_count){
        LOG.trace("inside formInsertQuery");
        String insertQuery = "";
        int i=0;
        String controllerIP = networkData.getController().toString().replace("[", "").replace("]", "");
        List<String> controllerNodes = new ArrayList();
                if(controllerIP.equals(findIpAddress())){
                       controllerNodes = networkData.getNode();
                 }
        for(NetworkCapabilitiesQOS qosData : list){
	        String node = qosData.getNode();
	        String port= qosData.getPort();
	        String receiveFrameError = qosData.getReceiveFrameError();
	        String receiveOverRunError = qosData.getReceiveOverRunError();
	        String receiveCrcError = qosData.getReceiveCrcError();
	        String collisionCount = qosData.getCollisionCount();
		String receivePackets = qosData.getReceivePackets();
		String transmitPackets = qosData.getTransmitPackets();
                
                if(node == null)
                {
			if(controllerIP.equals(findIpAddress())){
                                insertQuery +=  "insert into QOS_DATABASE (controller) values (" + controllerIP + "); -- ";
                        }else {
				  for(i=1;i<=peer_count;i++){
                                  insertQuery +=  "insert into QOS_DATABASE_PEER_"+peer_count+" (controller) values( " + controllerIP + "); -- ";
				  }
                        }

                }
                else{ 
			for(String nodes : controllerNodes)
 			{
				if(nodes == node){
					insertQuery +=  "insert into QOS_DATABASE values (" + controllerIP + "," + node + "," + port + "," + receiveFrameError + "," + receiveOverRunError + "," +  receiveCrcError  + "," + collisionCount + "," + receivePackets + "," + transmitPackets + "); -- ";
				} else
				{
					for(i=1;i<=peer_count;i++){
						insertQuery +=  "insert into QOS_DATABASE_PEER_"+peer_count + "values (" + controllerIP + "," + node + "," + port + "," + receiveFrameError + "," + receiveOverRunError + "," +  receiveCrcError  + "," + collisionCount + "," + receivePackets + "," + transmitPackets + "); -- ";
					}	
				}
              		}
		}
        
    	    }
	    LOG.trace("insertQuery at the end of formInsertQuery() method:"+insertQuery);
            return insertQuery;
	}

    	public static String ntoa(long raw) {
        	byte[] b = new byte[] {(byte)(raw >> 24), (byte)(raw >> 16), (byte)(raw >> 8), (byte)raw};
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

                                                        
	public String callRestAPI(String url) {
		final String admin = "admin";
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(admin, admin.toCharArray());
			}
		});
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(url).build());
		String data = service.accept(MediaType.APPLICATION_JSON).get(
				String.class);
		LOG.trace("Read sdni message from rest api:" + data);
		return data;
	}

 }
