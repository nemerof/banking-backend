package com.usb.UniversalSavingsBank.services;

import com.usb.UniversalSavingsBank.entities.Card;
import com.usb.UniversalSavingsBank.entities.Transaction;
import com.usb.UniversalSavingsBank.repositories.CardRepository;
import com.usb.UniversalSavingsBank.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountService accountService;

    private final CardService cardService;

    private final CardRepository cardRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, CardService cardService, CardRepository cardRepository) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }

    public Transaction finalizeTransaction(Transaction transaction, String cardId) {
        Card card = cardService.getCardById(cardId);
        double balance = card.getBalance() + transaction.getAmount();
        card.setBalance(balance);

        Transaction newTransaction = new Transaction(transaction.getName(), transaction.getType(), transaction.getAmount(), balance, cardId);
        card.getTransactionHistory().add(newTransaction);
        cardRepository.save(card);

        transactionRepository.save(newTransaction);
        return newTransaction;
    }

    public List<Transaction> getForCard(String cardId) {
        List<Transaction> transactions = transactionRepository.findAllByCardId(cardId);

        return transactions;
    }

    public List<Transaction> getForAccNumber(String accNumber) {
        List<Card> cards = accountService.getNumber(accNumber).getCards();

        List<Transaction> transactions = new ArrayList<>();
        for (Card card : cards) {
            transactions.addAll(card.getTransactionHistory());
        }
        transactions.sort(Comparator.comparing(Transaction::getPerformDate));

        return transactions;
    }
}
