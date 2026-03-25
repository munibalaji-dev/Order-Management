package com.munibalaji.OrderManagement.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatus {

    PLACED,
    DELIVERED,
    SHIPPED,
    CANCELLED;

    @JsonCreator
    public static OrderStatus from(String value){
        try {
            return OrderStatus.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Order Status: "+value);
        }
    }


}
