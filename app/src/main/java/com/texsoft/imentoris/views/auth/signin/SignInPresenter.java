package com.texsoft.imentoris.views.auth.signin;

import android.util.Log;

import com.texsoft.imentoris.base.BasePresenter;
import com.texsoft.imentoris.iterator.LoginEmailPasswordIterator;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public class SignInPresenter extends BasePresenter<SignInContract.View> implements SignInContract.Presenter {
    private LoginEmailPasswordIterator iteratorLoginMail;

    public SignInPresenter(LoginEmailPasswordIterator iteratorLoginMail) {
        this.iteratorLoginMail = iteratorLoginMail;
        Log.v("TestDagger", "SignInPresenter const");

    }

    @Override
    public void signInWithPassword(String email, String password) {
        view.onSuccess();
    }
}
