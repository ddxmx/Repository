package com.test.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationTest {
    @Test
    public void contextTest(){
        //指定路径下获取spring配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("e:/user.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void helloTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Hello hello = context.getBean("hello", Hello.class);
        Hello myhello = context.getBean("myhello", Hello.class);
        Hello hello2 = context.getBean("hello2", Hello.class);
        Hello hello3 = context.getBean("hello3", Hello.class);
        Hello hello4 = context.getBean("hello4", Hello.class);
        //bean实例化默认是单例模式
        System.out.println(hello == myhello); //true
        System.out.println(hello == hello2); //true
        System.out.println(hello == hello3); //true
        System.out.println(hello == hello4); //true
        hello.show();
    }

    @Test
    public void userTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user); //User{name='tom', age=20}
    }


    @Test
    public void factoryTest1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        Fruit fruit = context.getBean("fruit", Fruit.class);
        System.out.println(fruit);

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void initDestoryTest(){
        /*
            Hello类实例化...
            初始化操作...
            Hello，init destory test
            销毁操作...
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");
        Hello hello = context.getBean("hello", Hello.class);
        hello.show();
        //关闭工厂
        context.close();
    }
}