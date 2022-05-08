package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.services.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/finish-reg")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public User getCompleteUser(@RequestBody User requestUser, Principal principal) {
        System.out.println(requestUser);
        User user = registrationService.finishRegistration(requestUser, principal);
        return user;
    }
}
