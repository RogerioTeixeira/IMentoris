package com.texsoft.imentoris.views.login;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.util.ActivityScope;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = LoginPresenterModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
