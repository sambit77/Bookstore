package com.ms.order.listeners;

import com.ms.order.web.controllers.rabbitdemo.RabbitDemoController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ErrorOrderQueueConsumer {

    @RabbitListener(queues = "${orders.error-orders-queue}")
    public void handleNewOrder(RabbitDemoController.MyPayload payload) {
        System.out.println("Order errored out, forwarding to support team  " + payload.content());
    }
}
