package com.test.io.day17.stream.cache;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 字符输入输出流
 */
public class CharArrayReaderWriterDemo {
    public static void main(String[] args) {
        String str = "你好，中国；Hello，China";

        // public CharArrayReader(char buf[])
        // public CharArrayWriter()，CharArrayWriter内部维护了一个初始为32长度的char[]
        try (CharArrayReader reader = new CharArrayReader(str.toCharArray());
             CharArrayWriter writer = new CharArrayWriter()) {

            int value = 0;
            while ((value = reader.read()) != -1) {
                writer.write(Character.toUpperCase(value));
            }

            System.out.println(writer.toString()); // 你好，中国；HELLO，CHINA

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
