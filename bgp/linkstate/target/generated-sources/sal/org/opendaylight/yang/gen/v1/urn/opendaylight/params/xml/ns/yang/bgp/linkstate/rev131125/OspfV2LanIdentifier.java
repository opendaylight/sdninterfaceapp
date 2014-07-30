package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4InterfaceIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier;


/**
 * Reference:
 *     https://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.2.1.4
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)ospf-v2-lan-identifier/ospf-v2-lan-identifier]
 */
public interface OspfV2LanIdentifier
    extends
    DataObject,
    OspfRouterIdentifier
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","ospf-v2-lan-identifier");;

    Ipv4InterfaceIdentifier getIpv4Address();

}

