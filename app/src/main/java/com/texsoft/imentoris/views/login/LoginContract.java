package com.texsoft.imentoris.views.login;

import com.texsoft.imentoris.base.BaseContract;

/**
 * Created by Rogerio Lavoro on 22/02/2017.
 */

public interface LoginContract {
    interface View extends BaseContract.View {
        void onSuccess();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void signInWithPassword(String email, String password);
    }

}
