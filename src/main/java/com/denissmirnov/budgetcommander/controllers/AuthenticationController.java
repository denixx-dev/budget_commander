package com.denissmirnov.budgetcommander.controllers;

import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.LoginResponseDTO;
import com.denissmirnov.budgetcommander.models.RegistrationDTO;
import com.denissmirnov.budgetcommander.services.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private String username;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body, HttpSession session, Model model) {
        System.out.println("in loginUser method");

        Boolean isUserNull = false;

        LoginResponseDTO response = authenticationService.loginUser(body.getUsername(), body.getPassword());
//        System.out.println(response.getUser().getUsername());

        if (response.getUser() == null) {
            isUserNull = true;
            System.out.println("isUserNull value: " + isUserNull.toString());
        }

//        model.addAttribute("isUserNull", isUserNull);

        this.username = response.getUser().getUsername();
        session.setAttribute("username", this.username);

        return response;
    }


}
