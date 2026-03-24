package org.gs.dto;

public class IronCalculationResult {
    private double totalWeight;
    private double totalPrice;

    public IronCalculationResult(double totalWeight, double totalPrice) {
        this.totalWeight = totalWeight;
        this.totalPrice = totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
