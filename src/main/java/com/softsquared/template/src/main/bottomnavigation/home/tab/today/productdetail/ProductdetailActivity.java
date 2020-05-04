package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo.Result;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.recyclerview.MainViewAdapter;

import java.util.ArrayList;

public class ProductdetailActivity extends BaseActivity implements ProductdetailActivityView{

    private TextView productprice;

    private MainViewAdapter adapter;
    private String productNum;
    private RecyclerView recyclerView;
    private ArrayList<Result> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);

        recyclerView = findViewById(R.id.recyclerview_itemdetail);


        Intent productIntent = getIntent();
        productNum = productIntent.getStringExtra("productNum");
        Log.d("Recyclerview", "현재상품은 = "+ productNum);


        GetItemDetail();

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