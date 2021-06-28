package com.test.day03.autowire.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {
    @Test
    public void autowireTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day03-autowire.xml");
        Worker worker = context.getBean("worker", Worker.class);
        System.out.println(worker);
    }
}