package com.androidteam.sellingthing.sellingthing;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements Tab1Fragment.OnFragmentInteractionListener,Tab2Fragment.OnFragmentInteractionListener,Tab3Fragment.OnFragmentInteractionListener{
    private ArrayList<String> productTitle = new ArrayList<>();
    private ArrayList<String> productDesc= new ArrayList<>();
    private ArrayList<String> productRate = new ArrayList<>();
    private ArrayList<String> productPrice = new ArrayList<>();
    private ArrayList<String> productImg = new ArrayList<>();

    private MaterialSearchView searchView;
    private DrawerLayout drawerLayout;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);




        drawerLayout = findViewById(R.id.drawer);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        searchView = findViewById(R.id.search_view);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Explore"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorWhite),getResources().getColor(R.color.select));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final  PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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


//        insertItem();
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        ProductAdapter productAdapter = new ProductAdapter(productImg,productTitle,productDesc,productRate,productPrice,this);
//
//        recyclerView.setAdapter(productAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void insertItem(){
        productTitle.add("Coca Cola");
        productDesc.add("original taste");
        productRate.add("5");
        productPrice.add("2500");
        productImg.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");

        productTitle.add("Coca Cola");
        productDesc.add("original taste");
        productRate.add("5");
        productPrice.add("2500");
        productImg.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aa-4LErrHYE4jwpVr39dWEDDkpUSzVFMIubpVdRW8gHkJ1d1GA");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
