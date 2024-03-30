package com.denissmirnov.budgetcommander.controllers;

import com.denissmirnov.budgetcommander.dao.TransactionRepository;
import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth/userData")
@CrossOrigin("*")
public class NewTransactionsController {
    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping
    public String addTransaction(@RequestParam Long amount,
                                 @RequestParam ApplicationUser bc_user,
                                 @RequestParam Date transactionDate,
                                 @RequestParam String accountBank,
                                 @RequestParam String contragent,
                                 @RequestParam String transactionType,
                                 @RequestParam String transactionGroup,
                                 @RequestParam String project,
                                 @RequestParam String commentary,
                                 @RequestParam String status){
        System.out.println("got into addTransaction method");
        Transaction newTransaction = new Transaction(
                bc_user,
                transactionDate,
                accountBank,
                contragent,
                transactionType,
                transactionGroup,
                project,
                commentary,
                amount,
                status
        );
        System.out.println("passed creating new transaction");
        transactionRepository.save(newTransaction);
        System.out.println("passed saving new transaction");

        return "redirect:/auth/userData";
    }
}
