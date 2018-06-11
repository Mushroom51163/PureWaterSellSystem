package com.purewatersellsystem.entity;

public class OrderInfoForExp {
    private String orderId;
    private String userNick;
    private String orderAddr;
    private String orderTime;
    private String appointmentTime;
    private String productName;
    //订单数量
    private String productCount;
    //订单总额
    private String orderTotalPay;
    private Integer isPaied;
    private String stationName;
    private String payMethod;

    @Override
    public String toString() {
        return "OrderInfoForExp{" +
                "orderId='" + orderId + '\'' +
                ", userNick='" + userNick + '\'' +
                ", orderAddr='" + orderAddr + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", productName='" + productName + '\'' +
                ", productCount='" + productCount + '\'' +
                ", orderTotalPay='" + orderTotalPay + '\'' +
                ", isPaied=" + isPaied +
                ", stationName='" + stationName + '\'' +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getOrderTotalPay() {
        return orderTotalPay;
    }

    public void setOrderTotalPay(String orderTotalPay) {
        this.orderTotalPay = orderTotalPay;
    }

    public Integer getIsPaied() {
        return isPaied;
    }

    public void setIsPaied(Integer isPaied) {
        this.isPaied = isPaied;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
}
