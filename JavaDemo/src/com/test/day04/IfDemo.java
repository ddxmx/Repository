package com.test.day04;

/**
 * else匹配最近的一个if条件
 * if条件后不使用大括号，只会将if后的一条语句作为满足条件的执行语句
 */
public class IfDemo {
    public static void main(String[] args) {
        int x = 4;
        int y = 2;

        if(x>2)
            if(y==1)
                System.out.println("x = " + x);
                System.out.println("y = " + y); //不属于y==1条件的if语句

        if(x>2)
            if(y==1)
                System.out.println(x);
        else //就近原则，匹配最近的if条件
            System.out.println(y);
    }
}
