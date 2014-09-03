package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.AsNumber;
import java.io.Serializable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.beans.ConstructorProperties;


public class ShortAsNumber extends AsNumber
 implements Serializable {
    private static final long serialVersionUID = 437747738154437592L; 
    private static final List<Range<BigInteger>> _range;
    
    static {
        ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
        builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
        _range = builder.build();
    }
    
    @ConstructorProperties("value")
    public ShortAsNumber(java.lang.Long _value) {
        super(_value);
        if (_value != null) {
            BigInteger _constraint = BigInteger.valueOf(_value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", _value, range()));
            }
        }
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public ShortAsNumber(ShortAsNumber source) {
        super(source);
    }
    /**
     * Creates a new instance from AsNumber
     *
     * @param source Source object
     */
    public ShortAsNumber(AsNumber source) {
            super(source);
    }

    public static ShortAsNumber getDefaultInstance(String defaultValue) {
        return new ShortAsNumber(Long.valueOf(defaultValue));
    }






    public static List<Range<BigInteger>> range() {
        return _range;
    }

}
