package com.purewatersellsystem.entity;

//用户表实体类
public class User {
    //用户ID
    private String userId;
    //用户昵称
    private String userNick;
    //用户密码
    private String userPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
