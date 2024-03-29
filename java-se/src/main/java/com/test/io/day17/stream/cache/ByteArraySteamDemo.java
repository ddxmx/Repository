package com.test.io.day17.stream.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输入输出流
 * 数据被写入一个byte[]缓冲区，缓冲区会随着数据的不断写入而自动增长
 */
public class ByteArraySteamDemo {
    public static void main(String[] args) {
        String str = "你好，中国；Hello，China";

        // public ByteArrayInputStream(byte buf[])，内部维护了一个引用，指向传入的byte[]
        // public ByteArrayOutputStream()，内部维护了一个初始长度为32的byte[]，长度不足时自动扩容
        try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[8];
            int len = 0;
            // 将数据全部写到内存中，再整个输出
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

            // toString()方法将内部维护的byte[]转换为字符串输出
            System.out.println(out.toString()); // 你好，中国；Hello，China
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
