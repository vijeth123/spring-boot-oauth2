package com.vijeth.sample.model;

import java.time.LocalDateTime;

public class Employee {
    private int id;
    private String name;
    private LocalDateTime createdTime;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.createdTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
