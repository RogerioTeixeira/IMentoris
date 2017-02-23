package com.texsoft.imentoris.iterator;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public class LoginEmailPasswordIterator {
    private FirebaseAuth auth;

    @Inject
    public LoginEmailPasswordIterator(FirebaseAuth auth) {
        this.auth = auth;
        if (auth != null) {
            Log.d("TestDagger", "FirebaseLoginInt ok");
        } else {
            Log.d("TestDagger", "FirebaseLoginInt ko");
        }

    }

    public void startSignIn(String user, String password, LoginIterator.OnCompleteListener<String> listener) {

    }

}
