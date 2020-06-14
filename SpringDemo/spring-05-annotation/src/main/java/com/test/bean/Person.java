package com.test.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    @Value("jack")
    private String name;
    @Value("20")
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
