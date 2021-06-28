package com.test.day07.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面类
 * 切面是切入点和通知的集合
 * 切入点：定义要拦截的方法
 * 通知：方法拦截的时机和执行的操作
 */
@Component
//切面类注解
@Aspect
public class LogAspect {

    /*
            execution(<修饰符模式>? <返回类型模式> <方法名模式>(<参数模式>) <异常模式>?)
            除了返回类型模式、方法名模式和参数模式外，其它项都是可选的。

            <!-- 【拦截所有public方法】 -->
            <!-- execution(public * *(..)) -->

            <!-- 【拦截所有save开头的方法 】 -->
            <!-- execution(* save*(..)) -->

            <!-- 【拦截指定类的指定方法, 拦截时候一定要定位到方法】 -->
            <!-- execution(public * cn.itcast.g_pointcut.OrderDao.save(..)) -->

            <!-- 【拦截指定类的所有方法】 -->
            <!-- execution(* cn.itcast.g_pointcut.UserDao.*(..)) -->

            <!-- 【拦截指定包，以及其自包下所有类的所有方法】 -->
            <!-- execution(* cn..*.*(..)) -->

            <!-- 【取非值】 -->
            <!-- !execution(* cn.itcast.g_pointcut.OrderDao.save() -->
     */
    // 定义切入点
    @Pointcut("execution(* com.test.day07.aop.service.*.*(..))")
    private void cut() {
    }

    /**
     * 方法执行前执行
     */
    //@Before("cut()")
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 这里的返回指定的是切入点方法正常执行返回
     * 目标方法无异常返回后执行
     */
    //@AfterReturning("cut()")
    public void afterReturn() {
        System.out.println("返回通知");
    }

    /**
     * 目标方法执行无论是否有异常都会执行
     */
    //@After("cut()")
    public void after() {
        System.out.println("最终通知");
    }

    /**
     * 异常通知，出现异常后执行
     *
     * @param e
     */
    //@AfterThrowing(value = "cut()", throwing = "e")
    public void afterThrow(Exception e) {
        System.out.println("异常通知：" + e.getMessage());
    }

    /**
     * 环绕通知
     */
    @Around("cut()")
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
