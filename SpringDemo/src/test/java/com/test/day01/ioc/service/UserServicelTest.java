package com.test.day01.ioc.service;

import com.test.day01.ioc.config.UserConfig;
import com.test.day01.ioc.dao.UserDao;
import com.test.day01.ioc.dao.UserMysqlDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserServicelTest {
    /**
     * 通过相对路径获取IOC容器中对象
     */
    @Test
    public void classPathXmlTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 通过绝对路径获取IOC容器中对象
     */
    @Test
    public void fileSystemXmlTest() {
        String filePath = "E:/IdeaProjects/spring-basic/ssm-spring/src/main/resources/day01-ioc.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(filePath);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 通过注解方式获取IOC容器中对象
     */
    @Test
    public void AnnotationConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        UserDao userDao = context.getBean(UserMysqlDaoImpl.class);
        userDao.add();
    }
}