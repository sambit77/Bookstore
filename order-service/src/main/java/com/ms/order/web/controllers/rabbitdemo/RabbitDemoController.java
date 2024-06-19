package com.ms.order.web.controllers.rabbitdemo;

import com.ms.order.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitDemoController {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties applicationProperties;


    public RabbitDemoController(RabbitTemplate rabbitTemplate, ApplicationProperties applicationProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.applicationProperties = applicationProperties;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody MyMessage mymessage)
    {
        rabbitTemplate.convertAndSend(
                applicationProperties.orderEventsExchange(),mymessage.routingKey(),mymessage.payload()
        );
    }

    public record MyMessage(String routingKey, MyPayload payload){};
    public record MyPayload(String content){};
}
