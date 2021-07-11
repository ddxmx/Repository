package com.test.mybatis.dao;

import com.test.mybatis.pojo.Student;
import com.test.mybatis.pojo.Teacher;
import com.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTeacherDaoTest {
    @Test
    public void getStudents() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StudentTeacherDao mapper = session.getMapper(StudentTeacherDao.class);
            List<Student> list = mapper.getStudents();
            /*
                Student{id=2001, name='小明', teacher=Teacher{id=1001, name='张老师', students=null}}
                Student{id=2002, name='小红', teacher=Teacher{id=1001, name='张老师', students=null}}
                Student{id=2003, name='小张', teacher=Teacher{id=1001, name='张老师', students=null}}
                Student{id=2004, name='小李', teacher=Teacher{id=1001, name='张老师', students=null}}
                Student{id=2005, name='小王', teacher=Teacher{id=1001, name='张老师', students=null}}
             */
            list.forEach(System.out::println);
        }
    }

    @Test
    public void getTeacher() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StudentTeacherDao mapper = session.getMapper(StudentTeacherDao.class);
            Teacher teacher = mapper.getTeacher();
            /*
                Teacher{id=1001,
                    name='张老师',
                    students=[Student{id=2001, name='小明', teacher=null},
                        Student{id=2002, name='小红', teacher=null},
                        Student{id=2003, name='小张', teacher=null},
                        Student{id=2004, name='小李', teacher=null},
                        Student{id=2005, name='小王', teacher=null}]
                }
             */
            System.out.println(teacher);
        }
    }
}