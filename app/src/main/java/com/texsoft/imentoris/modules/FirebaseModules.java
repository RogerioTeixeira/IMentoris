package com.texsoft.imentoris.modules;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

@Module
public class FirebaseModules {
    // @Singleton
    @Provides
    FirebaseAuth firebaseAuth() {
        Log.v("FirebaseTest", "Create instance");
        return FirebaseAuth.getInstance();
    }
}
