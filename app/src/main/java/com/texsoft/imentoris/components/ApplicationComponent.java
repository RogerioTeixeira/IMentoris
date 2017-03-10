package com.texsoft.imentoris.components;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.firebase.FirebaseModule;
import com.texsoft.imentoris.modules.ApplicationModule;

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
