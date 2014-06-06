package org.opendaylight.controller.sdni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import net.floodlightcontroller.packet.IPv4;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class NetworkCapabilities {
	
	@XmlElement
	private List<String> link = new ArrayList<String>();
	@XmlElement
	private List<String> bandwidth = new ArrayList<String>();
	@XmlElement
	private List<String> latency = new ArrayList<String>();
	@XmlElement
	private List<String> macAddressList = new ArrayList<String>();
	@XmlElement
	private List<String> ipAddressList= new ArrayList<String>();
	@XmlElement
	private List<String> controller = new ArrayList<String>();
	@XmlElement
	private List<String> node = new ArrayList<String>();
	@XmlElement
	private List<String> host = new ArrayList<String>();
	
	public NetworkCapabilities(){
		
	}
	public List<String> getLinks() {
		return link;
	}

	public void setLinks(List<String> _links) {
		this.link = _links;
	}

	public void addLink(String links) {		
		link.add(links);
	}
	
	public List<String> getBandwidths() {
		return bandwidth;
	}

	public void setBandwidths(List<String> _bandwidths) {
		this.bandwidth = _bandwidths;
	}

	public void addBandwidth(String bandwidth) {		
		this.bandwidth.add(bandwidth);
	}
	
	public List<String> getLatencies() {
		return latency;
	}

	public void setLatencies(List<String> _latencies) {
		this.latency = _latencies;
	}

	public void addLatency(String latency) {		
		this.latency.add(latency);
	}
	
	public void addController(String controller) {		
		this.controller.add(controller);
	}
	
	public void addController(int controller) {			
		//this._controllers.add(IPv4.fromIPv4Address(controller));
	}
	
	public void addNode(String node) {
		this.node.add(node);
		Collections.sort(this.node);
	}
	
	public void addHost(String host) {
		this.host.add(host);
	}	
	
	public List<String> getControllers() {
		return controller;
	}
	public void setControllers(List<String> _controllers) {
		this.controller = _controllers;
	}
	
	public List<String> getNodes() {
		return node;
	}

	public void setNodes(List<String> _nodes) {
		this.node = _nodes;
	}

	public List<String> getHosts() {
		return host;
	}
	public void setHosts(List<String> _hosts) {
		this.host = _hosts;
	}
	
		
	public void addMacAddress(String macAddress1) {		
		macAddressList.add(macAddress1);
		Collections.sort(this.macAddressList);
	}
	
	public void addIpAddress(String ipAddress1) {		
		ipAddressList.add(ipAddress1);
	}

	public void addIpAddress(int ipAddress1) {
		//this._ipAddressList.add(IPv4.fromIPv4Address(ipAddress1));
	}
	
	public List<String> getMacAddressList() {
		return macAddressList;
	}

	public void setMacAddressList(List<String> _macAddress) {
		this.macAddressList = _macAddress;
	}

	public List<String> getIpAddressList() {
		return ipAddressList;
	}

	public void setIpAddressList(List<String> _ipAddress) {
		this.ipAddressList = _ipAddress;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Controllers ").append(controller);
		sb.append(", Links ").append(link);
		sb.append(", Nodes ").append(node);
		sb.append(", Hosts ").append(host);
		sb.append(", Bandwidths ").append(bandwidth);
		sb.append(", Latencies ").append(latency);
		sb.append(", MacAddressList ").append(macAddressList);
		sb.append(", IpAddressList ").append(ipAddressList);
		return sb.toString();
	}
}



