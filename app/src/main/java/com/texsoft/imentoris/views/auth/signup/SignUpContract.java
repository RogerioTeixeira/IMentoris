package com.texsoft.imentoris.views.auth.signup;

import android.app.Activity;

import com.texsoft.imentoris.base.Contract;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface SignUpContract {
    interface View extends Contract.View {
        void onSuccess();
    }

    interface Presenter extends Contract.Presenter {
        void signUpWithPassword(String email, String password, String name, Activity activity);
    }

}
