package com.test.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准输入输出流
 * System.in：键盘输入
 * System.out：控制台输出
 * System.err：控制台错误输出
 */
public class SystemInOutDemo {
    public static void main(String[] args) {
        System.out.println("请输入字符串");
        String line = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输入的字符串为：" + line);
    }
}
