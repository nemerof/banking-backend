package com.usb.UniversalSavingsBank.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.List;

@Getter
@Setter
// todo Credit card functionality
public class CreditCard extends Card {

    public CreditCard(List<Pair<String, Integer>> limits, String accNumber) {
        super(limits, true, accNumber);
    }
}
