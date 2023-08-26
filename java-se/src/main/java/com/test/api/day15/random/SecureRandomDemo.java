package com.test.api.day15.random;

import java.security.SecureRandom;

/**
 * 安全随机数算法
 * SecureRandom继承自java.util.Random类
 */
public class SecureRandomDemo {
    public static void main(String[] args) {
        // 实例化方式一，SecureRandom random = new SecureRandom();
        // 实例化方式二：SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        SecureRandom secureRandom = new SecureRandom();

        String verificationCode = "";
        // 生成长度为6的随机验证码
        for (int i = 0; i < 6; i++) {
            verificationCode += secureRandom.nextInt(10);
        }

        System.out.println(verificationCode); // 990725
    }
}
