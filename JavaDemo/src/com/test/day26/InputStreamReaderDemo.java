package com.test.day26;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流，字节流->字符流
 * InputStreamReader：字节流转换为字符输出流
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("hello.txt"), "utf-8")) {
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
