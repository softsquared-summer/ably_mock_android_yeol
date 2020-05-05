package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.ordermodels;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.ordermodels.datapojo.Result;

public class OrderDefaultResponse {

    @SerializedName("result")
    private Result[] result;
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private String isSuccess;

    public Result[] getResult() {
        return result;
    }

    public Result getResult(int i) {
        return result[i];
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}