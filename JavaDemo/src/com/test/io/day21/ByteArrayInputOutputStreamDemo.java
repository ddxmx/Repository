package com.test.io.day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输入输出流
 * 数据被写入一个byte数组缓冲区，缓冲区会随着数据的不断写入而自动增长
 */
public class ByteArrayInputOutputStreamDemo {
    public static void main(String[] args) {
        String str = "hello world";
        try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int value = 0;
            // 利用ByteArrayOutputStream转换大小写
            while ((value = in.read()) != -1) {
                // 英文字符占1个字节
                out.write(Character.toUpperCase(value));
            }
            System.out.println(out.toString()); // HELLO WORLD
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
