package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import java.io.Serializable;
import java.beans.ConstructorProperties;


/**
 * Module name:
 *     bgp-rib
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-rib?revision=2013-09-25)rib-id/rib-id]
 */
public class RibId extends Uri
 implements Serializable {
    private static final long serialVersionUID = -3699577265930177873L; 

    @ConstructorProperties("value")
    public RibId(java.lang.String _value) {
        super(_value);
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public RibId(RibId source) {
        super(source);
    }
    /**
     * Creates a new instance from Uri
     *
     * @param source Source object
     */
    public RibId(Uri source) {
            super(source);
    }
    
    public static RibId getDefaultInstance(String defaultValue) {
        return new RibId(defaultValue);
    }







}
