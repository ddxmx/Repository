package com.test.api.day15.system.util;

import org.apache.commons.lang3.SystemUtils;

public class ApacheSystemUtils {
    public static void main(String[] args) {
        System.out.println(SystemUtils.USER_NAME); // Yu
        System.out.println(SystemUtils.USER_HOME); // C:\Users\Yu
        System.out.println(SystemUtils.USER_DIR); // E:\IdeaProjects\java-basic
    }
}
