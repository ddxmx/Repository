package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

public class UserDaoTest {
    @Test
    public void getUserById() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            //方式一：通过接口调用，接口和mapper.xml文件绑定
            UserDao mapper = session.getMapper(UserDao.class);
            System.out.println(mapper.getUserById(1002));

            //直接通过mapper.xml文件执行sql语句，statement=namespace.id，对namespace无严格的命名要求
//            User user = (User) session.selectOne("com.test.mybatis.dao.UserDao.getUserById", 1002);
//            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUsers() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUsers();

            //方式二
//            List<User> list = session.selectList("com.test.mybatis.dao.UserDao.getUsers");

            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByIdAndName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByIdAndName(1004, "zhuliu");
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByIdAndName2() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            Map<String, Object> map = new HashMap<>();
            //mapper.xml直接使用key值设置值
            map.put("pid", 1003);
            map.put("pname", "wangwu");
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByIdAndName2(map);
            list.forEach(System.out::println);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            int count = mapper.addUser(new User(1006, "scott", 30));
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession session = MyBatisUtil.getSession();) {
            UserDao mapper = session.getMapper(UserDao.class);
            int count = mapper.updateUser(new User(1006,
                    UUID.randomUUID().toString().replace("-", "").substring(0, 5), 18));
            System.out.println("更新了" + count + "条数据");
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            System.out.println("更新了" + mapper.deleteUser(1006) + "条数据");
        }
    }

    @Test
    public void getUserByLikeName() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByLikeName("%li%");
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getUserByPage() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> list = mapper.getUserByPage(1, 2);
            list.forEach(System.out::println);
        }
    }
}