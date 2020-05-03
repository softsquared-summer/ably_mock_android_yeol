package com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewmodels.tabnewDefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface tabnewRetrofitInterface {

    @GET("/new-products")
    Call<tabnewDefaultResponse> RequestNewProduct();


}
