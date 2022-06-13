package com.test.collection.day18.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件操作
 * 1、getClassLoader().getResource(路径)
 * （1）路径不允许以/开头
 * （2）表示在classpath根路径下
 * 2、getResource(路径)
 * （1）路径以/开头表示根路径下
 * （2）路径不以/开头表示类同级路径下
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 获取工作目录
        System.out.println(System.getProperty("user.dir")); // E:\IdeaProjects\java-basic

        Properties properties = new Properties();
        File file = new File("jdbc.properties");
        System.out.println(file.getCanonicalFile().getPath()); //  E:\IdeaProjects\java-basic\jdbc.properties
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("desc", "user info"));

        System.out.println("***************资源获取方式***************");
        // 获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
        System.out.println(PropertiesDemo.class.getClassLoader().getResource(""));

        // 从classpath的路径下查找，路径不能以/开头，file:/E:/IdeaProjects/java-basic/out/production/javaSE/jdbc.properties
        System.out.println(PropertiesDemo.class.getClassLoader().getResource("jdbc.properties"));

        // 获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
        System.out.println(PropertiesDemo.class.getResource("/"));

        // 从classpath路径查找，file:/E:/IdeaProjects/java-basic/out/production/javaSE/jdbc.properties
        System.out.println(PropertiesDemo.class.getResource("/jdbc.properties"));

        // 从类同级路径查找，file:/E:/IdeaProjects/java-basic/out/production/javaSE/com/test/collection/day18/set/jdbc.properties
        System.out.println(PropertiesDemo.class.getResource("jdbc.properties"));

        InputStream inputStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        System.out.println(prop.getProperty("password"));
    }
}
