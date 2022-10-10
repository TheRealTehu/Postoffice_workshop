package org.example;

import java.time.LocalDate;

public abstract class PostedItem {
    private String address;
    private String sender;
    private LocalDate date;

    public PostedItem(String address, String sender, LocalDate date) {
        this.address = address;
        this.sender = sender;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public abstract double getPrice();
}
