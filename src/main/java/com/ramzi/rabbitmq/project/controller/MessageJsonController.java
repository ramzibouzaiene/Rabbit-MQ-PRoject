package com.ramzi.rabbitmq.project.controller;

import com.ramzi.rabbitmq.project.dto.User;
import com.ramzi.rabbitmq.project.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class MessageJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/json-publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent");
    }
}
