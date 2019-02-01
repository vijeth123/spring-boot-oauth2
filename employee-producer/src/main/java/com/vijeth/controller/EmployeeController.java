package com.vijeth.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vijeth.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/employee")
@Api(description = "Employee Controller is responsible for CRUD operations with Employee", tags = "Employee-Controller")
public class EmployeeController {

    @GetMapping("/create/{id}/{name}")
    @ApiOperation(value = "This end-point is responsible for creating a new employee with id and name.")
    public Employee createEmployeeWithIdAndName(@PathVariable("id") int id, @PathVariable("name") String name){
        return new Employee(id, name);
    }

    @GetMapping("/create")
    @HystrixCommand(fallbackMethod = "createEmployeeFallBack")
    @ApiOperation("This end-point is responsible for creating a new employee.")
    public Employee createEmployee(){
        return new Employee(new Random().nextInt(), "Vijeth");
    }

    /**
     * This is the Hytrix fall-back method that gets called when there is any failure on calling createEmployee() method.
     * @return
     */
    public Employee createEmployeeFallBack(){
        return new Employee(new Random().nextInt(), "FallBack");
    }

}
