package com.test.day01.ioc.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void defaultConstructorTest() {
        //ApplicationContext负责对象的创建和组装
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-student.xml");
        //获取bean
        Student student = context.getBean("student", Student.class); //默认构造器生成的对象
        System.out.println(student);
    }

    @Test
    public void argsConstructorTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc-student.xml");
        //带参构造器生成的对象
        Student student = context.getBean("student2", Student.class);
        System.out.println(student);
    }
}