package com.texsoft.imentoris.presenters;

import android.util.Log;

import com.texsoft.imentoris.Interactor.FirebaseLoginIteractor;
import com.texsoft.imentoris.views.login.LoginContract;

/**
 * Created by rogerio on 21/02/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private FirebaseLoginIteractor firebaseLoginIteractor;

    public LoginPresenter(FirebaseLoginIteractor firebaseLoginIteractor) {
        this.firebaseLoginIteractor = firebaseLoginIteractor;

        if (firebaseLoginIteractor != null) {
            Log.d("TestDagger", "LoginPresenter ok");
        } else {
            Log.d("TestDagger", "LoginPresenter ko");
        }
    }

    @Override
    public void loginWithPassword(String user, String password) {

    }

    @Override
    public void onViewAttached(LoginContract.View view) {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void Onsuccess() {

    }
}
