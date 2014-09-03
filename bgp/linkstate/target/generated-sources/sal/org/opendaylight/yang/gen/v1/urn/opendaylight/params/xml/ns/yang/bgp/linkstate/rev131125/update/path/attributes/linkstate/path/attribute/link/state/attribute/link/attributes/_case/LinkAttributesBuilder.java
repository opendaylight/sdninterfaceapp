package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case;
import com.google.common.collect.Range;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Metric;
import java.util.Map;
import java.util.HashMap;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.link.state.UnreservedBandwidth;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6RouterIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.TeMetric;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkProtectionType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.MplsProtocolMask;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.AdministrativeGroup;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4RouterIdentifier;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rsvp.rev130820.SrlgId;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.network.concepts.rev131125.Bandwidth;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes
 */
public class LinkAttributesBuilder {

    private AdministrativeGroup _adminGroup;
    private static List<Range<BigInteger>> _adminGroup_range;
    private java.lang.String _linkName;
    private LinkProtectionType _linkProtection;
    private Ipv4RouterIdentifier _localIpv4RouterId;
    private Ipv6RouterIdentifier _localIpv6RouterId;
    private Bandwidth _maxLinkBandwidth;
    private Bandwidth _maxReservableBandwidth;
    private Metric _metric;
    private static List<Range<BigInteger>> _metric_range;
    private MplsProtocolMask _mplsProtocol;
    private Ipv4RouterIdentifier _remoteIpv4RouterId;
    private Ipv6RouterIdentifier _remoteIpv6RouterId;
    private java.lang.String _sdniLinkState;
    private List<SrlgId> _sharedRiskLinkGroups;
    private TeMetric _teMetric;
    private static List<Range<BigInteger>> _teMetric_range;
    private List<UnreservedBandwidth> _unreservedBandwidth;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> augmentation = new HashMap<>();

    public LinkAttributesBuilder() {
    } 
    
