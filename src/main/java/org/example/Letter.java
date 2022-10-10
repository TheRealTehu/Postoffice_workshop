package org.example;

import java.time.LocalDate;

public class Letter extends PostedItem {
    private final double PRICE_OF_LETTER = 1.99;

    public Letter(String address, String sender, LocalDate date) {
        super(address, sender, date);
    }

    @Override
    public double getPrice() {
        return PRICE_OF_LETTER;
    }

    @Override
    public String toString() {
        return "Letter from: " + getSender()
                + " to: " + getAddress()
                + " on: " + getDate()
                + " with price: " + getPrice();
    }
}
