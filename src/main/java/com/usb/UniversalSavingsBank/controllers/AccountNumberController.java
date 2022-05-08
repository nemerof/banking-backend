package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.AccountNumber;
import com.usb.UniversalSavingsBank.entities.Card;
import com.usb.UniversalSavingsBank.services.AccountService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountNumberController {

    private final AccountService accountService;

    public AccountNumberController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{number}")
    public AccountNumber getAccountNumber(@PathVariable String number) {
        AccountNumber accountNumber = accountService.getNumber(number);
        return accountNumber;
    }
// TODO api call for account number creation
//    @PostMapping
//    public AccountNumber createAccount(@RequestParam String userId) {
//        AccountNumber accountNumber = accountService.createAccountNumber(userId);
//        return accountNumber;
//    }

    @PatchMapping("/{number}")
    public AccountNumber updateCardLimits(@PathVariable String number,
                                 @RequestBody List<Pair<String, Integer>> limits) {
        AccountNumber accountNumber = accountService.updateLimits(number, limits);

        return accountNumber;
    }
}
