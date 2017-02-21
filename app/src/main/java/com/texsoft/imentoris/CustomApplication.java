package com.texsoft.imentoris;

import android.app.Application;
import android.content.Context;

import com.texsoft.imentoris.components.AppComponent;
import com.texsoft.imentoris.components.DaggerAppComponent;
import com.texsoft.imentoris.modules.AppModule;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

public class CustomApplication extends Application {
    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                      .appModule(new AppModule(this))
                      .build();
    }

    public static  CustomApplication getCustomApplication(Context context){
        return (CustomApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
