package com.test.basic.day04;

/**
 * switch用于固定数量的常量选择
 * switch支持的表达式类型如下：
 * |- byte short int char
 * |- enum 1.5支持
 * |- String 7.0支持
 * switch语句都可以使用if-else改写
 * case后必须跟常量，不能使用变量
 * |- 在多个常量值中选一，推荐使用switch语句
 * |- 判断范围，推荐使用if-else语句
 */
public class SwitchDemo {
    public static void main(String[] args) {
        final char aChar = 'a';
        char value = 'b';
        switch (value) {
            // case后的常量必须不同
            case aChar:
                System.out.println("字符为a");
                break;
            case 'b': // 满足条件
                System.out.println("字符为b");
                break; // 结束switch语句
            case 'c':
                System.out.println("字符为c");
                break;
            // 可选的default语句
            default:
                System.out.println("字符不是a、b、c中的任何一个");
                break;
        }

        String today = "周四";
        // switch语句中String类型的变量为null时，将出现java.lang.NullPointerException异常
        // today = null;
        switch (today) {
            // default可以写在case语句之前，但是执行的时候依然先匹配case，所有case不满足再执行default
            // 但如果default中没有break语句将导致继续向下执行
            default:
                System.out.println("输入错误");
                break;
            case "周一":
            case "周二":
            case "周三":
            case "周四": // case语句没有break,则继续向下执行，但不再判断case条件，直到遇到break或switch语句执行结束
            case "周五":
                System.out.println("工作日");
                break;
            case "周六":
            case "周日":
                System.out.println("休息日");
                break;
        }

        Color color = Color.BLUE;
        switch (color) {
            // 枚举case标签必须为枚举常量的非限定名称，其实就是不能加类名
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("未知颜色");
                break;
        }
    }
}

enum Color {
    RED, BLUE, GREEN;
}