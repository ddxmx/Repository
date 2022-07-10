package com.test.annotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Student {
    @Value("Tom")
    private String name;

    @Value("20")
    private int age;

    // @Autowired不支持设置名称，先根据type，再根据name
    @Autowired
    private Teacher teacher;
}
