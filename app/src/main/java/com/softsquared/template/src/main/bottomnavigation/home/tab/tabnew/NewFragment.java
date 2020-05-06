package com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabrecyclerview.MainViewAdapter;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewinterfaces.tabnewActivityView;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewmodels.datapojo.Result;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewmodels.tabnewDefaultResponse;

import java.util.ArrayList;

public class NewFragment extends Fragment implements tabnewActivityView {
    ViewPager viewPager;
    ViewGroup viewGroup;
    private MainViewAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Result> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home_tab_new, container, false);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_item);
        RequestNewProduct();

        return viewGroup;
    }

     private void RequestNewProduct() {
        final tabnewService tabnewService= new tabnewService(this);
         tabnewService.GetRecommend();

    }

    @Override
    public void validateSuccess(tabnewDefaultResponse result) {

        int size = result.getResult().length;
        for(int i=0;i<size;i++) {
            list.add(result.getResult(i));
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
}
