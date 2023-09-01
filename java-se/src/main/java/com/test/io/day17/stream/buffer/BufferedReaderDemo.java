package com.test.io.day17.stream.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流
 * BufferedReader内部使用初始长度为8192的char[]作为缓冲区
 * 读取时，从文件一次性读取缓冲区长度的数据，减少文件读取次数
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        // public BufferedReader(Reader in)
        try (BufferedReader reader = new BufferedReader(new FileReader("hello.txt"))) {
            StringBuffer sb = new StringBuffer();

            // 读取方式一：char[]读取
            char[] chars = new char[1024];
            int len = 0;
            // public int read(char cbuf[]) throws IOException
            while ((len = reader.read(chars)) != -1) {
                String buffer = new String(chars, 0, len);
                sb.append(buffer);
            }

            System.out.println(sb);

            // 读取方式二：整行读取
            /*
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                System.out.println(temp);
            }
             */

            // 读取方式三：流式读取
            // reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
