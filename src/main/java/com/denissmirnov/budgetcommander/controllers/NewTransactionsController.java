package com.denissmirnov.budgetcommander.controllers;

import com.denissmirnov.budgetcommander.dao.BcUserRepository;
import com.denissmirnov.budgetcommander.dao.TransactionRepository;
import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
@RequestMapping("/auth/userData")
@CrossOrigin("*")
public class NewTransactionsController {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BcUserRepository bcUserRepository;

    @PostMapping
    public String addTransaction(@RequestParam("bc_user") String userId,
                                 @RequestParam("transactionDate") String date,
                                 @RequestParam("accountBank") String accountBank,
                                 @RequestParam("contragent") String contragent,
                                 @RequestParam("transactionType") String transactionType,
                                 @RequestParam("transactionGroup") String transactionGroup,
                                 @RequestParam("project") String project,
                                 @RequestParam("commentary") String commentary,
                                 @RequestParam("amount") Long amount,
                                 @RequestParam("status") String status) throws ParseException {
        System.out.println("got into addTransaction method");

        Integer intUserId = Integer.parseInt(userId);
        ApplicationUser bc_user = bcUserRepository.findByUserId(intUserId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        Date transactionDate = dateFormat.parse(date);


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
