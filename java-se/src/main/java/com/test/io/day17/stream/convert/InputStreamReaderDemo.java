package com.test.io.day17.stream.convert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换流，字节输入流->字符输入流
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        // public InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException
        try (FileInputStream in = new FileInputStream("hello.txt");
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8.toString())) {

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
