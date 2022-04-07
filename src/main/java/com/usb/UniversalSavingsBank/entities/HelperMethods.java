package com.usb.UniversalSavingsBank.entities;

import java.util.Random;

public class HelperMethods {

    protected static String generateNumber(int quantity) {
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < quantity; i ++) {
            number.append(new Random().nextInt(10));
        }

        return number.toString();
    }
}
