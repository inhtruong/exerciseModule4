package com.codegym.repository;

import com.codegym.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Integer> {

    @Query(value = "INSERT INTO transfer (id, id_sender, id_receive, amount_receive, fees_percent, fees_amount)" +
            "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertTransfer(@Param("transfer") Transfer transfer);
}
