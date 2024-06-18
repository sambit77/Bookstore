package com.ms.catalog.domain;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String msg) {
        super(msg);
    }

    public static ProductNotFoundException forCode(String code) {
        return new ProductNotFoundException("Product with code " + code + " not found");
    }
}
