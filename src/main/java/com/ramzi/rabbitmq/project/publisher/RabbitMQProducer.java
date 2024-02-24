package com.ramzi.rabbitmq.project.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
