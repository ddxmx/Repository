package com.test.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public String getUser(boolean exist) {
        System.out.println("UserService的getUser方法被执行...");
        if (!exist) {
            throw new ArithmeticException("参数错误，user不存在");
        }
        return "jerry";
    }
}
