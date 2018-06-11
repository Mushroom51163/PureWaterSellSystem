package com.purewatersellsystem.entity;

//订单表实体类
public class Order {
    //订单ID
    private String orderId;
    //用户ID
    private String userId;
    //用户地址
    private String orderAddr;
    //订单时间
    private String orderTime;
    //预约时间
    private String appointmentTime;
    //产品ID
    private String productId;
    //订单数量
    private String productCount;
    //订单总额
    private String orderTotalPay;
    //是否支付
    private Integer isPaied;
    //所属水站
    private String stationName;
    //支付方式
    private String payMethod;
    //订单完成时间
    private String doneTime;
    //订单状态
    private String orderStatus;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderAddr='" + orderAddr + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", productId='" + productId + '\'' +
                ", productCount='" + productCount + '\'' +
                ", orderTotalPay='" + orderTotalPay + '\'' +
                ", isPaied=" + isPaied +
                ", stationName='" + stationName + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", doneTime='" + doneTime + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(String doneTime) {
        this.doneTime = doneTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
