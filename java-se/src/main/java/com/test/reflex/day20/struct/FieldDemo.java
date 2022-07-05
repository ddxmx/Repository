package com.test.reflex.day20.struct;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Field类实例化及使用
 */
public class FieldDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.test.reflex.day20.Person");
        Object object = clazz.getConstructor(String.class, int.class).newInstance("张三", 20);

        // 获取属性结构
        // getFields():获取当前类及其父类中声明为public访问权限的属性
        System.out.println("***************getFields***************");
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f); // public static java.lang.String com.test.reflex.day20.Person.city
        }

        // getDeclaredFields():获取当前类中声明的所有属性（不包含父类中声明的属性）
        /*
            private	java.lang.String name 张三
            private	int	age 20
            public static java.lang.String city 北京
         */
        System.out.println("***************getDeclaredFields***************");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            // 1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 2.数据类型
            Type type = f.getGenericType();
            System.out.print(type.getTypeName() + "\t");

            // 3.变量名
            String fName = f.getName();
            System.out.print(fName + "\t");

            // 4.变量值
            try {
                // 变量不可见的情况下，无法直接通过get(Object obj)方式获取，会出现IllegalAccessException异常
                // 设置访问权限为可见
                f.setAccessible(true);
                // 获取对象中属性值
                System.out.println(f.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // getDeclaredField(String name):获取当前类中的指定属性
        System.out.println("***************getDeclaredField***************");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(object)); // 张三
        // 设置属性值
        name.set(object, "李四");
        System.out.println(name.get(object)); // 李四
    }
}
