package com.purewatersellsystem.entity;

public class InventoryInfo {
    private String stationName;
    private String productName;
    private String quantity;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryInfo{" +
                "stationName='" + stationName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
