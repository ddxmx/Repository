package com.test.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserLog {

    @Before("execution(* com.test.bean.User.*(..))")
    public void beforeLog() {
        System.out.println("方法调用准备");
    }

    @AfterReturning("execution(* com.test.bean.User.*(..))")
    public void afterLog() {
        System.out.println("方法调用结束");
    }
}
