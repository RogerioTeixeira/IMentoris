package com.texsoft.imentoris.components;

import com.texsoft.imentoris.modules.PresenterModule;
import com.texsoft.imentoris.util.PerActivity;
import com.texsoft.imentoris.views.auth.signin.SignInFragment;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PresenterModule.class)
public interface FragmentComponent extends ApplicationComponent {
    void inject(SignInFragment fragment);

}
