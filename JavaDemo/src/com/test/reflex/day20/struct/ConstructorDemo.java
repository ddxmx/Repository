package com.test.reflex.day20.struct;

import com.test.reflex.day20.Person;

import java.util.Arrays;

/**
 * Constructor类的实例化及使用
 */
public class ConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.test.reflex.day20.Person");

        // 只返回public的构造
        System.out.println("***************getConstructor***************");
        System.out.println(clazz.getConstructor(String.class, int.class));
        Arrays.stream(clazz.getConstructors()).forEach(System.out::println);

        // 返回所有的构造，不区分权限
        System.out.println("***************getDeclaredConstructor***************");
        System.out.println(clazz.getDeclaredConstructor(String.class, int.class));
        Arrays.stream(clazz.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println("***************实例化对象***************");
        Person person = null;
        try {
            // 使用无参构造实例化（该方法JDK1.9开始不在推荐）
            // 类中必须包含public修饰的无参构造
            person = (Person) clazz.newInstance();
            System.out.println(person);

            // 推荐使用clazz.getDeclaredConstructor().newInstance();
            person = (Person) clazz.getDeclaredConstructor().newInstance();
            System.out.println(person);

            // 使用带参数的构造方法实例化
            person = (Person) clazz.getDeclaredConstructor(String.class, int.class).newInstance("jerry", 20);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
