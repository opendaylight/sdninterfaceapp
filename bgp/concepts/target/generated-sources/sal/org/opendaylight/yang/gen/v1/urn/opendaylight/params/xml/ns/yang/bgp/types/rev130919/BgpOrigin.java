package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.types.rev130919;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 */
public enum BgpOrigin {
    Igp(0),
    
    Egp(1),
    
    Incomplete(2)
    ;


    int value;
    static java.util.Map<java.lang.Integer, BgpOrigin> valueMap;

    static {
        valueMap = new java.util.HashMap<>();
        for (BgpOrigin enumItem : BgpOrigin.values())
        {
            valueMap.put(enumItem.value, enumItem);
        }
    }

    private BgpOrigin(int value) {
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
     * @return corresponding BgpOrigin item
     */
    public static BgpOrigin forValue(int valueArg) {
        return valueMap.get(valueArg);
    }
}
