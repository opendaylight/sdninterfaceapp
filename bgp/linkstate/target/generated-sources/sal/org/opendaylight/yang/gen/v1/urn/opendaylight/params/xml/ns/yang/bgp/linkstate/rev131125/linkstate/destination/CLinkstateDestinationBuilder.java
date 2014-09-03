package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.PrefixDescriptors;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.ProtocolId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.RemoteNodeDescriptors;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkSdniDescriptors;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NlriType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.RouteDistinguisher;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LinkDescriptors;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LocalNodeDescriptors;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Identifier;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination
 */
public class CLinkstateDestinationBuilder {

    private RouteDistinguisher _distinguisher;
    private static List<Range<BigInteger>> _distinguisher_range;
    private Identifier _identifier;
    private static List<Range<BigInteger>> _identifier_range;
    private LinkDescriptors _linkDescriptors;
    private LinkSdniDescriptors _linkSdniDescriptors;
    private LocalNodeDescriptors _localNodeDescriptors;
    private NlriType _nlriType;
    private PrefixDescriptors _prefixDescriptors;
    private ProtocolId _protocolId;
    private RemoteNodeDescriptors _remoteNodeDescriptors;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> augmentation = new HashMap<>();

    public CLinkstateDestinationBuilder() {
    } 

    public CLinkstateDestinationBuilder(CLinkstateDestination base) {
        this._distinguisher = base.getDistinguisher();
        this._identifier = base.getIdentifier();
        this._linkDescriptors = base.getLinkDescriptors();
        this._linkSdniDescriptors = base.getLinkSdniDescriptors();
        this._localNodeDescriptors = base.getLocalNodeDescriptors();
        this._nlriType = base.getNlriType();
        this._prefixDescriptors = base.getPrefixDescriptors();
        this._protocolId = base.getProtocolId();
        this._remoteNodeDescriptors = base.getRemoteNodeDescriptors();
        if (base instanceof CLinkstateDestinationImpl) {
            CLinkstateDestinationImpl _impl = (CLinkstateDestinationImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public RouteDistinguisher getDistinguisher() {
        return _distinguisher;
    }
    
    public Identifier getIdentifier() {
        return _identifier;
    }
    
    public LinkDescriptors getLinkDescriptors() {
        return _linkDescriptors;
    }
    
    public LinkSdniDescriptors getLinkSdniDescriptors() {
        return _linkSdniDescriptors;
    }
    
    public LocalNodeDescriptors getLocalNodeDescriptors() {
        return _localNodeDescriptors;
    }
    
    public NlriType getNlriType() {
        return _nlriType;
    }
    
    public PrefixDescriptors getPrefixDescriptors() {
        return _prefixDescriptors;
    }
    
    public ProtocolId getProtocolId() {
        return _protocolId;
    }
    
    public RemoteNodeDescriptors getRemoteNodeDescriptors() {
        return _remoteNodeDescriptors;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public CLinkstateDestinationBuilder setDistinguisher(RouteDistinguisher value) {
        if (value != null) {
            BigInteger _constraint = value.getValue();
            boolean isValidRange = false;
            for (Range<BigInteger> r : _distinguisher_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _distinguisher_range));
            }
        }
        this._distinguisher = value;
        return this;
    }
    public static List<Range<BigInteger>> _distinguisher_range() {
        if (_distinguisher_range == null) {
            synchronized (CLinkstateDestinationBuilder.class) {
                if (_distinguisher_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
                    _distinguisher_range = builder.build();
                }
            }
        }
        return _distinguisher_range;
    }
    
    public CLinkstateDestinationBuilder setIdentifier(Identifier value) {
        if (value != null) {
            BigInteger _constraint = value.getValue();
            boolean isValidRange = false;
            for (Range<BigInteger> r : _identifier_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _identifier_range));
            }
        }
        this._identifier = value;
        return this;
    }
    public static List<Range<BigInteger>> _identifier_range() {
        if (_identifier_range == null) {
            synchronized (CLinkstateDestinationBuilder.class) {
                if (_identifier_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, new BigInteger("18446744073709551615")));
                    _identifier_range = builder.build();
                }
            }
        }
        return _identifier_range;
    }
    
    public CLinkstateDestinationBuilder setLinkDescriptors(LinkDescriptors value) {
        this._linkDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setLinkSdniDescriptors(LinkSdniDescriptors value) {
        this._linkSdniDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setLocalNodeDescriptors(LocalNodeDescriptors value) {
        this._localNodeDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setNlriType(NlriType value) {
        this._nlriType = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setPrefixDescriptors(PrefixDescriptors value) {
        this._prefixDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setProtocolId(ProtocolId value) {
        this._protocolId = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setRemoteNodeDescriptors(RemoteNodeDescriptors value) {
        this._remoteNodeDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public CLinkstateDestination build() {
        return new CLinkstateDestinationImpl(this);
    }

    private static final class CLinkstateDestinationImpl implements CLinkstateDestination {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination.class;
        }

        private final RouteDistinguisher _distinguisher;
        private final Identifier _identifier;
        private final LinkDescriptors _linkDescriptors;
        private final LinkSdniDescriptors _linkSdniDescriptors;
        private final LocalNodeDescriptors _localNodeDescriptors;
        private final NlriType _nlriType;
        private final PrefixDescriptors _prefixDescriptors;
        private final ProtocolId _protocolId;
        private final RemoteNodeDescriptors _remoteNodeDescriptors;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> augmentation = new HashMap<>();

        private CLinkstateDestinationImpl(CLinkstateDestinationBuilder base) {
            this._distinguisher = base.getDistinguisher();
            this._identifier = base.getIdentifier();
            this._linkDescriptors = base.getLinkDescriptors();
            this._linkSdniDescriptors = base.getLinkSdniDescriptors();
            this._localNodeDescriptors = base.getLocalNodeDescriptors();
            this._nlriType = base.getNlriType();
            this._prefixDescriptors = base.getPrefixDescriptors();
            this._protocolId = base.getProtocolId();
            this._remoteNodeDescriptors = base.getRemoteNodeDescriptors();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public RouteDistinguisher getDistinguisher() {
            return _distinguisher;
        }
        
        @Override
        public Identifier getIdentifier() {
            return _identifier;
        }
        
        @Override
        public LinkDescriptors getLinkDescriptors() {
            return _linkDescriptors;
        }
        
        @Override
        public LinkSdniDescriptors getLinkSdniDescriptors() {
            return _linkSdniDescriptors;
        }
        
        @Override
        public LocalNodeDescriptors getLocalNodeDescriptors() {
            return _localNodeDescriptors;
        }
        
        @Override
        public NlriType getNlriType() {
            return _nlriType;
        }
        
        @Override
        public PrefixDescriptors getPrefixDescriptors() {
            return _prefixDescriptors;
        }
        
        @Override
        public ProtocolId getProtocolId() {
            return _protocolId;
        }
        
        @Override
        public RemoteNodeDescriptors getRemoteNodeDescriptors() {
            return _remoteNodeDescriptors;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_distinguisher == null) ? 0 : _distinguisher.hashCode());
            result = prime * result + ((_identifier == null) ? 0 : _identifier.hashCode());
            result = prime * result + ((_linkDescriptors == null) ? 0 : _linkDescriptors.hashCode());
            result = prime * result + ((_linkSdniDescriptors == null) ? 0 : _linkSdniDescriptors.hashCode());
            result = prime * result + ((_localNodeDescriptors == null) ? 0 : _localNodeDescriptors.hashCode());
            result = prime * result + ((_nlriType == null) ? 0 : _nlriType.hashCode());
            result = prime * result + ((_prefixDescriptors == null) ? 0 : _prefixDescriptors.hashCode());
            result = prime * result + ((_protocolId == null) ? 0 : _protocolId.hashCode());
            result = prime * result + ((_remoteNodeDescriptors == null) ? 0 : _remoteNodeDescriptors.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination)obj;
            if (_distinguisher == null) {
                if (other.getDistinguisher() != null) {
                    return false;
                }
            } else if(!_distinguisher.equals(other.getDistinguisher())) {
                return false;
            }
            if (_identifier == null) {
                if (other.getIdentifier() != null) {
                    return false;
                }
            } else if(!_identifier.equals(other.getIdentifier())) {
                return false;
            }
            if (_linkDescriptors == null) {
                if (other.getLinkDescriptors() != null) {
                    return false;
                }
            } else if(!_linkDescriptors.equals(other.getLinkDescriptors())) {
                return false;
            }
            if (_linkSdniDescriptors == null) {
                if (other.getLinkSdniDescriptors() != null) {
                    return false;
                }
            } else if(!_linkSdniDescriptors.equals(other.getLinkSdniDescriptors())) {
                return false;
            }
            if (_localNodeDescriptors == null) {
                if (other.getLocalNodeDescriptors() != null) {
                    return false;
                }
            } else if(!_localNodeDescriptors.equals(other.getLocalNodeDescriptors())) {
                return false;
            }
            if (_nlriType == null) {
                if (other.getNlriType() != null) {
                    return false;
                }
            } else if(!_nlriType.equals(other.getNlriType())) {
                return false;
            }
            if (_prefixDescriptors == null) {
                if (other.getPrefixDescriptors() != null) {
                    return false;
                }
            } else if(!_prefixDescriptors.equals(other.getPrefixDescriptors())) {
                return false;
            }
            if (_protocolId == null) {
                if (other.getProtocolId() != null) {
                    return false;
                }
            } else if(!_protocolId.equals(other.getProtocolId())) {
                return false;
            }
            if (_remoteNodeDescriptors == null) {
                if (other.getRemoteNodeDescriptors() != null) {
                    return false;
                }
            } else if(!_remoteNodeDescriptors.equals(other.getRemoteNodeDescriptors())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                CLinkstateDestinationImpl otherImpl = (CLinkstateDestinationImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("CLinkstateDestination [");
            boolean first = true;
        
            if (_distinguisher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_distinguisher=");
                builder.append(_distinguisher);
             }
            if (_identifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identifier=");
                builder.append(_identifier);
             }
            if (_linkDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkDescriptors=");
                builder.append(_linkDescriptors);
             }
            if (_linkSdniDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkSdniDescriptors=");
                builder.append(_linkSdniDescriptors);
             }
            if (_localNodeDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localNodeDescriptors=");
                builder.append(_localNodeDescriptors);
             }
            if (_nlriType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nlriType=");
                builder.append(_nlriType);
             }
            if (_prefixDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_prefixDescriptors=");
                builder.append(_prefixDescriptors);
             }
            if (_protocolId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocolId=");
                builder.append(_protocolId);
             }
            if (_remoteNodeDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_remoteNodeDescriptors=");
                builder.append(_remoteNodeDescriptors);
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
