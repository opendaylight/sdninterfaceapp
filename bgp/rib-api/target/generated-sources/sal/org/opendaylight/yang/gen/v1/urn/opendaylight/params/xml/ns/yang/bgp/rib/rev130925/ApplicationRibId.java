package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import java.io.Serializable;
import java.beans.ConstructorProperties;


public class ApplicationRibId extends Uri
 implements Serializable {
    private static final long serialVersionUID = -7615196843008678199L; 
    
    @ConstructorProperties("value")
    public ApplicationRibId(java.lang.String _value) {
        super(_value);
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public ApplicationRibId(ApplicationRibId source) {
        super(source);
    }
    /**
     * Creates a new instance from Uri
     *
     * @param source Source object
     */
    public ApplicationRibId(Uri source) {
            super(source);
    }

    public static ApplicationRibId getDefaultInstance(String defaultValue) {
        return new ApplicationRibId(defaultValue);
    }







}
