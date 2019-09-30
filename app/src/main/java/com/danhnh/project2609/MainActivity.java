package com.danhnh.project2609;

import android.content.Context;
import android.os.Bundle;

import com.danhnh.project2609.adapter.main.MainBarAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;


import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MainBarAdapter pagerAdapter;

    private BottomNavigationView navigationView;
    private final Fragment HomeFragment = new HomeFragment();
    private final Fragment ProfileFragment = new ProfileFragment();
    private final Fragment NotificationFragment = new NotificationFragment();
    private final Fragment CartFragment = new CartFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
//        getSupportActionBar().hide(); // hide the title bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        pagerAdapter = new MainBarAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(HomeFragment);
        pagerAdapter.addFragment(ProfileFragment);
        pagerAdapter.addFragment(NotificationFragment);
        pagerAdapter.addFragment(CartFragment);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(mPageChangeListener);

        navigationView = findViewById(R.id.nav_view);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }


    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            navigationView.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_profile:
                    viewPager.setCurrentItem(1);

                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_cart:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

}
