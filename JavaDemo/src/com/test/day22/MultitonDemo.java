package com.test.day22;

/**
 * 不适用枚举类
 * 多例模式
 */
class Season {
    private static final Season SPRING = new Season("春天");
    private static final Season SUMMER = new Season("夏天");
    private static final Season AUTUMN = new Season("秋天");
    private static final Season WINTER = new Season("冬天");

    private String name;

    private Season(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Season getInstance(int index) {
        switch (index) {
            case 1:
                return SPRING;
            case 2:
                return SUMMER;
            case 3:
                return AUTUMN;
            case 4:
                return WINTER;
            default:
                return null;
        }
    }
}

public class MultitonDemo {
    public static void main(String[] args) {
        Season instance = Season.getInstance(2);
        System.out.println(instance.getName());
    }
}
