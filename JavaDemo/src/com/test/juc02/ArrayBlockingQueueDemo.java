package com.test.juc02;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 方法/处理方式     抛出异常	返回特殊值	一直阻塞	    超时退出
 * 插入		        add	        offer		put	        offer(e,time,unit)
 * 移除		        remove	    poll		take	    poll(time,unit)
 * 获取头		    element	    peek		无	        无
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
//        queue.add(4); // 超过有异常，Exception in thread "main" java.lang.IllegalStateException: Queue full
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove(); //超过有异常，Exception in thread "main" java.util.NoSuchElementException
    }
}
