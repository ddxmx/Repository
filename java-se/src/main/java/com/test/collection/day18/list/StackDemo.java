package com.test.collection.day18.list;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack类继承Vector类，也是一个同步操作类
 * Stack类使用push/pop/peek方法实现元素的压栈、弹栈、返回栈顶元素操作
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        stack.push(33);
        stack.push(55);
        stack.push(22);
        stack.push(44);

        // peek()每次会获取栈顶元素，但不会弹出元素，如果栈为空，将抛出EmptyStackException异常
        System.out.println("栈顶元素是：" + stack.peek());

        while (true) {
            try {
                // pop()每次会弹出栈顶元素，如果栈为空，将抛出EmptyStackException异常
                stack.pop();
                System.out.println(stack);
            } catch (EmptyStackException e) {
                e.printStackTrace();
                System.out.println("栈是否为空：" + stack.isEmpty());
                break;
            }
        }
    }
}
