package com.test.io.day17.stream.file;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 * 读取文本文件时，建议使用字符输入流，防止中文乱码的问题
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        // public FileReader(String fileName) throws FileNotFoundException
        // public FileReader(File file) throws FileNotFoundException
        try (FileReader reader = new FileReader("hello.txt")) {
            StringBuffer sb = new StringBuffer();

            // 数据读入，方式一：每次读取一个字符 返回-1表示读取完毕
            /*
                int temp = 0;
                // public int read() throws IOException
                while ((temp = reader.read()) != -1) {
                    sb.append((char) temp);
                }
             */

            // 数据读入，方式二：每次读取多个字节，返回-1表示读取完毕
            char[] chars = new char[3];
            int len = 0;
            // public int read(char cbuf[]) throws IOException
            while ((len = reader.read(chars)) != -1) {
                String buffer = new String(chars, 0, len);
                sb.append(buffer);
                System.out.println("本次读取字符：" + buffer);
            }

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
