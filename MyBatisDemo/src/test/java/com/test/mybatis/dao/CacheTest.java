package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 默认情况下，只有一级缓存开启。（SqlSession级别的缓存，也称为本地缓存）
 * 二级缓存需要手动开启和配置，他是基于namespace级别的缓存
 */
public class CacheTest {
    /**
     * 一级缓存，同一个SqlSession，多次查询读取缓存
     */
    @Test
    public void cacheTest() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            mapper.getUserById(1002);
            //第二次查询时直接返回的缓存中的对象
            mapper.getUserById(1002);
        }
    }


    /**
     * SqlSession销毁，对应的一级缓存失效
     */
    @Test
    public void cacheTest2() {
        User user1 = null;
        User user2 = null;
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            user1 = mapper.getUserById(1002);
            System.out.println(user1);
        }

        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            user2 = mapper.getUserById(1002);
            System.out.println(user2);
        }
    }

    /**
     * SqlSession缓存中没有的数据就从数据库查询
     */
    @Test
    public void cacheTest3() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            mapper.getUserById(1001);
            mapper.getUserById(1002);
        }
    }

    /**
     * 查询之间进行增、删、改操作会清空对应SqlSession一级缓存
     */
    @Test
    public void cacheTest4() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user1 = mapper.getUserById(1001);
            System.out.println(user1);
            mapper.updateUser(new User(1005, "赵七", 25));
            User user2 = mapper.getUserById(1001);
            System.out.println(user2);
        }
    }

    /**
     * 执行clearCache可以清空对应SqlSession的一级缓存
     */
    @Test
    public void cacheTest5() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            User user1 = mapper.getUserById(1002);
            session.clearCache();
            mapper.getUserById(1002);
        }
    }

    /**
     * 查出的数据都会被默认先放在一级缓存中
     * 只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中
     */
    @Test
    public void cacheTest6() {
        User user1 = null;
        User user2 = null;
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            mapper.getUserById(1002);
        }

        try (SqlSession session = MyBatisUtil.getSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            mapper.getUserById(1002);
        }
    }
}
