package com.test.day01.hello.factory;

import com.test.day01.hello.service.EmpService;

public class EmpServiceFactory {
    public EmpService getEmpService() {
        return new EmpService();
    }
}
