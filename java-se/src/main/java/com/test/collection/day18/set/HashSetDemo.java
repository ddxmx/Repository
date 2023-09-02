package com.test.collection.day18.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set接口中元素无序、不可重复
 * （1）HashSet：Set接口常用实现类，线程不安全，其中的元素无序，可以存储null，通过HashMap实现
 * （2）LinkedHashSet：HashSet子类，可以按照添加的顺序遍历，逻辑上有序，存储上无序
 * （3）TreeSet：可以对元素进行排序，元素类型必须要重写hashcode和equals方法，通过TreeMap实现
 * （4）CopyOnWriteArraySet：Set线程安全类
 */
public class HashSetDemo {
    public static void main(String[] args) {
        /*
            无序性，不等于随机性，存储的数据在底层数组中不是按照数组索引顺序添加，而是按照数据的hashCode()方法添加
            不可重复性：元素重复是根据hashCode和equals方法进行判断，使用数据结构：数组+链表的方法存储
            hashcode决定存放位置，equals进一步判断是否为同一个元素，相同则只会存储一个，不同则添加到同一个位置的链表上
         */
        Set<Object> set = new HashSet<>();

        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(123);
        // 通过Person类的hashCode()和equals()判断是否是相等对象
        set.add(new Person("Tom", 12));

        System.out.println(set); // [AA, CC, 123, Person(name=Tom, age=12)]

        /*
            AA
            CC
            123
            Person{name='Tom', age=12}
         */
        // set集合的遍历方式一：iterator
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // set集合的遍历方式二：foreach
        for (Object element : set) {
            System.out.println(element);
        }
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;

    /**
     * 按年龄从大到小排序，相同年龄按照名字从小到大排序
     */
    @Override
    public int compareTo(Person per) {
        if (this.age > per.age) {
            return -1;
        } else if (this.age < per.age) {
            return 1;
        } else {
            return this.name.compareTo(per.name);
        }
    }
}