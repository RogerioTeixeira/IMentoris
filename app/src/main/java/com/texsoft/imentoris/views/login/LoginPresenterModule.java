package com.texsoft.imentoris.views.login;

import android.util.Log;

import com.texsoft.imentoris.util.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@Module
public class LoginPresenterModule {
    private LoginContract.View view;

    public LoginPresenterModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public LoginContract.View getView() {
        Log.v("TestDagger", "LoginContract");
        return view;
    }
}
