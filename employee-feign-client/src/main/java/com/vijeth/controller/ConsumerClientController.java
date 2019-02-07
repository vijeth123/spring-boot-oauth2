package com.vijeth.controller;

import com.vijeth.model.Employee;
import com.vijeth.service.RemoteCallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConsumerClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerClientController.class);

    @Autowired
    private RemoteCallService remoteCallService;

    public Employee getEmployee() {
        Employee employee = remoteCallService.getData();
        return employee;
    }
}
