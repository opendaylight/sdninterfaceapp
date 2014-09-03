package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;


/**
 * Keepalive Message
 * <p>This class represents the following YANG schema fragment defined in module <b>bgp-message</b>
 * <br />(Source path: <i>META-INF/yang/bgp-message.yang</i>):
 * <pre>
 * notification keepalive {
 *     description
 *         "Keepalive Message";
 *     reference
 *         "http://tools.ietf.org/html/rfc4271#section-4.4";
 *     status CURRENT;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>bgp-message/keepalive</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.KeepaliveBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.KeepaliveBuilder
 */
public interface Keepalive
    extends
    ChildOf<DataObject>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.Keepalive>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-message","2013-09-19","keepalive");;


}

