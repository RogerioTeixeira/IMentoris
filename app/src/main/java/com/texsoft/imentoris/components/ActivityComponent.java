package com.texsoft.imentoris.components;

import com.texsoft.imentoris.modules.PresenterModule;
import com.texsoft.imentoris.views.login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by rogerio on 21/02/2017.
 */

@ActivityScope
@Subcomponent(modules = {PresenterModule.class})
public interface ActivityComponent {
    void inject(LoginActivity activity);
}
