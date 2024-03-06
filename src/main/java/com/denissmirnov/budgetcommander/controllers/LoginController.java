package com.denissmirnov.budgetcommander.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/auth/login")
@CrossOrigin("*")
public class LoginController {
    @GetMapping
    public String showLoginForm(){
        return "login";
    }


}
