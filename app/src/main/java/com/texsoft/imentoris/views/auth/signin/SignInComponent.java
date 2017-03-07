package com.texsoft.imentoris.views.auth.signin;

import com.texsoft.imentoris.ApplicationComponent;
import com.texsoft.imentoris.util.ActivityScope;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = SignInPresenterModule.class)
public interface SignInComponent extends ApplicationComponent {
    void inject(SignInActivity activity);

}
