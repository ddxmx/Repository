package com.test.reflex.day20.clazz.loader;

import java.io.IOException;

/**
 * 1、类的加载器
 * （1）启动类加载器Bootstrap ClassLoader：JVM自带的类加载器，主要负则加载JAVA_HOME/lib下的类库，无法直接获取
 * （2）扩展类加载器Extension ClassLoader：主要加载JAVA_HOME/lib/ext目录中的类库
 * （3）应用类加载器App ClassLoader：负责加载应用程序classpath目录下的所有jar和class文件（第三方jar）
 * 2、双亲委派机制
 * 类的加载过程采用双亲委派机制，它是一种任务委派模式
 * 即把加载类的请求交由父加载器处理，一直到顶层的父加载器（BootstrapClassLoader）
 * 如果父加载器能加载则用父加载器加载，否则才用子加载器加载该类
 * 父加载器并非是Java中的继承关系，而是双亲委派过程中向上委派的加载器
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("============================获取ClassLoader实例化对象============================");
        // 1、对于自定义类，使用应用类加载器进行加载
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 2、调用应用类加载器的getParent()：获取扩展类加载器
        ClassLoader superClassLoader = classLoader.getParent();
        System.out.println(superClassLoader); // sun.misc.Launcher$ExtClassLoader@677327b6

        // 3、调用扩展类加载器的getParent()：无法获取启动类加载器
        // 启动类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader topClassLoader = superClassLoader.getParent();
        System.out.println(topClassLoader); // null

        // java核心类库使用的是启动类加载器进行加载
        ClassLoader topClassLoader2 = String.class.getClassLoader();
        System.out.println(topClassLoader2); // null

        System.out.println("============================使用ClassLoader加载资源============================");
        // 使用ClassLoader加载文件
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        // jdbc.properties位于当前classpath下
        loader.getResourceAsStream("jdbc.properties");
    }
}
