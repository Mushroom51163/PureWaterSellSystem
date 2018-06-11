package com.purewatersellsystem.entity;

public class Evaluate {
    private String evaluateId;
    private String orderId;
    private String deliverId;
    private String orderEvaluate;

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(String deliverId) {
        this.deliverId = deliverId;
    }

    public String getOrderEvaluate() {
        return orderEvaluate;
    }

    public void setOrderEvaluate(String orderEvaluate) {
        this.orderEvaluate = orderEvaluate;
    }

    public String getDeliverEvaluate() {
        return deliverEvaluate;
    }

    public void setDeliverEvaluate(String deliverEvaluate) {
        this.deliverEvaluate = deliverEvaluate;
    }

    private String deliverEvaluate;
}
