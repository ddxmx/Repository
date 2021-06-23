package com.test.day23;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * LinkedList是一个双向队列，内部以Node维护节点数据和前后的指向
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        //linkedList的使用
        //数据结构一：队列，先进先出
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("python");
        list.add("go");

        while (true) {
            String value = list.poll();
            if (null == value) {
                break;
            }
            System.out.println(value);
        }

        System.out.println("************************");
        //数据结构二：栈，先进后出
        list.push("hello");
        list.push("world");
        list.push("java");
        list.push("python");
        list.push("go");

        System.out.println(list.getFirst()); //go
        System.out.println(list.getLast()); //hello

        System.out.println("------------------------");
        while (true) {
            String value = null;
            try {
                value = list.pop();
            } catch (NoSuchElementException e) {
                break;
            }
            System.out.println(value);
        }
    }
}
