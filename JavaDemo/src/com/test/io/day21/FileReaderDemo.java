package com.test.io.day21;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 * 读取文件时，建议使用字符输入流，防止中文乱码的问题
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        FileReader reader = null;
        try {
            // 创建字符输入流
            reader = new FileReader(file);

            // 数据读入，方式一：每次读取一个字符 返回-1表示读取完毕
            /*
                int temp = 0;
                while ((temp = reader.read()) != -1) {
                    System.out.print((char) temp);
                }
             */

            // 数据读入，方式二：每次读取多个字节，返回-1表示读取完毕
            char[] chars = new char[3];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 流的关闭
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
