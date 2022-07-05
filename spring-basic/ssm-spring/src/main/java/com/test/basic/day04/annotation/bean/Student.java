package com.test.basic.day04.annotation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Student {
    @Value("李四")
    private String name;
    @Value("18")
    private int age;
    private Teacher teacher;

    public Student(Teacher teacher){
        this.teacher = teacher;
    }
}
