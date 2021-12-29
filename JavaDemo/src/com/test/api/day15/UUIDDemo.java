package com.test.api.day15;

import java.util.UUID;

/**
 * UUID随机生成唯一编码
 */
public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString()); // ddca808c-fd3b-4f34-819a-c062c437f1b0
        System.out.println(UUID.randomUUID()); // 5294a4bb-9a7b-4eee-afc8-8d5b74b85181
        System.out.println(UUID.randomUUID()); // ce09b4f7-f66b-4896-9389-f98541b3ce63
    }
}
