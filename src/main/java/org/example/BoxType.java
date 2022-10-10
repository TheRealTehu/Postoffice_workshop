package org.example;

public enum BoxType {
    SMALL(7.99, 0.1), BIG(10.29, 0.29);

    private final double basePrice;
    private final double multiplier;

    BoxType(double basePrice, double multiplier) {
        this.basePrice = basePrice;
        this.multiplier = multiplier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getMultiplier() {
        return multiplier;
    }

}
