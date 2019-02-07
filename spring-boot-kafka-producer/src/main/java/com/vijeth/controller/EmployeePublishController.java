package com.vijeth.controller;

import com.vijeth.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/employee")
public class EmployeePublishController {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Employee> employeeKafkaTemplate;

    @GetMapping("/publish")
    public String publish(){
        Employee employee = new Employee(new Random().nextInt(), "Vijeth");
        employeeKafkaTemplate.send(topic, employee);
        return "Successfully published to Kafka-Topic '"+topic+"', the employee-json with details: "+employee;
    }

}
