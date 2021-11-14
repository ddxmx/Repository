package com.test.oop.day08;

/**
 * 单向链表，添加元素时节点自动关联
 */
class Linked {
    // 根节点
    private Node root;

    // 添加元素
    public void add(String data) {
        Node node = new Node(data);
        if (null == this.root) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    // 打印链表
    public void print() {
        if (null != this.root) {
            this.root.print();
        }
    }

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

        // 将元素添加到列表末尾
        public void add(Node node) {
            // 当前是最后一个节点
            if (null == this.next) {
                this.next = node;
            } else {
                this.next.add(node);
            }
        }

        /**
         * 打印当前及子节点数据
         */
        public void print() {
            System.out.println(this.getData());
            // 判断子节点是否存在
            if (null != this.next) {
                this.next.print();
            }
        }
    }


}

/**
 * 单向链表模型
 */
public class LinkedDemo {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.add("A");
        linked.add("B");
        linked.add("C");
        linked.print();
    }
}
