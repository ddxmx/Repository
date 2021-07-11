package com.test.mybatis.dao;

import com.test.mybatis.pojo.Person;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class PersonDaoTest {
    @Test
    public void getPersonById() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Person per = mapper.getPersonById(1003);
            //Person{id=1003, username='王五', age=21}
            System.out.println(per);
        }
    }

    @Test
    public void getPersonByAge() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Map<String, Object> map = mapper.getPersonByAge(23);
            System.out.println(map.get("id"));
            System.out.println(map.get("name"));
            System.out.println(map.get("age"));
        }
    }
}