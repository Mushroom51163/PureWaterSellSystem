package com.purewatersellsystem.entity;

//库存表实体类
public class Inventory {

    //水站ID
    private String stationId;
    //产品ID
    private String productId;
    //库存量
    private String quantity;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
