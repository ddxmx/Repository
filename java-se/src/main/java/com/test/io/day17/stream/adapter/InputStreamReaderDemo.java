package com.test.io.day17.stream.adapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流，字节输入流->字符输入流
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        // public InputStreamReader(InputStream in)
        // public InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("hello.txt"))) { // 实现Closeable接口的类都可以支持自动关闭
            StringBuffer sb = new StringBuffer();
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                sb.append(new String(chars, 0, len));
            }

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
