package com.test.basic.day01.hello.dao;

import org.springframework.stereotype.Component;

/**
 * 使用@Component注解方式，自动发现bean
 */
@Component
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserMysqlDaoImpl的add方法被执行了");
    }
}
