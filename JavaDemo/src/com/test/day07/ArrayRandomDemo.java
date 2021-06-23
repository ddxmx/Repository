package com.test.day07;

import java.util.Arrays;
import java.util.Random;

/**
 * 生成长度为6的随机数数组，元素各不相同
 */
public class ArrayRandomDemo {
    public static void main(String[] args) {
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            outer:
            while (true) {
                //生成一个[0,100)的随机数
                int tempValue = new Random().nextInt(100);
                //判断当前生成的随机数是否和数组中当前索引前已经存在的元素重复
                for (int j = 0; j < i; j++) {
                    //元素重复，重新生成随机数
                    if (tempValue == array[j]) {
                        continue outer;
                    }
                }
                //生成的随机数不重复，进行赋值
                array[i] = tempValue;
                //结束当前位置的元素随机数生成
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
