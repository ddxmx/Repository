package com.test.config;

import com.test.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigTest {
    @Test
    public void beanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

}
