package com.test.day05;

/**
 * 嵌套循环
 * 外层循环控制行数，内层循环控制列数
 */
public class NestedLoopDemo {
    public static void main(String[] args) {
        /*
            1*1=1
            1*2=2	2*2=4
            1*3=3	2*3=6	3*3=9
            1*4=4	2*4=8	3*4=12	4*4=16
            1*5=5	2*5=10	3*5=15	4*5=20	5*5=25
            1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36
            1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49
            1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64
            1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81
        */
        for (int i = 1; i <= 9; i++) {  //循环的复杂度 i*j
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }

        /*
              *
             * *
            * * *
           * * * *
          * * * * *
         */
        int line = 5;
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //水仙花数
        //153 370 371 407
        for (int i = 100; i < 1000; i++) {
            int bai = i / 100;
            int shi = i % 100 / 10;
            int ge = i % 10;
            int result = bai * bai * bai + shi * shi * shi + ge * ge * ge;
            if (i == result) {
                System.out.print(i + "\t");
            }
        }
    }
}
