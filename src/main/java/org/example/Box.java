package org.example;

import java.time.LocalDate;

public class Box extends PostedItem{
    private BoxType type;
    private double weight;

    public Box(String address, String sender, LocalDate date, BoxType type, double weight) {
        super(address, sender, date);
        this.type = type;
        this.weight = weight;
    }

    public BoxType getType() {
        return type;
    }

    public void setType(BoxType type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return type.getBasePrice() + weight * type.getMultiplier();
    }

    @Override
    public String toString() {
        return type + " box sent by: " + getSender()
                + " to: " + getAddress()
                + " on: " + getDate()
                + " with weight: " + getWeight()
                + " and price: " + getPrice();
    }
}
