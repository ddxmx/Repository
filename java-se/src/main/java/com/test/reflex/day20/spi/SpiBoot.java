package com.test.reflex.day20.spi;

import java.util.ServiceLoader;

public class SpiBoot {
    public static void main(String[] args) {
        ServiceLoader<IService> services = ServiceLoader.load(IService.class);
        for (IService service : services) {
            System.out.println(service.getPrice());
            System.out.println(service.getSpecifications());
        }
    }
}
