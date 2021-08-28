package com.codegym.service;

import com.codegym.service.impl.HiberBillServiceImpl;

public class BillFactory {
    private static IBillService singleton;

    public static synchronized IBillService getService() {
        if (singleton == null) {
            singleton = new HiberBillServiceImpl();
        }
        return singleton;
    }
}
