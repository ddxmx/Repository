package com.test.io.day17.stream.file;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 * 文本文件可以考虑使用字符流，防止中文读取乱码的问题
 * 非文本文件必须使用字节流进行读取
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 读取的文件必须存在，不然会抛出异常
        // public FileInputStream(File file) throws FileNotFoundException
        // public FileInputStream(String name) throws FileNotFoundException
        try (FileInputStream in = new FileInputStream("hello.txt")) {
            // 数组大小指定为5为了演示读取乱码的问题
            byte[] bytes = new byte[5]; // 每次最多从输入流中读取5个字节
            int len = 0;
            // 读取到文件的末尾时，返回-1，public int read(byte b[]) throws IOException
            while ((len = in.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
            你��，���国
            hello China
         */
        System.out.println(sb);
    }
}
