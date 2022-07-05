package com.test;

public class User {
    public User() {
        System.out.println("User对象被实例化...");
    }

    /**
     * 对象创建后调用的方法，在构造方法之后执行
     */
    public void init() {
        System.out.println("User的init方法被执行...");
    }

    /**
     * 对象销毁前调用的方法
     */
    public void destroy() {
        System.out.println("User的destroy方法被执行...");
    }
}
