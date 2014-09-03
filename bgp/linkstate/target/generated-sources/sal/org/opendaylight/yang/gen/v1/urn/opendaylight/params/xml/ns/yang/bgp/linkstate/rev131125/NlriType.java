package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.bgp.linkstate.rev131125;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 */
public enum NlriType {
    Node(1),
    
    Link(2),
    
    Ipv4Prefix(3),
    
    Ipv6Prefix(4)
    ;


    int value;
    static java.util.Map<java.lang.Integer, NlriType> valueMap;

    static {
        valueMap = new java.util.HashMap<>();
        for (NlriType enumItem : NlriType.values())
        {
            valueMap.put(enumItem.value, enumItem);
        }
    }

    private NlriType(int value) {
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
     * @return corresponding NlriType item
     */
    public static NlriType forValue(int valueArg) {
        return valueMap.get(valueArg);
    }
}
