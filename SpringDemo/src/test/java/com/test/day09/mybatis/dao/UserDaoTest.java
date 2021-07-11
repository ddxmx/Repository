package com.test.day09.mybatis.dao;

import com.test.day09.mybatis.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoTest {

    @Test
    public void getUserById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = factory.openSession(true)) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user = mapper.getUserById(1002);
            System.out.println(user);
        }
    }
}