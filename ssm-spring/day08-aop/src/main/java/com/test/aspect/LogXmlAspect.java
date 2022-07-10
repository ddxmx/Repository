package com.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 定义切面类
 * 切面是切入点和通知的集合
 * 切入点：定义要拦截的方法
 * 通知：方法拦截的时机和执行的操作
 */
public class LogXmlAspect {
    /**
     * 方法执行前执行
     */
    public void before(JoinPoint joinPoint) {
        // 获取目标方法名
        System.out.println(joinPoint.getSignature().getName()); // getUser
        // 获取目标方法所属类的简单类名
        System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName()); // UserService
        // 获取目标方法所属类的类名
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()); // com.test.service.UserService
        // 获取目标方法声明类型(public、private、protected)
        System.out.println(Modifier.toString(joinPoint.getSignature().getModifiers())); // public
        // 获取传入目标方法的参数，返回一个数组
        System.out.println(Arrays.toString(joinPoint.getArgs())); // [true]
        // 获取被代理的对象
        System.out.println(joinPoint.getTarget().getClass().getName()); // com.test.service.UserService
        // 获取代理对象自己
        // com.test.service.UserService$$EnhancerBySpringCGLIB$$afa9d87a
        System.out.println(joinPoint.getThis().getClass().getName());

        System.out.println("前置通知");
    }

    /**
     * 目标方法无异常返回后执行
     * JoinPoint可以获取切入点的信息
     */
    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("后置通知，返回值：" + result);
    }

    /**
     * 目标方法执行无论是否有异常都会执行
     */
    public void after(JoinPoint joinPoint) {
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
            System.out.println("后置通知：" + result);
        } catch (Throwable e) {
            System.out.println("异常通知");
            e.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }

        return result;
    }
}
