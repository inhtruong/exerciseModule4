package com.codegym.service.impl;

import com.codegym.model.Transfer;
import com.codegym.repository.ITransferRepository;
import com.codegym.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransferServiceImpl implements ITransferService {
    @Autowired
    private ITransferRepository transferRepository;

    @Override
    public void insert(Transfer transfer) {
        transferRepository.insertTransfer(transfer);
    }
}
