package com.vijeth.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vijeth.util.JsonDateDeserializer;
import com.vijeth.util.JsonDateSerializer;

import java.time.LocalDateTime;

public class Employee {
    private int id;
    private String name;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private LocalDateTime createdTime;

    public Employee(){}

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
