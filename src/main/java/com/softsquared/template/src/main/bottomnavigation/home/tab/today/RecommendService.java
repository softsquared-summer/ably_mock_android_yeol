package com.softsquared.template.src.main.bottomnavigation.home.tab.today;

import android.util.Log;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces.RecommendActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces.RecommendRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.RecommendDefaultResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class RecommendService {
    private final RecommendActivityView mMainActivityView;

    RecommendService(final RecommendActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetRecommend() {
        final RecommendRetrofitInterface mainRetrofitInterface = getRetrofit().create(RecommendRetrofitInterface.class);
        mainRetrofitInterface.RequestRecommend().enqueue(new Callback<RecommendDefaultResponse>() {

            @Override
            public void onResponse(Call<RecommendDefaultResponse> call, Response<RecommendDefaultResponse> response) {
                final RecommendDefaultResponse defaultResponse = response.body();
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
            public void onFailure(Call<RecommendDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
