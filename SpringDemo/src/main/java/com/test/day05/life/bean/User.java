package com.test.day05.life.bean;

public class User {
    public User(){
        System.out.println("User对象被实例化...");
    }

    public void init(){
        System.out.println("User的init方法被执行...");
    }

    public void destroy(){
        System.out.println("User的destroy方法被执行...");
    }
}
