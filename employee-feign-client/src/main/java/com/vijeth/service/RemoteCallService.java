package com.vijeth.service;

import com.vijeth.model.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="employee-producer", fallback = HystrixClientFallback.class)
public interface RemoteCallService {
    @RequestMapping(method = RequestMethod.GET, value = "/employee/create")
    public Employee getData();
}

@Component
class HystrixClientFallback implements RemoteCallService {
    @Override
    public Employee getData() {
        return new Employee(10, "Hystrix-Client-Fallback");
    }
}
