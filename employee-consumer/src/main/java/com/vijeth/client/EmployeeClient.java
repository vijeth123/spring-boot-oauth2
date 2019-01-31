package com.vijeth.client;

import com.vijeth.model.Employee;
import org.springframework.web.client.RestTemplate;

public class EmployeeClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject("http://localhost:8080/employee/create", Employee.class);
        System.out.println(employee);
    }
}
