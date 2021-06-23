package com.test.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    @Test
    public void DI1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Student stu = context.getBean("student", Student.class);
        System.out.println(stu.getName());
        System.out.println(stu.getAddress().getLocation());
        System.out.println(Arrays.toString(stu.getBooks()));
        System.out.println(stu.getHobbies().toString());
        Set<Map.Entry<String, String>> entries = stu.getParents().entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + "->" + next.getValue());
        }
        Iterator<String> iterator2 = stu.getGames().iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + ",");
        }
        System.out.println();
        System.out.println(stu.getWife());
        stu.getInfo().list(System.out);
    }

}