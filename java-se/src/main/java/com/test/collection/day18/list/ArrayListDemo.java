package com.test.collection.day18.list;

import java.util.*;

/**
 * List接口：存储有序的，可重复数据
 * （1）ArrayList：List主要实现类，数组实现，非线程安全，遍历、查找时使用
 * （2）LinkedList：双向链表实现，插入、删除时使用
 * （3）Vector：古老实现类，数组实现，线程安全的，已经逐步被CopyOnWriteArrayList取代
 * List存储引用类型，需要覆写引用类型的equals()和hashCode()方法
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(11);
        list.add(55);

        // list中可以包含重复元素
        System.out.println(list); // [11, 22, 33, 11, 55]

        System.out.println("=============================集合和数组转换=============================");
        // 数组转换为list
        // Arrays.asLis生成的list是Arrays的内部类，没有覆写add和remove方法，继承父类AbstractList的默认实现就是抛出异常
        ArrayList<Integer> destList = new ArrayList<>();
        Collections.addAll(destList, new Integer[]{1, 2, 3});
        System.out.println(destList); // [1, 2, 3]

        // list转换为数组
        Integer[] destArray = destList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(destArray)); // [1, 2, 3]

        System.out.println("=============================集合间相互转换=============================");
        // 使用构造方法转换
        LinkedList<Integer> linkedList = new LinkedList(list);
        System.out.println(linkedList); // [11, 22, 33, 11, 55]

        ArrayList<Integer> arrayList = new ArrayList<>(linkedList);
        System.out.println(arrayList); // [11, 22, 33, 11, 55]

        // 使用Collection接口的addAll()方法转换，public boolean addAll(Collection<? extends E> c)
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.addAll(arrayList);
        System.out.println(linkedList2);

        System.out.println("=============================List接口新增的方法=============================");
        // 和索引相关的方法，都是List新增的（区别Collection接口）
        list.add(1, 66);
        list.addAll(1, Arrays.asList(222, 333, 444));
        System.out.println(list); // [11, 222, 333, 444, 66, 22, 33, 11, 55]

        // 查找元素位置
        System.out.println(list.indexOf(444)); // 3
        System.out.println(list.indexOf(999)); // -1
        System.out.println(list.lastIndexOf(11)); // 7

        // 根据索引移除元素
        list.remove(1);
        System.out.println(list); // [11, 333, 444, 66, 22, 33, 11, 55]

        // 根据对象移除元素
        // 直接写444，方法会匹配到 public E remove(int index)
        list.remove(Integer.valueOf(444));
        System.out.println(list); // [11, 333, 66, 22, 33, 11, 55]

        // 修改索引位置的元素
        list.set(3, 20);
        System.out.println(list); // [11, 333, 66, 20, 33, 11, 55]

        // 截取子集合
        List<Integer> subList = list.subList(0, 4);
        System.out.println(subList); // [11, 333, 66, 20]
        System.out.println(list); // [11, 333, 66, 20, 33, 11, 55]

        System.out.println("=============================List元素遍历:iterator=============================");
        // 遍历方式一：iterator方式
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=============================List元素遍历:listIterator=============================");
        // 遍历方式二：listIterator方式，ListIterator是专门为遍历List而存在的
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("---------------------------");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.println("=============================List元素遍历:foreach=============================");
        // 遍历方式三：foreach方式
        for (Object element : list) {
            System.out.println(element);
        }

        System.out.println("=============================List元素遍历:for=============================");
        // 遍历方式四：for循环方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
