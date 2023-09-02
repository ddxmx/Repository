package com.test.io.day17.util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Apache的IOUtils类扩展了java.io包中流操作的能力
 * IOUtils操作后要关闭流
 */
public class ApacheIOUtils {
    public static void main(String[] args) throws IOException {
        System.out.println("=========================获取流=========================");
        // 通过文本获取输入流
        InputStream steam = IOUtils.toInputStream("hello world", StandardCharsets.UTF_8);

        System.out.println("=========================将输入流转换为字符串=========================");
        // 将字符流转换为字符串
        try (Reader reader = new FileReader("hello.txt")) {
            String str1 = IOUtils.toString(reader);
            System.out.println(str1);
        }

        // 将字节流转换为字符串
        try (FileInputStream in = new FileInputStream("hello.txt")) {
            String str2 = IOUtils.toString(in, StandardCharsets.UTF_8);
            System.out.println(str2);
        }

        System.out.println("=========================将数据写入到输出流=========================");
        FileOutputStream out = new FileOutputStream("hello_bak.txt");
        IOUtils.write("hello world".getBytes(StandardCharsets.UTF_8), out);
        // 关闭流，会抛出异常
        IOUtils.close(out);

        FileOutputStream out2 = new FileOutputStream("hello_bak.txt");
        IOUtils.write("hello world".toCharArray(), out2, StandardCharsets.UTF_8);
        IOUtils.closeQuietly(out2);

        FileWriter writer = new FileWriter("hello_bak.txt");
        IOUtils.write("hello world", writer);
        // 关闭流不会抛出异常
        IOUtils.closeQuietly(writer);
    }
}
