package com.test.io.day17.util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Apache的IOUtils类扩展了java.io包中流操作的能力
 */
public class ApacheIOUtils {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("hello.txt");
        Reader reader = new FileReader("hello.txt");
        FileOutputStream out = new FileOutputStream("hello_bak.txt");
        FileWriter writer = new FileWriter("hello_bak.txt");

        System.out.println("=========================获取流=========================");
        // 通过文本获取输入流
        InputStream steam = IOUtils.toInputStream("hello world", StandardCharsets.UTF_8);

        System.out.println("=========================将输入流转换为字符串=========================");
        // 将字符流转换为字符串
        String str1 = IOUtils.toString(reader);
        // 将字节流转换为字符串
        String str2 = IOUtils.toString(in, StandardCharsets.UTF_8);

        System.out.println("=========================将数据写入到输出流=========================");
        IOUtils.write("hello world".getBytes(), out);
        IOUtils.write("hello world".toCharArray(), writer);
        IOUtils.write("hello world", writer);

        System.out.println("=========================关闭流=========================");
        IOUtils.closeQuietly(in);
        IOUtils.close(out);
    }
}
