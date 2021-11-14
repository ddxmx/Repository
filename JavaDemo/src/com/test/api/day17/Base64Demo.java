package com.test.api.day17;

import java.util.Base64;

/**
 * Base64加解密
 * 加密长度为64位二进制数据，转换成十六进制为16位
 */
public class Base64Demo {
    public static void main(String[] args) {
        String str = "hello world";
        // Base64加密
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes());
        System.out.println(new String(encodeBytes)); // aGVsbG8gd29ybGQ=
        System.out.println(Base64.getEncoder().encodeToString(str.getBytes())); // aGVsbG8gd29ybGQ=

        // Base64解密
        byte[] decodeStr = Base64.getDecoder().decode(encodeBytes);
        System.out.println(new String(decodeStr)); // hello world
    }
}
