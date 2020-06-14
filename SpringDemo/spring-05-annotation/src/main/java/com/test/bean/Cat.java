package com.test.bean;

import org.springframework.beans.factory.annotation.Value;

public class Cat {
    @Value("花花")
    private String name;

    public String getName() {
        return name;
    }
}
