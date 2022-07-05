package com.test.basic.day04.annotation.bean;

import com.test.basic.day04.annotation.config.ContextConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {
    @Test
    public void annotationTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        Person person = context.getBean("person", Person.class);
        /*
            Person类中使用@Autowaired注解会在注入时调用一次该方法
            Person{name='张三', age=20, dog=Dog{name='大黄'}}
         */
        System.out.println(person);
        //Student student = context.getBean("getStudent",Student.class);
        Student student = context.getBean("stu", Student.class);
        System.out.println(student);
        Student student2 = context.getBean("student", Student.class);
        System.out.println(student2);
        System.out.println(student == student2);
    }
}