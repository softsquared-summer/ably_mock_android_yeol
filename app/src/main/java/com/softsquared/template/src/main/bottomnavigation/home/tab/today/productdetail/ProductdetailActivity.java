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

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces.OptionActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.OrderActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo.ProductDetailResult;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productrecyclerview.MainViewAdapter;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo.OptionResult;

import java.util.ArrayList;

public class ProductdetailActivity extends BaseActivity implements ProductdetailActivityView,OptionActivityView{

    private TextView productprice;
    private Context mContext;
    private MainViewAdapter adapter;
    private String productNum;
    private RecyclerView recyclerView;
    private ArrayList<ProductDetailResult> list = new ArrayList<>();
    private ArrayList<OptionResult> listOption = new ArrayList<>();
    private Button buttonBuy;
    private Spinner option_Spiner1;
    private Button dialogbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);

        mContext = ProductdetailActivity.this;
        recyclerView = findViewById(R.id.recyclerview_itemdetail);
        buttonBuy = findViewById(R.id.button_buy);


        Intent productIntent = getIntent();
        productNum = productIntent.getStringExtra("productNum");
        Log.d("Recyclerview", "현재상품은 = " + productNum);

        GetItemDetail();

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 옵션 정보 조회
                GetOptionInfor();


                // 다이얼로그 출력
                Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_itemdetail_buydialog);
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


                // 1-1 다이얼로그 구매버튼 클릭
                Button btn = dialog.findViewById(R.id.dialogbutton_buy);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext,OrderActivity.class);
                        mContext.startActivity(intent);
                    }
                });

                // 1-2 다이얼로그 장바구니버튼 클릭


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
    public void validateSuccess(OptionDefaultResponse result) {

       //


    }

    @Override
    public void validateFailure(String message) {

    }

    private void GetItemDetail() {

        final ProductdetailService signupService = new ProductdetailService( this);
        signupService.GetItemDetail(productNum);

    }
    private void GetOptionInfor() {

        final OptionService signupService = new OptionService((OptionActivityView) this);
        signupService.GetOptionInfor(productNum);

    }

}