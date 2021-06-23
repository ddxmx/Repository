package com.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.getName());
    }
}