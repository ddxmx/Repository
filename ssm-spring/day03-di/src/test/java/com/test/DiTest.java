package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
    /**
     * 构造方法注入
     */
    @Test
    public void constructorDiTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-constructor.xml");
        System.out.println(ctx.getBean("person", Person.class)); // Person(name=tom, age=21)
        System.out.println(ctx.getBean("person2", Person.class)); // Person(name=jack, age=18)
        System.out.println(ctx.getBean("person3", Person.class)); // Person(name=jerry, age=20)
    }

    /**
     * set注入
     */
    @Test
    public void setDiTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-set.xml");
        Member member = ctx.getBean("member", Member.class);
        /*
            Member(name=jerry, age=30,
            car=Car(brand=宝马, price=300000.0),
            books=[<<水浒传>>, <<三国演义>>, <<西游记>>, <<红楼梦>>],
            hobbies=[音乐, 画画, 游泳],
            parents={爸爸=35, 妈妈=34, 爷爷=60, 奶奶=58},
            games=[英雄联盟, 魔兽世界, 绝地求生],
            wife=null,
            info={语文=95, 英语=92, 数学=98})
         */
        System.out.println(member);
        System.out.println(null == member.getWife()); // true
    }

    /**
     * c标签简化构造器注入
     */
    @Test
    public void cDiTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-c.xml");
        System.out.println(ctx.getBean("person", Person.class)); // Person(name=zhangsan, age=12)
        System.out.println(ctx.getBean("person2", Person.class)); // Person(name=lisi, age=10)
    }

    /**
     * p标签简化set注入
     */
    @Test
    public void pDiTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-p.xml");
        System.out.println(ctx.getBean("car", Car.class)); // Car(brand=奔驰, price=250000.0)
        System.out.println(ctx.getBean("car2", Car.class)); // Car(brand=大众, price=180000.0)
    }
}