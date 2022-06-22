package com.test.reflex.day20.struct;

import com.test.reflex.day20.Person;

import java.lang.annotation.Annotation;

/**
 * Class类的实例化及使用
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = null;

        // 实例化Class对象方式一
        clazz = Person.class;
        printInfo(clazz);

        // 实例化Class对象方式二
        clazz = new Person().getClass();
        printInfo(clazz);

        // 实例化Class对象方式三
        try {
            clazz = Class.forName("com.test.reflex.day20.Person");
            printInfo(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ClassDemo.class.getClassLoader();
        clazz = classLoader.loadClass("com.test.reflex.day20.Person");
        printInfo(clazz);

        // 获取运行时类的父类
        System.out.println("***************获取父类***************");
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass); // class com.test.reflex.day20.Animal

        // 获取运行时类实现的接口
        System.out.println("***************获取父接口***************");
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c); // interface java.io.Serializable
        }

        // 获取运行时类的父类实现的接口
        System.out.println("***************获取父类实现的接口***************");
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c); // interface java.lang.Cloneable
        }

        // 获取运行时类所在的包
        System.out.println("***************获取所在包***************");
        Package pack = clazz.getPackage();
        System.out.println(pack); // package com.test.reflex.day20

        // 获取运行时类声明的注解
        System.out.println("***************获取运行时注解***************");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation); // @java.lang.Deprecated()
        }

        // 判断是否存在指定注解
        System.out.println(clazz.isAnnotationPresent(Deprecated.class)); // true
    }

    public static void printInfo(Class<?> clazz) {
        System.out.println(clazz.getName()); // com.test.reflex.day20.Person
        System.out.println(clazz.getSimpleName()); // Person
    }
}
