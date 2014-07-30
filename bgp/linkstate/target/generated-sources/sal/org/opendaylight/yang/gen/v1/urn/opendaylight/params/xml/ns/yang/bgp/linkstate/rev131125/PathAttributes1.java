package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.message.rev130919.update.PathAttributes;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.update.path.attributes.LinkstatePathAttribute;
import org.opendaylight.yangtools.yang.binding.Augmentation;


public interface PathAttributes1
    extends
    DataObject,
    Augmentation<PathAttributes>
{




    LinkstatePathAttribute getLinkstatePathAttribute();

}

