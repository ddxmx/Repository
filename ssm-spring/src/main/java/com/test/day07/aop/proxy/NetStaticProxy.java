package com.test.day07.aop.proxy;

/**
 * 代理类和真实类需要实现的父接口
 */
interface Net {
    public void browse();
}

/**
 * 真实类
 */
class RealNet implements Net {
    public void browse() {
        System.out.println("使用浏览器上网");
    }
}

/**
 * 代理类
 */
class ProxyNet implements Net {
    private Net net;

    public ProxyNet(Net net) {
        this.net = net;
    }

    public void browse() {
        this.start();
        net.browse();
        this.stop();
    }

    public void start() {
        System.out.println("开启代理");
    }

    public void stop() {
        System.out.println("断开代理");
    }
}

class ProxyNetTest {
    public static void main(String[] args) {
        ProxyNet proxyNet = new ProxyNet(new RealNet());
        proxyNet.browse();
    }
}
