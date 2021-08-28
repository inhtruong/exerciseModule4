package com.codegym.service;

import com.codegym.DTO.TransferDTO;
import com.codegym.model.Transfer;


import java.util.List;

public interface ITransferDTOService {
    List<TransferDTO> findAll();
}
