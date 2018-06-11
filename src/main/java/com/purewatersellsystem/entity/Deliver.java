package com.purewatersellsystem.entity;

public class Deliver {
    private String deliverId;
    private String orderId;
    private String expresserId;
    private String delivereStatus;
    private String payMethod;
    private String acceptTime;
    private String isDone;

    @Override
    public String toString() {
        return "Deliver{" +
                "deliverId='" + deliverId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", expresserId='" + expresserId + '\'' +
                ", delivereStatus='" + delivereStatus + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", acceptTime='" + acceptTime + '\'' +
                ", isDone='" + isDone + '\'' +
                '}';
    }

    public String getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(String deliverId) {
        this.deliverId = deliverId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExpresserId() {
        return expresserId;
    }

    public void setExpresserId(String expresserId) {
        this.expresserId = expresserId;
    }

    public String getDelivereStatus() {
        return delivereStatus;
    }

    public void setDelivereStatus(String delivereStatus) {
        this.delivereStatus = delivereStatus;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }
}