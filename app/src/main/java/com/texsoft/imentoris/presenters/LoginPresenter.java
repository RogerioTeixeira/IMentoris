package com.texsoft.imentoris.presenters;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by rogerio on 21/02/2017.
 */

public class LoginPresenter {
    FirebaseAuth auth;

    @Inject
    public LoginPresenter(FirebaseAuth auth) {
        this.auth = auth;
    }

    public void displayAuth() {
        Log.v("LoginPresenter", "Auth:" + auth.toString());
    }
}
