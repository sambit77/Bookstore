package com.ms.order.web.controllers.rabbitdemo;

import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    // @RabbitListener(queues = "${orders.new-orders-queue}")
    public void handleNewOrder(RabbitDemoController.MyPayload payload) {
        System.out.println("New Order " + payload.content());
    }

    // @RabbitListener(queues = "${orders.delivered-orders-queue}")
    public void handleDeliveredOrder(RabbitDemoController.MyPayload payload) {
        System.out.println("Delivered Order " + payload.content());
    }
}
