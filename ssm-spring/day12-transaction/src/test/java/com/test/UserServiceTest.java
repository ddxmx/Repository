package com.test;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void doUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day11-transaction.xml");
        //非事务操作
        context.getBean(UserDao.class).addUser(new User(3000, "张无忌", 25));

        //事务操作
        UserService service = context.getBean(UserService.class);
        User user = new User(3001, "张三丰", 120);
        service.doUser(user, 3000);
    }
}