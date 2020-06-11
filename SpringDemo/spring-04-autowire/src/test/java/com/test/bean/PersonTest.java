package com.test.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    @Test
    public void personTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        person.getDog().shout();
        person.getCat().shout();
    }
}