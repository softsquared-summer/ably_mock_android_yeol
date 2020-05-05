package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.BuyDialog;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.buydialog.order.OrderActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo.Result;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.recyclerview.MainViewAdapter;

import java.util.ArrayList;

public class ProductdetailActivity extends BaseActivity implements ProductdetailActivityView{

    private TextView productprice;
    private Context mContext;
    private MainViewAdapter adapter;
    private String productNum;
    private RecyclerView recyclerView;
    private ArrayList<Result> list = new ArrayList<>();
    private Button buttonBuy;
    private BuyDialog buyDialog;
    private Spinner option_Spiner1;
    private Dialog dialog;
    private Button dialogbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);

        mContext = ProductdetailActivity.this;
        recyclerView = findViewById(R.id.recyclerview_itemdetail);
        buttonBuy = findViewById(R.id.button_buy);

        option_Spiner1 = findViewById(R.id.option_spiner1);

/*
        option_Spiner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
*/


        Intent productIntent = getIntent();
        productNum = productIntent.getStringExtra("productNum");
        Log.d("Recyclerview", "현재상품은 = " + productNum);

        GetItemDetail();


        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_itemdetail_buydialog);
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                Button btn = dialog.findViewById(R.id.dialogbutton_buy);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,OrderActivity.class);
                        mContext.startActivity(intent);
                    }
                });


                dialog.show();

            }
        });
    }


    @Override
    public void validateSuccess(ProductdetailDefaultResponse result) {


        list.add(result.getResult());

        recyclerView.setHasFixedSize(true);
        adapter = new MainViewAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void validateFailure(String message) {

    }

    private void GetItemDetail() {

        final ProductdetailService signupService = new ProductdetailService( this);
        signupService.GetItemDetail(productNum);

    }


}