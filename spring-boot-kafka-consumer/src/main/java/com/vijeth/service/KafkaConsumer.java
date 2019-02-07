package com.vijeth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"spring-boot-topic"}, groupId = "string_message_group")
    public void consume(String message){
        LOGGER.info("KafkaConsumer consumed the message: [{}]", message);
    }

}
