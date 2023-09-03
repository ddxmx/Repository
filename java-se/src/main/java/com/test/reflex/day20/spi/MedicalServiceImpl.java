package com.test.reflex.day20.spi;

public class MedicalServiceImpl implements IService {
    @Override
    public String getPrice() {
        return "120.45元";
    }

    @Override
    public String getSpecifications() {
        return "50粒/盒";
    }
}
