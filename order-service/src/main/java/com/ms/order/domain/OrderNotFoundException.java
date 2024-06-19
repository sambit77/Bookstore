package com.ms.order.domain;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String msg) {
        super(msg);
    }

    public static OrderNotFoundException forOrderNumber(String orderNumber) {
        return new OrderNotFoundException("Order with Number " + orderNumber + " not found");
    }
}
