package com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupinterfaces;

import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels.SignupDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels.SignupRequest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SignupRetrofitInterface {

    @POST("/signUp")
    Call<SignupDefaultResponse> requestSignup(@Body SignupRequest params);


}
