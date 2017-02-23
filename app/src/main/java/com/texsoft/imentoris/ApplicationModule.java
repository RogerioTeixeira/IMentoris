package com.texsoft.imentoris;

import android.app.Application;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@Module
public final class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        Log.v("TestDagger", "init Application");
        this.application = application;
    }

    @Provides
    @Singleton
    public Application getApplication() {
        Log.v("TestDagger", "getApplication");
        return this.application;
    }
}
