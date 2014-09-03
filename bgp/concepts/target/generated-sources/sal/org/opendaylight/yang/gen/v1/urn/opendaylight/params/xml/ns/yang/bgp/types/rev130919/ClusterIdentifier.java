package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import java.io.Serializable;
import java.beans.ConstructorProperties;


public class ClusterIdentifier extends Ipv4Address
 implements Serializable {
    private static final long serialVersionUID = 4161512760326341973L; 
    
    @ConstructorProperties("value")
    public ClusterIdentifier(java.lang.String _value) {
        super(_value);
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public ClusterIdentifier(ClusterIdentifier source) {
        super(source);
    }
    /**
     * Creates a new instance from Ipv4Address
     *
     * @param source Source object
     */
    public ClusterIdentifier(Ipv4Address source) {
            super(source);
    }

    public static ClusterIdentifier getDefaultInstance(String defaultValue) {
        return new ClusterIdentifier(defaultValue);
    }







}
