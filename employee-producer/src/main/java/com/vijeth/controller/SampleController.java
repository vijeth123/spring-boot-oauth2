package com.vijeth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@Api(value="Sample Controller", description="Just for a demo!")
public class SampleController {

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @GetMapping(value = "hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
