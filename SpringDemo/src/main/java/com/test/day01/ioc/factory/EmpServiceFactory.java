package com.test.day01.ioc.factory;

import com.test.day01.ioc.service.EmpService;

/**
 * 非静态工厂类，使用时需要先实例化工厂类对象
 */
public class EmpServiceFactory {
    public EmpService getEmpService() {
        return new EmpService();
    }
}
