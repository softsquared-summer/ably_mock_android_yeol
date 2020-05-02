package com.softsquared.template.src.main.bottomnavigation.mypage.signin.signininterfaces;

import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.SigninRequest;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.SigninDefaultResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SigninRetrofitInterface {

    @POST("/signIn")
    Call<SigninDefaultResponse> RequestSignin(@Body SigninRequest params);
}
