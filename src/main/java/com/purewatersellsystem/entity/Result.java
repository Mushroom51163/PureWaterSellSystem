package com.purewatersellsystem.entity;

import java.io.Serializable;

//结果类
public class Result<T> implements Serializable {
    //  1=成功，0=失败
    private Integer status;
    //处理消息
    private String msg;
    //数据
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
