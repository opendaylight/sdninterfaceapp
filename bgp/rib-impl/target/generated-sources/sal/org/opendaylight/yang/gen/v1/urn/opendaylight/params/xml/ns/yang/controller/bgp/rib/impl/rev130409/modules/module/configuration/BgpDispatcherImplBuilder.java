package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.BossGroup;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.WorkerGroup;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.Md5ServerChannelFactory;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.BgpExtensions;
import java.util.Map;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.Md5ChannelFactory;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl} instances.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl
 */
public class BgpDispatcherImplBuilder {

    private BgpExtensions _bgpExtensions;
    private BossGroup _bossGroup;
    private Md5ChannelFactory _md5ChannelFactory;
    private Md5ServerChannelFactory _md5ServerChannelFactory;
    private WorkerGroup _workerGroup;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> augmentation = new HashMap<>();

    public BgpDispatcherImplBuilder() {
    } 
    

    public BgpDispatcherImplBuilder(BgpDispatcherImpl base) {
        this._bgpExtensions = base.getBgpExtensions();
        this._bossGroup = base.getBossGroup();
        this._md5ChannelFactory = base.getMd5ChannelFactory();
        this._md5ServerChannelFactory = base.getMd5ServerChannelFactory();
        this._workerGroup = base.getWorkerGroup();
        if (base instanceof BgpDispatcherImplImpl) {
            BgpDispatcherImplImpl _impl = (BgpDispatcherImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public BgpExtensions getBgpExtensions() {
        return _bgpExtensions;
    }
    
    public BossGroup getBossGroup() {
        return _bossGroup;
    }
    
    public Md5ChannelFactory getMd5ChannelFactory() {
        return _md5ChannelFactory;
    }
    
    public Md5ServerChannelFactory getMd5ServerChannelFactory() {
        return _md5ServerChannelFactory;
    }
    
    public WorkerGroup getWorkerGroup() {
        return _workerGroup;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public BgpDispatcherImplBuilder setBgpExtensions(BgpExtensions value) {
        this._bgpExtensions = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setBossGroup(BossGroup value) {
        this._bossGroup = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setMd5ChannelFactory(Md5ChannelFactory value) {
        this._md5ChannelFactory = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setMd5ServerChannelFactory(Md5ServerChannelFactory value) {
        this._md5ServerChannelFactory = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setWorkerGroup(WorkerGroup value) {
        this._workerGroup = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl> augmentation) {
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }

    public BgpDispatcherImpl build() {
        return new BgpDispatcherImplImpl(this);
    }

    private static final class BgpDispatcherImplImpl implements BgpDispatcherImpl {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl.class;
        }

        private final BgpExtensions _bgpExtensions;
        private final BossGroup _bossGroup;
        private final Md5ChannelFactory _md5ChannelFactory;
        private final Md5ServerChannelFactory _md5ServerChannelFactory;
        private final WorkerGroup _workerGroup;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> augmentation = new HashMap<>();

        private BgpDispatcherImplImpl(BgpDispatcherImplBuilder base) {
            this._bgpExtensions = base.getBgpExtensions();
            this._bossGroup = base.getBossGroup();
            this._md5ChannelFactory = base.getMd5ChannelFactory();
            this._md5ServerChannelFactory = base.getMd5ServerChannelFactory();
            this._workerGroup = base.getWorkerGroup();
                switch (base.augmentation.size()) {
                case 0:
                    this.augmentation = Collections.emptyMap();
                    break;
                    case 1:
                        final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> e = base.augmentation.entrySet().iterator().next();
                        this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>singletonMap(e.getKey(), e.getValue());       
                    break;
                default :
                    this.augmentation = new HashMap<>(base.augmentation);
                }
        }

        @Override
        public BgpExtensions getBgpExtensions() {
            return _bgpExtensions;
        }
        
        @Override
        public BossGroup getBossGroup() {
            return _bossGroup;
        }
        
        @Override
        public Md5ChannelFactory getMd5ChannelFactory() {
            return _md5ChannelFactory;
        }
        
        @Override
        public Md5ServerChannelFactory getMd5ServerChannelFactory() {
            return _md5ServerChannelFactory;
        }
        
        @Override
        public WorkerGroup getWorkerGroup() {
            return _workerGroup;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_bgpExtensions == null) ? 0 : _bgpExtensions.hashCode());
            result = prime * result + ((_bossGroup == null) ? 0 : _bossGroup.hashCode());
            result = prime * result + ((_md5ChannelFactory == null) ? 0 : _md5ChannelFactory.hashCode());
            result = prime * result + ((_md5ServerChannelFactory == null) ? 0 : _md5ServerChannelFactory.hashCode());
            result = prime * result + ((_workerGroup == null) ? 0 : _workerGroup.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl)obj;
            if (_bgpExtensions == null) {
                if (other.getBgpExtensions() != null) {
                    return false;
                }
            } else if(!_bgpExtensions.equals(other.getBgpExtensions())) {
                return false;
            }
            if (_bossGroup == null) {
                if (other.getBossGroup() != null) {
                    return false;
                }
            } else if(!_bossGroup.equals(other.getBossGroup())) {
                return false;
            }
            if (_md5ChannelFactory == null) {
                if (other.getMd5ChannelFactory() != null) {
                    return false;
                }
            } else if(!_md5ChannelFactory.equals(other.getMd5ChannelFactory())) {
                return false;
            }
            if (_md5ServerChannelFactory == null) {
                if (other.getMd5ServerChannelFactory() != null) {
                    return false;
                }
            } else if(!_md5ServerChannelFactory.equals(other.getMd5ServerChannelFactory())) {
                return false;
            }
            if (_workerGroup == null) {
                if (other.getWorkerGroup() != null) {
                    return false;
                }
            } else if(!_workerGroup.equals(other.getWorkerGroup())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpDispatcherImplImpl otherImpl = (BgpDispatcherImplImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("BgpDispatcherImpl [");
            boolean first = true;
        
            if (_bgpExtensions != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bgpExtensions=");
                builder.append(_bgpExtensions);
             }
            if (_bossGroup != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bossGroup=");
                builder.append(_bossGroup);
             }
            if (_md5ChannelFactory != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_md5ChannelFactory=");
                builder.append(_md5ChannelFactory);
             }
            if (_md5ServerChannelFactory != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_md5ServerChannelFactory=");
                builder.append(_md5ServerChannelFactory);
             }
            if (_workerGroup != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_workerGroup=");
                builder.append(_workerGroup);
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
