package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 * Reference:
 *     https://tools.ietf.org/html/rfc6020#section-9.6
 * Module name:
 *     bgp-linkstate
 * Schema path:
 *     [(urn:opendaylight:params:xml:ns:yang:bgp-linkstate?revision=2013-11-25)protocol-id/protocol-id/(urn:ietf:params:xml:ns:yang:1)enumeration]
 */
public enum ProtocolId {
    Unknown(0),
    
    IsisLevel1(1),
    
    IsisLevel2(2),
    
    Ospf(3),
    
    Direct(4),
    
    Static(5)
    ;


    int value;
    static java.util.Map<java.lang.Integer, ProtocolId> valueMap;

    static {
        valueMap = new java.util.HashMap<>();
        for (ProtocolId enumItem : ProtocolId.values())
        {
            valueMap.put(enumItem.value, enumItem);
        }
    }

    private ProtocolId(int value) {
        this.value = value;
    }
    
    /**
     * @return integer value
     */
    public int getIntValue() {
        return value;
    }

    /**
     * @param valueArg
     * @return corresponding ProtocolId item
     */
    public static ProtocolId forValue(int valueArg) {
        return valueMap.get(valueArg);
    }
}
