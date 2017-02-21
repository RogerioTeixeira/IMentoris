package com.texsoft.imentoris.modules;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

@Module
public class FirebaseModules {
    @Singleton
    @Provides
    FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
