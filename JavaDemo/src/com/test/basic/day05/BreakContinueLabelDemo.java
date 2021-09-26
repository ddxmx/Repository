package com.test.basic.day05;

/**
 * break、continue和标签语句一起使用，可以跳出或结束一次标签所在循环
 */
public class BreakContinueLabelDemo {
    public static void main(String[] args) {
        // 给外层循环定义标签
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    /*
                        0、1、2、
                        0、1、2、
                        0、1、2、
                     */
                    // 跳出内层循环
                    // break;

                    /*
                        0、1、2、
                     */
                    // 跳出标签指定的循环
                    break outer;
                }
                System.out.print(j + "、");
            }
            System.out.println();
        }
    }
}
