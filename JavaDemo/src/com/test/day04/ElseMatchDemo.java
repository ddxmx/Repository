package com.test.day04;

/**
 * else匹配最近的一个if条件
 * if条件后不使用大括号，只会将if后的一条语句作为满足条件的执行语句
 */
public class ElseMatchDemo {
    public static void main(String[] args) {
        int x = 4;
        int y = 2;

        //运行结果：y=2
        if(x>2)
            if(y==1)
                System.out.println("x = " + x);
                System.out.println("y = " + y); //必定会执行，不归属if语句

        //运行结果：2
        if(x>2)
            if(y==1)
                System.out.println(x);
        else //就近原则，匹配最近的if条件
            System.out.println(y);
    }
}
