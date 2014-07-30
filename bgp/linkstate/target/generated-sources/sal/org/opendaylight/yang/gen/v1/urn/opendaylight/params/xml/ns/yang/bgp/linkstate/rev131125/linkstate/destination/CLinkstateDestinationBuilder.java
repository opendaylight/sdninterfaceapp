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
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.c.linkstate.destination.LocalNodeDescriptors;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Identifier;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-destination/linkstate-destination/c-linkstate-destination]
 */
public class CLinkstateDestinationBuilder {

    private NlriType _nlriType;
    private RouteDistinguisher _distinguisher;
    private static List<Range<BigInteger>> _distinguisher_range;
    private ProtocolId _protocolId;
    private Identifier _identifier;
    private static List<Range<BigInteger>> _identifier_range;
    private LocalNodeDescriptors _localNodeDescriptors;
    private RemoteNodeDescriptors _remoteNodeDescriptors;
    private LinkDescriptors _linkDescriptors;
    private PrefixDescriptors _prefixDescriptors;
    private LinkSdniDescriptors _linkSdniDescriptors;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> augmentation = new HashMap<>();

    public CLinkstateDestinationBuilder() {
    } 

    public CLinkstateDestinationBuilder(CLinkstateDestination base) {
        this._nlriType = base.getNlriType();
        this._distinguisher = base.getDistinguisher();
        this._protocolId = base.getProtocolId();
        this._identifier = base.getIdentifier();
        this._localNodeDescriptors = base.getLocalNodeDescriptors();
        this._remoteNodeDescriptors = base.getRemoteNodeDescriptors();
        this._linkDescriptors = base.getLinkDescriptors();
        this._prefixDescriptors = base.getPrefixDescriptors();
        this._linkSdniDescriptors = base.getLinkSdniDescriptors();
        if (base instanceof CLinkstateDestinationImpl) {
            CLinkstateDestinationImpl _impl = (CLinkstateDestinationImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public NlriType getNlriType() {
        return _nlriType;
    }
    
    public RouteDistinguisher getDistinguisher() {
        return _distinguisher;
    }
    
    public ProtocolId getProtocolId() {
        return _protocolId;
    }
    
    public Identifier getIdentifier() {
        return _identifier;
    }
    
    public LocalNodeDescriptors getLocalNodeDescriptors() {
        return _localNodeDescriptors;
    }
    
    public RemoteNodeDescriptors getRemoteNodeDescriptors() {
        return _remoteNodeDescriptors;
    }
    
    public LinkDescriptors getLinkDescriptors() {
        return _linkDescriptors;
    }
    
    public PrefixDescriptors getPrefixDescriptors() {
        return _prefixDescriptors;
    }
    
    public LinkSdniDescriptors getLinkSdniDescriptors() {
        return _linkSdniDescriptors;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public CLinkstateDestinationBuilder setNlriType(NlriType value) {
        this._nlriType = value;
        return this;
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
    
    public CLinkstateDestinationBuilder setProtocolId(ProtocolId value) {
        this._protocolId = value;
        return this;
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
    
    public CLinkstateDestinationBuilder setLocalNodeDescriptors(LocalNodeDescriptors value) {
        this._localNodeDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setRemoteNodeDescriptors(RemoteNodeDescriptors value) {
        this._remoteNodeDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setLinkDescriptors(LinkDescriptors value) {
        this._linkDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setPrefixDescriptors(PrefixDescriptors value) {
        this._prefixDescriptors = value;
        return this;
    }
    
    public CLinkstateDestinationBuilder setLinkSdniDescriptors(LinkSdniDescriptors value) {
        this._linkSdniDescriptors = value;
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

        private final NlriType _nlriType;
        private final RouteDistinguisher _distinguisher;
        private final ProtocolId _protocolId;
        private final Identifier _identifier;
        private final LocalNodeDescriptors _localNodeDescriptors;
        private final RemoteNodeDescriptors _remoteNodeDescriptors;
        private final LinkDescriptors _linkDescriptors;
        private final PrefixDescriptors _prefixDescriptors;
        private final LinkSdniDescriptors _linkSdniDescriptors;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.linkstate.destination.CLinkstateDestination>> augmentation = new HashMap<>();

        private CLinkstateDestinationImpl(CLinkstateDestinationBuilder base) {
            this._nlriType = base.getNlriType();
            this._distinguisher = base.getDistinguisher();
            this._protocolId = base.getProtocolId();
            this._identifier = base.getIdentifier();
            this._localNodeDescriptors = base.getLocalNodeDescriptors();
            this._remoteNodeDescriptors = base.getRemoteNodeDescriptors();
            this._linkDescriptors = base.getLinkDescriptors();
            this._prefixDescriptors = base.getPrefixDescriptors();
            this._linkSdniDescriptors = base.getLinkSdniDescriptors();
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
        public NlriType getNlriType() {
            return _nlriType;
        }
        
        @Override
        public RouteDistinguisher getDistinguisher() {
            return _distinguisher;
        }
        
        @Override
        public ProtocolId getProtocolId() {
            return _protocolId;
        }
        
        @Override
        public Identifier getIdentifier() {
            return _identifier;
        }
        
        @Override
        public LocalNodeDescriptors getLocalNodeDescriptors() {
            return _localNodeDescriptors;
        }
        
        @Override
        public RemoteNodeDescriptors getRemoteNodeDescriptors() {
            return _remoteNodeDescriptors;
        }
        
        @Override
        public LinkDescriptors getLinkDescriptors() {
            return _linkDescriptors;
        }
        
        @Override
        public PrefixDescriptors getPrefixDescriptors() {
            return _prefixDescriptors;
        }
        
        @Override
        public LinkSdniDescriptors getLinkSdniDescriptors() {
            return _linkSdniDescriptors;
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
            result = prime * result + ((_nlriType == null) ? 0 : _nlriType.hashCode());
            result = prime * result + ((_distinguisher == null) ? 0 : _distinguisher.hashCode());
            result = prime * result + ((_protocolId == null) ? 0 : _protocolId.hashCode());
            result = prime * result + ((_identifier == null) ? 0 : _identifier.hashCode());
            result = prime * result + ((_localNodeDescriptors == null) ? 0 : _localNodeDescriptors.hashCode());
            result = prime * result + ((_remoteNodeDescriptors == null) ? 0 : _remoteNodeDescriptors.hashCode());
            result = prime * result + ((_linkDescriptors == null) ? 0 : _linkDescriptors.hashCode());
            result = prime * result + ((_prefixDescriptors == null) ? 0 : _prefixDescriptors.hashCode());
            result = prime * result + ((_linkSdniDescriptors == null) ? 0 : _linkSdniDescriptors.hashCode());
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
            CLinkstateDestinationImpl other = (CLinkstateDestinationImpl) obj;
            if (_nlriType == null) {
                if (other._nlriType != null) {
                    return false;
                }
            } else if(!_nlriType.equals(other._nlriType)) {
                return false;
            }
            if (_distinguisher == null) {
                if (other._distinguisher != null) {
                    return false;
                }
            } else if(!_distinguisher.equals(other._distinguisher)) {
                return false;
            }
            if (_protocolId == null) {
                if (other._protocolId != null) {
                    return false;
                }
            } else if(!_protocolId.equals(other._protocolId)) {
                return false;
            }
            if (_identifier == null) {
                if (other._identifier != null) {
                    return false;
                }
            } else if(!_identifier.equals(other._identifier)) {
                return false;
            }
            if (_localNodeDescriptors == null) {
                if (other._localNodeDescriptors != null) {
                    return false;
                }
            } else if(!_localNodeDescriptors.equals(other._localNodeDescriptors)) {
                return false;
            }
            if (_remoteNodeDescriptors == null) {
                if (other._remoteNodeDescriptors != null) {
                    return false;
                }
            } else if(!_remoteNodeDescriptors.equals(other._remoteNodeDescriptors)) {
                return false;
            }
            if (_linkDescriptors == null) {
                if (other._linkDescriptors != null) {
                    return false;
                }
            } else if(!_linkDescriptors.equals(other._linkDescriptors)) {
                return false;
            }
            if (_prefixDescriptors == null) {
                if (other._prefixDescriptors != null) {
                    return false;
                }
            } else if(!_prefixDescriptors.equals(other._prefixDescriptors)) {
                return false;
            }
            if (_linkSdniDescriptors == null) {
                if (other._linkSdniDescriptors != null) {
                    return false;
                }
            } else if(!_linkSdniDescriptors.equals(other._linkSdniDescriptors)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("CLinkstateDestination [");
            boolean first = true;
        
            if (_nlriType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nlriType=");
                builder.append(_nlriType);
             }
            if (_distinguisher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_distinguisher=");
                builder.append(_distinguisher);
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
            if (_identifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identifier=");
                builder.append(_identifier);
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
            if (_remoteNodeDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_remoteNodeDescriptors=");
                builder.append(_remoteNodeDescriptors);
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
            if (_prefixDescriptors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_prefixDescriptors=");
                builder.append(_prefixDescriptors);
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
