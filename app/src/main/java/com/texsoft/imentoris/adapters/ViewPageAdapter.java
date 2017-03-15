package com.texsoft.imentoris.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
        if (fm.getFragments() != null) {
            Log.v("AdaperPager", "Create:" + fm.getFragments().size());
        } else {
            Log.v("AdaperPager", "Create fm null:");
        }
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    public void removeFragment(Fragment fragment) {
        fragments.remove(fragment);
    }

    public void removeFragment(int position) {
        fragments.remove(position);
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }
}
