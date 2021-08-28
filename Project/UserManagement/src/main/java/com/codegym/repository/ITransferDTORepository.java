package com.codegym.repository;

import com.codegym.DTO.TransferDTO;
import com.codegym.model.Transfer;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface ITransferDTORepository {
    List<TransferDTO> selectAllTransfer();
}
