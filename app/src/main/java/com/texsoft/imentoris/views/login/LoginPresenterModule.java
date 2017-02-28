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

    @ActivityScope
    @Provides
    public LoginContract.Presenter getPresenter(LoginEmailPasswordIterator iterator) {
        Log.v("TestDagger", "LoginContract.Presenter");
        return new LoginPresenter(iterator);
    }

    @ActivityScope
    @Provides
    public LoginEmailPasswordIterator getIterator(FirebaseAuth auth) {
        Log.v("TestDagger", "LoginEmailPasswordIterator");
        return new LoginEmailPasswordIterator(auth);
    }


}
