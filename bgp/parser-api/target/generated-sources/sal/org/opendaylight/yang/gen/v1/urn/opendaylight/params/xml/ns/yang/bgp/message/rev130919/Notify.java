package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;


/**
 * Notification Message
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * notification notify {
 *     description
 *         "Notification Message";
 *     leaf error-code {
 *         type uint8;
 *     }
 *     leaf error-subcode {
 *         type uint8;
 *     }
 *     leaf data {
 *         type binary;
 *     }
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.5";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/notify</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.NotifyBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.NotifyBuilder
 */
public interface Notify
    extends
    ChildOf<DataObject>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Notify>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","notify");;

    java.lang.Short getErrorCode();
    
    java.lang.Short getErrorSubcode();
    
    byte[] getData();

}

