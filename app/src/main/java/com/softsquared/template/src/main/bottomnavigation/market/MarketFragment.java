package com.softsquared.template.src.main.bottomnavigation.market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.market.fragment.MainViewAdapter;
import com.softsquared.template.src.main.bottomnavigation.market.fragment.MarketRecycleItem;
import com.softsquared.template.src.main.bottomnavigation.style.fragment.StyleRecyclerItem;

import java.util.ArrayList;

public class MarketFragment extends Fragment {
    ViewGroup viewGroup;

    private RecyclerView recyclerView;
    private MainViewAdapter adapter;
    private ArrayList<MarketRecycleItem> list = new ArrayList<>();
    private SwipeRefreshLayout swipeToRefresh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_market, container, false);



        recyclerView = viewGroup.findViewById(R.id.recyclerView);
        swipeToRefresh = viewGroup.findViewById(R.id.swipeToRefresh);

        list = new ArrayList<MarketRecycleItem>();

        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"1","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"2","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"3","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"4","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"5","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"6","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"7","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));
        list.add(new MarketRecycleItem(R.drawable.product1, R.drawable.product2,R.drawable.product3,"8","크림치즈마켓","#10대#20대","심플베이직","오늘의 신상 2개"));


        recyclerView.setHasFixedSize(true);
        adapter = new MainViewAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 새로고침 코드

                // 새로고침 완료
                swipeToRefresh.setRefreshing(false);
            }
        });


        return viewGroup;
    }
}
