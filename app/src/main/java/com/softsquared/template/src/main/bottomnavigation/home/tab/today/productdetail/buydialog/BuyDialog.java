package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.ProductdetailActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.OrderActivity;


import android.content.Intent;


import android.view.Window;

public class BuyDialog extends Dialog {

    Button btn;
    Intent intent;
    Context context;
    // Context ctx;
    // ctx = Custom_Dialog2.this;

    public BuyDialog(final Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_itemdetail_buydialog);

        btn = findViewById(R.id.dialogbutton_buy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context,OrderActivity.class);
                context.startActivity(intent);
            }
        });

    }

}