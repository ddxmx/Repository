package com.test;

import com.test.dao.UserDaoMysqlImpl;
import com.test.dao.UserDaoOracleImpl;
import com.test.service.UserService;
import com.test.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    /**
     * 程序设计的演进
     * service和dao的耦合->service中通过set方法传入dao
     * 但是和客户端依然有耦合，需要在客户端中修改传入的dao，需要重新编译客户端代码
     */
    @Test
    public void getUser() {
        UserServiceImpl service = new UserServiceImpl();

        // 传入mysql dao实现类
        service.setUserDao(new UserDaoMysqlImpl());
        service.getUser(); // mysql get user

        // 传入oracle dao实现类
        service.setUserDao(new UserDaoOracleImpl());
        service.getUser(); // oracle get user
    }

    /**
     * 通过xml文件修改替换class文件的编译
     * 修改实际传入的dao，只需要修改xml文件
     */
    @Test
    public void springGetUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.getUser();
    }
}