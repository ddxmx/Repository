package com.test.factory;

import com.test.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    /**
     * 静态工厂类不需要先实例化工厂类对象
     */
    @Test
    public void staticFactoryTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext-staticFactory.xml");
        Person person = context.getBean("person", Person.class);
        person.print();
    }

    /**
     * 非静态工厂类，需要先实例化工厂类对象
     */
    @Test
    public void factoryTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext-factory.xml");
        Person person = context.getBean("person", Person.class);
        person.print();
    }
}