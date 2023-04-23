package com.test.jdk5.day16.generic;

import java.util.*;

/**
 * 泛型，即参数化类型，就是将类型由原来的具体的类型参数化
 * JDK1.5之前的容器类，添加元素时可以添加任意类型（Object类型），但是无法保证元素实际类型一致性，导致转型时ClassCastException
 */
public class GenericDemo {
    public static void main(String[] args) {
        // 不使用泛型带来的问题
        {
            // 对象实例化时不指定泛型的话，默认为Object
            ArrayList list = new ArrayList();
            list.add(78);
            list.add(76);
            list.add(89);
            list.add(88);
            // 问题一：类型不安全，可以添加任何的类型
            // list.add("Tom");

            for (Object element : list) {
                // 问题二：强转时，由于元素类型可能不一致，导致出现ClassCastException
                int value = (Integer) element;
                System.out.println(value);
            }
        }

        // 使用泛型能够解决类型不一致的问题
        {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(78);
            list.add(87);
            list.add(99);
            list.add(65);
            // 编译错误，元素必须是Integer类型才可以添加
            // list.add("Tom");

            // 遍历方式一：
            // 避免了强转操作
            for (Integer element : list) {
                System.out.println(element);
            }

            // 遍历方式二：
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                int value = iterator.next();
                System.out.println(value);
            }
        }


        // 泛型的嵌套
        {
            // Map<String,Integer> map = new HashMap<String,Integer>();
            // jdk7新特性：类型推断
            Map<String, Integer> map = new HashMap<>();

            map.put("Tom", 87);
            map.put("Jerry", 87);
            map.put("Jack", 67);

            // 泛型的嵌套
            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                String key = entry.getKey();
                int value = entry.getValue();
                System.out.println(key + ":" + value);
            }
        }

        // 泛型只在编译阶段有效，泛型类型在逻辑上可以看成是多个不同的类型，实际上都是相同的类型
        {
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            Class<?> class1 = list1.getClass();
            Class<?> class2 = list2.getClass();
            System.out.println(class1.getName()); // java.util.ArrayList
            System.out.println(class2.getName()); // java.util.ArrayList
            System.out.println(class1 == class2); // true
        }
    }
}
