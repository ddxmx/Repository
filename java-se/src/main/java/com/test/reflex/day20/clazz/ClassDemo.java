package com.test.reflex.day20.clazz;

import java.lang.annotation.Annotation;

/**
 * Class类的实例化及使用
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = null;

        System.out.println("=======================Class对象实例化===========================");
        // 实例化Class对象方式一
        clazz = Person.class;
        // 实例化Class对象方式二
        clazz = new Person().getClass();
        // 实例化Class对象方式三
        clazz = Class.forName("com.test.reflex.day20.clazz.Person");
        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ClassDemo.class.getClassLoader();
        clazz = classLoader.loadClass("com.test.reflex.day20.clazz.Person");

        System.out.println("=======================Class常用方法===========================");
        // 获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass.getName()); // class com.test.reflex.day20.Animal

        // 获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName()); // java.io.Serializable
        }

        // 获取运行时类的父类实现的接口
        Class[] interfaces2 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces2) {
            System.out.println(c.getName()); // java.lang.Cloneable
        }

        // 获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println(pack.getName()); // com.test.reflex.day20

        // 获取运行时类声明的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName()); // java.lang.Deprecated
        }

        // 判断是否存在指定注解
        System.out.println(clazz.isAnnotationPresent(Deprecated.class)); // true
    }
}
