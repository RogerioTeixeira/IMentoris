package com.texsoft.imentoris.components;

import com.texsoft.imentoris.modules.AppModule;
import com.texsoft.imentoris.modules.FirebaseModules;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

@Singleton
@Component(modules = {AppModule.class, FirebaseModules.class})
public interface AppComponent {

}
