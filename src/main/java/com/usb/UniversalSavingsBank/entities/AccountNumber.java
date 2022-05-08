package com.usb.UniversalSavingsBank.entities;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class AccountNumber implements Serializable {

    @Id
    private String number;
    private double balance;
    private LocalDateTime creationTime;
    private List<Pair<String, Integer>> limits;
    private List<Card> cards;

    private String userId;

    public AccountNumber(List<Pair<String, Integer>> limits, String userId, String countryCode) {
        this.number = countryCode + HelperMethods.generateNumber(26);
        this.creationTime = LocalDateTime.now();
        this.limits = limits;
        this.userId = userId;
        this.cards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "AccountNumber {" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", cards=" + cards +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber that = (AccountNumber) o;
        return Objects.equals(number, that.number) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, userId);
    }
}
