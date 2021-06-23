package com.test.day19;

class Info {
    private String key;
    private String value;

    public Info() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class InfoFactory {
    private Info info = new Info();

    private static InfoFactory instance = new InfoFactory();

    private InfoFactory() {
    }

    public static InfoFactory getInstance() {
        return instance;
    }

    public synchronized void get() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(info.getKey() + "->" + info.getValue());

        this.notify();
    }

    public synchronized void set(String key, String value) {
        info.setKey(key);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        info.setValue(value);
        System.out.println("生产者生产");

        this.notify();

        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (true) {
            if (flag) {
                InfoFactory.getInstance().set("hello", "world");
                flag = false;
            } else {
                InfoFactory.getInstance().set("welcome", "China");
                flag = true;
            }
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {
    @Override
    public void run() {
        while (true) {
            InfoFactory.getInstance().get();
        }
    }
}

/**
 * 生产者消费者问题
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) throws Exception {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        new Thread(consumer).start();
        Thread.sleep(1000);
        new Thread(producer).start();
    }
}
