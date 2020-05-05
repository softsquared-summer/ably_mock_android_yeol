package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.orderinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.ordermodels.OrderDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderRetrofitInterface {

    @GET("/recommended-products")
    Call<OrderDefaultResponse> RequestRecommend();


}
