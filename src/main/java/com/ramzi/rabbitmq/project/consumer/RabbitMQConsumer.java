package com.ramzi.rabbitmq.project.consumer;

import com.ramzi.rabbitmq.project.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        log.info(String.format("Received message -> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void jsonConsume(User user){
        log.info(String.format("Received json message -> %s", user.toString()));
    }
}
