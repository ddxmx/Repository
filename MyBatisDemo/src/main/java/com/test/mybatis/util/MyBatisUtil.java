package com.test.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类，封装SqlSessionFactory和SqlSession的获取
 */
public class MyBatisUtil {
    //sqlSessionFactory作用域贯穿整个MyBatis的生命周期，应该是单例的
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //类路径(target/classes)下的资源文件
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            //SqlSessionFactoryBuilder用于创建SqlSessionFactory，创建后就无用了，应该是局部变量
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession实例用于数据库操作
     * SqlSession最佳的作用域就是请求作用域或方法作用域
     *
     * @return
     */
    public static SqlSession getSession() {
        //true表示设置自动提交，增、删、改需要提交操作
        return sqlSessionFactory.openSession(true);
    }
}
