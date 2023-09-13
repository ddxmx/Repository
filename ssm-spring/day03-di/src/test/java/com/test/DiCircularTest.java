package com.test;

import com.test.bean.circular.Dept;
import com.test.bean.circular.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiCircularTest {
    /**
     * 循环依赖的问题，只能使用set注入方式，不能使用构造器注入
     */
    @Test
    public void diRefCircularTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext-circular.xml");

        Emp emp = ctx.getBean("emp", Emp.class);
        System.out.println(emp); // Emp{ename='Smith', dept=研发部}

        Emp emp2 = ctx.getBean("emp2", Emp.class);
        System.out.println(emp2); // Emp{ename='Helen', dept=研发部}

        Dept dept = ctx.getBean("dept", Dept.class);
        System.out.println(dept); // Dept(dname=研发部, emps=[Emp{ename='Smith', dept=研发部}, Emp{ename='Helen', dept=研发部}])
    }
}
