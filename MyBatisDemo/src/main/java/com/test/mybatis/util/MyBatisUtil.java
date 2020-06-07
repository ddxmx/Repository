package com.test.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    //sqlSessionFactory作用域贯穿整个MyBatis的生命周期
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 根据MyBatis核心配置文件，创建sqlSessionFactory工厂类
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession实例用于数据库操作
     * SqlSession最佳的作用域就是请求作用域
     *
     * @return
     */
    public static SqlSession getSession() {
        //设置自动提交，增、删、改需要提交操作
        return sqlSessionFactory.openSession(true);
    }
}
