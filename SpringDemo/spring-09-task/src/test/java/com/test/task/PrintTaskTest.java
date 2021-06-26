package com.test.task;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintTaskTest {
    @Test
    public void taskTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        while (true){
        }
    }
}