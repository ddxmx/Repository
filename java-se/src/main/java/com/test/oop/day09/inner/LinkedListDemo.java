package com.test.oop.day09.inner;

/**
 * 单向链表的创建和基本使用
 * 单向链表，添加元素时自动关联前一个节点
 * 代码结构使用内部类完成
 */
class LinkedList {
    // 根节点
    private Node root;

    /**
     * 链表中节点对象包含两部分内容：
     * （1）data，用于存储数据
     * （2）next，用于指向下一个节点对象
     */
    private class Node {
        private String data;

        private Node next;

        public Node(String data) {
            this.data = data;
        }

        /**
         * 将元素添加到链表末尾
         */
        public void add(Node node) {
            // 当前节点是链表中最后一个节点
            if (null == this.next) {
                this.next = node;
            } else {
                this.next.add(node);
            }
        }

        /**
         * 输出所有节点数据
         */
        public void print() {
            // 打印当前节点数据
            System.out.println(this.data);

            // 判断当前节点是否是链表中最后一个节点
            if (null != this.next) {
                this.next.print();
            }
        }
    }

    /**
     * 添加元素
     */
    public void add(String data) {
        // 将传入的数据封装成Node对象
        Node node = new Node(data);
        // 链表为空，将当前节点作为根节点
        if (null == this.root) {
            this.root = node;
        } else { // 链表不为空，将节点添加进链表
            this.root.add(node);
        }
    }

    /**
     * 打印链表
     */
    public void print() {
        if (null != this.root) {
            this.root.print();
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // 添加元素时自动关联节点
        list.add("A");
        list.add("B");
        list.add("C");
        /*
            A
            B
            C
         */
        list.print();
    }
}