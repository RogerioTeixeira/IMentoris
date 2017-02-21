package com.texsoft.imentoris.components;

import com.texsoft.imentoris.modules.LoginActivityModule;
import com.texsoft.imentoris.views.login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by rogerio on 21/02/2017.
 */

@ActivityScope
@Subcomponent(modules = {LoginActivityModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity activity);
}
