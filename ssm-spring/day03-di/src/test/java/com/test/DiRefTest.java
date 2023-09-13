package com.test;

import com.test.bean.Driver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiRefTest {
    /**
     * 构造器注入，引用其他bean
     */
    @Test
    public void DiRefCTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-ref.xml");
        Driver driver = ctx.getBean("cDriver", Driver.class);
        System.out.println(driver);
    }

    /**
     * set注入，引用其他bean
     */
    @Test
    public void DiRefPTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-ref.xml");
        Driver driver = ctx.getBean("pDriver", Driver.class);
        System.out.println(driver);
    }
}
