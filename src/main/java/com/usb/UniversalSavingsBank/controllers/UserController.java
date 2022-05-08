package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = userService.getAll("");
        return users;
    }

    @GetMapping("/all/{filter}")
    // TODO redo filter (???)
    public List<User> getAllUsersByFilter(@PathVariable String filter) {
        List<User> users = userService.getAll(filter);
        return users;
    }

    @PatchMapping("/update")
    public User updateUser(@RequestBody User user) {
        User newUser = userService.update(user);
        return newUser;
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable String userId) {
        User user = userService.remove(userId);
        return user;
    }
}
