package com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.datapojo.Result;

import java.util.ArrayList;
import java.util.List;

public class BestItemMainViewAdapter extends RecyclerView.Adapter<BestItemMainViewAdapter.Holder> {

    private Context context;
    private List<Result> list = new ArrayList<>();

    public BestItemMainViewAdapter(Context context, ArrayList<Result> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public BestItemMainViewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_tab_best_item, parent, false);
        BestItemMainViewAdapter.Holder holder = new BestItemMainViewAdapter.Holder(view);
        return holder;
    }

    /*
     * Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
     *
     * */
    @Override
    public void onBindViewHolder(BestItemMainViewAdapter.Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
      //  holder.imageView.setImageResource(list.get(itemposition).getThumbnailUrl());

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getThumbnailUrl() + "#" + position + System.currentTimeMillis()) //Glide가 동일한 URL일 때, 캐싱한 것을 보여주기 때문에 각각 URL을 틀리게 하기 위해 position과 현재 시각을 추가함
                .into(holder.imageView);

        holder.discount.setText(list.get(itemposition).getDiscountRatio());
        holder.price.setText(list.get(itemposition).getDisplayedPrice());
        holder.descText1.setText(list.get(itemposition).getMarketName());
        holder.descText2.setText(list.get(itemposition).getProductName());
        holder.descText3.setText(list.get(itemposition).getPurchaseCnt());
        Log.e("StudyApp", "onBindViewHolder" + itemposition);
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ImageView imageView_heart;
        public TextView discount;
        public TextView price;
        public TextView descText1;
        public TextView descText2;
        public TextView descText3;

        public Holder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img_thumb);
            imageView_heart = view.findViewById(R.id.img_heart);
            discount = (TextView) view.findViewById(R.id.txt_discou);
            price = (TextView) view.findViewById(R.id.txt_price);
            descText1 = (TextView) view.findViewById(R.id.txt_title1);
            descText2 = (TextView) view.findViewById(R.id.txt_title2);
            descText3 = (TextView) view.findViewById(R.id.txt_title3);

            imageView_heart.bringToFront();
        }
    }
}
