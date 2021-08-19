package com.codegym.service;

import com.codegym.service.impl.ProductServiceImpl;

public class ProductServiceFactory {
    private static IProductService singleton;

    public static synchronized IProductService getInstance() {
        if (singleton == null) {
            singleton = new ProductServiceImpl();
        }
        return singleton;
    }
}
