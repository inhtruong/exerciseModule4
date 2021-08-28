package com.codegym.service.impl;

import com.codegym.DTO.TransferDTO;
import com.codegym.repository.ITransferDTORepository;
import com.codegym.service.ITransferDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferDTOServiceImpl implements ITransferDTOService {
    @Autowired
    private ITransferDTORepository transferDTORepository;


    @Override
    public List<TransferDTO> findAll() {
        return transferDTORepository.selectAllTransfer();
    }
}
