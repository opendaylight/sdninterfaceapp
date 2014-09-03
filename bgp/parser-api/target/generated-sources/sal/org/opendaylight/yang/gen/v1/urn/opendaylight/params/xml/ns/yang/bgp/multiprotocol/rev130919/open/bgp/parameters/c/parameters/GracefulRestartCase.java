package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.bgp.parameters.CParameters;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-multiprotocol</b>
 * <br />(Source path: <i>META-INF/yang/bgp-multiprotocol.yang</i>):
 * <pre>
 * case graceful-restart-case {
 *     container graceful-restart-capability {
 *         leaf restart-flags {
 *             type bits;
 *         }
 *         leaf restart-time {
 *             type uint16;
 *         }
 *         list tables {
 *             key "afi" 
 *         "safi"
 *             leaf afi {
 *                 type identityref;
 *             }
 *             leaf safi {
 *                 type identityref;
 *             }
 *             leaf afi-flags {
 *                 type bits;
 *             }
 *             uses bgp-table-type;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-multiprotocol/open/bgp-parameters/c-parameters/(urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol?revision=2013-09-19)graceful-restart-case</i>
 */
public interface GracefulRestartCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.GracefulRestartCase>,
    CParameters
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-multiprotocol","2013-09-19","graceful-restart-case");;

    GracefulRestartCapability getGracefulRestartCapability();

}

