package com.usb.UniversalSavingsBank.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.List;

@Getter
@Setter
// todo Debit card functionality
public class DebitCard extends Card {
    public DebitCard(List<Pair<String, Integer>> limits) {
        super(limits, false);
    }
}
