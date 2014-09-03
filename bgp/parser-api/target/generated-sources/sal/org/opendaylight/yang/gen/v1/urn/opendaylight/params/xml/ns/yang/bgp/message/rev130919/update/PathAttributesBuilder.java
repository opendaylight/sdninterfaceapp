package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.MultiExitDisc;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.LocalPref;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.Aggregator;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.Origin;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ExtendedCommunities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AtomicAggregate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.AsPath;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.Communities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.ClusterId;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.path.attributes.OriginatorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.next.hop.CNextHop;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes
 */
public class PathAttributesBuilder {

    private Aggregator _aggregator;
    private AsPath _asPath;
    private AtomicAggregate _atomicAggregate;
    private CNextHop _cNextHop;
    private ClusterId _clusterId;
    private List<Communities> _communities;
    private List<ExtendedCommunities> _extendedCommunities;
    private LocalPref _localPref;
    private MultiExitDisc _multiExitDisc;
    private Origin _origin;
    private OriginatorId _originatorId;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> augmentation = new HashMap<>();

    public PathAttributesBuilder() {
    } 
    
    public PathAttributesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes arg) {
        this._origin = arg.getOrigin();
        this._asPath = arg.getAsPath();
        this._multiExitDisc = arg.getMultiExitDisc();
        this._localPref = arg.getLocalPref();
        this._atomicAggregate = arg.getAtomicAggregate();
        this._aggregator = arg.getAggregator();
        this._communities = arg.getCommunities();
        this._extendedCommunities = arg.getExtendedCommunities();
        this._originatorId = arg.getOriginatorId();
        this._clusterId = arg.getClusterId();
        this._cNextHop = arg.getCNextHop();
    }
    
    public PathAttributesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop arg) {
        this._cNextHop = arg.getCNextHop();
    }

    public PathAttributesBuilder(PathAttributes base) {
        this._aggregator = base.getAggregator();
        this._asPath = base.getAsPath();
        this._atomicAggregate = base.getAtomicAggregate();
        this._cNextHop = base.getCNextHop();
        this._clusterId = base.getClusterId();
        this._communities = base.getCommunities();
        this._extendedCommunities = base.getExtendedCommunities();
        this._localPref = base.getLocalPref();
        this._multiExitDisc = base.getMultiExitDisc();
        this._origin = base.getOrigin();
        this._originatorId = base.getOriginatorId();
        if (base instanceof PathAttributesImpl) {
            PathAttributesImpl _impl = (PathAttributesImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes</li>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes) {
            this._origin = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getOrigin();
            this._asPath = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getAsPath();
            this._multiExitDisc = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getMultiExitDisc();
            this._localPref = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getLocalPref();
            this._atomicAggregate = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getAtomicAggregate();
            this._aggregator = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getAggregator();
            this._communities = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getCommunities();
            this._extendedCommunities = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getExtendedCommunities();
            this._originatorId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getOriginatorId();
            this._clusterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes)arg).getClusterId();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop) {
            this._cNextHop = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop)arg).getCNextHop();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.PathAttributes, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.NextHop] \n" +
              "but was: " + arg
            );
        }
    }

    public Aggregator getAggregator() {
        return _aggregator;
    }
    
    public AsPath getAsPath() {
        return _asPath;
    }
    
    public AtomicAggregate getAtomicAggregate() {
        return _atomicAggregate;
    }
    
    public CNextHop getCNextHop() {
        return _cNextHop;
    }
    
    public ClusterId getClusterId() {
        return _clusterId;
    }
    
    public List<Communities> getCommunities() {
        return _communities;
    }
    
    public List<ExtendedCommunities> getExtendedCommunities() {
        return _extendedCommunities;
    }
    
    public LocalPref getLocalPref() {
        return _localPref;
    }
    
    public MultiExitDisc getMultiExitDisc() {
        return _multiExitDisc;
    }
    
    public Origin getOrigin() {
        return _origin;
    }
    
    public OriginatorId getOriginatorId() {
        return _originatorId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PathAttributesBuilder setAggregator(Aggregator value) {
        this._aggregator = value;
        return this;
    }
    
    public PathAttributesBuilder setAsPath(AsPath value) {
        this._asPath = value;
        return this;
    }
    
    public PathAttributesBuilder setAtomicAggregate(AtomicAggregate value) {
        this._atomicAggregate = value;
        return this;
    }
    
    public PathAttributesBuilder setCNextHop(CNextHop value) {
        this._cNextHop = value;
        return this;
    }
    
    public PathAttributesBuilder setClusterId(ClusterId value) {
        this._clusterId = value;
        return this;
    }
    
    public PathAttributesBuilder setCommunities(List<Communities> value) {
        this._communities = value;
        return this;
    }
    
    public PathAttributesBuilder setExtendedCommunities(List<ExtendedCommunities> value) {
        this._extendedCommunities = value;
        return this;
    }
    
    public PathAttributesBuilder setLocalPref(LocalPref value) {
        this._localPref = value;
        return this;
    }
    
    public PathAttributesBuilder setMultiExitDisc(MultiExitDisc value) {
        this._multiExitDisc = value;
        return this;
    }
    
    public PathAttributesBuilder setOrigin(Origin value) {
        this._origin = value;
        return this;
    }
    
    public PathAttributesBuilder setOriginatorId(OriginatorId value) {
        this._originatorId = value;
        return this;
    }
    
    public PathAttributesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public PathAttributes build() {
        return new PathAttributesImpl(this);
    }

    private static final class PathAttributesImpl implements PathAttributes {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes.class;
        }

        private final Aggregator _aggregator;
        private final AsPath _asPath;
        private final AtomicAggregate _atomicAggregate;
        private final CNextHop _cNextHop;
        private final ClusterId _clusterId;
        private final List<Communities> _communities;
        private final List<ExtendedCommunities> _extendedCommunities;
        private final LocalPref _localPref;
        private final MultiExitDisc _multiExitDisc;
        private final Origin _origin;
        private final OriginatorId _originatorId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> augmentation = new HashMap<>();

        private PathAttributesImpl(PathAttributesBuilder base) {
            this._aggregator = base.getAggregator();
            this._asPath = base.getAsPath();
            this._atomicAggregate = base.getAtomicAggregate();
            this._cNextHop = base.getCNextHop();
            this._clusterId = base.getClusterId();
            this._communities = base.getCommunities();
            this._extendedCommunities = base.getExtendedCommunities();
            this._localPref = base.getLocalPref();
            this._multiExitDisc = base.getMultiExitDisc();
            this._origin = base.getOrigin();
            this._originatorId = base.getOriginatorId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public Aggregator getAggregator() {
            return _aggregator;
        }
        
        @Override
        public AsPath getAsPath() {
            return _asPath;
        }
        
        @Override
        public AtomicAggregate getAtomicAggregate() {
            return _atomicAggregate;
        }
        
        @Override
        public CNextHop getCNextHop() {
            return _cNextHop;
        }
        
        @Override
        public ClusterId getClusterId() {
            return _clusterId;
        }
        
        @Override
        public List<Communities> getCommunities() {
            return _communities;
        }
        
        @Override
        public List<ExtendedCommunities> getExtendedCommunities() {
            return _extendedCommunities;
        }
        
        @Override
        public LocalPref getLocalPref() {
            return _localPref;
        }
        
        @Override
        public MultiExitDisc getMultiExitDisc() {
            return _multiExitDisc;
        }
        
        @Override
        public Origin getOrigin() {
            return _origin;
        }
        
        @Override
        public OriginatorId getOriginatorId() {
            return _originatorId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_aggregator == null) ? 0 : _aggregator.hashCode());
            result = prime * result + ((_asPath == null) ? 0 : _asPath.hashCode());
            result = prime * result + ((_atomicAggregate == null) ? 0 : _atomicAggregate.hashCode());
            result = prime * result + ((_cNextHop == null) ? 0 : _cNextHop.hashCode());
            result = prime * result + ((_clusterId == null) ? 0 : _clusterId.hashCode());
            result = prime * result + ((_communities == null) ? 0 : _communities.hashCode());
            result = prime * result + ((_extendedCommunities == null) ? 0 : _extendedCommunities.hashCode());
            result = prime * result + ((_localPref == null) ? 0 : _localPref.hashCode());
            result = prime * result + ((_multiExitDisc == null) ? 0 : _multiExitDisc.hashCode());
            result = prime * result + ((_origin == null) ? 0 : _origin.hashCode());
            result = prime * result + ((_originatorId == null) ? 0 : _originatorId.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes)obj;
            if (_aggregator == null) {
                if (other.getAggregator() != null) {
                    return false;
                }
            } else if(!_aggregator.equals(other.getAggregator())) {
                return false;
            }
            if (_asPath == null) {
                if (other.getAsPath() != null) {
                    return false;
                }
            } else if(!_asPath.equals(other.getAsPath())) {
                return false;
            }
            if (_atomicAggregate == null) {
                if (other.getAtomicAggregate() != null) {
                    return false;
                }
            } else if(!_atomicAggregate.equals(other.getAtomicAggregate())) {
                return false;
            }
            if (_cNextHop == null) {
                if (other.getCNextHop() != null) {
                    return false;
                }
            } else if(!_cNextHop.equals(other.getCNextHop())) {
                return false;
            }
            if (_clusterId == null) {
                if (other.getClusterId() != null) {
                    return false;
                }
            } else if(!_clusterId.equals(other.getClusterId())) {
                return false;
            }
            if (_communities == null) {
                if (other.getCommunities() != null) {
                    return false;
                }
            } else if(!_communities.equals(other.getCommunities())) {
                return false;
            }
            if (_extendedCommunities == null) {
                if (other.getExtendedCommunities() != null) {
                    return false;
                }
            } else if(!_extendedCommunities.equals(other.getExtendedCommunities())) {
                return false;
            }
            if (_localPref == null) {
                if (other.getLocalPref() != null) {
                    return false;
                }
            } else if(!_localPref.equals(other.getLocalPref())) {
                return false;
            }
            if (_multiExitDisc == null) {
                if (other.getMultiExitDisc() != null) {
                    return false;
                }
            } else if(!_multiExitDisc.equals(other.getMultiExitDisc())) {
                return false;
            }
            if (_origin == null) {
                if (other.getOrigin() != null) {
                    return false;
                }
            } else if(!_origin.equals(other.getOrigin())) {
                return false;
            }
            if (_originatorId == null) {
                if (other.getOriginatorId() != null) {
                    return false;
                }
            } else if(!_originatorId.equals(other.getOriginatorId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                PathAttributesImpl otherImpl = (PathAttributesImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PathAttributes [");
            boolean first = true;
        
            if (_aggregator != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_aggregator=");
                builder.append(_aggregator);
             }
            if (_asPath != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_asPath=");
                builder.append(_asPath);
             }
            if (_atomicAggregate != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_atomicAggregate=");
                builder.append(_atomicAggregate);
             }
            if (_cNextHop != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_cNextHop=");
                builder.append(_cNextHop);
             }
            if (_clusterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_clusterId=");
                builder.append(_clusterId);
             }
            if (_communities != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_communities=");
                builder.append(_communities);
             }
            if (_extendedCommunities != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_extendedCommunities=");
                builder.append(_extendedCommunities);
             }
            if (_localPref != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localPref=");
                builder.append(_localPref);
             }
            if (_multiExitDisc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_multiExitDisc=");
                builder.append(_multiExitDisc);
             }
            if (_origin != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_origin=");
                builder.append(_origin);
             }
            if (_originatorId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_originatorId=");
                builder.append(_originatorId);
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
