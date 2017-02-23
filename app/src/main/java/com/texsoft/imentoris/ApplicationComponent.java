package com.texsoft.imentoris;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.firebase.FirebaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, FirebaseModule.class})
public interface ApplicationComponent {
    FirebaseAuth getFirebaseAuth();
}
