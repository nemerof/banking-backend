package com.usb.UniversalSavingsBank.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction {

    private LocalDateTime performDate;
    private double balanceAfter;
    private String name;
    private int amount;

    private TransactionType type;

    public Transaction(String name, TransactionType type, int amount) {
        this.performDate = LocalDateTime.now();
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "performDate=" + performDate +
                ", balanceAfter=" + balanceAfter +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
