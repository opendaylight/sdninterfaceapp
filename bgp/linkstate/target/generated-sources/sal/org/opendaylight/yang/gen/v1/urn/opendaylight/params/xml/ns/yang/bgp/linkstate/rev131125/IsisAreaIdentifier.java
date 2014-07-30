package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import com.google.common.collect.Range;
import com.google.common.io.BaseEncoding;
import java.io.Serializable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.beans.ConstructorProperties;
import java.util.Arrays;


/**
 * Reference:
 *     https://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.3.1.2
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)isis-area-identifier/isis-area-identifier]
 */
public class IsisAreaIdentifier
 implements Serializable {
    private static final long serialVersionUID = -8523949719040349428L; 
    private static List<Range<BigInteger>> _length;
    final private byte[] _value;

    @ConstructorProperties("value")
    public IsisAreaIdentifier(byte[] _value) {
        if (_value != null) {
            BigInteger _constraint = BigInteger.valueOf(_value.length);
            boolean isValidLength = false;
            for (Range<BigInteger> r : length()) {
                if (r.contains(_constraint)) {
                    isValidLength = true;
                }
            }
            if (!isValidLength) {
                throw new IllegalArgumentException(String.format("Invalid length: %s, expected: %s.", _value, length()));
            }
        }
        this._value = _value;
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public IsisAreaIdentifier(IsisAreaIdentifier source) {
        this._value = source._value;
    }
    
    public static IsisAreaIdentifier getDefaultInstance(String defaultValue) {
        BaseEncoding baseEncoding = BaseEncoding.base64(); 
        return new IsisAreaIdentifier(baseEncoding.decode(defaultValue));
    }

    public byte[] getValue() {
        return _value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_value == null) ? 0 : Arrays.hashCode(_value));
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
        IsisAreaIdentifier other = (IsisAreaIdentifier) obj;
        if (_value == null) {
            if (other._value != null) {
                return false;
            }
        } else if(!Arrays.equals(_value, other._value)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder("IsisAreaIdentifier [");
        boolean first = true;
    
        if (_value != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_value=");
            builder.append(Arrays.toString(_value));
         }
        return builder.append(']').toString();
    }

    public static List<Range<BigInteger>> length() {
        if (_length == null) {
            synchronized (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IsisAreaIdentifier.class) {
                if (_length == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ONE, BigInteger.valueOf(20L)));
                    _length = builder.build();
                }
            }
        }
        return _length;
    }


}
