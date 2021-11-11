package com.test.collection.day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件操作
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 获取工作目录
        System.out.println(System.getProperty("user.dir")); // e:\IdeaProjects\java-basic
        Properties properties = new Properties();
        File file = new File("jdbc.properties");
        System.out.println(file.getCanonicalFile().getPath()); //  E:\IdeaProjects\java-basic\jdbc.properties
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("project_username"));
        System.out.println(properties.getProperty("test", ""));

        System.out.println("*******************************************");

        // 资源获取方式
        // 获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
        System.out.println(PropertiesDemo.class.getClassLoader().getResource(""));

        // class.getClassLoader().getResourceAsStream是从classpath的路径下查找，路径不能以/开头
        PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");

        // 获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
        System.out.println(PropertiesDemo.class.getResource("/"));

        // 从classpath路径查找
        PropertiesDemo.class.getResourceAsStream("/jdbc.properties");

        // 从类同级路径查找
        InputStream in = PropertiesDemo.class.getResourceAsStream("jdbc.properties");
        Properties prop = new Properties();
        prop.load(in);
        System.out.println(prop.getProperty("name")); // 张三
    }
}
