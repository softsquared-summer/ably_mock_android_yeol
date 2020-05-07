package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo.OptionResult;

public class OptionDefaultResponse {

    @SerializedName("result")
    private OptionResult[] result;
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private boolean isSuccess;



    public OptionResult[] getResult() {
        return result;
    }

    public OptionResult getResult(int i) {
        return result[i];
    }

    public void setResult(OptionResult[] result) {
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

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}