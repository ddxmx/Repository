package com.test.collection.day23;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * LinkedList是一个双向队列，内部以Node维护节点数据和前后的指向
 * 如果列表长度未知，添加删除操作比较多，按照索引位置访问较少，推荐使用linkedList
 * 操作方法	作用	异常情况
 * add	添加一个元素	如果队列已满 , 则抛出一个 IllegalStateException 异常
 * offer	添加一个元素并返回true	如果队列已满, 则返回 false
 * put	添加一个元素	如果队列已满, 则阻塞
 * <p>
 * remove	移除并返回队列头部元素	如果队列为空, 则抛出一个 NoSuchElementException异常
 * poll	移除并返回队列头部元素	如果队列为空, 则返回null
 * take	移除并返回队列头部元素
 * <p>
 * element	返回队列头部元素	如果队列为空 , 则抛出一个NoSuchElementException 异常
 * peek	返回队列头部元素	如果队列为空, 则返回 null
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // linkedList的使用
        // 数据结构一：队列，先进先出
        // add、offer、remove、poll、element、peek
        // offer()方法将元素添加到队列末尾
        list.offer(1);
        list.offer(2);
        list.offer(3);
        list.offer(4);
        list.offer(5);

        while (true) {
            // poll()方法返回队列开头元素，队列为空时返回null
            Integer value = list.poll();
            if (null == value) {
                break;
            }
            System.out.println(value); // []
        }
        System.out.println(list);

        System.out.println("************************");
        // 数据结构二：栈，先进后出（栈顶为第一个元素）
        // push、pop、peek
        // push()方法将元素添加到栈顶，如果栈满了抛出异常IllegalStateException
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.println(list.getFirst()); // 5
        System.out.println(list.getLast()); // 1

        System.out.println("------------------------");
        while (true) {
            try {
                // pop()方法返回栈顶元素，栈为空时抛出异常NoSuchElementException
                System.out.println(list.pop());
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }
}
