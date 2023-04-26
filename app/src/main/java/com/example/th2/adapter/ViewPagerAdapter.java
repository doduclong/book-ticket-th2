package com.example.th2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.th2.fragment.DashboardFragment;
import com.example.th2.fragment.HomeFragment;
import com.example.th2.fragment.NotificationsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HomeFragment();
            case 1: return new DashboardFragment();
            case 2: return new NotificationsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
