package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.IsisAreaIdentifier;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv4RouterIdentifier;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.TopologyIdentifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeFlagBits;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.Ipv6RouterIdentifier;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes
 */
public class NodeAttributesBuilder {

    private java.lang.String _dynamicHostname;
    private Ipv4RouterIdentifier _ipv4RouterId;
    private Ipv6RouterIdentifier _ipv6RouterId;
    private List<IsisAreaIdentifier> _isisAreaId;
    private NodeFlagBits _nodeFlags;
    private List<TopologyIdentifier> _topologyIdentifier;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> augmentation = new HashMap<>();

    public NodeAttributesBuilder() {
    } 
    
    public NodeAttributesBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState arg) {
        this._topologyIdentifier = arg.getTopologyIdentifier();
        this._nodeFlags = arg.getNodeFlags();
        this._isisAreaId = arg.getIsisAreaId();
        this._dynamicHostname = arg.getDynamicHostname();
        this._ipv4RouterId = arg.getIpv4RouterId();
        this._ipv6RouterId = arg.getIpv6RouterId();
    }

    public NodeAttributesBuilder(NodeAttributes base) {
        this._dynamicHostname = base.getDynamicHostname();
        this._ipv4RouterId = base.getIpv4RouterId();
        this._ipv6RouterId = base.getIpv6RouterId();
        this._isisAreaId = base.getIsisAreaId();
        this._nodeFlags = base.getNodeFlags();
        this._topologyIdentifier = base.getTopologyIdentifier();
        if (base instanceof NodeAttributesImpl) {
            NodeAttributesImpl _impl = (NodeAttributesImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState) {
            this._topologyIdentifier = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getTopologyIdentifier();
            this._nodeFlags = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getNodeFlags();
            this._isisAreaId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getIsisAreaId();
            this._dynamicHostname = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getDynamicHostname();
            this._ipv4RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getIpv4RouterId();
            this._ipv6RouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState)arg).getIpv6RouterId();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.NodeState] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getDynamicHostname() {
        return _dynamicHostname;
    }
    
    public Ipv4RouterIdentifier getIpv4RouterId() {
        return _ipv4RouterId;
    }
    
    public Ipv6RouterIdentifier getIpv6RouterId() {
        return _ipv6RouterId;
    }
    
    public List<IsisAreaIdentifier> getIsisAreaId() {
        return _isisAreaId;
    }
    
    public NodeFlagBits getNodeFlags() {
        return _nodeFlags;
    }
    
    public List<TopologyIdentifier> getTopologyIdentifier() {
        return _topologyIdentifier;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public NodeAttributesBuilder setDynamicHostname(java.lang.String value) {
        this._dynamicHostname = value;
        return this;
    }
    
    public NodeAttributesBuilder setIpv4RouterId(Ipv4RouterIdentifier value) {
        this._ipv4RouterId = value;
        return this;
    }
    
    public NodeAttributesBuilder setIpv6RouterId(Ipv6RouterIdentifier value) {
        this._ipv6RouterId = value;
        return this;
    }
    
    public NodeAttributesBuilder setIsisAreaId(List<IsisAreaIdentifier> value) {
        this._isisAreaId = value;
        return this;
    }
    
    public NodeAttributesBuilder setNodeFlags(NodeFlagBits value) {
        this._nodeFlags = value;
        return this;
    }
    
    public NodeAttributesBuilder setTopologyIdentifier(List<TopologyIdentifier> value) {
        this._topologyIdentifier = value;
        return this;
    }
    
    public NodeAttributesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public NodeAttributes build() {
        return new NodeAttributesImpl(this);
    }

    private static final class NodeAttributesImpl implements NodeAttributes {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes.class;
        }

        private final java.lang.String _dynamicHostname;
        private final Ipv4RouterIdentifier _ipv4RouterId;
        private final Ipv6RouterIdentifier _ipv6RouterId;
        private final List<IsisAreaIdentifier> _isisAreaId;
        private final NodeFlagBits _nodeFlags;
        private final List<TopologyIdentifier> _topologyIdentifier;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> augmentation = new HashMap<>();

        private NodeAttributesImpl(NodeAttributesBuilder base) {
            this._dynamicHostname = base.getDynamicHostname();
            this._ipv4RouterId = base.getIpv4RouterId();
            this._ipv6RouterId = base.getIpv6RouterId();
            this._isisAreaId = base.getIsisAreaId();
            this._nodeFlags = base.getNodeFlags();
            this._topologyIdentifier = base.getTopologyIdentifier();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public java.lang.String getDynamicHostname() {
            return _dynamicHostname;
        }
        
        @Override
        public Ipv4RouterIdentifier getIpv4RouterId() {
            return _ipv4RouterId;
        }
        
        @Override
        public Ipv6RouterIdentifier getIpv6RouterId() {
            return _ipv6RouterId;
        }
        
        @Override
        public List<IsisAreaIdentifier> getIsisAreaId() {
            return _isisAreaId;
        }
        
        @Override
        public NodeFlagBits getNodeFlags() {
            return _nodeFlags;
        }
        
        @Override
        public List<TopologyIdentifier> getTopologyIdentifier() {
            return _topologyIdentifier;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_dynamicHostname == null) ? 0 : _dynamicHostname.hashCode());
            result = prime * result + ((_ipv4RouterId == null) ? 0 : _ipv4RouterId.hashCode());
            result = prime * result + ((_ipv6RouterId == null) ? 0 : _ipv6RouterId.hashCode());
            result = prime * result + ((_isisAreaId == null) ? 0 : _isisAreaId.hashCode());
            result = prime * result + ((_nodeFlags == null) ? 0 : _nodeFlags.hashCode());
            result = prime * result + ((_topologyIdentifier == null) ? 0 : _topologyIdentifier.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes)obj;
            if (_dynamicHostname == null) {
                if (other.getDynamicHostname() != null) {
                    return false;
                }
            } else if(!_dynamicHostname.equals(other.getDynamicHostname())) {
                return false;
            }
            if (_ipv4RouterId == null) {
                if (other.getIpv4RouterId() != null) {
                    return false;
                }
            } else if(!_ipv4RouterId.equals(other.getIpv4RouterId())) {
                return false;
            }
            if (_ipv6RouterId == null) {
                if (other.getIpv6RouterId() != null) {
                    return false;
                }
            } else if(!_ipv6RouterId.equals(other.getIpv6RouterId())) {
                return false;
            }
            if (_isisAreaId == null) {
                if (other.getIsisAreaId() != null) {
                    return false;
                }
            } else if(!_isisAreaId.equals(other.getIsisAreaId())) {
                return false;
            }
            if (_nodeFlags == null) {
                if (other.getNodeFlags() != null) {
                    return false;
                }
            } else if(!_nodeFlags.equals(other.getNodeFlags())) {
                return false;
            }
            if (_topologyIdentifier == null) {
                if (other.getTopologyIdentifier() != null) {
                    return false;
                }
            } else if(!_topologyIdentifier.equals(other.getTopologyIdentifier())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NodeAttributesImpl otherImpl = (NodeAttributesImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.linkstate.route.attributes.attribute.type.node._case.NodeAttributes>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("NodeAttributes [");
            boolean first = true;
        
            if (_dynamicHostname != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dynamicHostname=");
                builder.append(_dynamicHostname);
             }
            if (_ipv4RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv4RouterId=");
                builder.append(_ipv4RouterId);
             }
            if (_ipv6RouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv6RouterId=");
                builder.append(_ipv6RouterId);
             }
            if (_isisAreaId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_isisAreaId=");
                builder.append(_isisAreaId);
             }
            if (_nodeFlags != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nodeFlags=");
                builder.append(_nodeFlags);
             }
            if (_topologyIdentifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_topologyIdentifier=");
                builder.append(_topologyIdentifier);
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
