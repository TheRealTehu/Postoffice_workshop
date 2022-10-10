package org.example;

import java.time.LocalDate;

public class Box extends PostedItem{
    private BoxType type;
    private double weight;

    public Box(String address, String sender, LocalDate date, BoxType type, double weight) {
        super(address, sender, date);
        this.type = type;
        this.weight = weight;
        this.setPrice(calculatePrice());
    }

    public BoxType getType() {
        return type;
    }

    public void setType(BoxType type) {
        this.type = type;
        this.setPrice(calculatePrice());
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        this.setPrice(calculatePrice());
    }

    @Override
    protected double calculatePrice() {
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
