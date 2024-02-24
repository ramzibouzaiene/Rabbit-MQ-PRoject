package com.ramzi.rabbitmq.project.publisher;

import com.ramzi.rabbitmq.project.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.json.routing.key.name}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user){
        log.info(String.format("Json Message sent to Rabbit MQ -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, user);
    }
}
