package com.test.io.day26;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 * 输出的文件不存在时，会自动创建
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            // out = new FileOutputStream(file, true); // 追加的方式输出
            out.write("hello world\n".getBytes());
            out.write("你好，中国\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
