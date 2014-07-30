package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import java.io.Serializable;
import java.beans.ConstructorProperties;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc5305#section-3.2">http://tools.ietf.org/html/rfc5305#section-3.2</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)ipv4-interface-identifier/ipv4-interface-identifier]
 */
public class Ipv4InterfaceIdentifier extends Ipv4Address
 implements Serializable {
    private static final long serialVersionUID = -1735179733723961328L; 

    @ConstructorProperties("value")
    public Ipv4InterfaceIdentifier(java.lang.String _value) {
        super(_value);
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv4InterfaceIdentifier(Ipv4InterfaceIdentifier source) {
        super(source);
    }
    /**
     * Creates a new instance from Ipv4Address
     *
     * @param source Source object
     */
    public Ipv4InterfaceIdentifier(Ipv4Address source) {
            super(source);
    }
    
    public static Ipv4InterfaceIdentifier getDefaultInstance(String defaultValue) {
        return new Ipv4InterfaceIdentifier(defaultValue);
    }







}
