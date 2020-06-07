package com.test.mybatis.dao;

import com.test.mybatis.pojo.Person;

import java.util.Map;

/**
 * Person类的字段不一致，使用ResultMap解决
 */
public interface PersonDao {
    public Person getPersonById(int id);

    public Map<String,Object> getPersonByName(String name);
}
