package com.softsquared.template.src.main.bottomnavigation.home.tab.today;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.template.R;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces.RecommendActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.RecommendDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.datapojo.Result;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendrecyclerview.MainViewAdapter;


import java.util.ArrayList;


public class TodayFragment extends Fragment implements RecommendActivityView {
    ViewPager viewPager;
    ViewGroup viewGroup;
    private MainViewAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Result> list = new ArrayList<>();
    private ArrayList<Result> listcopy = new ArrayList<>();
    private int currentPage = 1;
    private int previousTotal = 0;
    private int totPageCount = 0;
    private boolean loading = true;
    private int pagingcount = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home_tab_today, container, false);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_item);

        RequestRecommend();







        return viewGroup;
    }

    @Override
    public void validateSuccess(RecommendDefaultResponse result) {

        // 데이터 입력
        int size = result.getResult().length;
        for(int i=0;i<size;i++) {
            list.add(result.getResult(i));
        }

        for(int i=0;i<size;i++) {
            Log.d("StudyApp", "onBindViewHolder" +   list.get(i).toString());

        }




        recyclerView.setHasFixedSize(true);
        adapter = new MainViewAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void validateFailure(String message) {

    }

    private void RequestRecommend() {

        final RecommendService recommendService = new RecommendService(this);
        recommendService.GetRecommend();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void addItem(int initaillize){

        int size=10;

        for(int i=0;i<10;i++) {
            listcopy.add(list.get(initaillize+i));
        }
    }

}

