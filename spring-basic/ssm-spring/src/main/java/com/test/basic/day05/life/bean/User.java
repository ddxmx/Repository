package com.test.basic.day05.life.bean;

import javax.annotation.PreDestroy;


public class User {
    public User(){
        System.out.println("User对象被实例化...");
    }

    public void init(){
        System.out.println("User的init方法被执行...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("User的destroy方法被执行...");
    }
}
