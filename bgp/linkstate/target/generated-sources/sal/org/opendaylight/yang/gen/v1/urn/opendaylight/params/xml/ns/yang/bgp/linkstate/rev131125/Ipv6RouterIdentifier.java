package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv6Address;
import java.io.Serializable;
import java.beans.ConstructorProperties;


public class Ipv6RouterIdentifier extends Ipv6Address
 implements Serializable {
    private static final long serialVersionUID = -7137485050626839766L; 
    
    @ConstructorProperties("value")
    public Ipv6RouterIdentifier(java.lang.String _value) {
        super(_value);
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv6RouterIdentifier(Ipv6RouterIdentifier source) {
        super(source);
    }
    /**
     * Creates a new instance from Ipv6Address
     *
     * @param source Source object
     */
    public Ipv6RouterIdentifier(Ipv6Address source) {
            super(source);
    }

    public static Ipv6RouterIdentifier getDefaultInstance(String defaultValue) {
        return new Ipv6RouterIdentifier(defaultValue);
    }







}
