package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels;

import com.google.gson.annotations.SerializedName;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo.ProductDetailResult;

public class ProductdetailDefaultResponse {

    @SerializedName("result")
    private ProductDetailResult result;
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("isSuccess")
    private String isSuccess;

    public ProductDetailResult getResult() {
        return result;
    }

    public void setResult(ProductDetailResult result) {
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