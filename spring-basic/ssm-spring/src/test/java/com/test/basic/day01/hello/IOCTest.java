package com.test.basic.day01.hello;

import com.test.basic.day01.hello.bean.Student;
import com.test.basic.day01.hello.config.UserConfig;
import com.test.basic.day01.hello.dao.UserDao;
import com.test.basic.day01.hello.dao.UserMysqlDaoImpl;
import com.test.basic.day01.hello.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.Connection;

public class IOCTest {
    /**
     * 使用默认构造或带参构造注册Bean
     */
    @Test
    public void beanTest() {
        //ApplicationContext负责对象的创建和组装
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        //获取bean
        Student student = context.getBean("student", Student.class); //默认构造器生成的对象
        System.out.println(student); //Student(name=null, age=0)
        //带参构造器生成的对象
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2); //Student(name=jerry, age=12)
    }

    /**
     * 测试ConnectionFactoryBean方式
     */
    @Test
    public void connFactoryBeanTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        Connection conn = context.getBean("conn", Connection.class);
        System.out.println(conn);
    }


    /**
     * 通过静态工厂和非静态工厂注册Bean
     */
    @Test
    public void factoryTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
        UserService userService = context.getBean("userServiceBean", UserService.class);
        userService.add(); //UserMysqlDaoImpl的add方法被执行了
        Student student = context.getBean("studentBean", Student.class);
        student.tell(); //我是一个学生~
    }

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
