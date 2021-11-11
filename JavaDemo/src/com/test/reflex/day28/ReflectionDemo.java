package com.test.reflex.day28;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射实践操作
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        {
            // 反射之前，对于Person的操作
            Person person = new Person("Tom", 12);
            // 不能直接调用private属性
            person.setAge(20);
            System.out.println(person); // Person{name='Tom', age=20}
            person.show(); // 我是一个中国人
        }

        {
            System.out.println("****************************************");
            // 反射之后，对于Person的操作
            Class clazz = Person.class;
            // 1.通过反射，创建Person类的对象
            // 需要通过Constructor调用有参构造
            Constructor cons = clazz.getConstructor(String.class, int.class);
            Person person = (Person) cons.newInstance("Tom", 12);
            System.out.println(person); // Person{name='Tom', age=12}

            // 2.通过反射，调用对象指定的属性、方法
            // 调用属性
            Field age = clazz.getDeclaredField("age");
            // 将private权限设置为可见
            age.setAccessible(true);
            age.set(person, 10);
            System.out.println(person); // Person{name='Tom', age=10}

            // 调用方法
            Method show = clazz.getDeclaredMethod("show", String.class);
            show.invoke(person, "印度"); // 我是一个印度人
        }
    }
}
