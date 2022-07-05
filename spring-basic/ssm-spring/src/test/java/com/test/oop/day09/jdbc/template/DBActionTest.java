package com.test.oop.day09.jdbc.template;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBActionTest {
    @Test
    public void dbTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day09-spring-template.xml");
        DBAction dbAction = context.getBean(DBAction.class);
        dbAction.add();
        dbAction.update();
        dbAction.delete();
        dbAction.selectOne();
        dbAction.selectList();
        dbAction.count();
    }
}