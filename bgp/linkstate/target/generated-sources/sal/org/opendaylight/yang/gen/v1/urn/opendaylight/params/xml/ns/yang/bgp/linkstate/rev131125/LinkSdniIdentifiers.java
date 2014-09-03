package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.math.BigInteger;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-linkstate</b>
 * <br />(Source path: <i>META-INF/yang/bgp-linkstate.yang</i>):
 * <pre>
 * grouping link-sdni-identifiers {
 *     leaf sdni-identifier {
 *         type string;
 *     }
 *     leaf sdni-parameter {
 *         type uint64;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-linkstate/link-sdni-identifiers</i>
 */
public interface LinkSdniIdentifiers
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","link-sdni-identifiers");;

    java.lang.String getSdniIdentifier();
    
    BigInteger getSdniParameter();

}

