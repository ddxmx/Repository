package com.test.day07.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void getUser() {
        System.out.println("UserService的getUser方法被执行");
        //System.out.println(1/0);
    }
}
