package com.test.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 */
@Aspect
public class UserLogPointCut {
    // 指定切入点表达式，拦截哪个类的哪些方法
    //使用@Pointcut这个注解，来指定切入点表达式，在用到的地方中，直接引用就行了
    @Pointcut("execution(* com.test.bean.User.*(..))")
    public void pt() {

    }

    //多个@Before会按照方法名字排序执行
    @Before("pt()")
    public void initLog(){
        System.out.println("初始化日志");
    }

    @Before("execution(* com.test.bean.User.*(..))")
    public void beforeLog() {
        System.out.println("方法调用准备");
    }

    @AfterReturning("execution(* com.test.bean.User.*(..))")
    public void afterLog() {
        System.out.println("方法调用结束");
    }
}
