package com.test.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Dao接口mongoDB实现
 */
@Component
// 和@Component一起使用，自动装配时当找到多个Bean时，被注解为@Primary的Bean将作为首选者
 @Primary
public class UserDaoMongoDBImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mongoDB get user");
    }
}
