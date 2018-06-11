package com.purewatersellsystem.entity;

public class ServiceInfo {
    private String userNick;
    private String advice;
    private String complain;

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "userNick='" + userNick + '\'' +
                ", advice='" + advice + '\'' +
                ", complain='" + complain + '\'' +
                '}';
    }
}
