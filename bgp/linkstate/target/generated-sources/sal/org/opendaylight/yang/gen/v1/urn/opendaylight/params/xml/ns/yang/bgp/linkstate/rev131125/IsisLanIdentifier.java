package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.isis.lan.identifier.IsIsRouterIdentifier;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping isis-lan-identifier {
 *     container is-is-router-identifier {
 *         leaf iso-system-id {
 *             type iso-system-identifier;
 *         }
 *         uses isis-router-identifier;
 *     }
 *     leaf psn {
 *         type uint8;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/isis-lan-identifier</i>
 */
public interface IsisLanIdentifier
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","isis-lan-identifier");;

    IsIsRouterIdentifier getIsIsRouterIdentifier();
    
    java.lang.Short getPsn();

}

