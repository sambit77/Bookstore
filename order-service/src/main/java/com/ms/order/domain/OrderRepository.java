package com.ms.order.domain;

import com.ms.order.domain.models.OrderStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus(OrderStatus status);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

    default void updateOrderStatus(String orderNumber, OrderStatus status) {
        OrderEntity order = this.findByOrderNumber(orderNumber).orElseThrow();
        order.setStatus(status);
        this.save(order);
    }
}
