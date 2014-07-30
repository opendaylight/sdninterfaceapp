package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import com.google.common.collect.Range;
import java.io.Serializable;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import java.beans.ConstructorProperties;


/**
 * Reference:
 *     https://tools.ietf.org/html/draft-ietf-idr-ls-distribution-03#section-3.2.1.5
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)topology-identifier/topology-identifier]
 */
public class TopologyIdentifier
 implements Serializable {
    private static final long serialVersionUID = -6374364979721281800L; 
    private static List<Range<BigInteger>> _range;
    final private java.lang.Integer _value;

    @ConstructorProperties("value")
    public TopologyIdentifier(java.lang.Integer _value) {
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
        this._value = _value;
    }
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public TopologyIdentifier(TopologyIdentifier source) {
        this._value = source._value;
    }
    
    public static TopologyIdentifier getDefaultInstance(String defaultValue) {
        return new TopologyIdentifier(new java.lang.Integer(defaultValue));
    }

    public java.lang.Integer getValue() {
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
        TopologyIdentifier other = (TopologyIdentifier) obj;
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
        java.lang.StringBuilder builder = new java.lang.StringBuilder("TopologyIdentifier [");
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
        if (_range == null) {
            synchronized (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier.class) {
                if (_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4095L)));
                    _range = builder.build();
                }
            }
        }
        return _range;
    }

}
