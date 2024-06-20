package com.ms.order.domain;

public class InvalidOrderException extends RuntimeException {
    InvalidOrderException(String msg) {
        super(msg);
    }
}
