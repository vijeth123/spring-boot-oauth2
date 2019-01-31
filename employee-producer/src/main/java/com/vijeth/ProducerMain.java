package com.vijeth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.vijeth")
@EnableDiscoveryClient
public class ProducerMain {
    public static void main(String[] args) {
        SpringApplication.run(ProducerMain.class);
    }
}
