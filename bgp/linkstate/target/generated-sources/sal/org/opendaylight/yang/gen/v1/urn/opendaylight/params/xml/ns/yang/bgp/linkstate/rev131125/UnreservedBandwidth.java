package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Bandwidth;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping unreserved-bandwidth {
 *     leaf priority {
 *         type uint8;
 *     }
 *     leaf bandwidth {
 *         type bandwidth;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/unreserved-bandwidth</i>
 */
public interface UnreservedBandwidth
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","unreserved-bandwidth");;

    java.lang.Short getPriority();
    
    Bandwidth getBandwidth();

}

