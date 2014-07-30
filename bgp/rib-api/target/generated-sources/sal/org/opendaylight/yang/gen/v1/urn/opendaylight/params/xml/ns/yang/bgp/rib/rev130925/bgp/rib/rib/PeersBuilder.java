package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.peers.AdjRibOut;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.peers.AdjRibIn;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-rib
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-rib?revision=2013-09-25)bgp-rib/bgp-rib/rib/peers]
 */
public class PeersBuilder {

    private AdjRibIn _adjRibIn;
    private AdjRibOut _adjRibOut;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> augmentation = new HashMap<>();

    public PeersBuilder() {
    } 

    public PeersBuilder(Peers base) {
        this._adjRibIn = base.getAdjRibIn();
        this._adjRibOut = base.getAdjRibOut();
        if (base instanceof PeersImpl) {
            PeersImpl _impl = (PeersImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public AdjRibIn getAdjRibIn() {
        return _adjRibIn;
    }
    
    public AdjRibOut getAdjRibOut() {
        return _adjRibOut;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PeersBuilder setAdjRibIn(AdjRibIn value) {
        this._adjRibIn = value;
        return this;
    }
    
    public PeersBuilder setAdjRibOut(AdjRibOut value) {
        this._adjRibOut = value;
        return this;
    }
    
    public PeersBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public Peers build() {
        return new PeersImpl(this);
    }

    private static final class PeersImpl implements Peers {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers.class;
        }

        private final AdjRibIn _adjRibIn;
        private final AdjRibOut _adjRibOut;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> augmentation = new HashMap<>();

        private PeersImpl(PeersBuilder base) {
            this._adjRibIn = base.getAdjRibIn();
            this._adjRibOut = base.getAdjRibOut();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public AdjRibIn getAdjRibIn() {
            return _adjRibIn;
        }
        
        @Override
        public AdjRibOut getAdjRibOut() {
            return _adjRibOut;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.bgp.rib.rib.Peers>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_adjRibIn == null) ? 0 : _adjRibIn.hashCode());
            result = prime * result + ((_adjRibOut == null) ? 0 : _adjRibOut.hashCode());
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
            PeersImpl other = (PeersImpl) obj;
            if (_adjRibIn == null) {
                if (other._adjRibIn != null) {
                    return false;
                }
            } else if(!_adjRibIn.equals(other._adjRibIn)) {
                return false;
            }
            if (_adjRibOut == null) {
                if (other._adjRibOut != null) {
                    return false;
                }
            } else if(!_adjRibOut.equals(other._adjRibOut)) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Peers [");
            boolean first = true;
        
            if (_adjRibIn != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_adjRibIn=");
                builder.append(_adjRibIn);
             }
            if (_adjRibOut != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_adjRibOut=");
                builder.append(_adjRibOut);
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
