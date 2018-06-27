package com.androidteam.sellingthing.sellingthing;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ExploreTabFragment.OnFragmentInteractionListener
        ,Tab2Fragment.OnFragmentInteractionListener
        ,Tab3Fragment.OnFragmentInteractionListener
        , NavigationView.OnNavigationItemSelectedListener{

    int[] sampleImages = {R.drawable.electronic,R.drawable.fashion,R.drawable.sport,R.drawable.camera};
    private MaterialSearchView searchView;
    private DrawerLayout drawerLayout;
    private List<Product> productList;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private int mCurrentSelectedPosition;
    
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent getProducts = getIntent();
        productList = (List<Product>) getProducts.getSerializableExtra("Products");
        Log.d("Home Activity", String.valueOf(productList.size()));

        NavigationView navigationView = findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt("selected_navigation_drawer_position");
            mFromSavedInstanceState = true;
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        CarouselView carouselView = findViewById(R.id.carouselview);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


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
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhite));
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorWhite),getResources().getColor(R.color.select));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final  PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(), productList);
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

    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


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
            case R.id.nav_home:
                Toast.makeText(this, "thissssssss", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home:

//                StartUpActivity(new Intent(this,HomeActivity.class));
                //startActivity(new Intent(HomeActivity.this,StartUpActivity.class));
                drawerLayout.closeDrawers();

                return true;
        }
        return false;
    }
}
