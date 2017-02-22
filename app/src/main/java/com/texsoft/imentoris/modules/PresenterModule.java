package com.texsoft.imentoris.modules;

import com.google.firebase.auth.FirebaseAuth;
import com.texsoft.imentoris.Interactor.FirebaseLoginIteractor;
import com.texsoft.imentoris.components.ActivityScope;
import com.texsoft.imentoris.presenters.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerio on 21/02/2017.
 */

@Module
public class PresenterModule {
    @Provides
    @ActivityScope
    public LoginPresenter getLoginPresenter(FirebaseLoginIteractor interactor) {
        return new LoginPresenter(interactor);
    }

    @Provides
    @ActivityScope
    public FirebaseLoginIteractor getFirebaseLoginIteractor(FirebaseAuth auth) {
        return new FirebaseLoginIteractor(auth);
    }
}
