package com.test.mybatis.dao;

import com.test.mybatis.pojo.Student;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {

    @Test
    public void getStudents() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> list = mapper.getStudents();
            list.forEach(System.out::println);
        }
    }
}