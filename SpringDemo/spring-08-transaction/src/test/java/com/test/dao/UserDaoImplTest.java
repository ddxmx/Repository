package com.test.dao;

import com.test.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UserDaoImpl user = context.getBean("userDao", UserDaoImpl.class);
        user.trans(new User(1111, "zhangsan", 10));
    }
}