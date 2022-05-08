package com.usb.UniversalSavingsBank.services;

import com.usb.UniversalSavingsBank.entities.AccountNumber;
import com.usb.UniversalSavingsBank.entities.Card;
import com.usb.UniversalSavingsBank.entities.User;
import com.usb.UniversalSavingsBank.repositories.AccountRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountNumber createAccountNumber(User user) {
        AccountNumber number = new AccountNumber(new ArrayList<>(), user.getUserId(), "PL");
        accountRepository.save(number);
        return number;
    }

    public AccountNumber getNumber(String accNumber) {
        Optional<AccountNumber> toCheckNumber = accountRepository.findById(accNumber);
        if (toCheckNumber.isEmpty()) {
            // TODO if account number doesn't exist
            return new AccountNumber();
        }

        return toCheckNumber.get();
    }

    public void delete(AccountNumber accNumber) {
        accountRepository.delete(accNumber);
    }

    // todo Check limits
    public AccountNumber updateLimits(String number, List<Pair<String, Integer>> limits) {
        AccountNumber accountNumber = getNumber(number);
        accountNumber.setLimits(limits);
        accountRepository.save(accountNumber);
        return accountNumber;
    }
}
