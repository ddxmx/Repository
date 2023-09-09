package com.test.reflex.day20.spi;

import java.util.ServiceLoader;

/**
 * 调用实现类的方法
 */
public class SpiBoot {
    public static void main(String[] args) {
        // 通过接口进行加载实现类
        ServiceLoader<IService> services = ServiceLoader.load(IService.class);

        // 遍历所有的实现类并进行方法调用，ServiceLoader是Iterable接口的实现类
        for (IService service : services) {
            System.out.println(service.getPrice());
            System.out.println(service.getSpecifications());
        }
    }
}
