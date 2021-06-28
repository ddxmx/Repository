package com.test.day01.hello.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void defaultConstructorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-student.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void argsConstructorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-student.xml");
        Student student = context.getBean("student2", Student.class);
        System.out.println(student);
    }
}