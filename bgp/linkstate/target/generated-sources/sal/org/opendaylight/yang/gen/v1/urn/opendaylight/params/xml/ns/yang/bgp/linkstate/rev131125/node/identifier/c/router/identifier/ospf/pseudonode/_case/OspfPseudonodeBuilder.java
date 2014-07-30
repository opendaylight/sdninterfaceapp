package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case;
import com.google.common.collect.Range;
import java.util.Collections;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfInterfaceIdentifier;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)node-identifier/node-identifier/c-router-identifier/ospf-pseudonode-case/ospf-pseudonode]
 */
public class OspfPseudonodeBuilder {

    private OspfInterfaceIdentifier _lanInterface;
    private static List<Range<BigInteger>> _lanInterface_range;
    private java.lang.Long _ospfRouterId;
    private static List<Range<BigInteger>> _ospfRouterId_range;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> augmentation = new HashMap<>();

    public OspfPseudonodeBuilder() {
    } 
    
    public OspfPseudonodeBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfV3LanIdentifier arg) {
        this._lanInterface = arg.getLanInterface();
        this._ospfRouterId = arg.getOspfRouterId();
    }
    
    public OspfPseudonodeBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier arg) {
        this._ospfRouterId = arg.getOspfRouterId();
    }

    public OspfPseudonodeBuilder(OspfPseudonode base) {
        this._lanInterface = base.getLanInterface();
        this._ospfRouterId = base.getOspfRouterId();
        if (base instanceof OspfPseudonodeImpl) {
            OspfPseudonodeImpl _impl = (OspfPseudonodeImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier</li>
     * <li>org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfV3LanIdentifier</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier) {
            this._ospfRouterId = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier)arg).getOspfRouterId();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfV3LanIdentifier) {
            this._lanInterface = ((org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfV3LanIdentifier)arg).getLanInterface();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfRouterIdentifier, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.OspfV3LanIdentifier] \n" +
              "but was: " + arg
            );
        }
    }

    public OspfInterfaceIdentifier getLanInterface() {
        return _lanInterface;
    }
    
    public java.lang.Long getOspfRouterId() {
        return _ospfRouterId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public OspfPseudonodeBuilder setLanInterface(OspfInterfaceIdentifier value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value.getValue());
            boolean isValidRange = false;
            for (Range<BigInteger> r : _lanInterface_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _lanInterface_range));
            }
        }
        this._lanInterface = value;
        return this;
    }
    public static List<Range<BigInteger>> _lanInterface_range() {
        if (_lanInterface_range == null) {
            synchronized (OspfPseudonodeBuilder.class) {
                if (_lanInterface_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _lanInterface_range = builder.build();
                }
            }
        }
        return _lanInterface_range;
    }
    
    public OspfPseudonodeBuilder setOspfRouterId(java.lang.Long value) {
        if (value != null) {
            BigInteger _constraint = BigInteger.valueOf(value);
            boolean isValidRange = false;
            for (Range<BigInteger> r : _ospfRouterId_range()) {
                if (r.contains(_constraint)) {
                    isValidRange = true;
                }
            }
            if (!isValidRange) {
                throw new IllegalArgumentException(String.format("Invalid range: %s, expected: %s.", value, _ospfRouterId_range));
            }
        }
        this._ospfRouterId = value;
        return this;
    }
    public static List<Range<BigInteger>> _ospfRouterId_range() {
        if (_ospfRouterId_range == null) {
            synchronized (OspfPseudonodeBuilder.class) {
                if (_ospfRouterId_range == null) {
                    ImmutableList.Builder<Range<BigInteger>> builder = ImmutableList.builder();
                    builder.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(4294967295L)));
                    _ospfRouterId_range = builder.build();
                }
            }
        }
        return _ospfRouterId_range;
    }
    
    public OspfPseudonodeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public OspfPseudonode build() {
        return new OspfPseudonodeImpl(this);
    }

    private static final class OspfPseudonodeImpl implements OspfPseudonode {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode.class;
        }

        private final OspfInterfaceIdentifier _lanInterface;
        private final java.lang.Long _ospfRouterId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> augmentation = new HashMap<>();

        private OspfPseudonodeImpl(OspfPseudonodeBuilder base) {
            this._lanInterface = base.getLanInterface();
            this._ospfRouterId = base.getOspfRouterId();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public OspfInterfaceIdentifier getLanInterface() {
            return _lanInterface;
        }
        
        @Override
        public java.lang.Long getOspfRouterId() {
            return _ospfRouterId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.node.identifier.c.router.identifier.ospf.pseudonode._case.OspfPseudonode>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_lanInterface == null) ? 0 : _lanInterface.hashCode());
            result = prime * result + ((_ospfRouterId == null) ? 0 : _ospfRouterId.hashCode());
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
            OspfPseudonodeImpl other = (OspfPseudonodeImpl) obj;
            if (_lanInterface == null) {
                if (other._lanInterface != null) {
                    return false;
                }
            } else if(!_lanInterface.equals(other._lanInterface)) {
                return false;
            }
            if (_ospfRouterId == null) {
                if (other._ospfRouterId != null) {
                    return false;
                }
            } else if(!_ospfRouterId.equals(other._ospfRouterId)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("OspfPseudonode [");
            boolean first = true;
        
            if (_lanInterface != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_lanInterface=");
                builder.append(_lanInterface);
             }
            if (_ospfRouterId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ospfRouterId=");
                builder.append(_ospfRouterId);
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
