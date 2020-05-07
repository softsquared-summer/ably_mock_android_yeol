package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.account.AccountActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.adress.AddressActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces.OrderActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.ordermodels.OrderDefaultResponse;

public class OrderActivity extends BaseActivity implements OrderActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivitiy_orderpage);


        TextView text_adress = findViewById(R.id.textView_address);
        text_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
                startActivity(intent);
            }
        });


        TextView text_account = findViewById(R.id.textView_account);
        text_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent(); /*데이터 수신*/
        String address1 = intent.getExtras().getString("edit_1"); /*String형*/
        String address2 = intent.getExtras().getString("edit_2"); /*String형*/
        String address3 = intent.getExtras().getString("edit_3"); /*String형*/
        String address4 = intent.getExtras().getString("edit_4"); /*String형*/
        String address5 = intent.getExtras().getString("edit_5"); /*String형*/



    }

    @Override
    public void validateSuccess(OrderDefaultResponse result) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
