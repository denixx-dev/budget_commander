package com.denissmirnov.budgetcommander.controllers;


import com.denissmirnov.budgetcommander.dao.BcUserRepository;
import com.denissmirnov.budgetcommander.dao.TransactionRepository;
import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.Transaction;
import com.denissmirnov.budgetcommander.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@Controller
@Slf4j
@RequestMapping("/auth/userData")
@CrossOrigin("*")
public class UserDataController {
    @Autowired
    BcUserRepository bcUserRepository;

    @Autowired
    TransactionRepository transactionRepository;

    private Integer userId;

    @GetMapping
    public String showUserDataPage(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        System.out.println("Passed getting username");
        System.out.println(username);

        ApplicationUser user = bcUserRepository.findByUsername(username);
        System.out.println("Passed getting user");

        this.userId = user.getUserId();
        System.out.println("Passed getting user id");
        System.out.println(userId);

        List<Transaction> transactions = transactionRepository.findByBc_User(user);
        System.out.println("Passed getting transactions");

        Collections.sort(transactions, Comparator.comparing(Transaction::getTransactionDate));

        // Подготовка данных для гистограммы
        List<String> labels = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        for (Transaction transaction : transactions) {
            labels.add(transaction.getTransactionDate().toString());
            values.add(Double.valueOf(transaction.getAmount()));
        }

//        Collections.sort(labels);


        labels.stream().forEach(el -> System.out.println(el));

        model.addAttribute("userId", userId);
        model.addAttribute("transactions", transactions);
        model.addAttribute("labels", labels);
        model.addAttribute("values", values);
        return "userData";
    }
}
