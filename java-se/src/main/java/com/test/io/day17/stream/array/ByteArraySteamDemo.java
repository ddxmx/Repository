package com.test.io.day17.stream.array;

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

        // public ByteArrayInputStream(byte buf[])
        // public ByteArrayOutputStream()，ByteArrayOutputStream内部维护了一个初始长度为32的byte[]
        try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            byte[] bytes = new byte[8];
            int len = 0;
            // 将数据全部写到内存中，再整个输出
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }

            System.out.println(out.toString()); // 你好，中国；Hello，China
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
