package com.test.day04;

/**
 * switch的表达式类型如下
 * byte short int char
 * enum 1.5支持
 * String 7.0支持
 * switch语句都可以使用if-else改写
 * case后必须跟常量，不能使用变量
 */
public class SwitchDemo {
    public static void main(String[] args) {
        char value = 'b';
        switch (value) {
            case 'a':
                System.out.println("字符为a");
                break;
            case 'b': //满足条件
                System.out.println("字符为b");
                break; //结束switch语句
            case 'c':
                System.out.println("字符为c");
                break;
            default:
                System.out.println("字符不是a、b、c中的任何一个");
                break;
        }

        String day = "周四";
        switch (day) {
            case "周一":
            case "周二":
            case "周三":
            case "周四": //case语句没有break,则继续向下执行，不再判断case条件，直到遇到break或switch语句执行结束
            case "周五":
                System.out.println("工作日");
                break;
            case "周六":
            case "周日":
                System.out.println("休息日");
                break;
            default:    //default可以写在case语句之前，但是执行的时候依然先匹配case，所有case不满足再执行default
                System.out.println("输入错误");
                break;
        }

        Color color = Color.BLUE;
        switch (color) {
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
                System.out.println("输入错误");
                break;
        }
    }
}

enum Color {
    RED, BLUE, GREEN;
}