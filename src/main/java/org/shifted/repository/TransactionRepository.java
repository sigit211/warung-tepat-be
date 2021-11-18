package org.shifted.repository;

import org.shifted.entity.transaction.TransactionDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionDAO, Integer> {

    @Query("SELECT t from TransactionDAO t WHERE t.user_id = ?1")
    List<TransactionDAO> findByUserId(String user_id);

}
