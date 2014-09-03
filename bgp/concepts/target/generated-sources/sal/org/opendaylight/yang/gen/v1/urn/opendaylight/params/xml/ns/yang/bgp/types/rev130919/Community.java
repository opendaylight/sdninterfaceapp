package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.AsNumber;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;


/**
 * Community Path Attribute
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-types</b>
 * <br />(Source path: <i>META-INF/yang/bgp-types.yang</i>):
 * <pre>
 * grouping community {
 *     leaf as-number {
 *         type as-number;
 *     }
 *     leaf semantics {
 *         type uint16;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-types/community</i>
 */
public interface Community
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-types","2013-09-19","community");;

    AsNumber getAsNumber();
    
    java.lang.Integer getSemantics();

}

