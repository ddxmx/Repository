package com.test.basic.day04;

import java.util.Arrays;

/**
 * 数组拷贝
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};

        // 拷贝长度
        int len = 3;
        // 数组a的开始拷贝索引
        int oA = 2;
        // 数组b的开始拷贝索引
        int oB = 3;
        // 拷贝赋值
        for (int i = 0; i < len; i++) {
            b[oB + i] = a[oA + i];
        }
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]

        // 调用System类中arraycopy()方法实现数组拷贝
        b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.arraycopy(a, oA, b, oB, len);
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]

        // Arrays类对数组拷贝的支持，底层还是通过System.arraycopy()实现
        // copyOf是从开头拷贝指定个数元素，生成一个新数组
        int[] dest1 = Arrays.copyOf(a, 3);
        System.out.println(Arrays.toString(dest1)); // [1, 2, 3]

        // 拷贝长度超过原数组的长度，超出的元素设置为目标数组元素类型的默认值
        int[] dest2 = Arrays.copyOf(a, 7);
        System.out.println(Arrays.toString(dest2)); // [1, 2, 3, 4, 5, 0, 0]

        // copyOfRange指定拷贝的起止位置 [start,end) ，生成一个新数组
        int[] dest3 = Arrays.copyOfRange(a, 3, 5);
        System.out.println(Arrays.toString(dest3)); // [4, 5]

        // 拷贝目标位置超过了原数组的索引，超出的元素设置为目标数组元素类型的默认值
        int[] dest4 = Arrays.copyOfRange(a, 3, 7);
        System.out.println(Arrays.toString(dest4)); // [4, 5, 0, 0]
    }
}
