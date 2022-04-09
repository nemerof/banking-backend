package com.usb.UniversalSavingsBank.entities;

import org.springframework.data.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Card {

    private String cardId;
    private String number;
    private LocalDateTime expiryDate;
    private String CVV2;

    private List<Transaction> transactionHistory;
    private double balance;
    private List<Pair<String, Integer>> limits;
    private boolean isCredit;

    public Card(List<Pair<String, Integer>> limits, boolean isCredit) {
        this.cardId = UUID.randomUUID().toString();
        this.number = HelperMethods.generateNumber(16);
        this.expiryDate = LocalDateTime.now().plusYears(5);
        this.CVV2 = HelperMethods.generateNumber(3);
        this.limits = limits;
        this.isCredit = isCredit;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardId, card.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }

    @Override
    public String toString() {
        return "Card {" +
                "cardId=" + cardId +
                ", number='" + number + '\'' +
                ", CVV2='" + CVV2 + '\'' +
                ", balance=" + balance +
                '}';
    }
}
