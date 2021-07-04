package com.test.mybatis.dao;

import com.test.mybatis.pojo.Person;

import java.util.Map;

/**
 * 使用user表，user表中的字段和Person类中的属性不一致
 * Person类的字段不一致，使用ResultMap解决
 */
public interface PersonDao {
    public Person getPersonById(int id);

    //查询到的结果转换为map对象存储
    public Map<String, Object> getPersonByName(String name);
}
