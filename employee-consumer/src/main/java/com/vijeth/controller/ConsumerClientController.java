package com.vijeth.controller;

import com.vijeth.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ConsumerClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerClientController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    public Employee getEmployee() {
        final String instanceName = "employee-producer";
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(instanceName);

        if(serviceInstances == null || serviceInstances.isEmpty()){
            LOGGER.error("No instances registered with Eureka-server with the name: "+instanceName);
        }

        LOGGER.info("serviceInstances.size(): [{}]", serviceInstances.size());
        LOGGER.info("serviceInstances.get(0): [{}]", serviceInstances.get(0));
        LOGGER.info("serviceInstances.get(0).getHost(): [{}]", serviceInstances.get(0).getHost());
        LOGGER.info("serviceInstances.get(0).getPort(): [{}]", serviceInstances.get(0).getPort());
        LOGGER.info("serviceInstances.get(0).getUri(): [{}]", serviceInstances.get(0).getUri());
        LOGGER.info("serviceInstances.get(0).getServiceId(): [{}]", serviceInstances.get(0).getServiceId());
        LOGGER.info("serviceInstances.get(0).getMetadata(): [{}]", serviceInstances.get(0).getMetadata());

        String uri = serviceInstances.get(0).getUri().toString()+"/employee/create";

        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(uri, Employee.class);
        return employee;
    }
}
