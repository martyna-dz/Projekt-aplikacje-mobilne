package com.example.projekt;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SliderAdapter extends FragmentStatePagerAdapter {
    public SliderAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentScreenOneInfo();
            case 1:
                return new FragmentScreenTwoInfo();
            case 2:
                return new FragmentScreenThreeInfo();
            default:
                return new FragmentScreenOneInfo();
        }

    }

    @Override
    public int getCount() {

        return 3;
    }
}