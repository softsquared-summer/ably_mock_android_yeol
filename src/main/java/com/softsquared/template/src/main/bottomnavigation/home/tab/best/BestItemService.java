package com.softsquared.template.src.main.bottomnavigation.home.tab.best;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestiteminterfaces.BestItemActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestiteminterfaces.BestItemRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.BestItemDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces.RecommendActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces.RecommendRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.RecommendDefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class BestItemService {
    private final BestItemActivityView mMainActivityView;

    BestItemService(final BestItemActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetBestItem() {
        final BestItemRetrofitInterface mainRetrofitInterface = getRetrofit().create(BestItemRetrofitInterface.class);
        mainRetrofitInterface.RequestRecommend().enqueue(new Callback<BestItemDefaultResponse>() {

            @Override
            public void onResponse(Call<BestItemDefaultResponse> call, Response<BestItemDefaultResponse> response) {
                final BestItemDefaultResponse defaultResponse = response.body();
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
            public void onFailure(Call<BestItemDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
