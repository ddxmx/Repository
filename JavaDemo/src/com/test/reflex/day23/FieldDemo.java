package com.test.reflex.day23;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 */
public class FieldDemo {
    public static void main(String[] args) {
        Class<Person> clazz = Person.class;
        Person per = null;
        try {
            per = clazz.getConstructor(String.class, int.class).newInstance("张三", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取属性结构
        // getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f); // public static java.lang.String com.test.reflex.day28.Person.city
        }

        System.out.println("************************************");
        // getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        /*
            private	java.lang.String name 张三
            private	int	age 20
            public static java.lang.String city 北京
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            // 1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3.变量名
            String fName = f.getName();
            System.out.print(fName + "\t");

            // 4.变量值
            try {
                // 变量不可见的情况下，无法直接通过get(Object obj)方式获取，会出现IllegalAccessException异常
                // 设置访问权限为可见
                f.setAccessible(true);
                System.out.println(f.get(per));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
