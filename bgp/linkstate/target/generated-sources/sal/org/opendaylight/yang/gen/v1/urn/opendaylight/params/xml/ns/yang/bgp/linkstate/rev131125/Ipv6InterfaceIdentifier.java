package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv6Address;
import java.io.Serializable;
import java.beans.ConstructorProperties;


public class Ipv6InterfaceIdentifier extends Ipv6Address
 implements Serializable {
    private static final long serialVersionUID = 3043199137038825348L; 
    
    @ConstructorProperties("value")
    public Ipv6InterfaceIdentifier(java.lang.String _value) {
        super(_value);
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv6InterfaceIdentifier(Ipv6InterfaceIdentifier source) {
        super(source);
    }
    /**
     * Creates a new instance from Ipv6Address
     *
     * @param source Source object
     */
    public Ipv6InterfaceIdentifier(Ipv6Address source) {
            super(source);
    }

    public static Ipv6InterfaceIdentifier getDefaultInstance(String defaultValue) {
        return new Ipv6InterfaceIdentifier(defaultValue);
    }







}
