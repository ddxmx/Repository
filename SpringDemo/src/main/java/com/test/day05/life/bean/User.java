package com.test.day05.life.bean;

public class User {
    public User(){
        System.out.println("User对象被实例化...");
    }

    public void init(){
        System.out.println("User init");
    }

    public void destroy(){
        System.out.println("User destroy");
    }

    public void show(){
        System.out.println("User的show方法被执行...");
    }
}
