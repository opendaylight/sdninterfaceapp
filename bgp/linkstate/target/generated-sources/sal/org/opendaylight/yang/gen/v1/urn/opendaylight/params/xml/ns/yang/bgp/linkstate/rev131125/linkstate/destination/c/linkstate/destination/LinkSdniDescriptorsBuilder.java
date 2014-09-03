package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.math.BigInteger;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors
 */
public class LinkSdniDescriptorsBuilder {

    private java.lang.String _sdniIdentifier;
    private BigInteger _sdniParameter;
    private static List<Range<BigInteger>> _sdniParameter_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> augmentation = new HashMap<>();

    public LinkSdniDescriptorsBuilder() {
    } 
    
    public LinkSdniDescriptorsBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers arg) {
        this._sdniIdentifier = arg.getSdniIdentifier();
        this._sdniParameter = arg.getSdniParameter();
    }

    public LinkSdniDescriptorsBuilder(LinkSdniDescriptors base) {
        this._sdniIdentifier = base.getSdniIdentifier();
        this._sdniParameter = base.getSdniParameter();
        if (base instanceof LinkSdniDescriptorsImpl) {
            LinkSdniDescriptorsImpl _impl = (LinkSdniDescriptorsImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers) {
            this._sdniIdentifier = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers)arg).getSdniIdentifier();
            this._sdniParameter = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers)arg).getSdniParameter();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkSdniIdentifiers] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getSdniIdentifier() {
        return _sdniIdentifier;
    }
    
    public BigInteger getSdniParameter() {
        return _sdniParameter;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public LinkSdniDescriptorsBuilder setSdniIdentifier(java.lang.String value) {
        this._sdniIdentifier = value;
        return this;
    }
    
    public LinkSdniDescriptorsBuilder setSdniParameter(BigInteger value) {
        if (value != null) {
            BigInteger _constraint = value;
            boolean isValidRange = false;
            for (Range<BigInteger> r : _sdniParameter_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _sdniParameter_range));
            }
        }
        this._sdniParameter = value;
        return this;
    }
    public static List<Range<BigInteger>> _sdniParameter_range() {
        if (_sdniParameter_range == null) {
            synchronized (LinkSdniDescriptorsBuilder.class) {
                if (_sdniParameter_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
                    _sdniParameter_range = builder.build();
                }
            }
        }
        return _sdniParameter_range;
    }
    
    public LinkSdniDescriptorsBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public LinkSdniDescriptors build() {
        return new LinkSdniDescriptorsImpl(this);
    }

    private static final class LinkSdniDescriptorsImpl implements LinkSdniDescriptors {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors.class;
        }

        private final java.lang.String _sdniIdentifier;
        private final BigInteger _sdniParameter;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> augmentation = new HashMap<>();

        private LinkSdniDescriptorsImpl(LinkSdniDescriptorsBuilder base) {
            this._sdniIdentifier = base.getSdniIdentifier();
            this._sdniParameter = base.getSdniParameter();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public java.lang.String getSdniIdentifier() {
            return _sdniIdentifier;
        }
        
        @Override
        public BigInteger getSdniParameter() {
            return _sdniParameter;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_sdniIdentifier == null) ? 0 : _sdniIdentifier.hashCode());
            result = prime * result + ((_sdniParameter == null) ? 0 : _sdniParameter.hashCode());
            result = prime * result + ((augmentation == null) ? 0 : augmentation.hashCode());
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors)obj;
            if (_sdniIdentifier == null) {
                if (other.getSdniIdentifier() != null) {
                    return false;
                }
            } else if(!_sdniIdentifier.equals(other.getSdniIdentifier())) {
                return false;
            }
            if (_sdniParameter == null) {
                if (other.getSdniParameter() != null) {
                    return false;
                }
            } else if(!_sdniParameter.equals(other.getSdniParameter())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                LinkSdniDescriptorsImpl otherImpl = (LinkSdniDescriptorsImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("LinkSdniDescriptors [");
            boolean first = true;
        
            if (_sdniIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sdniIdentifier=");
                builder.append(_sdniIdentifier);
             }
            if (_sdniParameter != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sdniParameter=");
                builder.append(_sdniParameter);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
