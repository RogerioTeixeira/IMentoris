package com.texsoft.imentoris;

import android.app.Application;

import com.texsoft.imentoris.firebase.FirebaseModule;


/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

public class CustomApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .firebaseModule(new FirebaseModule())
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
