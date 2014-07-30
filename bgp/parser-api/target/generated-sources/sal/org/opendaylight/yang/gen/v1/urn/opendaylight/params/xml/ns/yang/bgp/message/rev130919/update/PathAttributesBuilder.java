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
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Address;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.ClusterIdentifier;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919.next.hop.CNextHop;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Reference:
 *     <a href = "http://tools.ietf.org/html/rfc4271#section-5">http://tools.ietf.org/html/rfc4271#section-5</a>
 * Module name:
 *     bgp-message
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-message?revision=2013-09-19)update/update/path-attributes]
 */
public class PathAttributesBuilder {

    private Origin _origin;
    private AsPath _asPath;
    private MultiExitDisc _multiExitDisc;
    private LocalPref _localPref;
    private AtomicAggregate _atomicAggregate;
    private Aggregator _aggregator;
    private List<Communities> _communities;
    private List<ExtendedCommunities> _extendedCommunities;
    private Ipv4Address _originatorId;
    private List<ClusterIdentifier> _clusterId;
    private CNextHop _cNextHop;

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
        this._origin = base.getOrigin();
        this._asPath = base.getAsPath();
        this._multiExitDisc = base.getMultiExitDisc();
        this._localPref = base.getLocalPref();
        this._atomicAggregate = base.getAtomicAggregate();
        this._aggregator = base.getAggregator();
        this._communities = base.getCommunities();
        this._extendedCommunities = base.getExtendedCommunities();
        this._originatorId = base.getOriginatorId();
        this._clusterId = base.getClusterId();
        this._cNextHop = base.getCNextHop();
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

    public Origin getOrigin() {
        return _origin;
    }
    
    public AsPath getAsPath() {
        return _asPath;
    }
    
    public MultiExitDisc getMultiExitDisc() {
        return _multiExitDisc;
    }
    
    public LocalPref getLocalPref() {
        return _localPref;
    }
    
    public AtomicAggregate getAtomicAggregate() {
        return _atomicAggregate;
    }
    
    public Aggregator getAggregator() {
        return _aggregator;
    }
    
    public List<Communities> getCommunities() {
        return _communities;
    }
    
    public List<ExtendedCommunities> getExtendedCommunities() {
        return _extendedCommunities;
    }
    
    public Ipv4Address getOriginatorId() {
        return _originatorId;
    }
    
    public List<ClusterIdentifier> getClusterId() {
        return _clusterId;
    }
    
