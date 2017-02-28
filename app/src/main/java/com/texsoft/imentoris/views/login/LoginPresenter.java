package com.texsoft.imentoris.views.login;

import android.util.Log;

import com.texsoft.imentoris.base.BasePresenter;
import com.texsoft.imentoris.iterator.LoginEmailPasswordIterator;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginEmailPasswordIterator iteratorLoginMail;
    private LoginContract.View view;

    public LoginPresenter(LoginEmailPasswordIterator iteratorLoginMail) {
        this.iteratorLoginMail = iteratorLoginMail;
        Log.v("TestDagger", "LoginPresenter const");

    }

    @Override
    public void signInWithPassword(String email, String password) {
        view.onSuccess();
    }
}
