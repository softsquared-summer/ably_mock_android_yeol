package com.softsquared.template.src.main.bottomnavigation.home.tab.today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.template.R;
import java.util.ArrayList;


public class TodayFragment extends Fragment {
    ViewPager autoScrollViewPager;

    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home_tab_today, container, false);




        return viewGroup;
    }
}
