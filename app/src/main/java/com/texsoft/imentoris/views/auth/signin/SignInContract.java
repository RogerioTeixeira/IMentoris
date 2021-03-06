package com.texsoft.imentoris.views.auth.signin;

import android.app.Activity;

import com.texsoft.imentoris.base.Contract;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface SignInContract {
    interface View extends Contract.View {
        void onSuccess();
    }

    interface Presenter extends Contract.Presenter {
        void signInWithPassword(String email, String password, Activity activity);
    }

}
