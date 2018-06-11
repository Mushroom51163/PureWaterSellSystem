package com.purewatersellsystem.entity;

//客服表实体类
public class Service {
    //用户ID
    private String userId;
    //建议
    private String Advice;
    //投诉
    private String Complain;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdvice() {
        return Advice;
    }

    public void setAdvice(String advice) {
        Advice = advice;
    }

    public String getComplain() {
        return Complain;
    }

    public void setComplain(String complain) {
        Complain = complain;
    }
}
