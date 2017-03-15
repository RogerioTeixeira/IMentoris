package com.texsoft.imentoris.views.auth.signin;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

public class SignInPresenter implements SignInContract.Presenter {
    private FirebaseAuth auth;

    public SignInPresenter(FirebaseAuth auth) {
        this.auth = auth;
        Log.v("TestDagger", "SignInPresenter const");

    }

    @Override
    public void signInWithPassword(String email, String password, Activity activity) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
