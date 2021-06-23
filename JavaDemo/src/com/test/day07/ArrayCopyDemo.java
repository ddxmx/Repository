package com.test.day07;

import java.util.Arrays;

/**
 * 数组拷贝
 * 数组拷贝会修改目标数组
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};

        //拷贝的长度
        int len = 3;
        //数组a的开始拷贝索引
        int oA = 2;
        //数组b的开始拷贝索引
        int oB = 3;
        for (int i = 0; i < len; i++) {
            b[oB + i] = a[oA + i];
        }
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]

        //使用API实现数组拷贝
        //System类的支持
        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.arraycopy(a, oA, b, oB, len);
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]

        //Arrays类的支持
        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //copyOf是从开头拷贝指定个数元素，生成一个新数组
        int[] dest1 = Arrays.copyOf(a, 5);
        System.out.println(Arrays.toString(dest1)); //[1, 2, 3, 4, 5]

        //copyOfRange指定拷贝的起止位置 [开始位置索引,结束位置索引) ，生成一个新数组
        int[] dest2 = Arrays.copyOfRange(a, 3, 5);
        System.out.println(Arrays.toString(dest2)); //[4, 5]
    }
}
