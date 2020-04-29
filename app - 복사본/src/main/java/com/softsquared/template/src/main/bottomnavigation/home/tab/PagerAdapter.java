package com.softsquared.template.src.main.bottomnavigation.home.tab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.softsquared.template.src.main.bottomnavigation.home.tab.best.BestFragment;
import com.softsquared.template.src.main.bottomnavigation.home.tab.hotdeal.HotdealFragment;
import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.NewFragment;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.TodayFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;
            case 1:
                NewFragment newFragment = new NewFragment();
                return newFragment;
            case 2:
                BestFragment bestFragment = new BestFragment();
                return bestFragment;
            case 3:
                HotdealFragment hotdealFragment = new HotdealFragment();
                return hotdealFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}