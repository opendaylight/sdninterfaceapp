package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6InterfaceIdentifier;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4InterfaceIdentifier;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors
 */
public class LinkDescriptorsBuilder {

    private Ipv4InterfaceIdentifier _ipv4InterfaceAddress;
    private Ipv4InterfaceIdentifier _ipv4NeighborAddress;
    private Ipv6InterfaceIdentifier _ipv6InterfaceAddress;
    private Ipv6InterfaceIdentifier _ipv6NeighborAddress;
    private java.lang.Long _linkLocalIdentifier;
    private static List<Range<BigInteger>> _linkLocalIdentifier_range;
    private java.lang.Long _linkRemoteIdentifier;
    private static List<Range<BigInteger>> _linkRemoteIdentifier_range;
    private TopologyIdentifier _multiTopologyId;
    private static List<Range<BigInteger>> _multiTopologyId_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> augmentation = new HashMap<>();

    public LinkDescriptorsBuilder() {
    } 
    
    public LinkDescriptorsBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier arg) {
        this._ipv4InterfaceAddress = arg.getIpv4InterfaceAddress();
        this._ipv6InterfaceAddress = arg.getIpv6InterfaceAddress();
        this._ipv4NeighborAddress = arg.getIpv4NeighborAddress();
        this._ipv6NeighborAddress = arg.getIpv6NeighborAddress();
        this._multiTopologyId = arg.getMultiTopologyId();
        this._linkLocalIdentifier = arg.getLinkLocalIdentifier();
        this._linkRemoteIdentifier = arg.getLinkRemoteIdentifier();
    }
    
    public LinkDescriptorsBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers arg) {
        this._linkLocalIdentifier = arg.getLinkLocalIdentifier();
        this._linkRemoteIdentifier = arg.getLinkRemoteIdentifier();
    }

    public LinkDescriptorsBuilder(LinkDescriptors base) {
        this._ipv4InterfaceAddress = base.getIpv4InterfaceAddress();
        this._ipv4NeighborAddress = base.getIpv4NeighborAddress();
        this._ipv6InterfaceAddress = base.getIpv6InterfaceAddress();
        this._ipv6NeighborAddress = base.getIpv6NeighborAddress();
        this._linkLocalIdentifier = base.getLinkLocalIdentifier();
        this._linkRemoteIdentifier = base.getLinkRemoteIdentifier();
        this._multiTopologyId = base.getMultiTopologyId();
        if (base instanceof LinkDescriptorsImpl) {
            LinkDescriptorsImpl _impl = (LinkDescriptorsImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier</li>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier) {
            this._ipv4InterfaceAddress = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier)arg).getIpv4InterfaceAddress();
            this._ipv6InterfaceAddress = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier)arg).getIpv6InterfaceAddress();
            this._ipv4NeighborAddress = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier)arg).getIpv4NeighborAddress();
            this._ipv6NeighborAddress = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier)arg).getIpv6NeighborAddress();
            this._multiTopologyId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier)arg).getMultiTopologyId();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers) {
            this._linkLocalIdentifier = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers)arg).getLinkLocalIdentifier();
            this._linkRemoteIdentifier = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers)arg).getLinkRemoteIdentifier();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkIdentifier, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkLrIdentifiers] \n" +
              "but was: " + arg
            );
        }
    }

    public Ipv4InterfaceIdentifier getIpv4InterfaceAddress() {
        return _ipv4InterfaceAddress;
    }
    
    public Ipv4InterfaceIdentifier getIpv4NeighborAddress() {
        return _ipv4NeighborAddress;
    }
    
    public Ipv6InterfaceIdentifier getIpv6InterfaceAddress() {
        return _ipv6InterfaceAddress;
    }
    
    public Ipv6InterfaceIdentifier getIpv6NeighborAddress() {
        return _ipv6NeighborAddress;
    }
    
    public java.lang.Long getLinkLocalIdentifier() {
        return _linkLocalIdentifier;
    }
    
    public java.lang.Long getLinkRemoteIdentifier() {
        return _linkRemoteIdentifier;
    }
    
    public TopologyIdentifier getMultiTopologyId() {
        return _multiTopologyId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public LinkDescriptorsBuilder setIpv4InterfaceAddress(Ipv4InterfaceIdentifier value) {
        this._ipv4InterfaceAddress = value;
        return this;
    }
    
    public LinkDescriptorsBuilder setIpv4NeighborAddress(Ipv4InterfaceIdentifier value) {
        this._ipv4NeighborAddress = value;
        return this;
    }
    
    public LinkDescriptorsBuilder setIpv6InterfaceAddress(Ipv6InterfaceIdentifier value) {
        this._ipv6InterfaceAddress = value;
        return this;
    }
    
    public LinkDescriptorsBuilder setIpv6NeighborAddress(Ipv6InterfaceIdentifier value) {
        this._ipv6NeighborAddress = value;
        return this;
    }
    
    public LinkDescriptorsBuilder setLinkLocalIdentifier(java.lang.Long value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _linkLocalIdentifier_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _linkLocalIdentifier_range));
            }
        }
        this._linkLocalIdentifier = value;
        return this;
    }
    public static List<Range<BigInteger>> _linkLocalIdentifier_range() {
        if (_linkLocalIdentifier_range == null) {
            synchronized (LinkDescriptorsBuilder.class) {
                if (_linkLocalIdentifier_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _linkLocalIdentifier_range = builder.build();
                }
            }
        }
        return _linkLocalIdentifier_range;
    }
    
    public LinkDescriptorsBuilder setLinkRemoteIdentifier(java.lang.Long value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _linkRemoteIdentifier_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _linkRemoteIdentifier_range));
            }
        }
        this._linkRemoteIdentifier = value;
        return this;
    }
    public static List<Range<BigInteger>> _linkRemoteIdentifier_range() {
        if (_linkRemoteIdentifier_range == null) {
            synchronized (LinkDescriptorsBuilder.class) {
                if (_linkRemoteIdentifier_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _linkRemoteIdentifier_range = builder.build();
                }
            }
        }
        return _linkRemoteIdentifier_range;
    }
    
    public LinkDescriptorsBuilder setMultiTopologyId(TopologyIdentifier value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _multiTopologyId_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _multiTopologyId_range));
            }
        }
        this._multiTopologyId = value;
        return this;
    }
    public static List<Range<BigInteger>> _multiTopologyId_range() {
        if (_multiTopologyId_range == null) {
            synchronized (LinkDescriptorsBuilder.class) {
                if (_multiTopologyId_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4095L)));
                    _multiTopologyId_range = builder.build();
                }
            }
        }
        return _multiTopologyId_range;
    }
    
    public LinkDescriptorsBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public LinkDescriptors build() {
        return new LinkDescriptorsImpl(this);
    }

    private static final class LinkDescriptorsImpl implements LinkDescriptors {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors.class;
        }

        private final Ipv4InterfaceIdentifier _ipv4InterfaceAddress;
        private final Ipv4InterfaceIdentifier _ipv4NeighborAddress;
        private final Ipv6InterfaceIdentifier _ipv6InterfaceAddress;
        private final Ipv6InterfaceIdentifier _ipv6NeighborAddress;
        private final java.lang.Long _linkLocalIdentifier;
        private final java.lang.Long _linkRemoteIdentifier;
        private final TopologyIdentifier _multiTopologyId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> augmentation = new HashMap<>();

        private LinkDescriptorsImpl(LinkDescriptorsBuilder base) {
            this._ipv4InterfaceAddress = base.getIpv4InterfaceAddress();
            this._ipv4NeighborAddress = base.getIpv4NeighborAddress();
            this._ipv6InterfaceAddress = base.getIpv6InterfaceAddress();
            this._ipv6NeighborAddress = base.getIpv6NeighborAddress();
            this._linkLocalIdentifier = base.getLinkLocalIdentifier();
            this._linkRemoteIdentifier = base.getLinkRemoteIdentifier();
            this._multiTopologyId = base.getMultiTopologyId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public Ipv4InterfaceIdentifier getIpv4InterfaceAddress() {
            return _ipv4InterfaceAddress;
        }
        
        @Override
        public Ipv4InterfaceIdentifier getIpv4NeighborAddress() {
            return _ipv4NeighborAddress;
        }
        
        @Override
        public Ipv6InterfaceIdentifier getIpv6InterfaceAddress() {
            return _ipv6InterfaceAddress;
        }
        
        @Override
        public Ipv6InterfaceIdentifier getIpv6NeighborAddress() {
            return _ipv6NeighborAddress;
        }
        
        @Override
        public java.lang.Long getLinkLocalIdentifier() {
            return _linkLocalIdentifier;
        }
        
        @Override
        public java.lang.Long getLinkRemoteIdentifier() {
            return _linkRemoteIdentifier;
        }
        
        @Override
        public TopologyIdentifier getMultiTopologyId() {
            return _multiTopologyId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_ipv4InterfaceAddress == null) ? 0 : _ipv4InterfaceAddress.hashCode());
            result = prime * result + ((_ipv4NeighborAddress == null) ? 0 : _ipv4NeighborAddress.hashCode());
            result = prime * result + ((_ipv6InterfaceAddress == null) ? 0 : _ipv6InterfaceAddress.hashCode());
            result = prime * result + ((_ipv6NeighborAddress == null) ? 0 : _ipv6NeighborAddress.hashCode());
            result = prime * result + ((_linkLocalIdentifier == null) ? 0 : _linkLocalIdentifier.hashCode());
            result = prime * result + ((_linkRemoteIdentifier == null) ? 0 : _linkRemoteIdentifier.hashCode());
            result = prime * result + ((_multiTopologyId == null) ? 0 : _multiTopologyId.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors)obj;
            if (_ipv4InterfaceAddress == null) {
                if (other.getIpv4InterfaceAddress() != null) {
                    return false;
                }
            } else if(!_ipv4InterfaceAddress.equals(other.getIpv4InterfaceAddress())) {
                return false;
            }
            if (_ipv4NeighborAddress == null) {
                if (other.getIpv4NeighborAddress() != null) {
                    return false;
                }
            } else if(!_ipv4NeighborAddress.equals(other.getIpv4NeighborAddress())) {
                return false;
            }
            if (_ipv6InterfaceAddress == null) {
                if (other.getIpv6InterfaceAddress() != null) {
                    return false;
                }
            } else if(!_ipv6InterfaceAddress.equals(other.getIpv6InterfaceAddress())) {
                return false;
            }
            if (_ipv6NeighborAddress == null) {
                if (other.getIpv6NeighborAddress() != null) {
                    return false;
                }
            } else if(!_ipv6NeighborAddress.equals(other.getIpv6NeighborAddress())) {
                return false;
            }
            if (_linkLocalIdentifier == null) {
                if (other.getLinkLocalIdentifier() != null) {
                    return false;
                }
            } else if(!_linkLocalIdentifier.equals(other.getLinkLocalIdentifier())) {
                return false;
            }
            if (_linkRemoteIdentifier == null) {
                if (other.getLinkRemoteIdentifier() != null) {
                    return false;
                }
            } else if(!_linkRemoteIdentifier.equals(other.getLinkRemoteIdentifier())) {
                return false;
            }
            if (_multiTopologyId == null) {
                if (other.getMultiTopologyId() != null) {
                    return false;
                }
            } else if(!_multiTopologyId.equals(other.getMultiTopologyId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                LinkDescriptorsImpl otherImpl = (LinkDescriptorsImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.object.type.link._case.LinkDescriptors>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("LinkDescriptors [");
            boolean first = true;
        
            if (_ipv4InterfaceAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv4InterfaceAddress=");
                builder.append(_ipv4InterfaceAddress);
             }
            if (_ipv4NeighborAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv4NeighborAddress=");
                builder.append(_ipv4NeighborAddress);
             }
            if (_ipv6InterfaceAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv6InterfaceAddress=");
                builder.append(_ipv6InterfaceAddress);
             }
            if (_ipv6NeighborAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv6NeighborAddress=");
                builder.append(_ipv6NeighborAddress);
             }
            if (_linkLocalIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkLocalIdentifier=");
                builder.append(_linkLocalIdentifier);
             }
            if (_linkRemoteIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkRemoteIdentifier=");
                builder.append(_linkRemoteIdentifier);
             }
            if (_multiTopologyId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_multiTopologyId=");
                builder.append(_multiTopologyId);
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
