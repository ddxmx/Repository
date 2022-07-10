package com.test;

import com.test.annotation.Student;
import com.test.config.UserConfig;
import com.test.service.UserService;
import com.test.service.UserServicePrimaryImpl;
import com.test.service.UserServiceQualifierImpl;
import com.test.service.UserServiceResourceImpl;
import com.test.xml.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {
    /**
     * xml方式自动装配
     */
    @Test
    public void xmlAutowireTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Emp emp = ctx.getBean("emp", Emp.class);
        // com.test.xml.Emp{ename='Smith', dept=Dept(dname=研发部)}
        System.out.println(emp);
    }

    /**
     * annotation方式自动装配
     */
    @Test
    public void annotationAutowireTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("spring/applicationContext-annotation.xml");
        Student student = ctx.getBean("student", Student.class);
        // Student(name=Tom, age=20, teacher=Teacher(name=Helen))
        System.out.println(student);
    }

    /**
     * 自动装配bean唯一性
     *
     * @Primary 、@Qualifier 和 @Resource
     * @Qualifier比@Primary优先级高
     */
    @Test
    public void autowireKeyWordTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        // @Primary使用
        UserService userService = context.getBean(UserServicePrimaryImpl.class);
        userService.getUser(); // mongoDB get user

        // @Qualifier使用
        UserService userService2 = context.getBean(UserServiceQualifierImpl.class);
        userService2.getUser(); // mysql get user

        // @Resource使用
        UserService userService3 = context.getBean(UserServiceResourceImpl.class);
        userService3.getUser(); // oracle get user
    }
}