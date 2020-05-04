package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail;

import android.util.Log;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailRetrofitInterface;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class ProductdetailService {
    private final ProductdetailActivityView mMainActivityView;

    ProductdetailService(final ProductdetailActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void GetItemDetail(String productNum) {
        final ProductdetailRetrofitInterface mainRetrofitInterface = getRetrofit().create(ProductdetailRetrofitInterface.class);
        mainRetrofitInterface.RequestProductnum(productNum).enqueue(new Callback<ProductdetailDefaultResponse>() {

            @Override
            public void onResponse(Call<ProductdetailDefaultResponse> call, Response<ProductdetailDefaultResponse> response) {
                final ProductdetailDefaultResponse defaultResponse = response.body();
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
            public void onFailure(Call<ProductdetailDefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.d("request","실패했습니다.");
            }
        });
    }

}
