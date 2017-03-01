package com.texsoft.imentoris.views.login;

import com.texsoft.imentoris.base.Contract;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface LoginContract {
    interface View extends Contract.View {
        void onSuccess();
    }

    interface Presenter extends Contract.Presenter<View> {
        void signInWithPassword(String email, String password);
    }

}
