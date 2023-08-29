package com.test.io.day17.stream.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准输入输出流
 * System.in：键盘输入
 * System.out：控制台输出
 * System.err：控制台错误输出
 */
public class SystemSteamDemo {
    public static void main(String[] args) {
        System.out.println("请输入字符串");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while (true) {
                line = bufferedReader.readLine();
                System.out.println("输入的字符串为：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
