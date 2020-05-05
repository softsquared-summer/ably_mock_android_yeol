package com.softsquared.template.src.main.bottomnavigation.mypage.signup;


import android.util.Log;
import android.widget.Toast;


import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupinterfaces.SignupActivityView;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupinterfaces.SignupRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels.SignupDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels.SignupRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class SignupService {
    private final SignupActivityView mMainActivityView;

    SignupService(final SignupActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetSignUp(SignupRequest Request) {
        final SignupRetrofitInterface mainRetrofitInterface = getRetrofit().create(SignupRetrofitInterface.class);
        mainRetrofitInterface.requestSignup(Request).enqueue(new Callback<SignupDefaultResponse>() {

            @Override
            public void onResponse(Call<SignupDefaultResponse> call, Response<SignupDefaultResponse> response) {
                final SignupDefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }
                Log.d("request",""+defaultResponse.getCode()+"성공했습니다.");

                if(defaultResponse.getCode()==100){
                    mMainActivityView.validateSuccess(defaultResponse.getResult());
                }else{
                    mMainActivityView.validateFailure(defaultResponse.getMessage());
                }

            }

            @Override
            public void onFailure(Call<SignupDefaultResponse> call, Throwable t) {

                Log.d("request", String.valueOf(t));
            }
        });
    }

}
