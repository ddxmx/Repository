package com.test.collection.day18.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * fail-fast机制是java集合中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
 * 例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了，就会抛出ConcurrentModificationException异常
 * 创建迭代器对象时expectedModCount = modCount，进行next和remove时，进行判断是否相等
 * list的add、remove等操作会修改modCount值，造成值不一致
 * 解决方案是使用CopyOnWriteArrayList类，CopyOnWriteArrayList的add、set、remove等操作，都是先拷贝副本，副本中操作完成后替换
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55));
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(11, 22, 33, 44, 55));

        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();

            while (iterator.hasNext()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Exception in thread "Thread-0" java.util.ConcurrentModificationException
                System.out.println(Thread.currentThread().getName() + "线程运行，" + iterator.next());
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(100);
        }).start();
    }
}
