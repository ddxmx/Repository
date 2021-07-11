package com.test.mybatis.dao;

import com.test.mybatis.pojo.Student;
import com.test.mybatis.pojo.Teacher;

import java.util.List;

public interface StudentTeacherDao {
    public List<Student> getStudents();

    public Teacher getTeacher();
}
