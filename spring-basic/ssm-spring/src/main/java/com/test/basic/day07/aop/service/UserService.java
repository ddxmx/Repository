package com.test.basic.day07.aop.service;

public class UserService {
    public String getUser() {
        System.out.println("UserService的getUser方法被执行...");
        //System.out.println(1/0);
        return "jerry";
    }
}
