package com.softsquared.template.src.main.bottomnavigation.jjim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.template.R;
import com.softsquared.template.src.main.bottomnavigation.jjim.tab.JJimTabPagerAdapter;

public class JjimFragment extends Fragment {
    ViewGroup viewGroup;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_jjim, container, false);

        // Initializing the TabLayout
        tabLayout = viewGroup.findViewById(R.id.tablayout_jjim);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager =  viewGroup.findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        JJimTabPagerAdapter pagerAdapter = new JJimTabPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return viewGroup;
    }
}
