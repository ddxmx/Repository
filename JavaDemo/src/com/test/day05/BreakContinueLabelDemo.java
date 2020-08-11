package com.test.day05;

/**
 * break、continue和标签语句一起使用，可以跳出或结束一次标签所在循环
 */
public class BreakContinueLabelDemo {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    /*
                    0、1、2、
                    0、1、2、
                    0、1、2、
                     */
                    //break; //跳出内层循环

                    /*
                    0、1、2、
                     */
                    break outer; //跳出标签指定的循环
                }
                System.out.print(j + "、");
            }
            System.out.println();
        }
    }
}
