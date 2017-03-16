package com.texsoft.imentoris.modules;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.texsoft.imentoris.adapters.PagerAdapterSignUp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 14/03/2017.
 */
@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public FragmentManager getFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    public Context getContext() {
        return activity;
    }

    @Provides
    public PagerAdapterSignUp getViewPageAdapter(FragmentManager fm) {
        return new PagerAdapterSignUp(fm);
    }
}
