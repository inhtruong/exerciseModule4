package com.codegym.service;


import com.codegym.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> findAll();

    Bill findOne(Long id);
}
