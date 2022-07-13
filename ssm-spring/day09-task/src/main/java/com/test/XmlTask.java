package com.test;

import java.time.LocalDateTime;

public class XmlTask {
    private static int count = 0;

    public void date() {
        System.out.println(LocalDateTime.now());
    }

    public void total() {
        System.out.println(LocalDateTime.now() + "，count= " + ++count);
    }
}
