package com.androidteam.sellingthing.sellingthing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int mNoTabs;

    public PagerAdapter(FragmentManager fm, int mNoTabs) {
        super(fm);
        this.mNoTabs = mNoTabs;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                return tab1Fragment;
            case 1:
                Tab2Fragment tab2Fragment = new Tab2Fragment();
                return tab2Fragment;
            case 2:
                Tab3Fragment tab3Fragment = new Tab3Fragment();
                return tab3Fragment;
           default:
               return null;

        }
    }

    @Override
    public int getCount() {
        return mNoTabs;
    }
}
