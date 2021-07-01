package com.test.day01.ioc.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl类的add方法被执行了...");
    }
}
