package com.test.api.day17;

import java.util.UUID;

/**
 * UUID随机生成唯一编码
 */
public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString()); // b9a1d4e6-573c-48a8-aa5b-e11da67f6d3d
    }
}
