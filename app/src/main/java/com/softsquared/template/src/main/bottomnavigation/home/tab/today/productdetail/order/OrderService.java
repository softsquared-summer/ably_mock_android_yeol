package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces.OrderActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces.OrderRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.ordermodels.OrderDefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class OrderService {
    private final OrderActivityView mMainActivityView;

    OrderService(final OrderActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetRecommend() {
        final OrderRetrofitInterface mainRetrofitInterface = getRetrofit().create(OrderRetrofitInterface.class);
        mainRetrofitInterface.RequestRecommend().enqueue(new Callback<OrderDefaultResponse>() {

            @Override
            public void onResponse(Call<OrderDefaultResponse> call, Response<OrderDefaultResponse> response) {
                final OrderDefaultResponse defaultResponse = response.body();
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
            public void onFailure(Call<OrderDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
