package com.usb.UniversalSavingsBank.services;

import com.usb.UniversalSavingsBank.entities.*;
import com.usb.UniversalSavingsBank.repositories.AccountRepository;
import com.usb.UniversalSavingsBank.repositories.CardRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    private final AccountService accountService;

    private final AccountRepository accountRepository;

    private final UserService userService;

    private static final List<Pair<String, Integer>> defaultLimits = new ArrayList<>(){{
        add(Pair.of("Withdrawal", 50_000));
        add(Pair.of("Online payment", 100_000));
        add(Pair.of("Transfer", 50_000));
    }};

    public CardService(CardRepository cardRepository, AccountService accountService, AccountRepository accountRepository, UserService userService) {
        this.cardRepository = cardRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public Card getCardById(String cardId) {
        Optional<Card> toCheckCard = cardRepository.findById(cardId);
        if (toCheckCard.isEmpty()) {
            // TODO if card not found
            return new Card();
        }

        return toCheckCard.get();
    }

    public Card block(String cardId, boolean toBlock) { // true - block, false - unblock
        Card card = getCardById(cardId);
        card.setBlocked(toBlock);
        cardRepository.save(card);
        return card;
    }

    // todo Check limits
    public Card updateLimits(String cardId, List<Pair<String, Integer>> limits) {
        Card card = getCardById(cardId);
        card.setLimits(limits);
        cardRepository.save(card);
        return card;
    }

    public Card create(Boolean isCredit, String accNumber) {
        Card card;
        if (isCredit) {
            card = new CreditCard(defaultLimits, accNumber);
        } else {
            card = new DebitCard(defaultLimits, accNumber);
        }
        AccountNumber account = accountService.getNumber(accNumber);
        account.getCards().add(card);
        accountRepository.save(account);
        cardRepository.save(card);
        return card;
    }

    public List<Card> getAllByAccNumber(String accNumber) {
        AccountNumber account = accountService.getNumber(accNumber);
        List<Card> cards = account.getCards();
        return cards;
    }

    public List<Card> getAllByUserId(String userId) {
        User user = userService.getUser(userId);
        AccountNumber accNumber = accountService.getNumber(user.getAccountNumber());
        List<Card> cards = accNumber.getCards();
        return cards;
    }

    public Card remove(String cardId) {
        Card card = getCardById(cardId);
        AccountNumber account = accountService.getNumber(card.getAccNumber());
        account.getCards().remove(card);
        accountRepository.save(account);
        cardRepository.delete(card);
        return card;
    }

    // TODO schedule to expire after expiration date of this card (dynamic scheduling)
    public Card expire(String cardId) {
        Card card = getCardById(cardId);
        block(cardId, true);
        cardRepository.save(card);
        return card;
    }

    // TODO expand expiration (only if <1 year left -> +2 years)
    public Card expand(String cardId) {
        Card card = getCardById(cardId);
        card.setExpiryDate(card.getExpiryDate().plusYears(2));
        cardRepository.save(card);
        return card;
    }

    public Card changeType(String cardId) {
        Card card = getCardById(cardId);
        if (card.isCredit()) {
            card.setCredit(false);
        } else {
            card.setCredit(true);
        }
        cardRepository.save(card);
        return card;
    }
}
