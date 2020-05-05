package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductdetailRetrofitInterface {

    @GET("/products/{productIdx}")
    Call<ProductdetailDefaultResponse> RequestProductnum(@Path("productIdx") String productNum);


}
