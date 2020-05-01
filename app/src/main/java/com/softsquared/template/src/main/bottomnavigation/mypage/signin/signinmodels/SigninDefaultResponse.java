package com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.datapojo.Result;

import java.util.ArrayList;

public class SigninDefaultResponse {
    @SerializedName("result")
    private Result result;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;


    public Result getResult() { return result; }
    public boolean isSuccess() { return isSuccess; }
    public int getCode() { return code; }
    public String getMessage() { return message; }
}