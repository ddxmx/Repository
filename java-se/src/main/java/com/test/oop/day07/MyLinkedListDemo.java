package com.test.oop.day07;

/**
 * 手工实现单向链表模型
 * 单向链表，添加元素时自动关联前一个节点
 * 链表中节点对象包含两部分内容：
 * |- data，用于存储数据
 * |- next，用于指向下一个节点对象
 */
class MyLinkedList {
    // 根节点
    private Node root;

    /**
     * 添加元素
     */
    public void add(String data) {
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

    /**
     * 链表中节点对象类
     */
    private class Node {
        private String data;

        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * 将元素添加到链表末尾
         */
        public void add(Node node) {
            // 当前是最后一个节点
            if (null == this.next) {
                this.next = node;
            } else {
                this.next.add(node);
            }
        }

        /**
         * 打印所有节点数据
         */
        public void print() {
            // 打印当前节点数据
            System.out.println(this.getData());

            // 判断是否是最后一个节点
            if (null != this.next) {
                this.next.print();
            }
        }
    }
}

/**
 * 单向链表的创建和基本使用
 */
public class MyLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        // 添加元素时自动关联节点之间的关系
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
