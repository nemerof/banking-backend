package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/finish-reg")
public class RegistrationController {

    private final UserRepository userRepo;

    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public User getCompleteUser(@RequestBody User requestUser, Principal principal) {
        System.out.println(requestUser);
        User user = userRepo.findByEmail((String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("email")).get();

        user.setLogin(requestUser.getLogin());
        user.setPassword(requestUser.getPassword());
        user.setAddress(requestUser.getAddress());
        user.setBirthDate(requestUser.getBirthDate());
        user.setFirstName(requestUser.getFirstName());
        user.setSurname(requestUser.getSurname());

        System.out.println(user);
        return user;
    }
}
