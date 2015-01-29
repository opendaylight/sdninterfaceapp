/**
 * 
 *
 * Generated by <a href="http://enunciate.codehaus.org">Enunciate</a>.
 */
package org.opendaylight.controller.sdniaggregator;

/**
 * (no documentation provided)
 */
@javax.xml.bind.annotation.XmlType (
  name = "networkCapabilities",
  namespace = ""
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "networkCapabilities",
  namespace = ""
)
public class NetworkCapabilities implements java.io.Serializable {

  private java.util.List<java.lang.String> _latency;
  private java.util.List<java.lang.String> _link;
  private java.util.List<java.lang.String> _ipAddressList;
  private java.util.List<java.lang.String> _macAddressList;
  private java.util.List<java.lang.String> _host;
  private java.util.List<java.lang.String> _node;
  private java.util.List<java.lang.String> _bandwidth;
  private java.util.List<java.lang.String> _controller;

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "latency",
    namespace = ""
  )
  public java.util.List<java.lang.String> getLatency() {
    return this._latency;
  }

  /**
   * (no documentation provided)
   */
  public void setLatency(java.util.List<java.lang.String> _latency) {
    this._latency = _latency;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "link",
    namespace = ""
  )
  public java.util.List<java.lang.String> getLink() {
    return this._link;
  }

  /**
   * (no documentation provided)
   */
  public void setLink(java.util.List<java.lang.String> _link) {
    this._link = _link;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "ipAddressList",
    namespace = ""
  )
  public java.util.List<java.lang.String> getIpAddressList() {
    return this._ipAddressList;
  }

  /**
   * (no documentation provided)
   */
  public void setIpAddressList(java.util.List<java.lang.String> _ipAddressList) {
    this._ipAddressList = _ipAddressList;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "macAddressList",
    namespace = ""
  )
  public java.util.List<java.lang.String> getMacAddressList() {
    return this._macAddressList;
  }

  /**
   * (no documentation provided)
   */
  public void setMacAddressList(java.util.List<java.lang.String> _macAddressList) {
    this._macAddressList = _macAddressList;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "host",
    namespace = ""
  )
  public java.util.List<java.lang.String> getHost() {
    return this._host;
  }

  /**
   * (no documentation provided)
   */
  public void setHost(java.util.List<java.lang.String> _host) {
    this._host = _host;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "node",
    namespace = ""
  )
  public java.util.List<java.lang.String> getNode() {
    return this._node;
  }

  /**
   * (no documentation provided)
   */
  public void setNode(java.util.List<java.lang.String> _node) {
    this._node = _node;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "bandwidth",
    namespace = ""
  )
  public java.util.List<java.lang.String> getBandwidth() {
    return this._bandwidth;
  }

  /**
   * (no documentation provided)
   */
  public void setBandwidth(java.util.List<java.lang.String> _bandwidth) {
    this._bandwidth = _bandwidth;
  }

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "controller",
    namespace = ""
  )
  public java.util.List<java.lang.String> getController() {
    return this._controller;
  }

  /**
   * (no documentation provided)
   */
  public void setController(java.util.List<java.lang.String> _controller) {
    this._controller = _controller;
  }

}
