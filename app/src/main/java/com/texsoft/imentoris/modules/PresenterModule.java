package com.texsoft.imentoris.modules;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.iterator.LoginEmailPasswordIterator;
import com.texsoft.imentoris.util.PerActivity;
import com.texsoft.imentoris.views.auth.signin.SignInContract;
import com.texsoft.imentoris.views.auth.signin.SignInPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@Module
public class PresenterModule {

    @PerActivity
    @Provides
    public SignInContract.Presenter getPresenter(LoginEmailPasswordIterator iterator) {
        Log.v("TestDagger", "SignInContract.Presenter");
        return new SignInPresenter(iterator);
    }

    @PerActivity
    @Provides
    public LoginEmailPasswordIterator getIterator(FirebaseAuth auth) {
        Log.v("TestDagger", "LoginEmailPasswordIterator");
        return new LoginEmailPasswordIterator(auth);
    }


}
