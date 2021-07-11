package com.test.day01.ioc.dao;

import org.springframework.stereotype.Component;

@Component
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserMysqlDaoImpl的add方法被执行了");
    }
}
