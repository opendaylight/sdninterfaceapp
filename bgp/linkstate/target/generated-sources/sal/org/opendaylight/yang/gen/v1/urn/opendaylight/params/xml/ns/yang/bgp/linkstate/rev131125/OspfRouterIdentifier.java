package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * Reference:
 *     https://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.2.1.4
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)ospf-router-identifier/ospf-router-identifier]
 */
public interface OspfRouterIdentifier
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","ospf-router-identifier");;

    java.lang.Long getOspfRouterId();

}

