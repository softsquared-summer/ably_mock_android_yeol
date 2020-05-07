package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces.OptionActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces.OptionRetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class OptionService {
    private final OptionActivityView mMainActivityView;

    OptionService(final OptionActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetOptionInfor(String productNum) {
        final OptionRetrofitInterface mainRetrofitInterface = getRetrofit().create(OptionRetrofitInterface.class);
        mainRetrofitInterface.RequestProductOption(productNum).enqueue(new Callback<OptionDefaultResponse>() {

            @Override
            public void onResponse(Call<OptionDefaultResponse> call, Response<OptionDefaultResponse> response) {
                final OptionDefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMainActivityView.validateFailureOptionInformation(null);
                    return;
                }
                Log.d("request",""+defaultResponse.getCode()+"성공했습니다.");
                if(defaultResponse.getCode()==100){
                    mMainActivityView.validateSuccessOptionInformation(defaultResponse);
                }
                else{

                }

            }

            @Override
            public void onFailure(Call<OptionDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailureOptionInformation(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
