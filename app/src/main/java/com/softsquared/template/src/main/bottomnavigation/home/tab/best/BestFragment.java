package com.softsquared.template.src.main.bottomnavigation.home.tab.best;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestiteminterfaces.BestItemActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.BestItemDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.datapojo.Result;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemrecyclerview.BestItemMainViewAdapter;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemrecyclerview.BestItemRecyclerItem;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.categoryrecyclerview.CategoryItem;
import com.softsquared.template.src.main.bottomnavigation.home.tab.best.categoryrecyclerview.MainViewAdapter;


import java.util.ArrayList;

public class BestFragment extends Fragment implements BestItemActivityView{
    ViewGroup viewGroup;
    private RecyclerView recyclerViewCategory;
    private RecyclerView recyclerViewItem;
    private MainViewAdapter categoryAdapter;
    private BestItemMainViewAdapter bestItemAdapter;
    private ArrayList<CategoryItem> categoryList = new ArrayList<>();
    private ArrayList<Result> bestItemList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home_tab_best, container, false);
        recyclerViewCategory = viewGroup.findViewById(R.id.RecyclerView_category);

        categoryList.add(new CategoryItem("비치웨어"));
        categoryList.add(new CategoryItem("언더웨어"));
        categoryList.add(new CategoryItem("주얼리"));
        categoryList.add(new CategoryItem("패션소품"));
        categoryList.add(new CategoryItem("신발"));
        categoryList.add(new CategoryItem("가방"));
        categoryList.add(new CategoryItem("스커트"));
        categoryList.add(new CategoryItem("팬츠"));
        categoryList.add(new CategoryItem("원피스"));
        categoryList.add(new CategoryItem("아우터"));
        categoryList.add(new CategoryItem("상의"));
        categoryList.add(new CategoryItem("전체"));

        recyclerViewCategory.setHasFixedSize(true);
        categoryAdapter = new MainViewAdapter(getActivity(),categoryList);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        //recyclerViewCategory.setNestedScrollingEnabled(false);
        recyclerViewCategory.setAdapter(categoryAdapter);



        // 상품 Recyclerview
        recyclerViewItem =  viewGroup.findViewById(R.id.recyclerview_item);


        RequestBestItem();




        return viewGroup;
    }

       private void RequestBestItem(){

        final BestItemService bestItemService = new BestItemService( this);
           bestItemService.GetBestItem();

    }

    @Override
    public void validateSuccess(BestItemDefaultResponse result) {

        int size = result.getResult().length;
        for(int i=0;i<size;i++) {
            bestItemList.add(result.getResult(i));
        }

        recyclerViewItem.setHasFixedSize(true);
        bestItemAdapter = new BestItemMainViewAdapter(getActivity(), bestItemList);
        recyclerViewItem.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerViewItem.setNestedScrollingEnabled(false);
        recyclerViewItem.setAdapter(bestItemAdapter);

        result.getResult().toString();

    }

    @Override
    public void validateFailure(String message) {

    }
}
