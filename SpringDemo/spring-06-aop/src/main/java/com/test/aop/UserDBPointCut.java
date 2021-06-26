package com.test.aop;

public class UserDBPointCut {

    public void connect() {
        System.out.println("连接数据库");
    }

    public void disconnect() {
        System.out.println("断开数据库连接");
    }

}
