package com.test.thread.day12.atomic.array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 数组类型原子操作
 * 数组元素直接获取或赋值操作本身都是原子的，但是获取+赋值的操作不能保证是原子的
 * getAndIncrement、getAndSet类似的方法可以保证获取+赋值的原子性
 * getAndIncrement、getAndSet类似的方法会进行自旋操作，compareAndSet不会自旋，可以保证最终只有一个线程执行成功
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int index = 1;

        // 初始化一，操作不会修改原数组内容，拷贝生成新数组进行操作
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        // 初始化方式二，指定长度，数组元素为类型默认值
        // AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array.length);

        // 设置值
        atomicIntegerArray.set(index, 5);
        // 获取值
        System.out.println(atomicIntegerArray.get(index)); // 5
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4]
        System.out.println(atomicIntegerArray.toString()); // [1, 5, 3, 4]

        // 返回原来的值，并设置新值
        System.out.println(atomicIntegerArray.getAndSet(index, 10)); // 5
        System.out.println(atomicIntegerArray.get(index)); // 10

        // 先获取再加1
        System.out.println(atomicIntegerArray.getAndIncrement(index)); // 10
        System.out.println(atomicIntegerArray.get(index)); // 11
        // 先加1再获取
        System.out.println(atomicIntegerArray.incrementAndGet(index)); // 12
        System.out.println(atomicIntegerArray.get(index)); // 12

        // 先获取再减1
        System.out.println(atomicIntegerArray.getAndDecrement(index)); // 12
        System.out.println(atomicIntegerArray.get(index)); // 11
        // 先减1再获取
        System.out.println(atomicIntegerArray.decrementAndGet(index)); // 10
        System.out.println(atomicIntegerArray.get(index)); // 10

        // 先获取再加指定值
        System.out.println(atomicIntegerArray.getAndAdd(index, 5)); // 10
        System.out.println(atomicIntegerArray.get(index)); // 15
        // 先加指定值再获取
        System.out.println(atomicIntegerArray.addAndGet(index, 5)); // 20
        System.out.println(atomicIntegerArray.get(index)); // 20

        // 当前值等于预期值时，设置新值，判断不成立
        atomicIntegerArray.compareAndSet(index, 10, 12);
        System.out.println(atomicIntegerArray.get(index)); // 20
        // 当前值等于预期值时，设置新值，判断成立
        atomicIntegerArray.compareAndSet(index, 20, 22);
        System.out.println(atomicIntegerArray.get(index)); // 22
    }
}
