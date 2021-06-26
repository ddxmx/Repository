package com.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    @Value("大黄")
    private String name;

    public String getName() {
        return name;
    }
}
