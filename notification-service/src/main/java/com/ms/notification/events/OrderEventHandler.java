package com.ms.notification.events;

import com.ms.notification.domain.NotificationService;
import com.ms.notification.domain.OrderEventEntity;
import com.ms.notification.domain.OrderEventRepository;
import com.ms.notification.domain.models.OrderCancelledEvent;
import com.ms.notification.domain.models.OrderCreatedEvent;
import com.ms.notification.domain.models.OrderDeliveredEvent;
import com.ms.notification.domain.models.OrderErrorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler {

    private static final Logger log = LoggerFactory.getLogger(OrderEventHandler.class);
    private final NotificationService notificationService;
    private final OrderEventRepository orderEventRepository;

    public OrderEventHandler(NotificationService notificationService, OrderEventRepository orderEventRepository) {
        this.notificationService = notificationService;
        this.orderEventRepository = orderEventRepository;
    }

    @RabbitListener(queues = "${notification.new-orders-queue}")
    public void handle(OrderCreatedEvent event) {
        log.info("Received a OrderCreatedEvent with orderNumber:{}: ", event.orderNumber());

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderCreatedEvent with eventID : " + event.eventId());
            return;
        }

        notificationService.sendOrderCreatedNotification(event);

        OrderEventEntity entity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(entity);
    }

    @RabbitListener(queues = "${notification.delivered-orders-queue}")
    public void handle(OrderDeliveredEvent event) {

        log.info("Received a OrderDeliveredEvent with orderNumber:{}: ", event.orderNumber());
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderDeliveredEvent event with eventID : " + event.eventId());
            return;
        }
        notificationService.sendOrderDeliveredNotification(event);

        OrderEventEntity entity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(entity);
    }

    @RabbitListener(queues = "${notification.cancelled-orders-queue}")
    public void handle(OrderCancelledEvent event) {

        notificationService.sendOrderCancelledNotification(event);
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderCancelledEvent with eventID : " + event.eventId());
            return;
        }
        log.info("Received a OrderCancelledEvent with orderNumber:{}: ", event.orderNumber());

        OrderEventEntity entity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(entity);
    }

    @RabbitListener(queues = "${notification.error-orders-queue}")
    public void handle(OrderErrorEvent event) {

        log.info("Received a OrderErrorEvent with orderNumber:{}: ", event.orderNumber());

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderErrorEvent with eventID : " + event.eventId());
            return;
        }
        notificationService.sendOrderErrorEventNotification(event);

        OrderEventEntity entity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(entity);
    }
}
