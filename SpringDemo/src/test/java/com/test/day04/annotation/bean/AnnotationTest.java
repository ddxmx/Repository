package com.test.day04.annotation.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void annotationTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day04-annotation.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}