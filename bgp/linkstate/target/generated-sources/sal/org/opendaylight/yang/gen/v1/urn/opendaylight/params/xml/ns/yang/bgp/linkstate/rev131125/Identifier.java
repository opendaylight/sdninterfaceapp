package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import com.google.common.collect.Range;
import java.io.Serializable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.beans.ConstructorProperties;


public class Identifier
 implements Serializable {
    private static final long serialVersionUID = -8921356948766432307L; 
    private static final List<Range<BigInteger>> _range;
    final private BigInteger _value;
    
    static {
        ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
        builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
        _range = builder.build();
    }
    
    @ConstructorProperties("value")
    public Identifier(BigInteger _value) {
        if (_value != null) {
            BigInteger _constraint = _value;
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
        this._value = _value;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public Identifier(Identifier source) {
        this._value = source._value;
    }

    public static Identifier getDefaultInstance(String defaultValue) {
        return new Identifier(new BigInteger(defaultValue));
    }

    public BigInteger getValue() {
        return _value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_value == null) ? 0 : _value.hashCode());
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Identifier other = (Identifier) obj;
        if (_value == null) {
            if (other._value != null) {
                return false;
            }
        } else if(!_value.equals(other._value)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Identifier.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_value != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_value=");
            builder.append(_value);
         }
        return builder.append(']').toString();
    }


    public static List<Range<BigInteger>> range() {
        return _range;
    }

}
