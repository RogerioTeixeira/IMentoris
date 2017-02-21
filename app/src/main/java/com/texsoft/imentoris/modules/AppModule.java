package com.texsoft.imentoris.modules;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.texsoft.imentoris.CustomApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */
@Module
public class AppModule {
    CustomApplication application;

    public AppModule(CustomApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public  CustomApplication getApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public Resources provideResources() {
        return application.getResources();

    }
}
