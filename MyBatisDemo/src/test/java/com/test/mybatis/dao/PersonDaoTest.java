package com.test.mybatis.dao;

import com.test.mybatis.pojo.Person;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PersonDaoTest {
    Logger logger = Logger.getLogger(PersonDaoTest.class);

    @Test
    public void getPersonById() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Person per = mapper.getPersonById(1003);
            System.out.println(per);
        }
    }

    @Test
    public void getPersonByName() {
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");

        try (SqlSession session = MyBatisUtil.getSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Map<String, Object> map = mapper.getPersonByName("zhangsan");
            System.out.println(map.get("id"));
            System.out.println(map.get("name"));
            System.out.println(map.get("age"));
        }
    }
}