package com.codegym.repository.impl;

import com.codegym.DTO.TransferDTO;
import com.codegym.repository.ITransferDTORepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TransferDTORepositoryImpl implements ITransferDTORepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<TransferDTO> selectAllTransfer() {
        String queryStr = "SELECT t.id as id, t.id_sender as id_sender, u.name_user as name_user, " +
                "t.id_receive as id_receive, u2.name_user as name_user, t.amount_receive as amount_receive, " +
                "t.fees_percent as fees_percent, t.fees_amount as fees_amount \n" +
                "FROM transfers t\n" +
                "LEFT JOIN users u\n" +
                "ON u.id = t.id_sender\n" +
                "LEFT JOIN users u2 \n" +
                "ON u2.id = t.id_receive";

        Query query = entityManager.createNativeQuery(queryStr);
        return query.getResultList();
    }
}
