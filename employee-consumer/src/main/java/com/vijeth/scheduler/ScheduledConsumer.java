package com.vijeth.scheduler;

import com.vijeth.controller.ConsumerClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledConsumer.class);

    @Autowired
    private ConsumerClientController consumerClientController;

    @Scheduled(fixedDelayString = "2000")
    public void schedule(){
        LOGGER.info("Employee details received: [{}]", consumerClientController.getEmployee());
    }

}
