package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidthKey;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Bandwidth;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth
 */
public class UnreservedBandwidthBuilder {

    private Bandwidth _bandwidth;
    private UnreservedBandwidthKey _key;
    private java.lang.Short _priority;
    private static List<Range<BigInteger>> _priority_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> augmentation = new HashMap<>();

    public UnreservedBandwidthBuilder() {
    } 
    
    public UnreservedBandwidthBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth arg) {
        this._priority = arg.getPriority();
        this._bandwidth = arg.getBandwidth();
    }

    public UnreservedBandwidthBuilder(UnreservedBandwidth base) {
        if (base.getKey() == null) {
            this._key = new UnreservedBandwidthKey(
                base.getPriority()
            );
            this._priority = base.getPriority();
        } else {
            this._key = base.getKey();
            this._priority = _key.getPriority();
        }
        this._bandwidth = base.getBandwidth();
        if (base instanceof UnreservedBandwidthImpl) {
            UnreservedBandwidthImpl _impl = (UnreservedBandwidthImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth) {
            this._priority = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth)arg).getPriority();
            this._bandwidth = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth)arg).getBandwidth();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.UnreservedBandwidth] \n" +
              "but was: " + arg
            );
        }
    }

    public Bandwidth getBandwidth() {
        return _bandwidth;
    }
    
    public UnreservedBandwidthKey getKey() {
        return _key;
    }
    
    public java.lang.Short getPriority() {
        return _priority;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public UnreservedBandwidthBuilder setBandwidth(Bandwidth value) {
        this._bandwidth = value;
        return this;
    }
    
    public UnreservedBandwidthBuilder setKey(UnreservedBandwidthKey value) {
        this._key = value;
        return this;
    }
    
    public UnreservedBandwidthBuilder setPriority(java.lang.Short value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _priority_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _priority_range));
            }
        }
        this._priority = value;
        return this;
    }
    public static List<Range<BigInteger>> _priority_range() {
        if (_priority_range == null) {
            synchronized (UnreservedBandwidthBuilder.class) {
                if (_priority_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(7L)));
                    _priority_range = builder.build();
                }
            }
        }
        return _priority_range;
    }
    
    public UnreservedBandwidthBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public UnreservedBandwidth build() {
        return new UnreservedBandwidthImpl(this);
    }

    private static final class UnreservedBandwidthImpl implements UnreservedBandwidth {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth.class;
        }

        private final Bandwidth _bandwidth;
        private final UnreservedBandwidthKey _key;
        private final java.lang.Short _priority;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> augmentation = new HashMap<>();

        private UnreservedBandwidthImpl(UnreservedBandwidthBuilder base) {
            if (base.getKey() == null) {
                this._key = new UnreservedBandwidthKey(
                    base.getPriority()
                );
                this._priority = base.getPriority();
            } else {
                this._key = base.getKey();
                this._priority = _key.getPriority();
            }
            this._bandwidth = base.getBandwidth();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public Bandwidth getBandwidth() {
            return _bandwidth;
        }
        
        @Override
        public UnreservedBandwidthKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.Short getPriority() {
            return _priority;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_bandwidth == null) ? 0 : _bandwidth.hashCode());
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_priority == null) ? 0 : _priority.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth)obj;
            if (_bandwidth == null) {
                if (other.getBandwidth() != null) {
                    return false;
                }
            } else if(!_bandwidth.equals(other.getBandwidth())) {
                return false;
            }
            if (_key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if(!_key.equals(other.getKey())) {
                return false;
            }
            if (_priority == null) {
                if (other.getPriority() != null) {
                    return false;
                }
            } else if(!_priority.equals(other.getPriority())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                UnreservedBandwidthImpl otherImpl = (UnreservedBandwidthImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("UnreservedBandwidth [");
            boolean first = true;
        
            if (_bandwidth != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bandwidth=");
                builder.append(_bandwidth);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_priority != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_priority=");
                builder.append(_priority);
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
