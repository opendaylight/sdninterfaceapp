package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * grouping bgp-table-type {
 *     leaf afi {
 *         type identityref;
 *     }
 *     leaf safi {
 *         type identityref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/bgp-table-type</i>
 */
public interface BgpTableType
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","bgp-table-type");;

    java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.AddressFamily> getAfi();
    
    java.lang.Class<? extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.SubsequentAddressFamily> getSafi();

}

