package com.softsquared.template.src.main.bottomnavigation.mypage.signin;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signininterfaces.SigninRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.SigninRequest;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.SigninDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signininterfaces.SigninActivityView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class SigninService {
    private final SigninActivityView mMainActivityView;

    SigninService(final SigninActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetSignin(SigninRequest Request) {
        final SigninRetrofitInterface mainRetrofitInterface = getRetrofit().create(SigninRetrofitInterface.class);
        mainRetrofitInterface.RequestSignin(Request).enqueue(new Callback<SigninDefaultResponse>() {

            @Override
            public void onResponse(Call<SigninDefaultResponse> call, Response<SigninDefaultResponse> response) {
                final SigninDefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }
                Log.d("request",""+defaultResponse.getCode()+"성공했습니다.");
                if(defaultResponse.getCode()==100){
                    mMainActivityView.validateSuccess(true);
                }
                else{
                    mMainActivityView.validateSuccess(false);
                }

            }

            @Override
            public void onFailure(Call<SigninDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
