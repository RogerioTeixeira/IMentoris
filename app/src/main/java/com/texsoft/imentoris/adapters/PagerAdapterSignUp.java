package com.texsoft.imentoris.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.texsoft.imentoris.views.auth.profile.ChooseRoleFragment;
import com.texsoft.imentoris.views.auth.signup.SignUpFragment;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */

public class PagerAdapterSignUp extends FragmentStatePagerAdapter {
    private final int size = 2;

    public PagerAdapterSignUp(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1)
            return new SignUpFragment();
        else
            return new ChooseRoleFragment();
    }

    @Override
    public int getCount() {
        return this.size;
    }
}
