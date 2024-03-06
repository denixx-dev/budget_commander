package com.denissmirnov.budgetcommander.controllers;

import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.LoginResponseDTO;
import com.denissmirnov.budgetcommander.models.RegistrationDTO;
import com.denissmirnov.budgetcommander.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
