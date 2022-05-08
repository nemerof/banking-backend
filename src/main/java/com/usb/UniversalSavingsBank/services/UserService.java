package com.usb.UniversalSavingsBank.services;

import com.usb.UniversalSavingsBank.entities.AccountNumber;
import com.usb.UniversalSavingsBank.entities.Card;
import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AccountService accountService;

    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    public User getUser(String id) {
        Optional<User> toCheckUser = userRepository.findByUserId(id);
        if (toCheckUser.isEmpty()) {
            // TODO user with id doesn't exist
            return new User();
        }

        return toCheckUser.get();
    }

    // TODO make up and implement filter logic for users
    public List<User> getAll(String filter) {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User update(User newData) {
        User oldUser = getUser(newData.getUserId());
        // TODO user fields update logic
        userRepository.save(oldUser);
        return oldUser;
    }

    public User remove(String userId) {
        User user = getUser(userId);
        AccountNumber accNumber = accountService.getNumber(user.getAccountNumber());
        accountService.delete(accNumber);
        userRepository.delete(user);
        return user;
    }
}
