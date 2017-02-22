package com.texsoft.imentoris.Interactor;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public class FirebaseLoginIteractor {
    private FirebaseAuth auth;

    public FirebaseLoginIteractor(FirebaseAuth auth) {
        this.auth = auth;
        if (auth != null) {
            Log.d("TestDagger", "FirebaseLoginInt ok");
        } else {
            Log.d("TestDagger", "FirebaseLoginInt ko");
        }
    }
}
