package org.example;

import java.time.LocalDate;

public class Letter extends PostedItem {
    private final double PRICE_OF_LETTER = 1.99;

    public Letter(String address, String sender, LocalDate date) {
        super(address, sender, date);
    }

    @Override
    protected double calculatePrice() {
        return PRICE_OF_LETTER;
    }
}
