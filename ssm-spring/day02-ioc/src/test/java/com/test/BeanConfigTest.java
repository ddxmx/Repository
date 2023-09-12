package com.test;

import com.test.config.Emp;
import com.test.config.BeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigTest {
    /**
     * 在Configuration文件中使用@Bean进行Bean的注册
     */
    @Test
    public void beanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
