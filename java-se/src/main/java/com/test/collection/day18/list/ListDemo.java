package com.test.collection.day18.list;

import com.test.collection.day18.Person;

import java.util.*;

/**
 * List接口：存储有序的，可重复数据
 * |- ArrayList：List主要实现类，数组实现，非线程安全，遍历、查找时使用
 * |- LinkedList：双向链表实现，插入、删除时使用
 * |- Vector：古老实现类，数组实现，线程安全的，已经逐步被Collections.synchronizedList(List<T> list) 方法取代
 * 如果List需要存储引用类型,并且使用到 remove() , contains() 等方法，建议覆写该引用类型的equals()和hashCode()方法。
 */
public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        // list中可以包含重复元素
        System.out.println(list); // [123, 456, AA, Person{name='Tom', age=12}, 456]

        // 数组转换为list
        Integer[] array = new Integer[]{11, 22, 33, 44, 55};
        // Arrays.asLis生成的list是Arrays的内部类，是不能执行add和remove方法，没有覆写，继承父类AbstractList的默认实现就是抛出异常
        // List<Integer> destList = Arrays.asList(array);
        ArrayList<Integer> destList = new ArrayList<>();
        Collections.addAll(destList, array);

        // list转换为数组
        Integer[] destArray = destList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(destArray)); // [11, 22, 33, 44, 55]

        // 不同集合类型之间的转换，可以通过构造方法
        LinkedList<Object> linkedList = new LinkedList(list);
        System.out.println(linkedList.getFirst()); // 123
        System.out.println(linkedList.getLast()); // 456

        ArrayList<Object> arrayList = new ArrayList<>(linkedList);
        System.out.println(arrayList); // [123, 456, AA, Person{name='Tom', age=12}, 456]

        System.out.println("***************List接口新增的方法***************");
        // 和索引相关的方法，都是List新增的（区别Collection接口）
        list.add(1, "BB");
        list.addAll(1, Arrays.asList(1, 2, 3));
        System.out.println(list); // [123, 1, 2, 3, BB, 456, AA, Person{name='Tom', age=12}, 456]

        // 查找元素位置
        System.out.println(list.indexOf(456)); // 5
        System.out.println(list.indexOf(999)); // -1
        System.out.println(list.lastIndexOf(456)); // 8

        // 根据索引移除元素
        list.remove(1);
        System.out.println(list); // [123, 2, 3, BB, 456, AA, Person{name='Tom', age=12}, 456]
        // 根据对象移除元素
        // 直接写456，方法会匹配到 public E remove(int index)
        list.remove(Integer.valueOf(456));
        System.out.println(list); // [123, 2, 3, BB, AA, Person{name='Tom', age=12}, 456]

        // 修改元素值
        list.set(3, "CC");
        System.out.println(list); // [123, 2, 3, CC, AA, Person{name='Tom', age=12}, 456]

        // List截取
        List<Object> subList = list.subList(0, 4);
        System.out.println(subList); // [123, 2, 3, CC]
        System.out.println(list); // [123, 2, 3, CC, AA, Person{name='Tom', age=12}, 456]

        System.out.println("***************List元素遍历***************");
        // 元素的遍历
        System.out.println("===============iterator===============");
        // 遍历方式一：iterator方式
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("===============listIterator===============");
        // 遍历方式二：listIterator方式
        // ListIterator是专门为遍历List而存在的
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("---------------------------");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.println("===============foreach===============");
        // 遍历方式三：foreach方式
        for (Object element : list) {
            System.out.println(element);
        }

        System.out.println("================for==============");
        // 遍历方式四：for循环方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("===============enumeration===============");
        // 遍历方式五：古老的遍历类
        Vector<Object> vector = new Vector<>(list);
        Enumeration<Object> enu = vector.elements();
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
    }
}