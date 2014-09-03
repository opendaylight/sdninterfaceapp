/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.protocol.bgp.sdniwrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParser {
    
    private static Logger LOG = LoggerFactory.getLogger(XmlParser.class);
	public static List<String> ip_address = new ArrayList<String>();
	

	public String setValue(String peer_ip) {
		ip_address.add(peer_ip);
		return "success";
	}

	public String saxValuParser(String path) {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bgp_peer = false;
				boolean name = false;
				boolean host = false;
				String peer_id = null;

				public void startElement(String uri, String localName,
						String tag, Attributes attributes) throws SAXException {

					if (tag.equalsIgnoreCase("name")) {
						name = true;
					}
					if (tag.equalsIgnoreCase("host")) {
						host = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					//System.out.println("End Element :" + qName);

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (name) {
						String type_name = new String(ch, start, length);
						if (type_name.equals("example-bgp-peer")) {
							bgp_peer = true;
						}
						name = false;
					}

					if (host && bgp_peer) {
						peer_id = new String(ch, start, length);
						LOG.info("Peer IP: " + peer_id);
						bgp_peer = false;
						host = false;
						if (peer_id != null) {
						    LOG.info(setValue(peer_id));
						}
					}
				}

			};

			saxParser.parse(path,handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}
	
	public List<String> getPeerIP(String path){
		saxValuParser(path);
		return ip_address;
	}
}
