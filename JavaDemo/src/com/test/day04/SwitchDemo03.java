package com.test.day04;

/**
 * siwtch的表达式类型
 * byte short int char
 * enum 1.5支持
 * String 7.0支持
 * switch语句都可以使用if-else 改写
 */
public class SwitchDemo03 {
    public static void main(String[] args) {
        char value = 'b';
        switch (value) {  //字符为b
            case 'a':
                System.out.println("字符为a");
                break;
            case 'b':
                System.out.println("字符为b");
                break;
            case 'c':
                System.out.println("字符为c");
                break;
            default:
                System.out.println("字符不是a、b、c中的任何一个");
                break;
        }

        String day = "周四";
        switch (day) {   //工作日
            case "周一":
            case "周二":
            case "周三":
            case "周四":
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
        switch (color) { //蓝色
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