    public LinkAttributesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState arg) {
        this._localIpv4RouterId = arg.getLocalIpv4RouterId();
        this._localIpv6RouterId = arg.getLocalIpv6RouterId();
        this._remoteIpv4RouterId = arg.getRemoteIpv4RouterId();
        this._remoteIpv6RouterId = arg.getRemoteIpv6RouterId();
        this._mplsProtocol = arg.getMplsProtocol();
        this._teMetric = arg.getTeMetric();
        this._metric = arg.getMetric();
        this._sharedRiskLinkGroups = arg.getSharedRiskLinkGroups();
        this._linkName = arg.getLinkName();
        this._maxLinkBandwidth = arg.getMaxLinkBandwidth();
        this._maxReservableBandwidth = arg.getMaxReservableBandwidth();
        this._unreservedBandwidth = arg.getUnreservedBandwidth();
        this._linkProtection = arg.getLinkProtection();
        this._adminGroup = arg.getAdminGroup();
        this._sdniLinkState = arg.getSdniLinkState();
    }

    public LinkAttributesBuilder(LinkAttributes base) {
        this._adminGroup = base.getAdminGroup();
        this._linkName = base.getLinkName();
        this._linkProtection = base.getLinkProtection();
        this._localIpv4RouterId = base.getLocalIpv4RouterId();
        this._localIpv6RouterId = base.getLocalIpv6RouterId();
        this._maxLinkBandwidth = base.getMaxLinkBandwidth();
        this._maxReservableBandwidth = base.getMaxReservableBandwidth();
        this._metric = base.getMetric();
        this._mplsProtocol = base.getMplsProtocol();
        this._remoteIpv4RouterId = base.getRemoteIpv4RouterId();
        this._remoteIpv6RouterId = base.getRemoteIpv6RouterId();
        this._sdniLinkState = base.getSdniLinkState();
        this._sharedRiskLinkGroups = base.getSharedRiskLinkGroups();
        this._teMetric = base.getTeMetric();
        this._unreservedBandwidth = base.getUnreservedBandwidth();
        if (base instanceof LinkAttributesImpl) {
            LinkAttributesImpl _impl = (LinkAttributesImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState) {
            this._localIpv4RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getLocalIpv4RouterId();
            this._localIpv6RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getLocalIpv6RouterId();
            this._remoteIpv4RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getRemoteIpv4RouterId();
            this._remoteIpv6RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getRemoteIpv6RouterId();
            this._mplsProtocol = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getMplsProtocol();
            this._teMetric = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getTeMetric();
            this._metric = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getMetric();
            this._sharedRiskLinkGroups = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getSharedRiskLinkGroups();
            this._linkName = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getLinkName();
            this._maxLinkBandwidth = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getMaxLinkBandwidth();
            this._maxReservableBandwidth = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getMaxReservableBandwidth();
            this._unreservedBandwidth = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getUnreservedBandwidth();
            this._linkProtection = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getLinkProtection();
            this._adminGroup = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getAdminGroup();
            this._sdniLinkState = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState)arg).getSdniLinkState();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.LinkState] \n" +
              "but was: " + arg
            );
        }
    }

    public AdministrativeGroup getAdminGroup() {
        return _adminGroup;
    }
    
    public java.lang.String getLinkName() {
        return _linkName;
    }
    
    public LinkProtectionType getLinkProtection() {
        return _linkProtection;
    }
    
    public Ipv4RouterIdentifier getLocalIpv4RouterId() {
        return _localIpv4RouterId;
    }
    
    public Ipv6RouterIdentifier getLocalIpv6RouterId() {
        return _localIpv6RouterId;
    }
    
    public Bandwidth getMaxLinkBandwidth() {
        return _maxLinkBandwidth;
    }
    
    public Bandwidth getMaxReservableBandwidth() {
        return _maxReservableBandwidth;
    }
    
    public Metric getMetric() {
        return _metric;
    }
    
    public MplsProtocolMask getMplsProtocol() {
        return _mplsProtocol;
    }
    
    public Ipv4RouterIdentifier getRemoteIpv4RouterId() {
        return _remoteIpv4RouterId;
    }
    
    public Ipv6RouterIdentifier getRemoteIpv6RouterId() {
        return _remoteIpv6RouterId;
    }
    
    public java.lang.String getSdniLinkState() {
        return _sdniLinkState;
    }
    
    public List<SrlgId> getSharedRiskLinkGroups() {
        return _sharedRiskLinkGroups;
    }
    
    public TeMetric getTeMetric() {
        return _teMetric;
    }
    
    public List<UnreservedBandwidth> getUnreservedBandwidth() {
        return _unreservedBandwidth;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public LinkAttributesBuilder setAdminGroup(AdministrativeGroup value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _adminGroup_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _adminGroup_range));
            }
        }
        this._adminGroup = value;
        return this;
    }
    public static List<Range<BigInteger>> _adminGroup_range() {
        if (_adminGroup_range == null) {
            synchronized (LinkAttributesBuilder.class) {
                if (_adminGroup_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _adminGroup_range = builder.build();
                }
            }
        }
        return _adminGroup_range;
    }
    
    public LinkAttributesBuilder setLinkName(java.lang.String value) {
        this._linkName = value;
        return this;
    }
    
    public LinkAttributesBuilder setLinkProtection(LinkProtectionType value) {
        this._linkProtection = value;
        return this;
    }
    
    public LinkAttributesBuilder setLocalIpv4RouterId(Ipv4RouterIdentifier value) {
        this._localIpv4RouterId = value;
        return this;
    }
    
    public LinkAttributesBuilder setLocalIpv6RouterId(Ipv6RouterIdentifier value) {
        this._localIpv6RouterId = value;
        return this;
    }
    
    public LinkAttributesBuilder setMaxLinkBandwidth(Bandwidth value) {
        this._maxLinkBandwidth = value;
        return this;
    }
    
    public LinkAttributesBuilder setMaxReservableBandwidth(Bandwidth value) {
        this._maxReservableBandwidth = value;
        return this;
    }
    
    public LinkAttributesBuilder setMetric(Metric value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _metric_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _metric_range));
            }
        }
        this._metric = value;
        return this;
    }
    public static List<Range<BigInteger>> _metric_range() {
        if (_metric_range == null) {
            synchronized (LinkAttributesBuilder.class) {
                if (_metric_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _metric_range = builder.build();
                }
            }
        }
        return _metric_range;
    }
    
    public LinkAttributesBuilder setMplsProtocol(MplsProtocolMask value) {
        this._mplsProtocol = value;
        return this;
    }
    
    public LinkAttributesBuilder setRemoteIpv4RouterId(Ipv4RouterIdentifier value) {
        this._remoteIpv4RouterId = value;
        return this;
    }
    
    public LinkAttributesBuilder setRemoteIpv6RouterId(Ipv6RouterIdentifier value) {
        this._remoteIpv6RouterId = value;
        return this;
    }
    
    public LinkAttributesBuilder setSdniLinkState(java.lang.String value) {
        this._sdniLinkState = value;
        return this;
    }
    
    public LinkAttributesBuilder setSharedRiskLinkGroups(List<SrlgId> value) {
        this._sharedRiskLinkGroups = value;
        return this;
    }
    
    public LinkAttributesBuilder setTeMetric(TeMetric value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _teMetric_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _teMetric_range));
            }
        }
        this._teMetric = value;
        return this;
    }
    public static List<Range<BigInteger>> _teMetric_range() {
        if (_teMetric_range == null) {
            synchronized (LinkAttributesBuilder.class) {
                if (_teMetric_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _teMetric_range = builder.build();
                }
            }
        }
        return _teMetric_range;
    }
    
    public LinkAttributesBuilder setUnreservedBandwidth(List<UnreservedBandwidth> value) {
        this._unreservedBandwidth = value;
        return this;
    }
    
    public LinkAttributesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public LinkAttributes build() {
        return new LinkAttributesImpl(this);
    }

    private static final class LinkAttributesImpl implements LinkAttributes {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes.class;
        }

        private final AdministrativeGroup _adminGroup;
        private final java.lang.String _linkName;
        private final LinkProtectionType _linkProtection;
        private final Ipv4RouterIdentifier _localIpv4RouterId;
        private final Ipv6RouterIdentifier _localIpv6RouterId;
        private final Bandwidth _maxLinkBandwidth;
        private final Bandwidth _maxReservableBandwidth;
        private final Metric _metric;
        private final MplsProtocolMask _mplsProtocol;
        private final Ipv4RouterIdentifier _remoteIpv4RouterId;
        private final Ipv6RouterIdentifier _remoteIpv6RouterId;
        private final java.lang.String _sdniLinkState;
        private final List<SrlgId> _sharedRiskLinkGroups;
        private final TeMetric _teMetric;
        private final List<UnreservedBandwidth> _unreservedBandwidth;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> augmentation = new HashMap<>();

        private LinkAttributesImpl(LinkAttributesBuilder base) {
            this._adminGroup = base.getAdminGroup();
            this._linkName = base.getLinkName();
            this._linkProtection = base.getLinkProtection();
            this._localIpv4RouterId = base.getLocalIpv4RouterId();
            this._localIpv6RouterId = base.getLocalIpv6RouterId();
            this._maxLinkBandwidth = base.getMaxLinkBandwidth();
            this._maxReservableBandwidth = base.getMaxReservableBandwidth();
            this._metric = base.getMetric();
            this._mplsProtocol = base.getMplsProtocol();
            this._remoteIpv4RouterId = base.getRemoteIpv4RouterId();
            this._remoteIpv6RouterId = base.getRemoteIpv6RouterId();
            this._sdniLinkState = base.getSdniLinkState();
            this._sharedRiskLinkGroups = base.getSharedRiskLinkGroups();
            this._teMetric = base.getTeMetric();
            this._unreservedBandwidth = base.getUnreservedBandwidth();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public AdministrativeGroup getAdminGroup() {
            return _adminGroup;
        }
        
        @Override
        public java.lang.String getLinkName() {
            return _linkName;
        }
        
        @Override
        public LinkProtectionType getLinkProtection() {
            return _linkProtection;
        }
        
        @Override
        public Ipv4RouterIdentifier getLocalIpv4RouterId() {
            return _localIpv4RouterId;
        }
        
        @Override
        public Ipv6RouterIdentifier getLocalIpv6RouterId() {
            return _localIpv6RouterId;
        }
        
        @Override
        public Bandwidth getMaxLinkBandwidth() {
            return _maxLinkBandwidth;
        }
        
        @Override
        public Bandwidth getMaxReservableBandwidth() {
            return _maxReservableBandwidth;
        }
        
        @Override
        public Metric getMetric() {
            return _metric;
        }
        
        @Override
        public MplsProtocolMask getMplsProtocol() {
            return _mplsProtocol;
        }
        
        @Override
        public Ipv4RouterIdentifier getRemoteIpv4RouterId() {
            return _remoteIpv4RouterId;
        }
        
        @Override
        public Ipv6RouterIdentifier getRemoteIpv6RouterId() {
            return _remoteIpv6RouterId;
        }
        
        @Override
        public java.lang.String getSdniLinkState() {
            return _sdniLinkState;
        }
        
        @Override
        public List<SrlgId> getSharedRiskLinkGroups() {
            return _sharedRiskLinkGroups;
        }
        
        @Override
        public TeMetric getTeMetric() {
            return _teMetric;
        }
        
        @Override
        public List<UnreservedBandwidth> getUnreservedBandwidth() {
            return _unreservedBandwidth;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_adminGroup == null) ? 0 : _adminGroup.hashCode());
            result = prime * result + ((_linkName == null) ? 0 : _linkName.hashCode());
            result = prime * result + ((_linkProtection == null) ? 0 : _linkProtection.hashCode());
            result = prime * result + ((_localIpv4RouterId == null) ? 0 : _localIpv4RouterId.hashCode());
            result = prime * result + ((_localIpv6RouterId == null) ? 0 : _localIpv6RouterId.hashCode());
            result = prime * result + ((_maxLinkBandwidth == null) ? 0 : _maxLinkBandwidth.hashCode());
            result = prime * result + ((_maxReservableBandwidth == null) ? 0 : _maxReservableBandwidth.hashCode());
            result = prime * result + ((_metric == null) ? 0 : _metric.hashCode());
            result = prime * result + ((_mplsProtocol == null) ? 0 : _mplsProtocol.hashCode());
            result = prime * result + ((_remoteIpv4RouterId == null) ? 0 : _remoteIpv4RouterId.hashCode());
            result = prime * result + ((_remoteIpv6RouterId == null) ? 0 : _remoteIpv6RouterId.hashCode());
            result = prime * result + ((_sdniLinkState == null) ? 0 : _sdniLinkState.hashCode());
            result = prime * result + ((_sharedRiskLinkGroups == null) ? 0 : _sharedRiskLinkGroups.hashCode());
            result = prime * result + ((_teMetric == null) ? 0 : _teMetric.hashCode());
            result = prime * result + ((_unreservedBandwidth == null) ? 0 : _unreservedBandwidth.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes)obj;
            if (_adminGroup == null) {
                if (other.getAdminGroup() != null) {
                    return false;
                }
            } else if(!_adminGroup.equals(other.getAdminGroup())) {
                return false;
            }
            if (_linkName == null) {
                if (other.getLinkName() != null) {
                    return false;
                }
            } else if(!_linkName.equals(other.getLinkName())) {
                return false;
            }
            if (_linkProtection == null) {
                if (other.getLinkProtection() != null) {
                    return false;
                }
            } else if(!_linkProtection.equals(other.getLinkProtection())) {
                return false;
            }
            if (_localIpv4RouterId == null) {
                if (other.getLocalIpv4RouterId() != null) {
                    return false;
                }
            } else if(!_localIpv4RouterId.equals(other.getLocalIpv4RouterId())) {
                return false;
            }
            if (_localIpv6RouterId == null) {
                if (other.getLocalIpv6RouterId() != null) {
                    return false;
                }
            } else if(!_localIpv6RouterId.equals(other.getLocalIpv6RouterId())) {
                return false;
            }
            if (_maxLinkBandwidth == null) {
                if (other.getMaxLinkBandwidth() != null) {
                    return false;
                }
            } else if(!_maxLinkBandwidth.equals(other.getMaxLinkBandwidth())) {
                return false;
            }
            if (_maxReservableBandwidth == null) {
                if (other.getMaxReservableBandwidth() != null) {
                    return false;
                }
            } else if(!_maxReservableBandwidth.equals(other.getMaxReservableBandwidth())) {
                return false;
            }
            if (_metric == null) {
                if (other.getMetric() != null) {
                    return false;
                }
            } else if(!_metric.equals(other.getMetric())) {
                return false;
            }
            if (_mplsProtocol == null) {
                if (other.getMplsProtocol() != null) {
                    return false;
                }
            } else if(!_mplsProtocol.equals(other.getMplsProtocol())) {
                return false;
            }
            if (_remoteIpv4RouterId == null) {
                if (other.getRemoteIpv4RouterId() != null) {
                    return false;
                }
            } else if(!_remoteIpv4RouterId.equals(other.getRemoteIpv4RouterId())) {
                return false;
            }
            if (_remoteIpv6RouterId == null) {
                if (other.getRemoteIpv6RouterId() != null) {
                    return false;
                }
            } else if(!_remoteIpv6RouterId.equals(other.getRemoteIpv6RouterId())) {
                return false;
            }
            if (_sdniLinkState == null) {
                if (other.getSdniLinkState() != null) {
                    return false;
                }
            } else if(!_sdniLinkState.equals(other.getSdniLinkState())) {
                return false;
            }
            if (_sharedRiskLinkGroups == null) {
                if (other.getSharedRiskLinkGroups() != null) {
                    return false;
                }
            } else if(!_sharedRiskLinkGroups.equals(other.getSharedRiskLinkGroups())) {
                return false;
            }
            if (_teMetric == null) {
                if (other.getTeMetric() != null) {
                    return false;
                }
            } else if(!_teMetric.equals(other.getTeMetric())) {
                return false;
            }
            if (_unreservedBandwidth == null) {
                if (other.getUnreservedBandwidth() != null) {
                    return false;
                }
            } else if(!_unreservedBandwidth.equals(other.getUnreservedBandwidth())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                LinkAttributesImpl otherImpl = (LinkAttributesImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.linkstate.path.attribute.link.state.attribute.link.attributes._case.LinkAttributes>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("LinkAttributes [");
            boolean first = true;
        
            if (_adminGroup != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_adminGroup=");
                builder.append(_adminGroup);
             }
            if (_linkName != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkName=");
                builder.append(_linkName);
             }
            if (_linkProtection != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_linkProtection=");
                builder.append(_linkProtection);
             }
            if (_localIpv4RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localIpv4RouterId=");
                builder.append(_localIpv4RouterId);
             }
            if (_localIpv6RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_localIpv6RouterId=");
                builder.append(_localIpv6RouterId);
             }
            if (_maxLinkBandwidth != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_maxLinkBandwidth=");
                builder.append(_maxLinkBandwidth);
             }
            if (_maxReservableBandwidth != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_maxReservableBandwidth=");
                builder.append(_maxReservableBandwidth);
             }
            if (_metric != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_metric=");
                builder.append(_metric);
             }
            if (_mplsProtocol != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_mplsProtocol=");
                builder.append(_mplsProtocol);
             }
            if (_remoteIpv4RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_remoteIpv4RouterId=");
                builder.append(_remoteIpv4RouterId);
             }
            if (_remoteIpv6RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_remoteIpv6RouterId=");
                builder.append(_remoteIpv6RouterId);
             }
            if (_sdniLinkState != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sdniLinkState=");
                builder.append(_sdniLinkState);
             }
            if (_sharedRiskLinkGroups != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sharedRiskLinkGroups=");
                builder.append(_sharedRiskLinkGroups);
             }
            if (_teMetric != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_teMetric=");
                builder.append(_teMetric);
             }
            if (_unreservedBandwidth != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_unreservedBandwidth=");
                builder.append(_unreservedBandwidth);
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
