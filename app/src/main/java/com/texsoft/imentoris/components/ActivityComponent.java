package com.texsoft.imentoris.components;

import com.texsoft.imentoris.modules.ActivityModule;
import com.texsoft.imentoris.modules.PresenterModule;
import com.texsoft.imentoris.util.PerActivity;
import com.texsoft.imentoris.views.auth.profile.WizardProfileActivity;
import com.texsoft.imentoris.views.auth.signin.SignInActivity;

import dagger.Component;

/**
 * Created by Rogerio Lavoro on 23/02/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {PresenterModule.class, ActivityModule.class})
public interface ActivityComponent extends ApplicationComponent {
    void inject(WizardProfileActivity activity);

    void inject(SignInActivity activity);

}
