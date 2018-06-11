package com.purewatersellsystem.entity;

//用户信息表实体类
public class UserInfo {
    //用户ID
    private String userId;
    //用户地址
    private String userAddr;
    //用户电话
    private String userTel;
    //用户信息ID
    private String userInfoId;
    //是否为默认地址    0代表否  1代表是
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
