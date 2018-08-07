package com.jery.lib.networklibrary.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class BaseResult implements Serializable {
    public static final int RESULT_SUCCESS = 200;
    public static final int RESULT_TOKEN_ERROR = 401;
    public static final int RESULT_RISK_ERROR = 600;

    public BaseResult() {
    }

    public BaseResult(int retCode, String retMsg) {
        this.code = retCode;
        this.msg = retMsg;
    }

    @SerializedName("resultcode")
    public int code;

    @SerializedName("reason")
    public String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static final int errorCode = -0x00001;
    public static final String errorMsg = "网络异常,请稍候再试";
}
