package com.test.reflex.day20;

import java.io.IOException;

/**
 * 类的加载器
 * 1、系统类加载器：自定义类的加载
 * 2、扩展类加载器：负责jre/lib/ext目录下jar包的加载
 * 3、引导类加载器：JVM自带的类加载器，加载核心类库，无法直接获取
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader superClassLoader = classLoader.getParent();
        System.out.println(superClassLoader); // sun.misc.Launcher$ExtClassLoader@677327b6

        // 调用扩展类加载器的getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader topClassLoader = superClassLoader.getParent();
        System.out.println(topClassLoader); // null

        ClassLoader topClassLoader2 = String.class.getClassLoader();
        System.out.println(topClassLoader2); // null

        // 使用ClassLoader加载文件
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        // jdbc.properties位于当前classpath下
        loader.getResourceAsStream("jdbc.properties");
    }
}
