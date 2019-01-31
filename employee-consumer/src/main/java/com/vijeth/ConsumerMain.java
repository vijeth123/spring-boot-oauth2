package com.vijeth;

import com.vijeth.controller.ConsumerClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConsumerMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMain.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsumerMain.class, args);
        ConsumerClientController consumerClientController = context.getBean(ConsumerClientController.class);
        LOGGER.info("Employee details received: [{}]", consumerClientController.getEmployee());
    }
}
