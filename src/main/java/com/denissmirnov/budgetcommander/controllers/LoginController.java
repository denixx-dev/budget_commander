package com.denissmirnov.budgetcommander.controllers;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Controller
@RequestMapping(value = "/auth/login")
@CrossOrigin("*")
public class LoginController implements WebMvcConfigurer {
    @GetMapping()
    public String showLoginForm(){
        return "login";
    }



}
