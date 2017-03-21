package com.texsoft.imentoris.modules;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.util.PerActivity;
import com.texsoft.imentoris.views.auth.signin.SignInContract;
import com.texsoft.imentoris.views.auth.signin.SignInPresenter;
import com.texsoft.imentoris.views.auth.signup.SignUpContract;
import com.texsoft.imentoris.views.auth.signup.SignUpPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@Module
public class PresenterModule {

    @PerActivity
    @Provides
    public SignInContract.Presenter getSignInPresenter(FirebaseAuth auth) {
        Log.v("TestDagger", "SignInContract.Presenter");
        return new SignInPresenter(auth);
    }

    @PerActivity
    @Provides
    public SignUpContract.Presenter getSignUpPresenter(FirebaseAuth auth) {
        Log.v("TestDagger", "SignInContract.Presenter");
        return new SignUpPresenter(auth);
    }


}
