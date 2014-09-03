package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.graceful.restart.capability.Tables;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability.RestartFlags;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability
 */
public class GracefulRestartCapabilityBuilder {

    private RestartFlags _restartFlags;
    private java.lang.Integer _restartTime;
    private static List<Range<BigInteger>> _restartTime_range;
    private List<Tables> _tables;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> augmentation = new HashMap<>();

    public GracefulRestartCapabilityBuilder() {
    } 

    public GracefulRestartCapabilityBuilder(GracefulRestartCapability base) {
        this._restartFlags = base.getRestartFlags();
        this._restartTime = base.getRestartTime();
        this._tables = base.getTables();
        if (base instanceof GracefulRestartCapabilityImpl) {
            GracefulRestartCapabilityImpl _impl = (GracefulRestartCapabilityImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public RestartFlags getRestartFlags() {
        return _restartFlags;
    }
    
    public java.lang.Integer getRestartTime() {
        return _restartTime;
    }
    
    public List<Tables> getTables() {
        return _tables;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public GracefulRestartCapabilityBuilder setRestartFlags(RestartFlags value) {
        this._restartFlags = value;
        return this;
    }
    
    public GracefulRestartCapabilityBuilder setRestartTime(java.lang.Integer value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _restartTime_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _restartTime_range));
            }
        }
        this._restartTime = value;
        return this;
    }
    public static List<Range<BigInteger>> _restartTime_range() {
        if (_restartTime_range == null) {
            synchronized (GracefulRestartCapabilityBuilder.class) {
                if (_restartTime_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4095L)));
                    _restartTime_range = builder.build();
                }
            }
        }
        return _restartTime_range;
    }
    
    public GracefulRestartCapabilityBuilder setTables(List<Tables> value) {
        this._tables = value;
        return this;
    }
    
    public GracefulRestartCapabilityBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public GracefulRestartCapability build() {
        return new GracefulRestartCapabilityImpl(this);
    }

    private static final class GracefulRestartCapabilityImpl implements GracefulRestartCapability {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability.class;
        }

        private final RestartFlags _restartFlags;
        private final java.lang.Integer _restartTime;
        private final List<Tables> _tables;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> augmentation = new HashMap<>();

        private GracefulRestartCapabilityImpl(GracefulRestartCapabilityBuilder base) {
            this._restartFlags = base.getRestartFlags();
            this._restartTime = base.getRestartTime();
            this._tables = base.getTables();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public RestartFlags getRestartFlags() {
            return _restartFlags;
        }
        
        @Override
        public java.lang.Integer getRestartTime() {
            return _restartTime;
        }
        
        @Override
        public List<Tables> getTables() {
            return _tables;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_restartFlags == null) ? 0 : _restartFlags.hashCode());
            result = prime * result + ((_restartTime == null) ? 0 : _restartTime.hashCode());
            result = prime * result + ((_tables == null) ? 0 : _tables.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability)obj;
            if (_restartFlags == null) {
                if (other.getRestartFlags() != null) {
                    return false;
                }
            } else if(!_restartFlags.equals(other.getRestartFlags())) {
                return false;
            }
            if (_restartTime == null) {
                if (other.getRestartTime() != null) {
                    return false;
                }
            } else if(!_restartTime.equals(other.getRestartTime())) {
                return false;
            }
            if (_tables == null) {
                if (other.getTables() != null) {
                    return false;
                }
            } else if(!_tables.equals(other.getTables())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                GracefulRestartCapabilityImpl otherImpl = (GracefulRestartCapabilityImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.multiprotocol.rev130919.open.bgp.parameters.c.parameters.graceful.restart._case.GracefulRestartCapability>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("GracefulRestartCapability [");
            boolean first = true;
        
            if (_restartFlags != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_restartFlags=");
                builder.append(_restartFlags);
             }
            if (_restartTime != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_restartTime=");
                builder.append(_restartTime);
             }
            if (_tables != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_tables=");
                builder.append(_tables);
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
