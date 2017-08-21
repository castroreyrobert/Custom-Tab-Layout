package com.example.customtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by castroreyrobert on 8/21/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listFragmentTitle = new ArrayList<>();

    MyFragmentPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    void addFragment(Fragment fragment, String title) {
        listFragment.add(fragment);
        listFragmentTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentTitle.get(position);
    }
}
