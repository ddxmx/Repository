package com.test.day24;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件操作
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //获取properties文件方式一
        {
            System.out.println(System.getProperty("user.dir")); //e:\IdeaProjects\java-basic
            Properties properties = new Properties();
            //properties的路径在module同级目录
            properties.load(new FileInputStream("jdbc.properties"));
            String username = properties.getProperty("project_username");
            System.out.println(username); //zhangsan
        }

        System.out.println("*******************************************");
        //获取properties文件方式二
        {
            //获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
            System.out.println(PropertiesDemo.class.getClassLoader().getResource(""));

            Properties properties = new Properties();
            /*
                class.getClassLoader().getResourceAsStream是从module的路径下查找，路径不能以/开头
             */
            InputStream inputStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            System.out.println(properties.getProperty("module_username")); //scott

            Properties properties2 = new Properties();
            InputStream inputStream2 = PropertiesDemo.class.getClassLoader().getResourceAsStream("com/test/day24/jdbc.properties");
            properties2.load(inputStream2);
            System.out.println(properties2.getProperty("class_username")); //lisi
        }

        System.out.println("*******************************************");
        //获取properties文件方式三
        {
            //获取classpath路径：file:/E:/IdeaProjects/java-basic/out/production/javaSE/
            System.out.println(PropertiesDemo.class.getResource("/"));

            Properties properties = new Properties();
            //从classpath路径查找
            InputStream inputStream = PropertiesDemo.class.getResourceAsStream("/jdbc.properties");
            properties.load(inputStream);
            System.out.println(properties.getProperty("module_username")); //scott

            Properties properties2 = new Properties();
            //从类同级路径查找
            InputStream inputStream2 = PropertiesDemo.class.getResourceAsStream("jdbc.properties");
            properties2.load(inputStream2);
            System.out.println(properties2.getProperty("class_username")); //lisi
        }

    }
}
