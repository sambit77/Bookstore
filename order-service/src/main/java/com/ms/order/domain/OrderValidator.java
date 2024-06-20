package com.ms.order.domain;

import com.ms.order.clients.catalog.Product;
import com.ms.order.clients.catalog.ProductServiceClient;
import com.ms.order.domain.models.CreateOrderRequest;
import com.ms.order.domain.models.OrderItem;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    private static final Logger logger = LoggerFactory.getLogger(OrderValidator.class);

    private final ProductServiceClient client;

    public OrderValidator(ProductServiceClient productServiceClient) {
        this.client = productServiceClient;
    }

    void validate(CreateOrderRequest request) {
        Set<OrderItem> items = request.items();
        for (OrderItem item : items) {
            Product product = client.getProductByCode(item.code())
                    .orElseThrow(() -> new InvalidOrderException("Invalid Product Code : " + item.code()));
            if (item.price().compareTo(product.price()) != 0) {
                logger.error(
                        "Product price is not matching. Actual price:{}, received price:{}",
                        product.price(),
                        item.price());
                throw new InvalidOrderException("Product price is not matching");
            }
        }
    }
}
