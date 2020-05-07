package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.adress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces.OrderActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.ordermodels.OrderDefaultResponse;

public class AddressActivity extends BaseActivity implements OrderActivityView {

    private String edit_1;
    private String edit_2;
    private String edit_3;
    private String edit_4;
    private String edit_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        TextView editText_1 = findViewById(R.id.editText_1);
        TextView editText_2 = findViewById(R.id.editText_2);
        TextView editText_3 = findViewById(R.id.editText_3);
        TextView editText_4 = findViewById(R.id.editText_4);
        TextView editText_5 = findViewById(R.id.editText_5);

          edit_1= editText_1.getText().toString();
          edit_2= editText_2.getText().toString();
          edit_3= editText_3.getText().toString();
          edit_4= editText_4.getText().toString();
          edit_5= editText_5.getText().toString();



        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("name","홍길동"); /*송신*/
        intent.putExtra("age",20);
        intent.putExtra("array",array);
        intent.putExtra("class",option);
        startActivity(intent);



    }

    @Override
    public void validateSuccess(OrderDefaultResponse result) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
