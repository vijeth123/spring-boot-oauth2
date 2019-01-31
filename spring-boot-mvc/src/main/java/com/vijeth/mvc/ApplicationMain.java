package com.vijeth.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.vijeth.mvc.repository")
@EntityScan("com.vijeth.mvc.model")
@SpringBootApplication(scanBasePackages = "com.vijeth.mvc")
public class ApplicationMain {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ApplicationMain.class);
    }
}
