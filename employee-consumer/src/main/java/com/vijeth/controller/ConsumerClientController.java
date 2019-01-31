package com.vijeth.controller;

import com.vijeth.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ConsumerClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerClientController.class);

    @Autowired
    private LoadBalancerClient client;

    public Employee getEmployee() {
        final String instanceName = "employee-producer";
        ServiceInstance serviceInstance = client.choose(instanceName);

        if(serviceInstance == null){
            LOGGER.error("No instance registered with Eureka-server with the name: "+instanceName);
        }

        LOGGER.info("serviceInstance: [{}]", serviceInstance);
        LOGGER.info("serviceInstance.getHost(): [{}]", serviceInstance.getHost());
        LOGGER.info("serviceInstance.getPort(): [{}]", serviceInstance.getPort());
        LOGGER.info("serviceInstance.getUri(): [{}]", serviceInstance.getUri());
        LOGGER.info("serviceInstance.getServiceId(): [{}]", serviceInstance.getServiceId());
        LOGGER.info("serviceInstance.getMetadata(): [{}]", serviceInstance.getMetadata());

        String uri = serviceInstance.getUri().toString()+"/employee/create";

        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("Calling REST URI: [{}]", uri);
        Employee employee = restTemplate.getForObject(uri, Employee.class);
        return employee;
    }
}
