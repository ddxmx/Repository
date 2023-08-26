package com.test.api.day15.random;

import java.util.UUID;

/**
 * UUID随机生成唯一编码，不会重复
 */
public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString()); // ddca808c-fd3b-4f34-819a-c062c437f1b0
    }
}
