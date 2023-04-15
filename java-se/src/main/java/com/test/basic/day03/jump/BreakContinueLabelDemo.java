package com.test.basic.day03.jump;

/**
 * break、continue可以和标签语句一起使用，可以跳出或结束一次标签所在循环
 */
public class BreakContinueLabelDemo {
    public static void main(String[] args) {
        // 给外层循环定义标签
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    /*
                        i=0,j=0
                        i=0,j=1
                        i=0,j=2
                        i=1,j=0
                        i=1,j=1
                        i=1,j=2
                        i=2,j=0
                        i=2,j=1
                        i=2,j=2
                     */
                    // 跳出内层循环
                    // break;

                    /*
                        i=0,j=0
                        i=0,j=1
                        i=0,j=2
                     */
                    // 跳出标签指定的循环
                    break outer;
                }
                System.out.println("i=" + i + ",j=" + j);
            }
        }
    }
}
