package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces.OrderActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.ordermodels.OrderDefaultResponse;

public class AccountActivity extends BaseActivity implements OrderActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_refuntaccount);






    }

    @Override
    public void validateSuccess(OrderDefaultResponse result) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
