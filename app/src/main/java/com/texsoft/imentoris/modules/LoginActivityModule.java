package com.texsoft.imentoris.modules;

import com.texsoft.imentoris.components.ActivityScope;
import com.texsoft.imentoris.views.login.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerio on 21/02/2017.
 */

@Module
public class LoginActivityModule {
    public final LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @ActivityScope
    public LoginActivity getLoginActivity() {
        return loginActivity;
    }
}
