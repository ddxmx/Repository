package com.test.factory;

import com.test.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FactoryTest {
    @Test
    public void staticFactoryTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext-staticFactory.xml");
        Person person = context.getBean("person", Person.class);
        person.print();
    }

    @Test
    public void factoryTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext-factory.xml");
        Person person = context.getBean("person", Person.class);
        person.print();
    }
}