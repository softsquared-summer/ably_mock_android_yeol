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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.Cart.CartItem;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.option.SecondOptionItem;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionrecyclerview.AdapterSpinner1;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionrecyclerview.AdapterSpinner2;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionrecyclerview.CartAdapter;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces.OptionActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.OrderActivity;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces.ProductdetailActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo.ProductDetailResult;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productrecyclerview.MainViewAdapter;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo.OptionResult;

import java.util.ArrayList;
import java.util.List;

public class ProductdetailActivity<Static> extends BaseActivity implements ProductdetailActivityView,OptionActivityView{

    private TextView productprice;
    private Context mContext;
    private MainViewAdapter adapter;
    private String productNum;
    private RecyclerView recyclerView;
    private ArrayList<ProductDetailResult> list = new ArrayList<>();
    private ArrayList<OptionResult> listOption = new ArrayList<>();
    private ArrayList<String> firstOption = new ArrayList<>();
    private ArrayList<SecondOptionItem> SecondOption = new ArrayList<>();
    private ArrayList<String> firstOptionCopy = new ArrayList<>();
    private ArrayList<SecondOptionItem> SecondOptionCopy = new ArrayList<>();

    private ArrayList<CartItem> cartItemslist = new ArrayList<>();

    public String FirstOptionString;
    public String SecondOptionStirng;
    public String OptionPice;

    private Button buttonBuy;
    private Spinner option_Spiner1;
    private Spinner option_Spiner2;
    private Button dialogbutton;

    private AdapterSpinner1 adapterSpinner1;
    private AdapterSpinner2 adapterSpinner2;
    private Dialog dialog;
    private  List<String> data;
    private  List<String> data2;

    private ArrayList<CartItem> CartItemlist;
    private ListView productList;

    public static int counting;
    public static int cost;
    private boolean flag1 = false;
    private boolean flag2 = false;

    public ProductdetailActivity() {
    }


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
                dialog = new Dialog(mContext, R.style.DialogTheme);
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


                ImageButton Button_plus = dialog.findViewById(R.id.imageButton_plus);
                Button_plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView count = dialog.findViewById(R.id.textView_count);
                        TextView price = dialog.findViewById(R.id.textView_pirce);

                            counting++;
                            cost = counting * Integer.parseInt(listOption.get(1).getDetailedPrice());
                            count.setText(+counting + "개 선택");
                            price.setText("총 "+cost+"원");

                    }
                });

                ImageButton Button_minus = dialog.findViewById(R.id.imageButton_minus);
                Button_minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView count = dialog.findViewById(R.id.textView_count);
                        TextView price = dialog.findViewById(R.id.textView_pirce);

                        if (counting <= 0){

                        }
                        else {

                            counting--;
                            cost = counting * Integer.parseInt(listOption.get(1).getDetailedPrice());
                            count.setText(+counting + "개 선택");
                            price.setText("총 " + cost + "원");
                        }
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
    public void validateFailure(String message) {

    }

    @Override
    public void validateSuccessOptionInformation(OptionDefaultResponse result) {

        // 데이터 입력
        int size = result.getResult().length;
        for(int i=0;i<size;i++) {
            listOption.add(result.getResult(i));
        }



        for(int i=0;i<size;i++) {

            firstOption.add(listOption.get(i).getFirstOption());
            Log.d("첫번째 옵션은",listOption.get(i).getFirstOption());
        }

        for(int i=0; i<firstOption.size(); i++) {
            if(!firstOptionCopy.contains(firstOption.get(i)))
                firstOptionCopy.add(firstOption.get(i));
        }

        //데이터
        final List<String> data = new ArrayList<>();
        for(int i=0;i<firstOptionCopy.size();i++){
            data.add(firstOptionCopy.get(i));
        }
        data.add("옵션1을 선택해주세요");
        option_Spiner1 = dialog.findViewById(R.id.option_spiner1);
        adapterSpinner1 = new AdapterSpinner1(mContext, data){

            @Override
            public int getCount() {
                return super.getCount()-1;
            }
        };

        option_Spiner1.setAdapter(adapterSpinner1);
        option_Spiner1.setSelection(adapterSpinner1.getCount());

        // 스피너 이벤트 처리 ( 스피너 = setOnItemSelectedListener 이용)
        option_Spiner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    FirstOptionString = data.get(position);


                Log.d("몇번째 클릭하셨습니다",data.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        /////////////////////////////////////////////////////




        for(int i=0;i<size;i++) {
            SecondOption.add(new SecondOptionItem(listOption.get(i).getSecondOption(),listOption.get(i).getDetailedPrice()));
            Log.d("두번째 옵션은",listOption.get(i).getSecondOption());
        }


        for (int i = 0; i < SecondOption.size(); i++) {
            for (int j = 0; j < SecondOption.size(); j++) {
                if (i == j) {
                } else if (SecondOption.get(j).getSecondOption().equals(SecondOption.get(i).getSecondOption())) {
                    SecondOption.remove(j);
                }
            }
        }


        for(int i=0; i<SecondOption.size(); i++) {
            if(!SecondOptionCopy.contains(SecondOption.get(i)))
                SecondOptionCopy.add(SecondOption.get(i));
        }


        //데이터
        final List<SecondOptionItem> dataSecond = new ArrayList<>();
        for(int i=0;i<SecondOptionCopy.size();i++){
            dataSecond.add(SecondOptionCopy.get(i));
        }
        dataSecond.add(new SecondOptionItem("옵션2을 선택해주세요"," "));
        option_Spiner2 = dialog.findViewById(R.id.option_spiner2);
        adapterSpinner2 = new AdapterSpinner2(mContext, dataSecond){
            @Override
            public int getCount() {
                return super.getCount()-1;
            }
        };
        option_Spiner2.setAdapter(adapterSpinner2);
        option_Spiner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override   // position 으로 몇번째 것이 선택됬는지 값을 넘겨준다
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    SecondOptionStirng = dataSecond.get(position).getSecondOption();
                    OptionPice = dataSecond.get(position).getPrice();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        option_Spiner2.setSelection(adapterSpinner2.getCount());







    }

    @Override
    public void validateFailureOptionInformation(String message) {

    }

    private void GetItemDetail() {

        final ProductdetailService signupService = new ProductdetailService( this);
        signupService.GetItemDetail(productNum);

    }
    private void GetOptionInfor() {

        final OptionService signupService = new OptionService((OptionActivityView) this);
        signupService.GetOptionInfor(productNum);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}