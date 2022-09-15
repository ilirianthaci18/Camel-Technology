package org.ubt.order.common.enums;

import java.util.EnumSet;

public enum OrderStatus {
    NEW("NEW"),
    HOLD("HOLD"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED"),
    CLOSED("CLOSED");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue(){return value;}

    public static OrderStatus fromString(String value){
        if(value==null) return  null;

        return EnumSet.allOf(OrderStatus.class)
                .stream()
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException(String.format("Unsupported type %s",value)));
    }
}
