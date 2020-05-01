package com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.RecommendDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecommendRetrofitInterface {

    @GET("/recommended-products")
    Call<RecommendDefaultResponse> RequestRecommend();


}
