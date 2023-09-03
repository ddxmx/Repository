package com.test.reflex.day20.spi;

public class GoodServiceImpl implements IService {
    @Override
    public String getPrice() {
        return "35.00元";
    }

    @Override
    public String getSpecifications() {
        return "200g/件";
    }
}
