package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.IgpMetric;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.prefix.state.IgpBits;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.ExtendedRouteTag;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.RouteTag;
import java.util.List;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping prefix-state {
 *     container igp-bits {
 *         leaf up-down {
 *             type bits;
 *         }
 *         uses igp-bits;
 *     }
 *     leaf-list route-tags {
 *         type route-tag;
 *     }
 *     leaf-list extended-tags {
 *         type extended-route-tag;
 *     }
 *     leaf prefix-metric {
 *         type igp-metric;
 *     }
 *     leaf ospf-forwarding-address {
 *         type ip-address;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/prefix-state</i>
 */
public interface PrefixState
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","prefix-state");;

    IgpBits getIgpBits();
    
    List<RouteTag> getRouteTags();
    
    List<ExtendedRouteTag> getExtendedTags();
    
    IgpMetric getPrefixMetric();
    
    IpAddress getOspfForwardingAddress();

}

