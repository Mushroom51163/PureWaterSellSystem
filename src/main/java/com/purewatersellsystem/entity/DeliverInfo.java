package com.purewatersellsystem.entity;

public class DeliverInfo {
    private String info;
    private String infoTime;

    public DeliverInfo(String info, String infoTime) {
        this.info = info;
        this.infoTime = infoTime;
    }

    @Override
    public String toString() {
        return "DeliverInfo{" +
                "info='" + info + '\'' +
                ", infoTime='" + infoTime + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(String infoTime) {
        this.infoTime = infoTime;
    }
}
