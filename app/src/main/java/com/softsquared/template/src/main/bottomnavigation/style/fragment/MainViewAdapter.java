package com.softsquared.template.src.main.bottomnavigation.style.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.softsquared.template.R;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.Holder> {

    private Context context;
    private List<StyleRecyclerItem> list = new ArrayList<>();

    public MainViewAdapter(Context context, List<StyleRecyclerItem> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_style_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    /*
     * Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
     *
     * */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.imageView.setImageResource(list.get(itemposition).getIcon());
        holder.TitleText.setText(list.get(itemposition).getTitle());
        holder.descText.setText(list.get(itemposition).getDesc());
        holder.descText2.setText(list.get(itemposition).getDesc2());
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
        public ImageView imageView2;
        public TextView TitleText;
        public TextView descText;
        public TextView descText2;

        public Holder(View view){
            super(view);
            imageView =  view.findViewById(R.id.image_1);
            imageView2 =  view.findViewById(R.id.image_2);
            TitleText =  view.findViewById(R.id.text_1);
            descText =  view.findViewById(R.id.text_2);
            descText2 = view.findViewById(R.id.text_3);

            imageView2.bringToFront();
        }
    }
}
