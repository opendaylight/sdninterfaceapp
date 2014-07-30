package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.BossGroup;
import java.util.Collections;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.Md5ServerChannelFactory;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.WorkerGroup;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.BgpExtensions;
import java.util.Map;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.Md5ChannelFactory;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.bgp.dispatcher.impl.Timer;
import org.opendaylight.yangtools.yang.binding.Augmentation;


/**
 * Module name:
 *     bgp-rib-impl
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:controller:config?revision=2013-04-05)modules/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:bgp:rib:impl?revision=2013-04-09)bgp-dispatcher-impl]
 */
public class BgpDispatcherImplBuilder {

    private BgpExtensions _bgpExtensions;
    private Timer _timer;
    private BossGroup _bossGroup;
    private WorkerGroup _workerGroup;
    private Md5ChannelFactory _md5ChannelFactory;
    private Md5ServerChannelFactory _md5ServerChannelFactory;

    private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> augmentation = new HashMap<>();

    public BgpDispatcherImplBuilder() {
    } 
    

    public BgpDispatcherImplBuilder(BgpDispatcherImpl base) {
        this._bgpExtensions = base.getBgpExtensions();
        this._timer = base.getTimer();
        this._bossGroup = base.getBossGroup();
        this._workerGroup = base.getWorkerGroup();
        this._md5ChannelFactory = base.getMd5ChannelFactory();
        this._md5ServerChannelFactory = base.getMd5ServerChannelFactory();
        if (base instanceof BgpDispatcherImplImpl) {
            BgpDispatcherImplImpl _impl = (BgpDispatcherImplImpl) base;
            this.augmentation = new HashMap<>(_impl.augmentation);
        }
    }


    public BgpExtensions getBgpExtensions() {
        return _bgpExtensions;
    }
    
    public Timer getTimer() {
        return _timer;
    }
    
    public BossGroup getBossGroup() {
        return _bossGroup;
    }
    
    public WorkerGroup getWorkerGroup() {
        return _workerGroup;
    }
    
    public Md5ChannelFactory getMd5ChannelFactory() {
        return _md5ChannelFactory;
    }
    
    public Md5ServerChannelFactory getMd5ServerChannelFactory() {
        return _md5ServerChannelFactory;
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
    
    public BgpDispatcherImplBuilder setTimer(Timer value) {
        this._timer = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setBossGroup(BossGroup value) {
        this._bossGroup = value;
        return this;
    }
    
    public BgpDispatcherImplBuilder setWorkerGroup(WorkerGroup value) {
        this._workerGroup = value;
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
        private final Timer _timer;
        private final BossGroup _bossGroup;
        private final WorkerGroup _workerGroup;
        private final Md5ChannelFactory _md5ChannelFactory;
        private final Md5ServerChannelFactory _md5ServerChannelFactory;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.bgp.rib.impl.rev130409.modules.module.configuration.BgpDispatcherImpl>> augmentation = new HashMap<>();

        private BgpDispatcherImplImpl(BgpDispatcherImplBuilder base) {
            this._bgpExtensions = base.getBgpExtensions();
            this._timer = base.getTimer();
            this._bossGroup = base.getBossGroup();
            this._workerGroup = base.getWorkerGroup();
            this._md5ChannelFactory = base.getMd5ChannelFactory();
            this._md5ServerChannelFactory = base.getMd5ServerChannelFactory();
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
        public Timer getTimer() {
            return _timer;
        }
        
        @Override
        public BossGroup getBossGroup() {
            return _bossGroup;
        }
        
        @Override
        public WorkerGroup getWorkerGroup() {
            return _workerGroup;
        }
        
        @Override
        public Md5ChannelFactory getMd5ChannelFactory() {
            return _md5ChannelFactory;
        }
        
        @Override
        public Md5ServerChannelFactory getMd5ServerChannelFactory() {
            return _md5ServerChannelFactory;
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
            result = prime * result + ((_timer == null) ? 0 : _timer.hashCode());
            result = prime * result + ((_bossGroup == null) ? 0 : _bossGroup.hashCode());
            result = prime * result + ((_workerGroup == null) ? 0 : _workerGroup.hashCode());
            result = prime * result + ((_md5ChannelFactory == null) ? 0 : _md5ChannelFactory.hashCode());
            result = prime * result + ((_md5ServerChannelFactory == null) ? 0 : _md5ServerChannelFactory.hashCode());
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
            BgpDispatcherImplImpl other = (BgpDispatcherImplImpl) obj;
            if (_bgpExtensions == null) {
                if (other._bgpExtensions != null) {
                    return false;
                }
            } else if(!_bgpExtensions.equals(other._bgpExtensions)) {
                return false;
            }
            if (_timer == null) {
                if (other._timer != null) {
                    return false;
                }
            } else if(!_timer.equals(other._timer)) {
                return false;
            }
            if (_bossGroup == null) {
                if (other._bossGroup != null) {
                    return false;
                }
            } else if(!_bossGroup.equals(other._bossGroup)) {
                return false;
            }
            if (_workerGroup == null) {
                if (other._workerGroup != null) {
                    return false;
                }
            } else if(!_workerGroup.equals(other._workerGroup)) {
                return false;
            }
            if (_md5ChannelFactory == null) {
                if (other._md5ChannelFactory != null) {
                    return false;
                }
            } else if(!_md5ChannelFactory.equals(other._md5ChannelFactory)) {
                return false;
            }
            if (_md5ServerChannelFactory == null) {
                if (other._md5ServerChannelFactory != null) {
                    return false;
                }
            } else if(!_md5ServerChannelFactory.equals(other._md5ServerChannelFactory)) {
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
            if (_timer != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_timer=");
                builder.append(_timer);
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
            if (_workerGroup != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_workerGroup=");
                builder.append(_workerGroup);
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
