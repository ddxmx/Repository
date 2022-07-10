package com.test.aspect;

import com.test.config.LogConfig;
import com.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    /**
     * 前置、后置、最终通知
     */
    @Test
    public void xmlAspectTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-xml.xml");
        UserService service = context.getBean(UserService.class);
        /*
            getUser
            UserService
            com.test.service.UserService
            public
            [true]
            com.test.service.UserService
            com.test.service.UserService$$EnhancerBySpringCGLIB$$afa9d87a
            前置通知
            UserService的getUser方法被执行...
            后置通知，返回值：jerry
            最终通知
         */
        service.getUser(true);
    }

    /**
     * 异常通知
     */
    @Test
    public void xmlAfterAspectTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-xml.xml");
        UserService service = context.getBean(UserService.class);
        /*
            getUser
            UserService
            com.test.service.UserService
            public
            [false]
            com.test.service.UserService
            com.test.service.UserService$$EnhancerBySpringCGLIB$$afa9d87a
            前置通知
            UserService的getUser方法被执行...
            最终通知
            异常通知：参数错误，user不存在
         */
        service.getUser(false);
    }

    /**
     * 环绕通知
     */
    @Test
    public void xmlAroundAspectTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-xml-around.xml");
        UserService service = context.getBean(UserService.class);
        /*
            前置通知
            UserService的getUser方法被执行...
            后置通知：jerry
            最终通知
         */
        service.getUser(true);
    }

    /**
     * 使用注解设置切入点、通知、切面
     */
    @Test
    public void annotationAspectTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-annotation.xml");
        UserService service = context.getBean(UserService.class);
        /*
            前置通知
            UserService的getUser方法被执行...
            后置通知：jerry
            最终通知
         */
        service.getUser(true);
    }

    /**
     * 使用配置类
     */
    @Test
    public void configurationAspectTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LogConfig.class);
        UserService service = context.getBean(UserService.class);
        /*
            前置通知
            UserService的getUser方法被执行...
            异常通知：参数错误，user不存在
            最终通知
         */
        service.getUser(false);
    }
}