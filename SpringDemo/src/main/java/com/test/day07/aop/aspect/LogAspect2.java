package com.test.day07.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 定义切面类
 * 切面是切入点和通知的集合
 * 切入点：定义要拦截的方法
 * 通知：方法拦截的时机和执行的操作
 */
@Component
public class LogAspect2 {

    /**
     * 方法执行前执行
     */
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 目标方法无异常返回后执行
     */
    public void afterReturn() {
        System.out.println("返回通知");
    }

    /**
     * 目标方法执行无论是否有异常都会执行
     */
    public void after() {
        System.out.println("最终通知");
    }

    /**
     * 异常通知，出现异常后执行
     *
     * @param e
     */
    public void afterThrow(Exception e) {
        System.out.println("异常通知：" + e.getMessage());
    }

    /**
     * 环绕通知
     */
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("前置通知");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("返回通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }

        return result;
    }
}
