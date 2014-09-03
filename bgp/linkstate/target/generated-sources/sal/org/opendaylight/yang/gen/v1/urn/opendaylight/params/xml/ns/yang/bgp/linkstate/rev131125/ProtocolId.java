package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;


/**
 * The enumeration built-in type represents values from a set of assigned names.
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
