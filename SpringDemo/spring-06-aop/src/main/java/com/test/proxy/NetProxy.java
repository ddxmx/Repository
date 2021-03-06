package com.test.proxy;

interface Net {
    public void browse();
}

class RealNet implements Net {
    public void browse() {
        System.out.println("使用浏览器上网");
    }
}

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
        Net net = new RealNet();
        ProxyNet proxyNet = new ProxyNet(net);
        proxyNet.browse();
    }
}
