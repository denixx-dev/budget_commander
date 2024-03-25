package com.denissmirnov.budgetcommander.dao;

import com.denissmirnov.budgetcommander.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransactionDAO implements ITransactionsDAO{
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public boolean save(Transaction transaction) throws Exception{
        transactionRepository.save(transaction);
        return false;
    }

    @Override
    public Iterable<Transaction> fetchAll() throws Exception{
        return transactionRepository.findAll();
    }
}
