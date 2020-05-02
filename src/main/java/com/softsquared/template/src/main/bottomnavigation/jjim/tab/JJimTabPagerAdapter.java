package com.softsquared.template.src.main.bottomnavigation.jjim.tab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.template.src.main.bottomnavigation.jjim.tab.market.MarketFragment;
import com.softsquared.template.src.main.bottomnavigation.jjim.tab.product.ProductFragment;

public class JJimTabPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public JJimTabPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MarketFragment todayFragment = new MarketFragment();
                return todayFragment;
            case 1:
                ProductFragment newFragment = new ProductFragment();
                return newFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}