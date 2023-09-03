package com.test.reflex.day20.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Field类实例化及使用
 */
public class FieldDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Person.class;
        Person person = (Person) clazz.getConstructor(String.class, int.class).newInstance("张三", 20);

        System.out.println("========================getFields========================");
        // getFields():获取当前类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(System.out::println); // public static java.lang.String com.test.reflex.day20.clazz.Person.city

        System.out.println("========================getDeclaredFields========================");
        // getDeclaredFields():获取当前类中声明的所有权限的属性（不包含父类中声明的属性）
        /*
            private	java.lang.String name 张三
            private	int	age 20
            public static java.lang.String city 北京
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            // 1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + " ");

            // 2.数据类型
            Type type = f.getGenericType();
            System.out.print(type.getTypeName() + " ");

            // 3.变量名
            String name = f.getName();
            System.out.print(name + " ");

            // 4.变量值
            // 变量不可见的情况下，无法直接通过get(Object obj)方式获取，会出现IllegalAccessException异常
            // 设置访问权限为可见
            f.setAccessible(true);
            // 获取对象中属性值
            System.out.println(f.get(person));
        }

        System.out.println("========================getDeclaredField========================");
        // getDeclaredField(String name):获取当前类中的指定属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(person)); // 张三
        // 设置属性值
        name.set(person, "李四");
        System.out.println(name.get(person)); // 李四
    }
}
