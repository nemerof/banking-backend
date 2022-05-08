package com.usb.UniversalSavingsBank.services;

import com.usb.UniversalSavingsBank.entities.AccountNumber;
import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class RegistrationService {

    private final UserRepository userRepo;

    private final AccountService accountService;

    public RegistrationService(UserRepository userRepo, AccountService accountService) {
        this.userRepo = userRepo;
        this.accountService = accountService;
    }

    public User finishRegistration(User requestUser, Principal principal) {
        User user = userRepo.findByEmail((String) ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("email")).get();

        user.setLogin(requestUser.getLogin());
        user.setPassword(requestUser.getPassword());
        user.setAddress(requestUser.getAddress());
        user.setBirthDate(requestUser.getBirthDate());
        user.setFirstName(requestUser.getFirstName());
        user.setSurname(requestUser.getSurname());

        AccountNumber number = accountService.createAccountNumber(user);
        user.setAccountNumber(number.getNumber());

        userRepo.save(user);

        return user;
    }
}