    public CNextHop getCNextHop() {
        return _cNextHop;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PathAttributesBuilder setOrigin(Origin value) {
        this._origin = value;
        return this;
    }
    
    public PathAttributesBuilder setAsPath(AsPath value) {
        this._asPath = value;
        return this;
    }
    
    public PathAttributesBuilder setMultiExitDisc(MultiExitDisc value) {
        this._multiExitDisc = value;
        return this;
    }
    
    public PathAttributesBuilder setLocalPref(LocalPref value) {
        this._localPref = value;
        return this;
    }
    
    public PathAttributesBuilder setAtomicAggregate(AtomicAggregate value) {
        this._atomicAggregate = value;
        return this;
    }
    
    public PathAttributesBuilder setAggregator(Aggregator value) {
        this._aggregator = value;
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
    
    public PathAttributesBuilder setOriginatorId(Ipv4Address value) {
        this._originatorId = value;
        return this;
    }
    
    public PathAttributesBuilder setClusterId(List<ClusterIdentifier> value) {
        this._clusterId = value;
        return this;
    }
    
    public PathAttributesBuilder setCNextHop(CNextHop value) {
        this._cNextHop = value;
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

        private final Origin _origin;
        private final AsPath _asPath;
        private final MultiExitDisc _multiExitDisc;
        private final LocalPref _localPref;
        private final AtomicAggregate _atomicAggregate;
        private final Aggregator _aggregator;
        private final List<Communities> _communities;
        private final List<ExtendedCommunities> _extendedCommunities;
        private final Ipv4Address _originatorId;
        private final List<ClusterIdentifier> _clusterId;
        private final CNextHop _cNextHop;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes>> augmentation = new HashMap<>();

        private PathAttributesImpl(PathAttributesBuilder base) {
            this._origin = base.getOrigin();
            this._asPath = base.getAsPath();
            this._multiExitDisc = base.getMultiExitDisc();
            this._localPref = base.getLocalPref();
            this._atomicAggregate = base.getAtomicAggregate();
            this._aggregator = base.getAggregator();
            this._communities = base.getCommunities();
            this._extendedCommunities = base.getExtendedCommunities();
            this._originatorId = base.getOriginatorId();
            this._clusterId = base.getClusterId();
            this._cNextHop = base.getCNextHop();
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
        public Origin getOrigin() {
            return _origin;
        }
        
        @Override
        public AsPath getAsPath() {
            return _asPath;
        }
        
        @Override
        public MultiExitDisc getMultiExitDisc() {
            return _multiExitDisc;
        }
        
        @Override
        public LocalPref getLocalPref() {
            return _localPref;
        }
        
        @Override
        public AtomicAggregate getAtomicAggregate() {
            return _atomicAggregate;
        }
        
        @Override
        public Aggregator getAggregator() {
            return _aggregator;
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
        public Ipv4Address getOriginatorId() {
            return _originatorId;
        }
        
        @Override
        public List<ClusterIdentifier> getClusterId() {
            return _clusterId;
        }
        
        @Override
        public CNextHop getCNextHop() {
            return _cNextHop;
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
            result = prime * result + ((_origin == null) ? 0 : _origin.hashCode());
            result = prime * result + ((_asPath == null) ? 0 : _asPath.hashCode());
            result = prime * result + ((_multiExitDisc == null) ? 0 : _multiExitDisc.hashCode());
            result = prime * result + ((_localPref == null) ? 0 : _localPref.hashCode());
            result = prime * result + ((_atomicAggregate == null) ? 0 : _atomicAggregate.hashCode());
            result = prime * result + ((_aggregator == null) ? 0 : _aggregator.hashCode());
            result = prime * result + ((_communities == null) ? 0 : _communities.hashCode());
            result = prime * result + ((_extendedCommunities == null) ? 0 : _extendedCommunities.hashCode());
            result = prime * result + ((_originatorId == null) ? 0 : _originatorId.hashCode());
            result = prime * result + ((_clusterId == null) ? 0 : _clusterId.hashCode());
            result = prime * result + ((_cNextHop == null) ? 0 : _cNextHop.hashCode());
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
            PathAttributesImpl other = (PathAttributesImpl) obj;
            if (_origin == null) {
                if (other._origin != null) {
                    return false;
                }
            } else if(!_origin.equals(other._origin)) {
                return false;
            }
            if (_asPath == null) {
                if (other._asPath != null) {
                    return false;
                }
            } else if(!_asPath.equals(other._asPath)) {
                return false;
            }
            if (_multiExitDisc == null) {
                if (other._multiExitDisc != null) {
                    return false;
                }
            } else if(!_multiExitDisc.equals(other._multiExitDisc)) {
                return false;
            }
            if (_localPref == null) {
                if (other._localPref != null) {
                    return false;
                }
            } else if(!_localPref.equals(other._localPref)) {
                return false;
            }
            if (_atomicAggregate == null) {
                if (other._atomicAggregate != null) {
                    return false;
                }
            } else if(!_atomicAggregate.equals(other._atomicAggregate)) {
                return false;
            }
            if (_aggregator == null) {
                if (other._aggregator != null) {
                    return false;
                }
            } else if(!_aggregator.equals(other._aggregator)) {
                return false;
            }
            if (_communities == null) {
                if (other._communities != null) {
                    return false;
                }
            } else if(!_communities.equals(other._communities)) {
                return false;
            }
            if (_extendedCommunities == null) {
                if (other._extendedCommunities != null) {
                    return false;
                }
            } else if(!_extendedCommunities.equals(other._extendedCommunities)) {
                return false;
            }
            if (_originatorId == null) {
                if (other._originatorId != null) {
                    return false;
                }
            } else if(!_originatorId.equals(other._originatorId)) {
                return false;
            }
            if (_clusterId == null) {
                if (other._clusterId != null) {
                    return false;
                }
            } else if(!_clusterId.equals(other._clusterId)) {
                return false;
            }
            if (_cNextHop == null) {
                if (other._cNextHop != null) {
                    return false;
                }
            } else if(!_cNextHop.equals(other._cNextHop)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("PathAttributes [");
            boolean first = true;
        
            if (_origin != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_origin=");
                builder.append(_origin);
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
            if (_multiExitDisc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_multiExitDisc=");
                builder.append(_multiExitDisc);
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
            if (_atomicAggregate != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_atomicAggregate=");
                builder.append(_atomicAggregate);
             }
            if (_aggregator != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_aggregator=");
                builder.append(_aggregator);
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
            if (_originatorId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_originatorId=");
                builder.append(_originatorId);
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
            if (_cNextHop != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_cNextHop=");
                builder.append(_cNextHop);
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
