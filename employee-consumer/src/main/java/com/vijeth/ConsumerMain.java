package com.vijeth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMain.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsumerMain.class, args);
        LOGGER.info("Consumer has started!");
    }
}
