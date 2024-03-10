package com.denissmirnov.budgetcommander.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping("/auth/userData")
@CrossOrigin("*")
public class UserDataController {
    @GetMapping
    public String showUserDataPage(){
        return "userData";
    }
}
