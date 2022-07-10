package com.test.proxy;

import com.test.proxy.base.Net;
import com.test.proxy.base.RealNet;
import org.junit.Test;

public class NetCglibProxyTest {
    @Test
    public void cglibProxyTest() {
        Net proxy = (Net) (new NetCglibProxy(new RealNet()).getProxy());
        /*
            设置上网代理
            使用浏览器上网
            com.test.proxy.base.RealNet$$EnhancerByCGLIB$$702e56ff
            结束上网代理
         */
        proxy.browse();
    }
}