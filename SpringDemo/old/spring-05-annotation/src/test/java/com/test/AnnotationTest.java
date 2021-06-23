package com.test;

import com.test.bean.Cat;
import com.test.bean.Dog;
import com.test.bean.Person;
import com.test.bean.User;
import com.test.config.BeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
    }

    @Test
    public void personTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void dogTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Dog dog = context.getBean("getDog", Dog.class);
        System.out.println(dog.getName());

        Cat cat = context.getBean("getCat", Cat.class);
        System.out.println(cat.getName());
    }
}