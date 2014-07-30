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
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)link-state/link-state/unreserved-bandwidth]
 */
public class UnreservedBandwidthBuilder {

    private UnreservedBandwidthKey _key;
    private java.lang.Short _priority;
    private static List<Range<BigInteger>> _priority_range;
    private Bandwidth _bandwidth;

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

    public UnreservedBandwidthKey getKey() {
        return _key;
    }
    
    public java.lang.Short getPriority() {
        return _priority;
    }
    
    public Bandwidth getBandwidth() {
        return _bandwidth;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
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
    
    public UnreservedBandwidthBuilder setBandwidth(Bandwidth value) {
        this._bandwidth = value;
        return this;
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

        private final UnreservedBandwidthKey _key;
        private final java.lang.Short _priority;
        private final Bandwidth _bandwidth;

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
        public UnreservedBandwidthKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.Short getPriority() {
            return _priority;
        }
        
        @Override
        public Bandwidth getBandwidth() {
            return _bandwidth;
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
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_priority == null) ? 0 : _priority.hashCode());
            result = prime * result + ((_bandwidth == null) ? 0 : _bandwidth.hashCode());
            result = prime * result + ((augmentation == null) ? 0 : augmentation.hashCode());
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
            UnreservedBandwidthImpl other = (UnreservedBandwidthImpl) obj;
            if (_key == null) {
                if (other._key != null) {
                    return false;
                }
            } else if(!_key.equals(other._key)) {
                return false;
            }
            if (_priority == null) {
                if (other._priority != null) {
                    return false;
                }
            } else if(!_priority.equals(other._priority)) {
                return false;
            }
            if (_bandwidth == null) {
                if (other._bandwidth != null) {
                    return false;
                }
            } else if(!_bandwidth.equals(other._bandwidth)) {
                return false;
            }
            if (augmentation == null) {
                if (other.augmentation != null) {
                    return false;
                }
            } else if(!augmentation.equals(other.augmentation)) {
                return false;
            }
            return true;
        }
        
        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("UnreservedBandwidth [");
            boolean first = true;
        
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
            if (_bandwidth != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bandwidth=");
                builder.append(_bandwidth);
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
