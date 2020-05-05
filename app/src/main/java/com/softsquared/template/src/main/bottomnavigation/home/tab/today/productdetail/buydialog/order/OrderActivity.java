package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order;

import android.os.Bundle;

import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.orderinterfaces.OrderActivityView;
import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.ordermodels.OrderDefaultResponse;

public class OrderActivity extends BaseActivity implements OrderActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivitiy_orderpage);




    }

    @Override
    public void validateSuccess(OrderDefaultResponse result) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
