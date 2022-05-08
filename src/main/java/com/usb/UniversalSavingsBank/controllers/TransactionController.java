package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.Transaction;
import com.usb.UniversalSavingsBank.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/account/{accNumber}")
    public List<Transaction> getTransactionsForAccNumber(@PathVariable String accNumber) {
        List<Transaction> transactions = transactionService.getForAccNumber(accNumber);

        return transactions;
    }

    @GetMapping("/user/{cardId}")
    public List<Transaction> getTransactionsForCard(@PathVariable String cardId) {
        List<Transaction> transactions = transactionService.getForCard(cardId);

        return transactions;
    }

    @PostMapping("/{cardId}")
    public Transaction createTransaction(@RequestBody Transaction transaction,
                                         @PathVariable String cardId) {
        Transaction newTransaction = transactionService.finalizeTransaction(transaction, cardId);

        return newTransaction;
    }
}
