package com.test.xml;

import com.test.annotation.Emp;
import com.test.bean.EmpConfig;
import com.test.bean.TeacherConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImportTest {
    /**
     * xml中使用import
     */
    @Test
    public void xmlImportTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-student.xml");
        Student student = context.getBean(Student.class);
        // Student(name=Tom, teacher=Teacher(name=Helen))
        System.out.println(student);
    }

    /**
     * Configuration类中使用import导入Configuration类
     */
    @Test
    public void configurationImportTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
        Emp emp = context.getBean(Emp.class);
        // Emp(name=Tom, dept=Dept(name=纽约))
        System.out.println(emp);
    }

    /**
     * Configuration类中使用ImportResource导入xml文件
     */
    @Test
    public void configurationImportXmlTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TeacherConfig.class);
        Teacher teacher = context.getBean(Teacher.class);
        // Teacher(name=Helen)
        System.out.println(teacher);
    }

    /**
     * xml中引入Configuration类
     */
    @Test
    public void xmlImportConfigurationTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-emp.xml");
        Emp emp = context.getBean(Emp.class);
        // Emp(name=Jerry, dept=Dept(name=纽约))
        System.out.println(emp);
    }
}
