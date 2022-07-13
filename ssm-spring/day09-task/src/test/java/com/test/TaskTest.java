package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class TaskTest {
    /**
     * 定时任务使用xml配置
     */
    @Test
    public void xmlTaskTest() throws InterruptedException {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TimeUnit.MINUTES.sleep(10);
    }

    /**
     * 开启定时任务，使用注解配置
     */
    @Test
    public void annotationTaskTest() throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaskConfig.class);
        TimeUnit.MINUTES.sleep(10);
    }

    /**
     * 开启定时任务，使用xml配置
     */
    @Test
    public void xmlScheduleTaskTest() throws InterruptedException {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-xml-schedule.xml");
        TimeUnit.MINUTES.sleep(10);
    }
}