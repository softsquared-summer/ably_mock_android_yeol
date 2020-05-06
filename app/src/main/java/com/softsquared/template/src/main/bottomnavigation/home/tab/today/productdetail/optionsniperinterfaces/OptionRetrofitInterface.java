package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OptionRetrofitInterface {

    @GET("/products/{productIdx}/options")
    Call<OptionDefaultResponse> RequestProductOption(@Path("productIdx") String productNum);

}
