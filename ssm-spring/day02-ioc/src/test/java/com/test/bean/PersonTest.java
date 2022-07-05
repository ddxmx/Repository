package com.test.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class PersonTest {
    /**
     * 使用ClassPathXmlApplicationContext获取spring容器
     */
    @Test
    public void classPathXmlApplicationContextTest() {
        System.out.println("----------------加载spring配置文件-------------");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        System.out.println("----------------从spring容器中获取对象-------------");
        Person person = context.getBean("person", Person.class);
        person.print();
    }

    /**
     * 使用FileSystemXmlApplicationContext获取spring容器
     */
    @Test
    public void fileSystemXmlApplicationContextTest() {
        String path = PersonTest.class.getClassLoader().getResource("spring/applicationContext.xml").getPath();
        ApplicationContext context =
                new FileSystemXmlApplicationContext(path);
        Person person = context.getBean("person", Person.class);
        person.print();
    }

    /**
     * 容器中获取bean的方式
     */
    @Test
    public void getBeanTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        // 通过bean的id和类型获取bean
        ctx.getBean("person", Person.class).print(); // Person.print

        // 只通过类型获取bean，当存在多个相同类型的bean时将会出现异常
        ctx.getBean(Person.class).print(); // Person.print

        // 获取的是Spring⼯⼚配置⽂件中所有bean标签的id值
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames)); // [person]

        // 根据类型获得Spring配置⽂件中对应的id值
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        System.out.println(Arrays.toString(beanNamesForType)); // [person]

        // ⽤于判断是否存在指定的bean，只会根据id属性判断，不会根据name属性判断
        System.out.println(ctx.containsBeanDefinition("person")); // true
        System.out.println(ctx.containsBeanDefinition("per")); // false

        // ⽤于判断是否存在指定的bean，会根据id和name属性判断
        System.out.println(ctx.containsBean("person")); // true
        System.out.println(ctx.containsBean("per")); // true
        System.out.println(ctx.containsBean("test")); // false
    }
}