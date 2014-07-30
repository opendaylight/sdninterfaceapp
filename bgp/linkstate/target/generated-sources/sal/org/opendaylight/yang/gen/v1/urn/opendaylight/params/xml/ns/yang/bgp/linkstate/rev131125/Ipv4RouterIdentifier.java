package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import java.io.Serializable;
import java.beans.ConstructorProperties;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.1.4">http://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.1.4</a>
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)ipv4-router-identifier/ipv4-router-identifier]
 */
public class Ipv4RouterIdentifier extends Ipv4Address
 implements Serializable {
    private static final long serialVersionUID = -3130689977448007233L; 

    @ConstructorProperties("value")
    public Ipv4RouterIdentifier(java.lang.String _value) {
        super(_value);
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Ipv4RouterIdentifier(Ipv4RouterIdentifier source) {
        super(source);
    }
    /**
     * Creates a new instance from Ipv4Address
     *
     * @param source Source object
     */
    public Ipv4RouterIdentifier(Ipv4Address source) {
            super(source);
    }
    
    public static Ipv4RouterIdentifier getDefaultInstance(String defaultValue) {
        return new Ipv4RouterIdentifier(defaultValue);
    }







}
