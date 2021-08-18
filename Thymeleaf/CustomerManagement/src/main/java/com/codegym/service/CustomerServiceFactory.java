package com.codegym.service;

import com.codegym.service.impl.CustomerServiceImpl;

public class CustomerServiceFactory {
    private static ICustomerService singleton;

    public static synchronized ICustomerService getInstance() {
        if (singleton == null) {
            singleton = new CustomerServiceImpl();
        }
        return singleton;
    }
}
