package com.vijeth.sample.controller;

import com.vijeth.sample.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/create/{id}/{name}")
    public Employee createEmployeeWithIdAndName(@PathVariable("id") int id, @PathVariable("name") String name){
        return new Employee(id, name);
    }

    @GetMapping("/create")
    public Employee createEmployee(){
        return new Employee(new Random().nextInt(), "Vijeth");
    }

}
