package com.codegym.service;

import com.codegym.model.Transfer;
import com.codegym.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ITransferService {
    void insert(Transfer transfer);
}
