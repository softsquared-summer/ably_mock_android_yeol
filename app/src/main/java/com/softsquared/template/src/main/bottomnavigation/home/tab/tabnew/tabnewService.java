package com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewinterfaces.tabnewActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewinterfaces.tabnewRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewmodels.tabnewDefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class tabnewService {
    private final tabnewActivityView mMainActivityView;

    tabnewService(final tabnewActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetRecommend() {
        final tabnewRetrofitInterface mainRetrofitInterface = getRetrofit().create(tabnewRetrofitInterface.class);
        mainRetrofitInterface.RequestNewProduct().enqueue(new Callback<tabnewDefaultResponse>() {

            @Override
            public void onResponse(Call<tabnewDefaultResponse> call, Response<tabnewDefaultResponse> response) {
                final tabnewDefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }
                Log.d("request",""+defaultResponse.getCode()+"성공했습니다.");
                if(defaultResponse.getCode()==100){
                    mMainActivityView.validateSuccess(defaultResponse);
                }
                else{

                }

            }

            @Override
            public void onFailure(Call<tabnewDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
