package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 使用注解配置sql语句
 */
public class UserAnnotationDaoTest {
    @Test
    public void getUserById() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserAnnotationDao mapper = session.getMapper(UserAnnotationDao.class);
            System.out.println(mapper.getUserById(1002));
        }
    }

    @Test
    public void getUsers() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserAnnotationDao mapper = session.getMapper(UserAnnotationDao.class);
            List<User> list = mapper.getUsers();
            list.forEach(System.out::println);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserAnnotationDao mapper = session.getMapper(UserAnnotationDao.class);
            int count = mapper.addUser(new User(1007, "jack", 28));
            System.out.printf("更新了%s条数据\n", count);
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserAnnotationDao mapper = session.getMapper(UserAnnotationDao.class);
            int count = mapper.updateUser(new User(1007, "张三丰", 120));
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserAnnotationDao mapper = session.getMapper(UserAnnotationDao.class);
            System.out.println("更新了" + mapper.deleteUser(1007) + "条数据");
        }
    }
}