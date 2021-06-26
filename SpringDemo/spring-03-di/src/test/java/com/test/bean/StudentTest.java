package com.test.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    @Test
    public void studentTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Student stu = context.getBean("student", Student.class);

        //String类型
        System.out.println(stu.getName());
        //对象类型
        System.out.println(stu.getAddress().getLocation());
        //数组
        System.out.println(Arrays.toString(stu.getBooks()));
        //list
        System.out.println(stu.getHobbies().toString());
        //map
        Set<Map.Entry<String, String>> entries = stu.getParents().entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + "->" + next.getValue());
        }
        //set
        Iterator<String> iterator2 = stu.getGames().iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + ",");
        }
        System.out.println();
        //null
        System.out.println(stu.getWife());
        //properties
        stu.getInfo().list(System.out);
    }

    @Test
    public void studentTest2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Student stu = context.getBean("student2", Student.class);
        System.out.println(stu.getName());
        System.out.println(stu.getParents());
    }
}