package com.texsoft.imentoris.views.login;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.iterator.LoginEmailPasswordIterator;
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

    @ActivityScope
    @Provides
    public LoginContract.Presenter getPresenter(LoginContract.View view, LoginEmailPasswordIterator iterator) {
        Log.v("TestDagger", "LoginContract.Presenter");
        return new LoginPresenter(view, iterator);
    }

    @ActivityScope
    @Provides
    public LoginEmailPasswordIterator getIterator(FirebaseAuth auth) {
        Log.v("TestDagger", "LoginEmailPasswordIterator");
        return new LoginEmailPasswordIterator(auth);
    }


}
