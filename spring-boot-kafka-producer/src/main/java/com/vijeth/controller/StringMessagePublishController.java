package com.vijeth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringMessagePublishController {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message")String message){
        stringKafkaTemplate.send(topic, message);
        return "Successfully published to Kafka-Topic: '"+ topic +"', the message: "+message;
    }

}
