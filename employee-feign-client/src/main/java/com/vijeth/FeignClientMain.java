package com.vijeth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class FeignClientMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientMain.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FeignClientMain.class, args);
        LOGGER.info("Feign-Client has started!");
    }
}
