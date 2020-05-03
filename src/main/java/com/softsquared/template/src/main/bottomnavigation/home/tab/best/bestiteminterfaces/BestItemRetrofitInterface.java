package com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestiteminterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.BestItemDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BestItemRetrofitInterface {

    @GET("/recommended-products")
    Call<BestItemDefaultResponse> RequestRecommend();


}
