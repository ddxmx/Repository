package com.test.day15;

interface Net {
    public void browse();
}

class RealNet implements Net {
    @Override
    public void browse() {
        System.out.println("使用浏览器上网");
    }
}

/**
 * 代理类
 */
class ProxyNet implements Net {
    //代理类内部使用对象接收真实类对象
    private Net net;

    public ProxyNet(Net net) {
        this.net = net;
    }

    public void start() {
        System.out.println("初始化代理");
    }

    public void stop() {
        System.out.println("停止代理");
    }

    @Override
    public void browse() {
        this.start();
        //调用真实类的操作
        this.net.browse();
        this.stop();
    }
}

/**
 * 代理设计模式
 */
public class ProxyDemo {
    public static void main(String[] args) {
        /*
            初始化代理
            使用浏览器上网
            停止代理
         */
        new ProxyNet(new RealNet()).browse();
    }
}
