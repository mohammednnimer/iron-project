package org.gs.dto;
public class IronCalculationRequest {
    private int type;
    private double quantity;
    private double length;
    private double unitWeight;
    private double unitPrice;
    private String ironType;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getUnitWeight() {
        return unitWeight;
    }
    public void setUnitWeight(double unitWeight) {
        this.unitWeight = unitWeight;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getIronType() {
        return ironType;
    }
    public void setIronType(String ironType) {
        this.ironType = ironType;
    }
}
