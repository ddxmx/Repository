package com.test.day06.task;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskTest {

    @Test
    public void taskTest(){
        new ClassPathXmlApplicationContext("day06-task.xml");
        while (true){}
    }

    @Test
    public void monitorTest(){
        new ClassPathXmlApplicationContext("day06-task-annotation.xml");
        while (true){}
    }
}