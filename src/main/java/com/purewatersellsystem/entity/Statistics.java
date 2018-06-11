package com.purewatersellsystem.entity;

//统计表实体类
public class Statistics {
    //水站ID
    private String stationId;
    //产品ID
    private String productId;
    //销量统计
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
