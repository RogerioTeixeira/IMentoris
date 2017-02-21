package com.texsoft.imentoris.components;

import com.texsoft.imentoris.CustomApplication;
import com.texsoft.imentoris.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 21/02/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    CustomApplication customApplication();
}
