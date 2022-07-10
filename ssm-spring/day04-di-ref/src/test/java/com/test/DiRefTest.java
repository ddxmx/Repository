package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiRefTest {
    @Test
    public void diRefTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // 引用外部bean
        // Person(name=tom, age=30, car=Car(brand=宝马, price=300000.0))
        System.out.println(ctx.getBean("person", Person.class));

        // 创建内部bean
        // Person(name=jerry, age=32, car=Car(brand=奔驰, price=250000.0))
        System.out.println(ctx.getBean("person2", Person.class));

        // 构造方法引用外部bean
        // Person(name=jack, age=28, car=Car(brand=宝马, price=300000.0))
        System.out.println(ctx.getBean("person3", Person.class));
    }

    /**
     * 循环依赖的问题，只能使用set注入方式，不能使用构造器注入
     */
    @Test
    public void diRefCircularTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-circular.xml");
        Emp emp = ctx.getBean("emp", Emp.class);
        // Emp{ename='Smith', dept=研发部}
        System.out.println(emp);
        Emp emp2 = ctx.getBean("emp2", Emp.class);
        // Emp{ename='Helen', dept=研发部}
        System.out.println(emp2);
        Dept dept = ctx.getBean("dept", Dept.class);
        // Dept(dname=研发部, location=[伦敦, 纽约], emps=[Emp{ename='Smith', dept=研发部}, Emp{ename='Helen', dept=研发部}])
        System.out.println(dept);
    }
}
