package com.test.mybatis.dao;

import com.test.mybatis.pojo.Teacher;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher();
            System.out.println(teacher);
        }
    }
}