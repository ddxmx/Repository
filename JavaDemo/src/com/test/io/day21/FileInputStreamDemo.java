package com.test.io.day21;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 * 输入的文件必须存在，不然会抛出异常
 * 文本文件可以考虑使用字符流，防止中文读取乱码的问题
 * 非文本文件必须使用字节流进行读取
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        StringBuilder sb = new StringBuilder();
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[5]; // 数组大小指定为5为了演示读取乱码的问题
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
            hello world
            你好��中���
         */
        System.out.println(sb.toString());
    }
}
