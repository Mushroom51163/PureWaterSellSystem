package com.purewatersellsystem.entity;

//派送员表实体类
public class Expresser {
    //派送员ID
    private String expresserId;
    //派送员姓名
    private String expresserName;
    //派送员所属水站
    private String expresserStation;
    //派送员电话
    private String expresserTel;
    //配送员状态
    private Integer expresserStatus;
    //订单ID
    private String orderId;
    //统计
    private Integer count;
    //密码
    private String expresserPwd;

    public Expresser() {
    }

    public Expresser(String expresserId, String expresserName, String expresserStation, String expresserTel, Integer expresserStatus, String orderId, Integer count, String expresserPwd) {
        this.expresserId = expresserId;
        this.expresserName = expresserName;
        this.expresserStation = expresserStation;
        this.expresserTel = expresserTel;
        this.expresserStatus = expresserStatus;
        this.orderId = orderId;
        this.count = count;
        this.expresserPwd = expresserPwd;
    }

    public String getExpresserPwd() {
        return expresserPwd;
    }

    public void setExpresserPwd(String expresserPwd) {
        this.expresserPwd = expresserPwd;
    }

    public String getExpresserId() {
        return expresserId;
    }

    public void setExpresserId(String expresserId) {
        this.expresserId = expresserId;
    }

    public String getExpresserName() {
        return expresserName;
    }

    public void setExpresserName(String expresserName) {
        this.expresserName = expresserName;
    }

    public String getExpresserStation() {
        return expresserStation;
    }

    public void setExpresserStation(String expresserStation) {
        this.expresserStation = expresserStation;
    }

    public String getExpresserTel() {
        return expresserTel;
    }

    public void setExpresserTel(String expresserTel) {
        this.expresserTel = expresserTel;
    }

    public Integer getExpresserStatus() {
        return expresserStatus;
    }

    public void setExpresserStatus(Integer expresserStatus) {
        this.expresserStatus = expresserStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
