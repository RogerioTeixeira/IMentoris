package com.texsoft.imentoris.views.login;

import android.util.Log;

import com.texsoft.imentoris.iterator.LoginEmailPasswordIterator;

import javax.inject.Inject;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginEmailPasswordIterator iteratorLoginMail;
    private LoginContract.View view;

    @Inject
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        Log.v("TestDagger", "LoginPresenter const");

    }

    @Inject
    public void setIteratorLoginMail(LoginEmailPasswordIterator iteratorLoginMail) {
        this.iteratorLoginMail = iteratorLoginMail;
        Log.v("TestDagger", "LoginPresenter set");
    }

    @Override
    public void signInWithPassword(String email, String password) {

    }
}
