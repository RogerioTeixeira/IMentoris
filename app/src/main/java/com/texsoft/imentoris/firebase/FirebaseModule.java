package com.texsoft.imentoris.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */
@Module
public class FirebaseModule {
    @Provides
    @Singleton
    FirebaseAuth firebaseAuth() {
        Log.v("TestDagger", "Firebase module");
        return FirebaseAuth.getInstance();
    }

}
