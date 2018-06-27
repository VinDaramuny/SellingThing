package com.androidteam.sellingthing.sellingthing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.Serializable;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    int mNoTabs;
    private List<Product> productList;
    public PagerAdapter(FragmentManager fm, int mNoTabs, List<Product> productList) {
        super(fm);
        this.mNoTabs = mNoTabs;
        this.productList = productList;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               /* Tab1Fragment tab1Fragment = new Tab1Fragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Products", (Serializable) productList);
                tab1Fragment.setArguments(bundle);
                return tab1Fragment;*/
                ExploreTabFragment exploreTabFragment = new ExploreTabFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Products", (Serializable) productList);
                exploreTabFragment.setArguments(bundle);
                return exploreTabFragment;
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
