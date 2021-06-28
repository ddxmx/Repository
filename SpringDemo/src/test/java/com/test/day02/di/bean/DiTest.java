package com.test.day02.di.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
    @Test
    public void setDiTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day02-di-set.xml");
        Person person = context.getBean("person", Person.class);
        // Person{name='jerry', age=30, car=Car{brind='宝马', price=300000.0}, books=[三国演义, 水浒传, 西游记, 红楼梦],
        // hobbies=[读书, 音乐, 唱歌], parents={爸爸=35, 妈妈=32, 爷爷=60, 奶奶=58}, games=[英雄联盟, 魔兽世界, 绝地求生],
        // wife='null', info={语文=95, 英语=92, 数学=98}}
        System.out.println(person);
    }

    @Test
    public void constructorDiTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day02-di-constructor.xml");
        Worker worker = context.getBean("worker", Worker.class);
        System.out.println(worker); //Worker{name='zhangsan', age=30, car=Car{brind='奔驰', price=250000.0}}
    }

    /**
     * 构造器注入的循环依赖，只能使用set注入方式解决
     */
    @Test
    public void constructorDiTest2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day02-di-constructor2.xml");
        Emp emp = context.getBean("emp", Emp.class);
        Dept dept = context.getBean("dept", Dept.class);
        System.out.println(emp);
        System.out.println(dept);
    }

    /**
     * p标签和c标签
     */
    @Test
    public void pAndCDiTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day02-di-p-c.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car); //Car{brind='大众', price=150000.0}
        Car car2 = context.getBean("car2", Car.class);
        System.out.println(car2); //Car{brind='奥迪', price=400000.0}
    }
}