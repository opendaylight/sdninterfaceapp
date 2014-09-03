package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Notification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.open.BgpParameters;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.ProtocolVersion;


/**
 * Open Message
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * notification open {
 *     description
 *         "Open Message";
 *     leaf version {
 *         type protocol-version;
 *     }
 *     leaf my-as-number {
 *         type uint16;
 *     }
 *     leaf hold-timer {
 *         type uint16;
 *     }
 *     leaf bgp-identifier {
 *         type ipv4-address;
 *     }
 *     list bgp-parameters {
 *         key     choice c-parameters {
 *             case as4-bytes-case {
 *                 container as4-bytes-capability {
 *                     leaf as-number {
 *                         type as-number;
 *                     }
 *                 }
 *             }
 *             case graceful-restart-case {
 *                 container graceful-restart-capability {
 *                     leaf restart-flags {
 *                         type bits;
 *                     }
 *                     leaf restart-time {
 *                         type uint16;
 *                     }
 *                     list tables {
 *                         key "afi" 
 *                     "safi"
 *                         leaf afi {
 *                             type identityref;
 *                         }
 *                         leaf safi {
 *                             type identityref;
 *                         }
 *                         leaf afi-flags {
 *                             type bits;
 *                         }
 *                         uses bgp-table-type;
 *                     }
 *                 }
 *             }
 *             case multiprotocol-case {
 *                 container multiprotocol-capability {
 *                     leaf afi {
 *                         type identityref;
 *                     }
 *                     leaf safi {
 *                         type identityref;
 *                     }
 *                     uses bgp-table-type;
 *                 }
 *             }
 *         }
 *     }
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.2";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/open</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.OpenBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.OpenBuilder
 */
public interface Open
    extends
    ChildOf<DataObject>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Open>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","open");;

    ProtocolVersion getVersion();
    
    java.lang.Integer getMyAsNumber();
    
    java.lang.Integer getHoldTimer();
    
    Ipv4Address getBgpIdentifier();
    
    List<BgpParameters> getBgpParameters();

}

