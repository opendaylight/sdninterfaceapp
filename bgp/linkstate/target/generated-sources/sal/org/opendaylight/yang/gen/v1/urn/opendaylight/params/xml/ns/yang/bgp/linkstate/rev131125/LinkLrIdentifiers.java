package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc5307">http://tools.ietf.org/html/rfc5307</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)link-lr-identifiers/link-lr-identifiers]
 */
public interface LinkLrIdentifiers
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-lr-identifiers");;

    java.lang.Long getLinkLocalIdentifier();
    
    java.lang.Long getLinkRemoteIdentifier();

}

