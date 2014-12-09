/*
 * Copyright (c) 2014 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.sdniwrapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.net.Authenticator;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.PasswordAuthentication;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdniWrapper {

    private static final Logger LOG = LoggerFactory.getLogger(SdniWrapper.class);
    private static final NetworkCapabilities networkData = new NetworkCapabilities();
    private final String CONTROLLER_URL = "http://localhost:8080/controller/nb/v2/sdni/default/topology";
    public static Map peer_information = new HashMap();

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
        LOG.trace("Convert sdni message into ByteBuf: {0}", sdniBytes);
        return sdniBytes;
    }

    public String parseSDNIMessage(ByteBuf msg) {
        String result = "";
        byte[] bytes = new byte[msg.readableBytes()];
        int readerIndex = msg.readerIndex();
        msg.getBytes(readerIndex, bytes);
        String sdniMsg = new String(bytes);

        LOG.trace("After parsing sdni message from ByteBuf to String: {0}", sdniMsg);
        result = parseSDNIMessage(sdniMsg);
        return result;

    }

    @SuppressWarnings("unchecked")
    public String parseSDNIMessage(String sdnimsg) {

        try {
            JsonFactory jfactory = new JsonFactory();

            String message = sdnimsg.replace('"', '\"');

            JsonParser jParser = jfactory.createJsonParser(message);

            LOG.trace("Started parsing sdni message to NetworkCapabilities {0}", message);
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
                    networkData.setLinks(tempList);
                }
                if ("bandwidth".equals(fieldname)) {
                    jParser.nextToken();
                    String bandwidth = jParser.getText();
                    List<String> tempList = new ArrayList<String>();
                    while (jParser.nextToken() != JsonToken.END_ARRAY) {
                        tempList.add(jParser.getText());
                    }
                    networkData.setBandwidths(tempList);
                }
                if ("latency".equals(fieldname)) {
                    jParser.nextToken();
                    String latency = jParser.getText();
                    List<String> tempList = new ArrayList<String>();
                    while (jParser.nextToken() != JsonToken.END_ARRAY) {
                        tempList.add(jParser.getText());
                    }
                    networkData.setLatencies(tempList);
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
                    networkData.setControllers(tempList);
                }
                if ("node".equals(fieldname)) {
                    jParser.nextToken();
                    String node = jParser.getText();
                    List<String> tempList = new ArrayList<String>();
                    while (jParser.nextToken() != JsonToken.END_ARRAY) {
                        tempList.add(jParser.getText());
                    }
                    networkData.setNodes(tempList);
                }
                if ("host".equals(fieldname)) {
                    jParser.nextToken();
                    String host = jParser.getText();
                    List<String> tempList = new ArrayList<String>();
                    while (jParser.nextToken() != JsonToken.END_ARRAY) {
                        tempList.add(jParser.getText());
                    }
                    networkData.setHosts(tempList);
                }
            }
            jParser.close();
        } catch (JsonGenerationException e) {
            LOG.trace("JsonGenerationException:{0}", e);
            return "JsonGenerationException";
        } catch (JsonMappingException e) {
            LOG.trace("JsonMappingException:{0}", e);
            return "JsonMappingException";
        } catch (IOException e) {
            LOG.trace("IOException:{0}", e);
            return "IOException";
        }
        peer_information.put(networkData.getControllers().toString(),
                networkData);
        LOG.trace("After storing sdni message in peer_info:{0}",
                peer_information.get(networkData.getControllers().toString()));
        return "success";
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
        LOG.trace("Read sdni message from rest api:{0}", data);
        return data;
    }

}
