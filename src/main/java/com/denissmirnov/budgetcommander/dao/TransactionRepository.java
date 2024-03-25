package com.denissmirnov.budgetcommander.dao;

import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE t.bc_user = :bcUser")
    List<Transaction> findByBc_User(ApplicationUser bcUser);
}
