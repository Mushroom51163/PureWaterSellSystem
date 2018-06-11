package com.purewatersellsystem.entity;

//水站表实体类
public class WaterStation {
    //水站ID
    private String stationId;
    //水站名
    private String stationName;
    //水站地址
    private String stationAddr;
    //水站电话
    private String stationTel;
    //水站经理
    private String stationMangr;


    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddr() {
        return stationAddr;
    }

    public void setStationAddr(String stationAddr) {
        this.stationAddr = stationAddr;
    }

    public String getStationTel() {
        return stationTel;
    }

    public void setStationTel(String stationTel) {
        this.stationTel = stationTel;
    }

    public String getStationMangr() {
        return stationMangr;
    }

    public void setStationMangr(String stationMangr) {
        this.stationMangr = stationMangr;
    }


    public WaterStation() {
    }

    public WaterStation(String stationId, String stationName, String stationAddr, String stationTel, String stationMangr) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationAddr = stationAddr;
        this.stationTel = stationTel;
        this.stationMangr = stationMangr;
    }
}
