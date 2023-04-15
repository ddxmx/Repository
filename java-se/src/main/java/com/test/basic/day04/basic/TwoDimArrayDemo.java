package com.test.basic.day04.basic;

/**
 * 二维数组中每一个元素都是一维数组，每个一维数组长度可以不相同
 * 从底层机制来看，其实不存在多维数组，二维数组就是元素是一维数组的一维数组
 */
public class TwoDimArrayDemo {
    public static void main(String[] args) {
        // 静态初始化
        int[][] arr1 = new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};

        // 动态初始化，方式一，每个元素长度相同
        String[][] arr2 = new String[3][2];
        arr2[0][0] = "hello";
        arr2[1][0] = "java";
        arr2[1][1] = "python";

        /*
            hello   null
            java    python
            null    null
         */
        // 二维数组打印需要两层循环
        for (int i = 0; i < arr2.length; i++) {
            // 根据每个元素的长度，打印元素的值
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }

        // 动态初始化，方式二，每个元素长度可以不同
        // 二维数组不开辟内层元素空间
        // 等价于int[][] arr3 = {null, null};
        int[][] arr3 = new int[2][];
        // 内层元素没有实例化，NullPointerException
        // System.out.println(arr3[1][1]);
        arr3[0] = new int[2];
        arr3[1] = new int[]{11, 22, 33};
        /*
            0		0
            11		22		33
         */
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + "\t");
            }
            System.out.println();
        }

        // 面试题
        /*
            0 0 0
            0 0 0
         */
        int[][] a = new int[2][3];
        System.out.println(a); // [[I@1540e19d
        System.out.println(a[0]); // [I@677327b6
        System.out.println(a[0][0]); // 0

        /*
            null
            null
         */
        double[][] b = new double[2][];
        System.out.println(b); // [[D@16b4a017
        System.out.println(b[0]); // null
        System.out.println(b[0][0]); // NullPointerException
    }
}
