package com.codegym.service;

import com.codegym.service.impl.CustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new CustomerServiceImpl();
        }
        return singleton;
    }
}
