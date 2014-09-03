// <auto-generated>
// 
//
// Generated by <a href="http://enunciate.codehaus.org">Enunciate</a>.
// </auto-generated>
using System;

namespace Org.Opendaylight.Controller.Sdniaggregator {

  /// <remarks>
  ///  
  /// </remarks>
  /// <summary>
  ///  
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="networkCapabilities")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="networkCapabilities")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="networkCapabilities")]
  public partial class NetworkCapabilities {

    private System.Collections.Generic.List<string> _link;
    private System.Collections.Generic.List<string> _macAddressList;
    private System.Collections.Generic.List<string> _controller;
    private System.Collections.Generic.List<string> _node;
    private System.Collections.Generic.List<string> _bandwidth;
    private System.Collections.Generic.List<string> _host;
    private System.Collections.Generic.List<string> _ipAddressList;
    private System.Collections.Generic.List<string> _latency;
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="link",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="link")]
    public System.Collections.Generic.List<string> Link {
      get {
        return this._link;
      }
      set {
        this._link = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="macAddressList",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="macAddressList")]
    public System.Collections.Generic.List<string> MacAddressList {
      get {
        return this._macAddressList;
      }
      set {
        this._macAddressList = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="controller",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="controller")]
    public System.Collections.Generic.List<string> Controller {
      get {
        return this._controller;
      }
      set {
        this._controller = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="node",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="node")]
    public System.Collections.Generic.List<string> Node {
      get {
        return this._node;
      }
      set {
        this._node = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="bandwidth",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="bandwidth")]
    public System.Collections.Generic.List<string> Bandwidth {
      get {
        return this._bandwidth;
      }
      set {
        this._bandwidth = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="host",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="host")]
    public System.Collections.Generic.List<string> Host {
      get {
        return this._host;
      }
      set {
        this._host = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="ipAddressList",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="ipAddressList")]
    public System.Collections.Generic.List<string> IpAddressList {
      get {
        return this._ipAddressList;
      }
      set {
        this._ipAddressList = value;
      }
    }
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="latency",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="latency")]
    public System.Collections.Generic.List<string> Latency {
      get {
        return this._latency;
      }
      set {
        this._latency = value;
      }
    }
  }
}  
