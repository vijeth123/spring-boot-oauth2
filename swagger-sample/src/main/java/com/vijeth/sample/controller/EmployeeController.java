package com.vijeth.sample.controller;

import com.vijeth.sample.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("This end-point is responsible for creating a new employee.")
    public Employee createEmployee(){
        return new Employee(new Random().nextInt(), "Vijeth");
    }

}
