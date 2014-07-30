package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.rib.rev130925.rib.Tables;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.linkstate.routes.LinkstateRoute;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import java.util.List;


/**
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-rib?revision=2013-09-25)bgp-rib/bgp-rib/rib/loc-rib/tables/routes/(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)linkstate-routes-case/linkstate-routes]
 */
public interface LinkstateRoutes
    extends
    ChildOf<Tables>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125.bgp.rib.rib.loc.rib.tables.routes.linkstate.routes._case.LinkstateRoutes>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:bgp-linkstate","2013-11-25","linkstate-routes");;

    /**
     * Link-state information entry. Due to the complexity of link-state information 
     * and YANG limitations this is the top-level object from contract perspective. It 
     * is keyed by route-key, whose format is internal to the implementation exposing 
     * this information. As an explicit example it can rely on information stored in 
     * the entry's subtree, so the subtree MUST NOT be modified by outside entities. 
     * Augmentations can attach data, but must be explicitly aware that such data, 
     * unlike the data modeled directly here, does not have any effects on keys, 
     * especially they must not impact equality tests.
     */
    List<LinkstateRoute> getLinkstateRoute();

}

