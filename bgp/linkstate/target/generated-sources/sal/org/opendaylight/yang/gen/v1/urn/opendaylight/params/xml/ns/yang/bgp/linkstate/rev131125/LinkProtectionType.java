package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 */
public enum LinkProtectionType {
    ExtraTraffic(1),
    
    Unprotected(2),
    
    Shared(4),
    
    Dedicated1to1(8),
    
    Dedicated1plus1(16),
    
    Enhanced(32)
    ;


    int value;
    static java.util.Map<java.lang.Integer, LinkProtectionType> valueMap;

    static {
        valueMap = new java.util.HashMap<>();
        for (LinkProtectionType enumItem : LinkProtectionType.values())
        {
            valueMap.put(enumItem.value, enumItem);
        }
    }

    private LinkProtectionType(int value) {
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
     * @return corresponding LinkProtectionType item
     */
    public static LinkProtectionType forValue(int valueArg) {
        return valueMap.get(valueArg);
    }
}
