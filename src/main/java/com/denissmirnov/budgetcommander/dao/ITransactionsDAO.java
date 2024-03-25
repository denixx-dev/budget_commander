package com.denissmirnov.budgetcommander.dao;

import com.denissmirnov.budgetcommander.models.Transaction;
import java.util.List;

public interface ITransactionsDAO {
    boolean save (Transaction transaction) throws Exception;

    Iterable<Transaction> fetchAll() throws Exception;
}
