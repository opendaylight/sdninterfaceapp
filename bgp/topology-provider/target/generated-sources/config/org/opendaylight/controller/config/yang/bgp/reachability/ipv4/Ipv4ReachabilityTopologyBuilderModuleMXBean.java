/*
* Generated file
*
* Generated from: yang module name: odl-bgp-treachability-ipv4-cfg yang module local name: bgp-reachability-ipv4
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Tue Sep 02 12:41:22 IST 2014
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.controller.config.yang.bgp.reachability.ipv4;
public interface Ipv4ReachabilityTopologyBuilderModuleMXBean {
    public org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId getTopologyId();

    public void setTopologyId(org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId topologyId);

    public javax.management.ObjectName getDataProvider();

    public void setDataProvider(javax.management.ObjectName dataProvider);

    public javax.management.ObjectName getLocalRib();

    public void setLocalRib(javax.management.ObjectName localRib);

}
